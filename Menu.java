

/**
 * Created by Conni on 11/16/2016.
 */

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.SoundStore;


public class Menu extends BasicGameState{
	
	public String mouse = "";
	private Music bgmusic;

	
    public Menu(int state){

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
    	//gc:			//sbg:
    	
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
    	//draws stuff : texts, images
    	
    	
    	/*g.drawOval(40, 40, 100, 100);*/
    	//Image bg = new Image("res/BG.png");
    	Image bg = new Image("res/menubg.png");
    	
    	g.drawImage(bg, 0, 0);
    	    	
    	g.setColor(Color.white);
    	//g.drawString(mouse, 50, 50);
    	/*
    	g.drawOval(75, 100, 100, 100);
    	g.drawString("> Play <", 87, 140);
    	
    	g.drawOval(200, 100, 100, 100);
    	g.drawString("> Instructions <", 214, 140);

    	g.drawOval(75, 400, 100, 100);
    	g.drawString("> Credits <", 87, 440);
    	
    	g.drawOval(200, 400, 100, 100);
    	g.drawString("> Quit <", 214, 440);
    	*/
    }
    
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
    	//update images for moving around (animation)
    	int xpos = Mouse.getX();
    	int ypos = Mouse.getY();
    	mouse = "x pos = "+xpos+"   y pos = "+ypos;
    	
    	
    	//
    	
    	Input input = gc.getInput();	//keyboard and mouse input
    	/*
    	if(input.isKeyDown(Input.KEY_UP)){
    		bgY -= 0.5;
    	}
    	if(input.isKeyDown(Input.KEY_DOWN)){
    		bgY += 0.5;
    	}
    	if(input.isKeyDown(Input.KEY_LEFT)){
    		bgX -= 0.5;
    	}
    	if(input.isKeyDown(Input.KEY_RIGHT)){
    		bgX += 0.5;
    	}
    	*/
    	bgmusic = new Music("res/backgroundmusic.wav");
    	bgmusic.play();
    	bgmusic.setVolume(100);
    	bgmusic.loop();
    	if((xpos>156 && xpos<317) && (ypos>101 && ypos<256) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(1);	//1: play state
    		}
    	}
    	
    	if((xpos>98 && xpos<175) && (ypos>28 && ypos<88) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(2);	//2: instruction state
    		}
    	}
    	
    	if((xpos>205 && xpos<281) && (ypos>28 && ypos<91) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			sbg.enterState(3);	//3: credits state
    		}
    	}
    	
    	if((xpos>308 && xpos<375) && (ypos>30 && ypos<88) ){
    		if(input.isMouseButtonDown(0)){	//0: left-clicked
    			System.exit(0);//exit
    		}
    	}
    	
    }

    public int getID(){
        return 0;
    }

}
