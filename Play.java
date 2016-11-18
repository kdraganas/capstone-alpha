

/**
 * Created by Conni on 11/16/2016.
 */

import java.util.Random;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.ShapeRenderer;



public class Play extends BasicGameState{
	
	public String mouse = "";
	protected int score = 0;
	private float rect1X = 220;
	private float rect1Y = 0;
	private float rect2X = 220;
	private float rect2Y = 160;
	private float rect3X = 220;
	private float rect3Y = 320;
	private float rect4X = 220;
	private float rect4Y = 480;
	private double rectYAdd = 0.3;
	private final int sxpos = 206;
	private final int ypos = 565;
	private final int oxpos = 171;
	private final int imagex = 40;
	private final int imagey = 50;
	private final int obstaclex = 83;
	private final int obstacley = 118;
	private float obsy = 30;
	private int count = 0;
	private boolean[] boo = new boolean[6];
	protected boolean[] shapes = new boolean[5];
	private boolean[] state = new boolean[5];
	private Rectangle sp = new Rectangle(sxpos,ypos, obsy, obsy);
	private Rectangle ob = new Rectangle(oxpos,obsy, obsy, obsy);
	protected boolean diffShape = false;
	protected boolean theresAnObject = false;
	protected int value;
	private double add = 0.3;
	

	private Graphics g;


	public Play(int state){
    	
    }
	
	public int getScore(){
    	return this.score;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
    	for(int i=0;i<6;i++) {
			boo[i] = false;
		}
    	initilizer();

    }

    private void initilizer() {
		for(int i=0; i<5; i++){
			shapes[i] = false;
			state[i] = false;
		}
		shapes[0] = true;
		theresAnObject = false;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
    	Image background = new Image("res/pastelbg.png");
    	Image yellowBar = new Image("res/yellowbar.png");

    	g.drawImage(background, 0, 0);
    	g.setColor(Color.white);
    	
    	//g.drawString("BEGIN!", 100, 100);
    	g.setColor(Color.darkGray);
    	g.fillRect(170, 0, 110, 640);

    	/*g.drawImage(yellowBar, rect1X, rect1Y);
    	g.drawImage(yellowBar, rect2X, rect2Y);
    	g.drawImage(yellowBar, rect3X, rect3Y);
    	g.drawImage(yellowBar, rect4X, rect4Y);
    	*/
    	
		Random rand = new Random();
		
		if(!theresAnObject){
			obsy = 0;
			value = rand.nextInt(5);
			theresAnObject = true;
			initializer(state);
			ObstacleDraw(value,state,ob);
		}
		if(theresAnObject && obsy < 500){
			ObstacleDraw(value,state,ob);
		}
		if(obsy >= 500){
			obsy = 640;
			collided(shapes,state);
			theresAnObject = false;
			initializer(state);

		}
    	
    	for(int i=0; i<5; i++){
    		if(shapes[i]){
    	    	//g.drawString("misulod", 200, 100);
				initializer(shapes);
    			ShapeDraw(i,shapes,sp);
    	    	//g.drawString(String.valueOf(i), 300, 100);
    			break;
    		}
    	}
    	
    	if(rect1Y > 640){
    		rect1Y = 0;
    	}
    	if(rect2Y > 640){
    		rect2Y = 0;
    	}
    	if(rect3Y > 640){
    		rect3Y = 0;
    	}
    	if(rect4Y > 640){
    		rect4Y = 0;
    	}
    	g.setColor(Color.darkGray);
    	g.drawString(mouse, 50, 50);
    	g.drawString("SCORE: "+score, 10, 70);
    	//g.drawString("add: "+add, 10, 100);
    }
	
	@Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    	//Graphics g = new Graphics();
    	/*rect1Y+=0.3;
    	rect2Y+=0.3;
    	rect3Y+=0.3;
    	rect4Y+=0.3;
    	*/
		
    	obsy+=add;
    	
    	int xpos = Mouse.getX();
    	int ypos = Mouse.getY();
    	Input input = gc.getInput();
    	//mouse = "x pos = "+xpos+"   y pos = "+ypos;
    	
    	if (diffShape){
    		diffShape = false;
    		initializer(shapes);
    		shapes[0] = true;
    		add = 0.3;
    		//write file for score
    		score = 0;
    		sbg.enterState(4);	//4: gameover state
    		
    	}
    	/*if(((Shape) sp).Intersects((Shape(ob)){
    		collided(shapes, state);
    	}
    	*/
    	if(input.isKeyDown(Input.KEY_W)){
    		initializer(shapes);
    		shapes[0] = true;
    	}
    	if(input.isKeyDown(Input.KEY_D)){
    		initializer(shapes);
    		shapes[1] = true;
    	}
    	if(input.isKeyDown(Input.KEY_S)){
    		initializer(shapes);
    		shapes[2] = true;
    	}
    	if(input.isKeyDown(Input.KEY_A)){
    		initializer(shapes);
    		shapes[3] = true;
    	}
    	if(input.isKeyDown(Input.KEY_SPACE)){
    		initializer(shapes);
    		shapes[4] = true;
    	}
    	if(input.isKeyDown(Input.KEY_UP)){
    		//boo = false;
    	}
    }

	public void ShapeDraw(int i, boolean[] br, Rectangle sp2) throws SlickException{
		Image[] im = {new Image("res/CircleChar.png"), new Image("res/SquareChar.png"), new Image("res/TriangleChar.png"), new Image ("res/RectangleChar.png"), new Image ("res/DiamondChar.png")} ;
		Graphics gr = new Graphics();	
		gr.drawImage(im[i], sxpos, ypos);
		br[i] = true;
		
	}
	public void ObstacleDraw(int i, boolean[] br, Rectangle rc) throws SlickException{
		Image[] obs = {new Image("res/circleobs.png"), new Image("res/squareobs.png"), new Image("res/triangleobs.png"), new Image("res/rectangleobs.png"), new Image("res/diamondobs.png")};
		Graphics gd = new Graphics();
		gd.drawImage(obs[i], oxpos, obsy);
		state[i] = true;
	}
	public int getTrue(boolean[] br){
		for(int i=0; i<5; i++){
			if(br[i]){
				return i;
			}
		}
		return -2;
	}
	public void initializer(boolean[] br){
		for(int i=0; i<5; i++){
			br[i] = false;
		}
	}
	public void collided(boolean[] br, boolean[] bs){
		if(getTrue(br) == getTrue(bs)){
			score++;
			add = add+0.05;
		}
		else{
			diffShape = true;
		}
	}

    public int getID(){
        return 1;
    }

}
