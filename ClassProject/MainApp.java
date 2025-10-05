package ClassProject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainApp extends Application {

    private GameManager gameManager = new GameManager(""); // filePath not used in GUI
    private ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SDEV 200 Final Project");

        // --- Game Input ---
        HBox gameBox = new HBox(10);
        TextField gameNameField = new TextField();
        Button addGameButton = new Button("Add Game");
        gameBox.getChildren().addAll(new Label("Game Name:"), gameNameField, addGameButton);

        // --- Item Input ---
        HBox itemBox = new HBox(10);
        TextField itemTitleField = new TextField();
        ComboBox<String> statusCombo = new ComboBox<>();
        statusCombo.getItems().addAll("Not Started", "In Progress", "Completed");
        statusCombo.setValue("Not Started");
        Button addItemButton = new Button("Add Item");
        itemBox.getChildren().addAll(new Label("Item Title:"), itemTitleField,
                                     new Label("Progress:"), statusCombo, addItemButton);

        Label outputLabel = new Label("Output will appear here");

        // --- Add Game Event ---
        addGameButton.setOnAction(e -> {
            String name = gameNameField.getText();
            if (!name.isEmpty()) {
                Game game = new Game(gameManager.getNextItemId(), name, "Unknown", "Not Started",
                                     0, 0, "Unknown", "", java.time.LocalDate.now(), java.time.LocalDate.now());
                gameManager.addGame(game);
                outputLabel.setText("Game added: " + name);
                gameNameField.clear();
                updateListView();
            } else {
                outputLabel.setText("Please enter a game name.");
            }
        });

        // --- Add Item Event ---
        addItemButton.setOnAction(e -> {
            String title = itemTitleField.getText();
            String status = statusCombo.getValue();
            if (!title.isEmpty()) {
                int id = gameManager.getNextItemId();
                GameItem item = new GameItem(id, title, "Unknown", status);
                try {
                    gameManager.addItemToLastGame(item);
                    outputLabel.setText("Item added: " + title + " (" + status + ")");
                    itemTitleField.clear();
                    statusCombo.setValue("Not Started");
                    updateListView();
                } catch (IllegalStateException ex) {
                    outputLabel.setText("Please add a game first.");
                }
            } else {
                outputLabel.setText("Please enter an item title.");
            }
        });

        VBox root = new VBox(10);
        root.setStyle("-fx-padding: 20;");
        root.getChildren().addAll(gameBox, itemBox, listView, outputLabel);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateListView() {
        listView.getItems().clear();
        for (Game g : gameManager.getGames()) {
            listView.getItems().add("Game: " + g.getTitle());
            for (Item i : g.getItems()) {
                listView.getItems().add("  - " + i.getTitle() + " (" + i.getStatus() + ")");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
