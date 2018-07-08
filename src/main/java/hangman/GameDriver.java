package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameDriver {

	private HangmanGame game;
	private int lives = 5;
	public List<String> wordList;

	public void createNewGame() throws FileNotFoundException, IllegalStateException {
		inputWordList();
		if (wordList.isEmpty()) {
			throw new IllegalStateException("wordList is empty");
		}
		Random generator = new Random();
		int r = generator.nextInt(wordList.size());
		game = new HangmanGame(wordList.get(r), lives);

	}

	public HangmanGame getCurrentGame() {
		return game;
	}

	// if one wants to give the choice between different difficulty levels
	public void setLives(int lives) {
		this.lives = lives;
	}

	public void inputWordList() throws FileNotFoundException {
		try (Scanner s = new Scanner(new File("WordsToGuess.txt"))) {
			wordList = new ArrayList<>();
			while (s.hasNext()) {
				wordList.add(s.next());
			}
		}
	}
}
