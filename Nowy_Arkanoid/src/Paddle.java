
public class Paddle {

	private int x,y, width,height;
	private int right, left;
	
	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		
		
		if((x + width <= right) && (x >=left)){
			this.x = x;
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Paddle(int l, int r){
		height = 10;
		width = 60;
		x = 520;
		y = 620;
		left = l;
		right = r;
		
	}
}
