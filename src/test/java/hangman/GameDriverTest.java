package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hangman.game.HangmanGame;

public class GameDriverTest {

	@Test
	public void testNewGame() {
		GameDriver driver = new GameDriver();
		driver.setLives(4);

		List<String> wordList = new ArrayList<>();
		wordList.add("TEST");
		driver.setWordList(wordList);

		driver.createNewGame();
		HangmanGame game = driver.getCurrentGame();

		assertNotNull(game);
		assertEquals(4, game.getRemainingLives());
		assertEquals("TEST", game.getWordToGuess());
	}

}
