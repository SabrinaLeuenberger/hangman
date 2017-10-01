package hangman.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HangmanGameTest {

	@Test
	public void testRemainingLives() {
		HangmanGame game = new HangmanGame("Hello", 5);
		assertEquals(5, game.getRemainingLives());
	}

	@Test
	public void testDisplayedWord() {
		HangmanGame game = new HangmanGame("Hello", 1);
		assertEquals("#####", game.getDisplayedWord());
	}

	@Test
	public void testWordToGuess() {
		HangmanGame game = new HangmanGame("TEST", 1);
		assertEquals("TEST", game.getWordToGuess());
	}

	@Test
	public void testGuessPresentCharacter() {
		HangmanGame game = new HangmanGame("Hello", 2);
		assertTrue(game.guessCharacter('E'));
		assertEquals("#E###", game.getDisplayedWord());
		assertTrue(game.guessCharacter('l'));
		assertEquals("#ELL#", game.getDisplayedWord());
		assertEquals(2, game.getRemainingLives());
	}

	@Test
	public void testGuessAbsentCharacter() {
		HangmanGame game = new HangmanGame("Hello", 2);
		assertFalse(game.guessCharacter('F'));
		assertEquals("#####", game.getDisplayedWord());
		assertEquals(1, game.getRemainingLives());
	}

	@Test
	public void testGameLost() {
		HangmanGame game = new HangmanGame("Hello", 2);
		assertFalse(game.isGameLost());
		game.guessCharacter('F');
		assertFalse(game.isGameLost());
		game.guessCharacter('R');
		assertTrue(game.isGameLost());
	}

	@Test
	public void testGameWon() {
		HangmanGame game = new HangmanGame("HE", 2);
		assertFalse(game.isGameWon());
		game.guessCharacter('H');
		assertFalse(game.isGameWon());
		game.guessCharacter('E');
		assertTrue(game.isGameWon());
	}
}
