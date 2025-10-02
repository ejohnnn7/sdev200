package WeeklyProjects;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;

public class StaffManagerFX extends Application {

    // DB connection
    private Connection conn;
    private PreparedStatement viewStmt, insertStmt, updateStmt;

    // GUI fields
    private TextField tfId = new TextField();
    private TextField tfLastName = new TextField();
    private TextField tfFirstName = new TextField();
    private TextField tfMi = new TextField();
    private TextField tfAddress = new TextField();
    private TextField tfCity = new TextField();
    private TextField tfState = new TextField();
    private TextField tfTelephone = new TextField();
    private TextField tfEmail = new TextField();

    private Button btView = new Button("View");
    private Button btInsert = new Button("Insert");
    private Button btUpdate = new Button("Update");

    @Override
    public void start(Stage primaryStage) {
        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(8);

        // Add labels and fields
        grid.add(new Label("ID:"), 0, 0); grid.add(tfId, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1); grid.add(tfLastName, 1, 1);
        grid.add(new Label("First Name:"), 0, 2); grid.add(tfFirstName, 1, 2);
        grid.add(new Label("MI:"), 0, 3); grid.add(tfMi, 1, 3);
        grid.add(new Label("Address:"), 0, 4); grid.add(tfAddress, 1, 4);
        grid.add(new Label("City:"), 0, 5); grid.add(tfCity, 1, 5);
        grid.add(new Label("State:"), 0, 6); grid.add(tfState, 1, 6);
        grid.add(new Label("Telephone:"), 0, 7); grid.add(tfTelephone, 1, 7);
        grid.add(new Label("Email:"), 0, 8); grid.add(tfEmail, 1, 8);

        // Buttons row
        HBox buttonBox = new HBox(10, btView, btInsert, btUpdate);
        grid.add(buttonBox, 1, 9);

        // Connect to database
        connectDB();

        // Button actions
        btView.setOnAction(e -> viewRecord());
        btInsert.setOnAction(e -> insertRecord());
        btUpdate.setOnAction(e -> updateRecord());

        // Create scene
        Scene scene = new Scene(grid, 450, 400);
        primaryStage.setTitle("Staff Manager (JavaFX)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void connectDB() {
        try {

            // Prepare statements
            viewStmt = conn.prepareStatement("SELECT * FROM Staff WHERE id = ?");
            insertStmt = conn.prepareStatement(
                "INSERT INTO Staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            updateStmt = conn.prepareStatement(
                "UPDATE Staff SET lastName=?, firstName=?, mi=?, address=?, city=?, state=?, telephone=?, email=? WHERE id=?");

            System.out.println("Connected to DB.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void viewRecord() {
        try {
            viewStmt.setString(1, tfId.getText().trim());
            ResultSet rs = viewStmt.executeQuery();
            if (rs.next()) {
                tfLastName.setText(rs.getString("lastName"));
                tfFirstName.setText(rs.getString("firstName"));
                tfMi.setText(rs.getString("mi"));
                tfAddress.setText(rs.getString("address"));
                tfCity.setText(rs.getString("city"));
                tfState.setText(rs.getString("state"));
                tfTelephone.setText(rs.getString("telephone"));
                tfEmail.setText(rs.getString("email"));
            } else {
                showAlert("No record found for ID " + tfId.getText());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRecord() {
        try {
            insertStmt.setString(1, tfId.getText().trim());
            insertStmt.setString(2, tfLastName.getText().trim());
            insertStmt.setString(3, tfFirstName.getText().trim());
            insertStmt.setString(4, tfMi.getText().trim());
            insertStmt.setString(5, tfAddress.getText().trim());
            insertStmt.setString(6, tfCity.getText().trim());
            insertStmt.setString(7, tfState.getText().trim());
            insertStmt.setString(8, tfTelephone.getText().trim());
            insertStmt.setString(9, tfEmail.getText().trim());

            int rows = insertStmt.executeUpdate();
            showAlert(rows + " record inserted.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateRecord() {
        try {
            updateStmt.setString(1, tfLastName.getText().trim());
            updateStmt.setString(2, tfFirstName.getText().trim());
            updateStmt.setString(3, tfMi.getText().trim());
            updateStmt.setString(4, tfAddress.getText().trim());
            updateStmt.setString(5, tfCity.getText().trim());
            updateStmt.setString(6, tfState.getText().trim());
            updateStmt.setString(7, tfTelephone.getText().trim());
            updateStmt.setString(8, tfEmail.getText().trim());
            updateStmt.setString(9, tfId.getText().trim());

            int rows = updateStmt.executeUpdate();
            showAlert(rows + " record updated.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
