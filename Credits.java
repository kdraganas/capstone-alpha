

/**
 * Created by Conni on 11/16/2016.
 */

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Credits extends BasicGameState{
	
	public String mouse = "";

    public Credits(int state){

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
    	Image bg = new Image("res/credits.png");
    	g.drawImage(bg, 0, 0);
    	
    	//g.drawString(mouse, 50, 50);
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    	int xpos = Mouse.getX();
    	int ypos = Mouse.getY();
    	mouse = "x pos = "+xpos+"   y pos = "+ypos;
    	Input input = gc.getInput();
    	if((xpos>350 && xpos<430) && (ypos>10&&ypos<40) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(0);	//0: menu state
    		}
    	}
    }

    public int getID(){
        return 3;
    }

}
