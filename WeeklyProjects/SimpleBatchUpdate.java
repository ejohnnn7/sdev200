package WeeklyProjects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Random;

public class SimpleBatchUpdate extends Application {
    private TextArea outputArea;
    private Connection connection;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        outputArea = new TextArea();
        outputArea.setEditable(false);

        Button btnBatch = new Button("Batch Update");
        Button btnNonBatch = new Button("Non-Batch Update");

        btnBatch.setOnAction(e -> runBatchUpdate());
        btnNonBatch.setOnAction(e -> runNonBatchUpdate());

        HBox buttonBox = new HBox(10, btnBatch, btnNonBatch);
        VBox root = new VBox(10, outputArea, buttonBox);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Batch vs Non-Batch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /** Batch insert */
    private void runBatchUpdate() {
        if (connection == null) return;
        long start = System.currentTimeMillis();
        String sql = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Random rand = new Random();
            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, rand.nextDouble());
                pstmt.setDouble(2, rand.nextDouble());
                pstmt.setDouble(3, rand.nextDouble());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            long elapsed = System.currentTimeMillis() - start;
            outputArea.appendText("Batch update completed in " + elapsed + " ms\n\n");
        } catch (SQLException e) {
            outputArea.appendText("Batch error: " + e.getMessage() + "\n");
        }
    }

    /** Non-batch insert */
    private void runNonBatchUpdate() {
        if (connection == null) return;
        long start = System.currentTimeMillis();
        String sql = "INSERT INTO Temp (num1, num2, num3) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            Random rand = new Random();
            for (int i = 0; i < 1000; i++) {
                pstmt.setDouble(1, rand.nextDouble());
                pstmt.setDouble(2, rand.nextDouble());
                pstmt.setDouble(3, rand.nextDouble());
                pstmt.executeUpdate();
            }
            long elapsed = System.currentTimeMillis() - start;
            outputArea.appendText("Non-Batch update completed in " + elapsed + " ms\n\n");
        } catch (SQLException e) {
            outputArea.appendText("Non-Batch error: " + e.getMessage() + "\n");
        }
    }
}
