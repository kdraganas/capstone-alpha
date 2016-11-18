

/**
 * Created by Conni on 11/16/2016.
 */

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class GameOver extends BasicGameState{
	public String mouse = "";
	
    public GameOver(int state){

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
    	//gc:			//sbg:
    	
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
    	
    	Image gameover = new Image("res/gameober.png");
    	g.drawImage(gameover, 0, 0);
    	g.setColor(Color.darkGray);
    	//g.drawString("SCORE: "+score, 10, 70);
    	//g.drawString(mouse, 50, 50);
    	
    	
    }
    
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    	
    	int xpos = Mouse.getX();
    	int ypos = Mouse.getY();
    	mouse = "x pos = "+xpos+"   y pos = "+ypos;
    	Input input = gc.getInput();
    	
    	if((xpos>150 && xpos<308) && (ypos>132 && ypos<289) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(1);	//1: play state
    		}
    	}
    	
    	if((xpos>143 && xpos<217) && (ypos>54 && ypos<117) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(0);	//1: play state
    		}
    	}
    	
    	if((xpos>242 && xpos<316) && (ypos>56 && ypos<121) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			System.exit(0);
    		}
    	}
    	
    }

    public int getID(){
        return 4;
    }

}
