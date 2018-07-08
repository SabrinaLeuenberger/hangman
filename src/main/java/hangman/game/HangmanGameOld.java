package hangman.game;

public class HangmanGameOld {

	private String wordToGuess;
	private int remainingLives;
	private char[] displayedWord;

	public HangmanGameOld(String wordToGuess, int lives) {
		this.wordToGuess = wordToGuess.toUpperCase();
		this.remainingLives = lives;
		displayedWord = new char[wordToGuess.length()];
		for (int i = 0; i < wordToGuess.length(); i++) {
			displayedWord[i] = '#';
		}
	}

	public int getRemainingLives() {
		return remainingLives;
	}

	public String getDisplayedWord() {
		return String.copyValueOf(displayedWord);
	}

	public boolean guessCharacter(char c) {
		char toTest = Character.toUpperCase(c);
		boolean found = false;
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (toTest == wordToGuess.charAt(i)) {
				displayedWord[i] = toTest;
				found = true;
			}
		}
		if (!found) {
			remainingLives--;
		}
		return found;
	}

	public boolean isGameLost() {
		return remainingLives < 1;
	}

	public boolean isGameWon() {
		boolean wonGame = true;
		for (int i = 0; i < displayedWord.length; i++) {
			if (displayedWord[i] == '#') {
				wonGame = false;
			}
		}
		return wonGame;
	}

	@Override
	public String toString() {
		return "Actual result: " + String.copyValueOf(displayedWord) + "\nRemaining lives: " + remainingLives;
	}

	public String getWordToGuess() {
		return wordToGuess;
	}
}
