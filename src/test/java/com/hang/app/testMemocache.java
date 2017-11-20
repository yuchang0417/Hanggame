package com.hang.app;
import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import com.hang.game.memcache;
import com.hang.game.Game; 

public class testMemocache {
	
	memcache meo = new memcache("34.205.78.200",11211);
	//Game g1 = new Game(1, "apple"); 
	//Game g2 = new Game(2, "fruit"); 
	
  @Test
  public void run() {
	  meo.memcachedClient.add("1", 60*30, "apple");
	  meo.memcachedClient.add("2", 60*30, "fruit");
	  
	  try{
	  String test1 =(String) meo.memcachedClient.get("1"); 
	  System.out.print(test1);
	  } catch (Exception E){
		  System.out.print(E); 
	  }
  }
}
