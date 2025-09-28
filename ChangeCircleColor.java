import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ChangeCircleColor extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a circle with initial color yellow
        Circle circle = new Circle(150, 150, 50);
        circle.setFill(Color.YELLOW);

        Pane pane = new Pane(circle);

        // Change circle color to purple when the circle is pressed
        circle.setOnMousePressed(e -> circle.setFill(Color.PURPLE));

        // Change circle color back to yellow when the circle is released
        circle.setOnMouseReleased(e -> circle.setFill(Color.YELLOW));

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Interactive Circle Color Change");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
