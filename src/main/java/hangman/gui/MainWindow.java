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
		primaryStage.setTitle("Hangman by hearts");

		Button newGameBtn = new Button("New Game");
		// Verknüpfung des Buttons mit der methode createNewGame
		newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				driver.createNewGame();
				displayStatus();
			}
		});
		// ein flowPane welches die Buchstaben Buttons aufnimmt
		FlowPane letterBtnPane = new FlowPane();
		// die Buttons, die erlauben einen Btn zu wählen
		// werden dem letterBtnPane zugefügt
		letterBtnPane.getChildren().add(createGuessButton('A'));
		letterBtnPane.getChildren().add(createGuessButton('B'));
		letterBtnPane.getChildren().add(createGuessButton('C'));
		letterBtnPane.getChildren().add(createGuessButton('D'));
		letterBtnPane.getChildren().add(createGuessButton('E'));
		letterBtnPane.getChildren().add(createGuessButton('F'));
		letterBtnPane.getChildren().add(createGuessButton('G'));
		letterBtnPane.getChildren().add(createGuessButton('H'));
		letterBtnPane.getChildren().add(createGuessButton('I'));
		letterBtnPane.getChildren().add(createGuessButton('J'));
		letterBtnPane.getChildren().add(createGuessButton('K'));
		letterBtnPane.getChildren().add(createGuessButton('L'));
		letterBtnPane.getChildren().add(createGuessButton('M'));
		letterBtnPane.getChildren().add(createGuessButton('N'));
		letterBtnPane.getChildren().add(createGuessButton('O'));
		letterBtnPane.getChildren().add(createGuessButton('P'));
		letterBtnPane.getChildren().add(createGuessButton('Q'));
		letterBtnPane.getChildren().add(createGuessButton('R'));
		letterBtnPane.getChildren().add(createGuessButton('S'));
		letterBtnPane.getChildren().add(createGuessButton('T'));
		letterBtnPane.getChildren().add(createGuessButton('U'));
		letterBtnPane.getChildren().add(createGuessButton('V'));
		letterBtnPane.getChildren().add(createGuessButton('W'));
		letterBtnPane.getChildren().add(createGuessButton('X'));
		letterBtnPane.getChildren().add(createGuessButton('Y'));
		letterBtnPane.getChildren().add(createGuessButton('Z'));

		VBox vbox = new VBox();
		vbox.getChildren().add(newGameBtn);
		vbox.getChildren().add(remainingLivesLbl);
		vbox.getChildren().add(displayedWordLbl);
		vbox.getChildren().add(letterBtnPane);

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