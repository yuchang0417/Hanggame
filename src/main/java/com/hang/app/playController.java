package com.hang.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
//import javax.validation.Valid;

import com.google.gson.Gson;
import com.hang.game.Game; 
import com.hang.game.memcache;




@SuppressWarnings("unused")
@Controller
public class playController {
	
    private @Autowired ServletContext servletContext;
    memcache meo = new memcache("34.205.78.200",11211);
    int sucess, fail; 
    
   // static memcachedClient client = meo.memcachedClient;
 // Creates a new game resource
    
    
    
    
    @RequestMapping(value = "/games",method=RequestMethod.GET)
	public String startGame(Model model) {
        
    	
    	// Create a game with a current id when need extentinon 
    	Game newGame = new Game(1, "guesses");
    	sucess = 0; 
    	fail = 0; 
    	
    	newGame.setSucess(sucess);
    	newGame.setFail(fail);
    	
    	//keep on for current Game data. 
      // referesh if current is already exit 
        meo.memcachedClient.set("current", 30* 60,newGame); 
    	model.addAttribute("game", newGame); 
    	
    	// Add the game to the list of played games and indirectly into the session
    
    	
    
    	
        return "play"; 
    }
    
    
    
    
  
    // Updates a game resource. This is the part where the player makes guesses.
    @RequestMapping(value = "/guess",method=RequestMethod.GET)
    @ResponseBody
    public  String Guess(String letterInput) {
		//
    	// avoid out Exception of String define automatic input
    	if(letterInput.length() == 0){
    		letterInput = " "; 
    	}
    	
    	Gson g = new Gson();
    	String result = "";
    	//use memcached as DB to store data and keep status. 
    	
    	Game game = (Game)meo.memcachedClient.get("current"); 
    	
    	
    	System.out.println(letterInput);
    //      define games' playable and none-playable conditions
    //      keep on moving forward for playable conditions.     	
    	if (game.isPlayable()) {
    		// Sanitize the input. In case the player sends more than one character
    		String singleLetter = String.valueOf(letterInput.charAt(0));
	    	game.makeGuess(singleLetter);
	    	
	    	
	    	System.out.println("the state is " + game.getState() + "  the remain is " + game.getRemain());   	
	    	meo.memcachedClient.set("current", 30* 60,game);	    	
	    	
	    
	        result = g.toJson(game);
	    	//model.addAttribute("game", game); 
	    	
	//make a new game to replace for none-playable conditions     	
    	} else{
    		
    		if(game.getState() == 1) {
    			sucess++; 
    		} else if (game.getState() == -1) {
    			fail++; 
    		}
    		int id = game.getId() +1; 
    		Game newgame = new Game(id ,"guesses" );
    		
    		newgame.setSucess(sucess);
        	newgame.setFail(fail);
        	
    		meo.memcachedClient.set("current", 30* 60,newgame); 
    		
    		
    		
    		result = g.toJson(newgame);
    		//model.addAttribute("game", newgame); 
    		
    	}    	
    
    	
    	return result;
    }   
    
//  
//    
//    @RequestMapping(value = "/guess",method=RequestMethod.GET)
//    public  String Guess(String letterInput,  Model model) {
//		//
//    	// avoid out Exception of String define automatic input
//    	if(letterInput.length() == 0){
//    		letterInput = " "; 
//    	}
//    	
//    	//use memcached as DB to store data and keep status. 
//    	Game game = (Game)meo.memcachedClient.get("current"); 
//    	
//    	
//    	System.out.println(letterInput);
//    //      define games' playable and none-playable conditions
//    //      keep on moving forward for playable conditions.     	
//    	if (game.isPlayable()) {
//    		// Sanitize the input. In case the player sends more than one character
//    		String singleLetter = String.valueOf(letterInput.charAt(0));
//	    	game.makeGuess(singleLetter);
//	    	System.out.println("the state is " + game.getState() + "  the remain is " + game.getRemain());
//	    	meo.memcachedClient.set("current", 30* 60,game); 
//	    	model.addAttribute("game", game); 
//	    	
//	//make a new game to replace for none-playable conditions     	
//    	} else{
//    		int id = game.getId() +1; 
//    		Game newgame = new Game(id ,"catast" );
//    		meo.memcachedClient.set("current", 30* 60,newgame); 
//    		model.addAttribute("game", newgame); 
//    		
//    	}    	
//    	
//    	String result = "hello world";
//    	
//    	return result;
//    }   
//    
    
    
    
    
    
}
