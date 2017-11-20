package com.hang.game;

import java.util.HashMap;
import java.util.Stack;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Game implements Serializable {
	
	private static final int win = 1; 
	private static final int lose = -1; 
	private static final int onplay = 0; 
	
    private  final int id;
    private  final int count; 
    private  final String  word; 
    
    private int remain; 
    private int state;
    private String CurrentString; 
    private HashMap<Character, Stack<Integer>> map; 
    private char [] chars; 
    private int sucess; 
    private int fail; 
    
    public Game(int id, String word) {
    	this.id = id; 
    	this.word = word; 
    	this.remain = 10; 
    	this.count = word.length(); 
    	this.state =onplay;    	 
    	
    	char [] array = word.toCharArray();
    	map = getMap(array); 
    	chars = setChars(word.length());
    	CurrentString = String.valueOf(chars); 

    }
    
    @JsonIgnore public String getWord() { return word; }
    
    
    public HashMap<Character, Stack<Integer>> getMap(char [] array) {
    	HashMap<Character, Stack<Integer>> map = new HashMap();
    	
    	for(int i = 0 ; i < array.length; i++) {		
		if(map.containsKey(array[i])){
			map.get(array[i]).push(i); 
		}else{
			Stack<Integer> stack = new Stack(); 
			stack.push(i); 
			map.put(array[i], stack); 
		}
	}
    	return map; 
    	
    }
    
    public char [] setChars(int n) {
    	char res[] = new char [n]; 
    	for(int i = 0; i < n; i++) {
    		res[i] = '_'; 
    	}
    	return res; 
    }
    
    public void setSucess(int sucess) {
    	this.sucess = sucess; 
    }
    
    public int getSucess()  { return sucess; } ;
    
    public void setFail(int fail) {
    	this.fail = fail; 
    }
    
    public int getFail() {
    	return fail; 
    }
    
    public int getId() { return id; }   
    public int getCount() { return count; } 
    public int getRemain() { return remain; }
    public int getState() { return state; };
    public HashMap<Character, Stack<Integer>> getMap(){ return map; }; 
    public char[] getChars() { return chars; }; 
    
    public String getCurrentString() { return CurrentString; }
	public boolean isPlayable() { return state == onplay; }
	
	private void reduceRemain() {
		remain--; 
	}
	
	public void makeGuess(String letter) {
		char input = letter.charAt(0); 
		if(map.containsKey(input)) {
			updateGuess(input); 
			reduceRemain(); 
		} else {
			reduceRemain(); 
		}
		
		updateStatus(); 
		
	}
	
	private void updateStatus() {
		if(map.size() == 0) {
			state = win; 
		} else if (remain <= 0) {
			state = lose; 
		}
	}
	
	private void updateGuess(char input) {
		
		int index = map.get(input).pop(); 
		chars[index] = input; 
		CurrentString = String.valueOf(chars); 
		
		if(map.get(input).isEmpty()) {
			map.remove(input); 
		}		
	}
	
	

}
