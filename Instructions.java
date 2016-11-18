

/**
 * Created by Conni on 11/16/2016.

 */

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Instructions extends BasicGameState{
	
	public String mouse = "";

    public Instructions(int state){

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
    	Image bg = new Image("res/HOWTOPLAY.png");
    	g.drawImage(bg, 0, 0);
    	
    	//g.drawString(mouse, 50, 50);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    	int xpos = Mouse.getX();
    	int ypos = Mouse.getY();
    	mouse = "x pos = "+xpos+"   y pos = "+ypos;
    	Input input = gc.getInput();
    	if((xpos>400 && xpos<432) && (ypos>13 && ypos<43) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(0);	//0: menu state
    		}
    	}
    }

    public int getID(){
        return 2;
    }

}
