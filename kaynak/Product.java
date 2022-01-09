
public class Product {
	private String marka;
	private int fiyat;
	private int ram;
	private int SSD;
	private String islemci;
	public Product() {

	}
	public Product(String marka, int fiyat, int ram, int SSD, String islemci) {
		super();
		this.marka = marka;
		this.fiyat = fiyat;
		this.ram = ram;
		this.SSD = SSD;
		this.islemci = islemci;
	}
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getSSD() {
		return SSD;
	}
	public void setSSD(int sSD) {
		SSD = sSD;
	}
	public String getIslemci() {
		return islemci;
	}
	public void setIslemci(String islemci) {
		this.islemci = islemci;
	}
	
	
}
