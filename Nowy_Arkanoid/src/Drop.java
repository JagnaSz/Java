import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Drop implements Runnable {

	
	private int x,y;
	private int Vy;
	private int width = 15;
	private int height = 15;
	private int nr_bonus;

	public Drop(int Xx, int Yy){
		Random r = new Random();
		x = Xx+12;
		y=Yy+4;
		Vy=3;
		setNr_bonus(r.nextInt(4));
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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

	public int getVy() {
		return Vy;
	}

	public void setVy(int vy) {
		Vy = vy;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			y = y+Vy;
		}

	}

	public int getNr_bonus() {
		return nr_bonus;
	}

	public void setNr_bonus(int nr_bonus) {
		this.nr_bonus = nr_bonus;
	}

}
