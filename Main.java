
/**
 * Created by Conni on 11/14/2016.
 */
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import java.io.File;

import org.lwjgl.LWJGLUtil;


public class Main extends StateBasedGame{
	
	//protected int score = 0;

    public static final String gamename = "Suit UP!";
    public static final int menu = 0;
    public static final int play = 1;
    public static final int instructions = 2;
    public static final int credits = 3;
    public static final int gameover = 4;
    public int yourScore = 0;
    private int highScore = 0;
    
    

    public Main(String gameName){

        super(gameName);	//generate title
        this.addState(new Menu(menu));
        this.addState(new Play(play));
        this.addState(new Instructions(instructions));
        this.addState(new Credits(credits));
        this.addState(new GameOver(gameover));
    }

    public void initStatesList(GameContainer gc) throws SlickException{
    	//inherited from statebasedgame	//gamecontainer: manages input, frame
    	//initialize states in the game
        this.getState(menu).init(gc,this);
        this.getState(play).init(gc,this);
        this.getState(instructions).init(gc,this);
        this.getState(credits).init(gc,this);
        this.getState(gameover).init(gc,this);
        
        this.enterState(menu);	//initial state

    }
    

    public static void main(String args[]){
    	//int tmp = 0;
    	System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"),"native"),LWJGLUtil.getPlatformName()).getAbsolutePath());

        AppGameContainer appgc;	//window for the game
        try{
            appgc = new AppGameContainer(new Main(gamename));
            appgc.setDisplayMode(450, 640, false);
            appgc.start();
        }catch(SlickException e){
            e.printStackTrace();
        }
    }
    public void compareScore(int score){
    	if (score>highScore){
    		highScore = score;
    	}
    }

}
