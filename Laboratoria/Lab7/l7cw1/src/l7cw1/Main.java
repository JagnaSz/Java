package l7cw1;

public class Main {

	public static void main(String[] args) {
		DB db=new DB();
		db.printAll();
		System.out.println("******************************");
		db.findByAuthor("Aldous Huxley");
		System.out.println("******************************");
		//db.findById("1234567891246");
		System.out.println("******************************");
		//db.delByName("George Orwell");
		System.out.println("******************************");
		//db.delById("1234567891240");
		//db.printAll();
		
	}

}
