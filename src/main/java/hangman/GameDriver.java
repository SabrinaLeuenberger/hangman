package hangman;

import java.util.List;
import java.util.Random;

import hangman.game.HangmanGame;

public class GameDriver {

	private HangmanGame game;
	private int lives = 5;
	private List<String> wordList;

	public void createNewGame() {
		Random generator = new Random();
		int r = generator.nextInt(wordList.size());
		game = new HangmanGame(wordList.get(r), lives);
	}

	public HangmanGame getCurrentGame() {
		return game;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

}
