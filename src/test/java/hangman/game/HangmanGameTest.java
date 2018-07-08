package hangman.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HangmanGameTest {

	@Test
	public void testRemainingLives() {
		HangmanGameOld game = new HangmanGameOld("Hello", 5);
		assertEquals(5, game.getRemainingLives());
	}

	@Test
	public void testDisplayedWord() {
		HangmanGameOld game = new HangmanGameOld("Hello", 1);
		assertEquals("#####", game.getDisplayedWord());
	}

	@Test
	public void testWordToGuess() {
		HangmanGameOld game = new HangmanGameOld("TEST", 1);
		assertEquals("TEST", game.getWordToGuess());
	}

	@Test
	public void testGuessPresentCharacter() {
		HangmanGameOld game = new HangmanGameOld("Hello", 2);
		assertTrue(game.guessCharacter('E'));
		assertEquals("#E###", game.getDisplayedWord());
		assertTrue(game.guessCharacter('l'));
		assertEquals("#ELL#", game.getDisplayedWord());
		assertEquals(2, game.getRemainingLives());
	}

	@Test
	public void testGuessAbsentCharacter() {
		HangmanGameOld game = new HangmanGameOld("Hello", 2);
		assertFalse(game.guessCharacter('F'));
		assertEquals("#####", game.getDisplayedWord());
		assertEquals(1, game.getRemainingLives());
	}

	@Test
	public void testGameLost() {
		HangmanGameOld game = new HangmanGameOld("Hello", 2);
		assertFalse(game.isGameLost());
		game.guessCharacter('F');
		assertFalse(game.isGameLost());
		game.guessCharacter('R');
		assertTrue(game.isGameLost());
	}

	@Test
	public void testGameWon() {
		HangmanGameOld game = new HangmanGameOld("HE", 2);
		assertFalse(game.isGameWon());
		game.guessCharacter('H');
		assertFalse(game.isGameWon());
		game.guessCharacter('E');
		assertTrue(game.isGameWon());
	}
}
