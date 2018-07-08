package hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hangman.game.HangmanGameOld;

public class GameDriverTest {

	@Test
	public void testNewGame() {
		GameDriverOld driver = new GameDriverOld();
		driver.setLives(4);

		List<String> wordList = new ArrayList<>();
		wordList.add("TEST");
		driver.setWordList(wordList);

		driver.createNewGame();
		HangmanGameOld game = driver.getCurrentGame();

		assertNotNull(game);
		assertEquals(4, game.getRemainingLives());
		assertEquals("TEST", game.getWordToGuess());
	}

}
