

public class Block {

	private int x,y;
	private int height, width;

	private boolean visible;
	
	public Block(int x, int y){
		this.x = x;
		this.y = y;
		height = 25;
		width = 45;
		visible = true;
	}
	public Block() {
		height = 25;
		width = 45;
		visible = true;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
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
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean available) {
		this.visible = available;
	}
	
	
}
