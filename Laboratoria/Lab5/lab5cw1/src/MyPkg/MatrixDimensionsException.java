package MyPkg;

public class MatrixDimensionsException extends Exception {
	
	private String str;
	private DummyMatrix m = new DummyMatrix();
	private static final long serialVersionUID = 1L;

	public MatrixDimensionsException(String str) {
		this.str = str;
	}
	
	public void co() {
		System.out.println(str);
	}
	
	public Matrix matrix() {
		return m;
	}
	
	public MatrixDimensionsException(String str, DummyMatrix m) {
		this.str = str;
		this.m = m;
	}

}
