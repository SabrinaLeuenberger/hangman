package hangman;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HangmanGui extends Application {

	private GameDriver driver = new GameDriver();
	private Label livesLbl = new Label("Lives:");
	private Label remainingLivesLbl = new Label("++");
	private Label displayedWordLbl = new Label("#####");
	private Button newGameBtn = new Button("New Game");
	private Button a = new Button("A");
	private Button b = new Button("B");
	private Button c = new Button("C");
	private Button d = new Button("D");
	private Button e = new Button("E");
	private Button f = new Button("F");
	private Button g = new Button("G");
	private Button h = new Button("H");
	private Button i = new Button("I");
	private Button j = new Button("J");
	private Button k = new Button("K");
	private Button l = new Button("L");
	private Button m = new Button("M");
	private Button n = new Button("N");
	private Button o = new Button("O");
	private Button p = new Button("P");
	private Button q = new Button("Q");
	private Button r = new Button("R");
	private Button s = new Button("S");
	private Button t = new Button("T");
	private Button u = new Button("U");
	private Button v = new Button("V");
	private Button w = new Button("W");
	private Button x = new Button("X");
	private Button y = new Button("Y");
	private Button z = new Button("Z");
	private Button[] charButtons = { a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z };

	@Override
	public void start(Stage primaryStage) {
		createGui(primaryStage);
		addActionsToGui();
		primaryStage.show();
		startNewGame();
	}

	private void createGui(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane, 400, 250);
		primaryStage.setTitle("Hangman");
		primaryStage.setScene(scene);
		VBox topLeftLetters = new VBox();
		topLeftLetters.getChildren().addAll(a, b, c, d, e, f, g);
		VBox leftLetters = new VBox();
		leftLetters.getChildren().addAll(h, i, j, k, l, m);
		VBox rightLetters = new VBox();
		rightLetters.getChildren().addAll(n, o, p, q, r, s);
		VBox topRightLetters = new VBox();
		topRightLetters.getChildren().addAll(t, u, v, w, x, y, z);
		HBox leftSide = new HBox();
		leftSide.getChildren().addAll(topLeftLetters, leftLetters);
		HBox rightSide = new HBox();
		rightSide.getChildren().addAll(rightLetters, topRightLetters);
		BorderPane.setAlignment(leftSide, Pos.CENTER);
		borderPane.setLeft(leftSide);
		BorderPane.setAlignment(rightSide, Pos.CENTER);
		borderPane.setRight(rightSide);
		StackPane middle = new StackPane();
		middle.getChildren().add(displayedWordLbl);
		BorderPane.setAlignment(middle, Pos.CENTER);
		borderPane.setCenter(middle);
		StackPane top = new StackPane();
		top.getChildren().add(newGameBtn);
		BorderPane.setAlignment(top, Pos.CENTER);
		borderPane.setTop(top);
		VBox lifeCounter = new VBox();
		lifeCounter.setAlignment(Pos.CENTER);
		lifeCounter.getChildren().addAll(livesLbl, remainingLivesLbl);
		StackPane bottom = new StackPane();
		bottom.getChildren().add(lifeCounter);
		BorderPane.setAlignment(bottom, Pos.CENTER);
		borderPane.setBottom(bottom);
	}

	private void startNewGame() {
		try {// sicherstellen, dass mit dem Start des neuen Spieles alle Buttons
				// wieder aktiv sind
			for (int i = 0; i < charButtons.length; i++) {
				charButtons[i].setDisable(false);
			}
			driver.createNewGame();
			displayStatus();
		} catch (FileNotFoundException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("FileNotFoundException");
			alert.setContentText("wordList could not be imported");
			alert.show();
		} catch (IllegalStateException e) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Error");
			alert.setHeaderText("IllegalStateException");
			alert.setContentText("wordList is empty");
			alert.show();
		}
	}

	private void addActionsToGui() {
		newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startNewGame();
			}
		});

		a.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				a.setDisable(true);
				guessCharacter('A');
			}
		});

		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				b.setDisable(true);
				guessCharacter('B');
			}
		});

		c.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				c.setDisable(true);
				guessCharacter('C');
			}
		});

		d.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				d.setDisable(true);
				guessCharacter('D');
			}
		});

		e.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				e.setDisable(true);
				guessCharacter('E');
			}
		});

		f.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				f.setDisable(true);
				guessCharacter('F');
			}
		});

		g.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				g.setDisable(true);
				guessCharacter('G');
			}
		});

		h.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				h.setDisable(true);
				guessCharacter('H');
			}
		});

		i.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				i.setDisable(true);
				guessCharacter('I');
			}
		});

		j.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				j.setDisable(true);
				guessCharacter('J');
			}
		});

		k.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				k.setDisable(true);
				guessCharacter('K');
			}
		});

		l.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				l.setDisable(true);
				guessCharacter('L');
			}
		});

		m.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				m.setDisable(true);
				guessCharacter('M');
			}
		});

		n.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				n.setDisable(true);
				guessCharacter('N');
			}
		});

		o.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				o.setDisable(true);
				guessCharacter('O');
			}
		});

		p.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p.setDisable(true);
				guessCharacter('P');
			}
		});

		q.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				q.setDisable(true);
				guessCharacter('Q');
			}
		});

		r.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				r.setDisable(true);
				guessCharacter('R');
			}
		});

		s.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				s.setDisable(true);
				guessCharacter('S');
			}
		});

		t.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				t.setDisable(true);
				guessCharacter('T');
			}
		});

		u.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				u.setDisable(true);
				guessCharacter('U');
			}
		});

		v.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				v.setDisable(true);
				guessCharacter('V');
			}
		});

		w.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				w.setDisable(true);
				guessCharacter('W');
			}
		});

		x.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				x.setDisable(true);
				guessCharacter('X');
			}
		});

		y.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				y.setDisable(true);
				guessCharacter('Y');
			}
		});

		z.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				z.setDisable(true);
				guessCharacter('Z');
			}
		});

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
			alert.setHeaderText("You have won!");
			alert.setContentText("Congratulations!");
			alert.show();
			startNewGame();
		}

		if (driver.getCurrentGame().isGameLost()) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Hangman");
			alert.setHeaderText("You have lost");
			alert.setContentText("Don't give up!");
			alert.show();
			startNewGame();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
