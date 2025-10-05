package ClassProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.time.LocalDate;

public class MainApp extends Application {

    private GameManager gameManager = new GameManager("games.txt");

    private ListView<String> gameListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Tracker");

        // Create input fields
        TextField titleField = new TextField();
        titleField.setPromptText("Enter game title");

        TextField platformField = new TextField();
        platformField.setPromptText("Enter platform");

        ComboBox<String> statusCombo = new ComboBox<>();
        statusCombo.getItems().addAll("Not Started", "In Progress", "Completed");
        statusCombo.setValue("Not Started");

        TextField hoursField = new TextField();
        hoursField.setPromptText("Hours played");

        TextField completionField = new TextField();
        completionField.setPromptText("Completion %");

        TextField genreField = new TextField();
        genreField.setPromptText("Genre");

        TextArea notesArea = new TextArea();
        notesArea.setPromptText("Notes");
        notesArea.setPrefRowCount(3);

        // Buttons
        Button addButton = new Button("Add Game");
        Button updateButton = new Button("Update Game");

        // Layout for input fields
        GridPane inputGrid = new GridPane();
        inputGrid.setPadding(new Insets(10));
        inputGrid.setHgap(10);
        inputGrid.setVgap(10);

        inputGrid.add(new Label("Item Title:"), 0, 0);
        inputGrid.add(titleField, 1, 0);

        inputGrid.add(new Label("Platform:"), 0, 1);
        inputGrid.add(platformField, 1, 1);

        inputGrid.add(new Label("Status / Progress:"), 0, 2);
        inputGrid.add(statusCombo, 1, 2);

        inputGrid.add(new Label("Hours Played:"), 0, 3);
        inputGrid.add(hoursField, 1, 3);

        inputGrid.add(new Label("Completion %:"), 0, 4);
        inputGrid.add(completionField, 1, 4);

        inputGrid.add(new Label("Genre:"), 0, 5);
        inputGrid.add(genreField, 1, 5);

        inputGrid.add(new Label("Notes:"), 0, 6);
        inputGrid.add(notesArea, 1, 6);

        HBox buttonBox = new HBox(10, addButton, updateButton);
        inputGrid.add(buttonBox, 1, 7);

        // Main layout
        HBox mainLayout = new HBox(20);
        mainLayout.setPadding(new Insets(10));
        mainLayout.getChildren().addAll(inputGrid, gameListView);

        // Event: Add Game
        addButton.setOnAction(e -> {
            try {
                String title = titleField.getText();
                String platform = platformField.getText();
                String status = statusCombo.getValue();
                int hours = Integer.parseInt(hoursField.getText());
                int completion = Integer.parseInt(completionField.getText());
                String genre = genreField.getText();
                String notes = notesArea.getText();
                LocalDate today = LocalDate.now();

                if (title.isEmpty() || platform.isEmpty()) {
                    showAlert("Title and Platform cannot be empty.");
                    return;
                }

                Game game = new Game(gameManager.getGames().size() + 1, title, platform, status,
                        hours, completion, genre, notes, today, today);

                gameManager.addGame(game);
                gameListView.getItems().add(game.getTitle());

                clearFields(titleField, platformField, statusCombo, hoursField, completionField, genreField, notesArea);

            } catch (NumberFormatException ex) {
                showAlert("Hours Played and Completion % must be numeric.");
            } catch (IllegalArgumentException ex) {
                showAlert(ex.getMessage());
            }
        });

        // Event: Update Game
        updateButton.setOnAction(e -> {
            String selected = gameListView.getSelectionModel().getSelectedItem();
            if (selected == null) {
                showAlert("Select a game from the list to update.");
                return;
            }

            Game game = gameManager.findGameByTitle(selected);
            if (game != null) {
                try {
                    game.setTitle(titleField.getText());
                    game.setPlatform(platformField.getText());
                    game.setStatus(statusCombo.getValue());
                    game.setHoursPlayed(Integer.parseInt(hoursField.getText()));
                    game.setCompletionPercent(Integer.parseInt(completionField.getText()));
                    game.setGenre(genreField.getText());
                    game.setNotes(notesArea.getText());

                    int index = gameListView.getSelectionModel().getSelectedIndex();
                    gameListView.getItems().set(index, game.getTitle());

                    clearFields(titleField, platformField, statusCombo, hoursField, completionField, genreField, notesArea);

                } catch (NumberFormatException ex) {
                    showAlert("Hours Played and Completion % must be numeric.");
                } catch (IllegalArgumentException ex) {
                    showAlert(ex.getMessage());
                }
            }
        });

        // Event: Populate fields when selecting a game
        gameListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                Game game = gameManager.findGameByTitle(newVal);
                if (game != null) {
                    titleField.setText(game.getTitle());
                    platformField.setText(game.getPlatform());
                    statusCombo.setValue(game.getStatus());
                    hoursField.setText(String.valueOf(game.getHoursPlayed()));
                    completionField.setText(String.valueOf(game.getCompletionPercent()));
                    genreField.setText(game.getGenre());
                    notesArea.setText(game.getNotes());
                }
            }
        });

        Scene scene = new Scene(mainLayout, 900, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.showAndWait();
    }

    private void clearFields(TextField title, TextField platform, ComboBox<String> status,
                             TextField hours, TextField completion, TextField genre, TextArea notes) {
        title.clear();
        platform.clear();
        status.setValue("Not Started");
        hours.clear();
        completion.clear();
        genre.clear();
        notes.clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
