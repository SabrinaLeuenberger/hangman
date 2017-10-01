package hangman.gui;

import java.util.ArrayList;
import java.util.List;

import hangman.GameDriver;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")

public class MainWindow extends Application {

	private GameDriver driver = new GameDriver();
	private Label remainingLivesLbl = new Label("++");
	private Label displayedWordLbl = new Label("####");

	public static void main(String[] args) {
		launch(args);
	}

	public MainWindow() {

		driver.setLives(5);

		List<String> words = new ArrayList<>();
		words.add("Sabrina");
		words.add("Andreas");
		words.add("Hangman");
		words.add("Murten");
		words.add("Rose");
		words.add("Iris");
		words.add("Backup");
		driver.setWordList(words);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hangman by lsa");

		Button newGameBtn = new Button("New Game");
		newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				driver.createNewGame();
				displayStatus();
			}
		});

		FlowPane btnPane = new FlowPane();

		btnPane.getChildren().add(createGuessButton('A'));
		btnPane.getChildren().add(createGuessButton('B'));
		btnPane.getChildren().add(createGuessButton('C'));
		btnPane.getChildren().add(createGuessButton('D'));
		btnPane.getChildren().add(createGuessButton('E'));
		btnPane.getChildren().add(createGuessButton('F'));
		btnPane.getChildren().add(createGuessButton('G'));
		btnPane.getChildren().add(createGuessButton('H'));
		btnPane.getChildren().add(createGuessButton('I'));
		btnPane.getChildren().add(createGuessButton('J'));
		btnPane.getChildren().add(createGuessButton('K'));
		btnPane.getChildren().add(createGuessButton('L'));
		btnPane.getChildren().add(createGuessButton('M'));
		btnPane.getChildren().add(createGuessButton('N'));
		btnPane.getChildren().add(createGuessButton('O'));
		btnPane.getChildren().add(createGuessButton('P'));
		btnPane.getChildren().add(createGuessButton('Q'));
		btnPane.getChildren().add(createGuessButton('R'));
		btnPane.getChildren().add(createGuessButton('S'));
		btnPane.getChildren().add(createGuessButton('T'));
		btnPane.getChildren().add(createGuessButton('U'));
		btnPane.getChildren().add(createGuessButton('V'));
		btnPane.getChildren().add(createGuessButton('W'));
		btnPane.getChildren().add(createGuessButton('X'));
		btnPane.getChildren().add(createGuessButton('Y'));
		btnPane.getChildren().add(createGuessButton('Z'));

		VBox vbox = new VBox();
		vbox.getChildren().add(newGameBtn);
		vbox.getChildren().add(remainingLivesLbl);
		vbox.getChildren().add(displayedWordLbl);
		vbox.getChildren().add(btnPane);

		StackPane root = new StackPane();
		root.getChildren().add(vbox);
		primaryStage.setScene(new Scene(root, 600, 300));
		primaryStage.show();
	}

	private Button createGuessButton(char guess) {
		Button aBtn = new Button(Character.toString(guess));
		aBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				guessCharacter(guess);
			}
		});
		return aBtn;
	}

	private void guessCharacter(char c) {
		driver.getCurrentGame().guessCharacter(c);
		displayStatus();
	}

	private void displayStatus() {
		displayedWordLbl.setText(driver.getCurrentGame().getDisplayedWord());
		remainingLivesLbl.setText(Integer.toString(driver.getCurrentGame().getRemainingLives()));

		if (driver.getCurrentGame().isGameWon()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Hangman");
			alert.setHeaderText("You win");
			alert.setContentText("Congratulations!");
			alert.show();
		}

		if (driver.getCurrentGame().isGameLost()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Hangman");
			alert.setHeaderText("You loose");
			alert.setContentText("Too bad!");
			alert.show();
		}
	}
}