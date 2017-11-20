package com.hang.app;

import com.hang.*;
import com.hang.game.Game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	Game gs = new Game(2, "babara");

	@Test
	public void test() {
		// System.out.print(gs.getWord());

		for (char e : gs.getChars()) {
			System.out.println(e);
		}
		int num = gs.getMap().get('b').pop();
		System.out.println(num);

	}

}
