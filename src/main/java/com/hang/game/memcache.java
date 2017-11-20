package com.hang.game;

import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.MemcachedClient;

public class memcache {
	
	public static MemcachedClient memcachedClient;
	
	public memcache(String memcacheIP, int memport){
		
		// singleton pattern for cache connection and word list
        if (memcachedClient == null) {
            try {
                memcachedClient = new MemcachedClient(new InetSocketAddress[]{new InetSocketAddress(memcacheIP, memport)});
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
	}
	
}
