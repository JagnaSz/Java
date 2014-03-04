import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Game extends Thread {

	private Ball ball;
	private ExecutorService exec;
	private Paddle paddle;
	private Block blocks;
	private LinkedList<Block> list_blocks;
	private LinkedList<Drop> list_drops;
	private LinkedList<Block> list_wsplBlock;
	
	private int score;
	private int lives;
	
	public Game(){
		score = 0;
		lives = 3;
		setBall(new Ball(paddle.getX()-20,paddle.getY()-10));

		setBlocks(new Block());
		setList_blocks(new LinkedList<Block>());
		setList_drops(new LinkedList<Drop>());
		setList_wsplBlock(new LinkedList<Block>());
		
		
		exec = Executors.newCachedThreadPool();
		exec.execute(ball);
		
	}

	public Game(int left, int right) {
		score = 0;
		lives = 3;
		setPaddle(new Paddle(left, right));
		setBall(new Ball(paddle.getX()-20,paddle.getY()-10));
		setBlocks(new Block());
		setList_blocks(new LinkedList<Block>());
		setList_drops(new LinkedList<Drop>());
		setList_wsplBlock(new LinkedList<Block>());
		
			//list_blocks.add(new Block(150,150));
		for(int j = 0; j<8; j++){ //8
			for(int i=0; i<23; i++){ //23
				list_blocks.add(new Block(38+ blocks.getWidth()*i,80+blocks.getHeight()*j)); //38 80
			}
		}
		
		
		//ustalanie wspó³rzêdnych dla dropa
		for(int i=0; i<20; i++){
			list_wsplBlock.add(getRandomX());
		}
		
		//dodawanie do listy
		for(int i=0;i<20;i++){
			list_drops.add(new Drop(getList_wsplBlock().get(i).getX(),getList_wsplBlock().get(i).getY()));
		}
		
		exec = Executors.newCachedThreadPool();
		exec.execute(ball);
	
	}

	public void addBall(){
		if(lives != 0){
			this.setBall(new Ball(paddle.getX()+30,paddle.getY()-10));
			exec.execute(ball);
			
		}
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Paddle getPaddle() {
		return paddle;
	}

	public void setPaddle(Paddle paddle) {
		this.paddle = paddle;
	}
	
	public void deleteBall(){
		ball.setStart(false);
		
	}
	

	public void deleteBlock(int x){
		for(int i=0; i<list_drops.size();i++){
			
			if(list_drops.get(i).getX()>=list_blocks.get(x).getX()
				   &&list_drops.get(i).getX()+list_drops.get(i).getWidth()<=list_blocks.get(x).getX()+list_blocks.get(x).getWidth()
				   &&list_drops.get(i).getY()>=list_blocks.get(x).getY()
				   &&list_drops.get(i).getY()+list_drops.get(i).getHeight()<=list_blocks.get(x).getY()+list_blocks.get(x).getHeight())
				{
					System.out.println(list_drops.get(i).getX() + "  " +list_blocks.get(x).getX() );
					exec.execute(list_drops.get(i));
				}
		}
		list_blocks.remove(x);
		
	}
	
	public Block getBlocks() {
		return blocks;
	}

	public void setBlocks(Block blocks) {
		this.blocks = blocks;
	}
	

	public LinkedList<Block> getList_blocks() {
		return list_blocks;
	}

	public void setList_blocks(LinkedList<Block> list_blocks) {
		this.list_blocks = list_blocks;
	}
	
	//pobiera randomowy x bloczka do ustawienia dropa
	public Block getRandomX(){
		Random generator = new Random();
		return list_blocks.get(generator.nextInt(list_blocks.size()));
	}

	public LinkedList<Drop> getList_drops() {
		return list_drops;
	}

	public void setList_drops(LinkedList<Drop> list_drops) {
		this.list_drops = list_drops;
	}

	public LinkedList<Block> getList_wsplBlock() {
		return list_wsplBlock;
	}

	public void setList_wsplBlock(LinkedList<Block> list_wsplBlock) {
		this.list_wsplBlock = list_wsplBlock;
	}


	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int i){
		score+=i;
		System.out.println(getScore());
	}
	
	public void getBonus(int i){
		switch(i){
		case 0:
			addScore(100);
		break;
		case 1:
			lengthen_paddle();
		break;
		case 2:
			shorten_paddle();
		break;
		case 3:
			addLive();
			
		default:
			System.out.println("Nieznane!");
			
		}
	}
	
	public void lengthen_paddle(){
		paddle.setWidth(paddle.getWidth()+30);
		paddle.setX(paddle.getX()-15);
	}
	
	public void shorten_paddle(){
		if(paddle.getWidth() > paddle.getWidth()-25 ){
			paddle.setWidth(paddle.getWidth()-25);
			paddle.setX(paddle.getX()+14);
		}
	}
	
	public void pause(){
		ball.pause();
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public void addLive(){
		lives++;
	}
	
	public void subLive(){
		lives--;
	}
	

}
