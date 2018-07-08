package hangman;

import java.util.List;
import java.util.Random;

import hangman.game.HangmanGameOld;

public class GameDriverOld {

	private HangmanGameOld game;
	private int lives = 5;
	private List<String> wordList;

	public void createNewGame() {
		Random generator = new Random();
		int r = generator.nextInt(wordList.size());
		game = new HangmanGameOld(wordList.get(r), lives);
	}

	public HangmanGameOld getCurrentGame() {
		return game;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList;
	}

}
