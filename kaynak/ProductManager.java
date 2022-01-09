import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductManager{
	 private Product product;
	 public ProductManager(Product product) {
		 this.product=product;
	 }
	 public void gecerliMi() throws Exception{
		  int kontrol=0;
		  if(product.getMarka()==null) {
	              kontrol=1;
		  }else if(product.getFiyat()<0) {
		          kontrol=1;
		  }
		  if(kontrol==1) {
			 throw new Exception("urun hatasi");
		  }
	 }
	 
}
