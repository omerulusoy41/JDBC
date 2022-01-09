import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySql extends DatabaseTeknologies {
	private DbHelper help = null;
	private Scanner scan = new Scanner(System.in);

	public MySql() {
		help = new DbHelper();
	}
	private Connection baglanti() {
		Connection connect=null;
		try {
			connect = help.getConnection();
		} catch (SQLException e) {
			help.errorMesage(e);
		} 
		return connect;
	}
	@Override
	public void insert(Product product) {
		Connection connect=baglanti();
		PreparedStatement state = null;
		String sql = "insert into bilgiler(marka,fiyat,ram,SSD,islemci) values(?,?,?,?,?)";
		try {
			state = connect.prepareStatement(sql);
			state.setString(1, product.getMarka());
			state.setInt(2, product.getFiyat());
			state.setInt(3, product.getRam());
			state.setInt(4, product.getSSD());
			state.setString(5, product.getIslemci());
			int kontrol = state.executeUpdate();
			if (kontrol != 1) {
				throw new SQLException("ekleme hatasi");
			}
		} catch (SQLException e) {
			help.errorMesage(e);
		}

	}

	@Override
	public void update() {
		Connection connect=baglanti();
		System.out.println("\n*******GUNCELLEME********");
		try {
			PreparedStatement state = null;
			listeleme();
			int id = 0;
			System.out.println("Guncellemek istediginiz\nId degerini giriniz=");
			id = scan.nextInt();
			System.out.println("Hangi alanlarini guncellemek istiyorsunuz ?");
			System.out.println("1=>marka");
			System.out.println("2=>Fiyat");
			System.out.println("3=>ram");
			System.out.println("4=>SSD");
			System.out.println("5=>islemci");
			System.out.println("Sirasiyla islemleri giriniz(Orn(marka fiyat degisikligi 12))");
			String secim = scan.next();
			for (int i = 0; i < secim.length(); i++) {
				String sql = null;
				int kontrol = 0;
				int deger1 = 0;
				String deger2 = null;
				switch (secim.charAt(i)) {
				case '1':
					System.out.println("Yeni marka degerini giriniz=");
					deger2 = scan.next();
					sql = "update bilgiler set marka=? where id=" + id;
					kontrol = 1;
					break;
				case '2':
					System.out.println("Yeni fiyat degerini giriniz=");
					deger1 = scan.nextInt();
					sql = "update bilgiler set fiyat=? where id=" + id;
					break;
				case '3':
					System.out.println("Yeni Ram kapasitesini giriniz=");
					deger1 = scan.nextInt();
					sql = "update bilgiler set ram=? where id=" + id;
					break;
				case '4':
					System.out.println("Yeni SSD kapasitesini giriniz=");
					deger1 = scan.nextInt();
					sql = "update bilgiler set SSD=? where id=" + id;
					break;
				case '5':
					System.out.println("Yeni islemci degerini giriniz=");
					deger2 = scan.next();
					sql = "update bilgiler set islemci=? where id=" + id;
					kontrol = 1;
					break;
				default:
					System.out.println(secim.charAt(i) + " icin bir eslesme yok!(Hatali Giris)");
					break;
				}
				state = connect.prepareStatement(sql);
				if (kontrol == 1) {
					state.setString(1, deger2);
				} else {
					state.setInt(1, deger1);
				}
			    if(state.execute()) {
			    	System.out.println("Bir hata!!");
			    }
			    state.close();
			}
	        connect.close();
		} catch (SQLException e) {
			help.errorMesage(e);
		}
	}

	@Override
	public void listeleme() {
		Connection connect=baglanti();
		System.out.println("\n-LISTE");
		String sql = "select * from bilgiler";
		ResultSet result = null;
		try {
			Statement state = connect.createStatement();
			result = state.executeQuery(sql);
			while (result.next()) {
				System.out.println("------------------");
				System.out.println("ID=" + result.getString("id"));
				System.out.println("marka=" + result.getString("marka"));
				System.out.println("fiyat=" + result.getString("fiyat"));
				System.out.println("Ram=" + result.getString("ram"));
				System.out.println("SSD=" + result.getString("SSD"));
				System.out.println("islemci=" + result.getString("islemci"));
			}
			state.close();
			connect.close();
		} catch (SQLException e) {
			help.errorMesage(e);
		}
		System.out.println("\n\n");
	}

	@Override
	public void silme() {
		Connection connect=baglanti();
		try {
			String SQL = "delete from bilgiler where id=?";
			PreparedStatement state = connect.prepareStatement(SQL);
			listeleme();
			System.out.println("Silmek istediginiz Id degerini giriniz=?");
			state.setInt(1, scan.nextInt());
			boolean kont = state.execute();
			if (kont==false) {
				System.out.println("Silme islemi basarili.");
			} else {
				System.out.println("HATA!");
			}
			state.close();
			connect.close();
		} catch (SQLException e) {
			help.errorMesage(e);
		}

	}
	@Override
	public String toString() {
		return "MySql";
	}

}
