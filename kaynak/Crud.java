import java.util.Scanner;

public class Crud {
	private IDataBase sorgu;

	public Crud(IDataBase sorgu) {
		this.sorgu = sorgu;
		System.out.println("CRUD islemleri " + sorgu.toString() + " veritabanina gerceklsecektir.");
	}

	public void islemler() {
		int secim=0;
		while (secim!=5) {
			System.out.println("Islemler----");
			System.out.println("1->Urun Ekleme");
			System.out.println("2->Urun Listeleme");
			System.out.println("3->Urun Guncelleme");
			System.out.println("4->Urun Silme");
			System.out.println("5->Cikis");
			System.out.print("Bir secim yapiniz=");
			Scanner scanInt = new Scanner(System.in);
			Scanner scanStr = new Scanner(System.in);
			secim = scanInt.nextInt();
			switch (secim) {
			case 1:
				Product product = new Product();
				System.out.println("Marka Giriniz=");
				product.setMarka(scanStr.next());
				System.out.println("Fiyat Giriniz=");
				product.setFiyat(scanInt.nextInt());
				System.out.println("Ram Giriniz=");
				product.setRam(scanInt.nextInt());
				System.out.println("SSD Giriniz=");
				product.setSSD(scanInt.nextInt());
				System.out.println("Islemci Giriniz=");
				product.setIslemci(scanStr.next());
				ProductManager manage = new ProductManager(product);
				try {
					manage.gecerliMi();
					sorgu.insert(product);
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 2:
				sorgu.listeleme();
				break;
			case 3:
				sorgu.update();
				break;
			case 4:
				sorgu.silme();
				break;
			case 5:
				break;
			default:
				System.out.println("Hatali Giris");
				break;
			}
		}
	}

}
