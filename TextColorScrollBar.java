import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TextColorScrollBar extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label textLabel = new Label("Watch my color change!");
        textLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Create scroll bars for Red, Green, Blue, and Opacity
        ScrollBar redBar = createColorScrollBar();
        ScrollBar greenBar = createColorScrollBar();
        ScrollBar blueBar = createColorScrollBar();
        ScrollBar opacityBar = createColorScrollBar();
        opacityBar.setMax(1.0); // Opacity from 0.0 to 1.0
        opacityBar.setValue(1.0);

        // Update color whenever any scroll bar changes
        ChangeListener<Number> colorChangeListener = (observable, oldValue, newValue) -> {
            Color color = new Color(
                redBar.getValue() / 255.0,
                greenBar.getValue() / 255.0,
                blueBar.getValue() / 255.0,
                opacityBar.getValue()
            );
            textLabel.setTextFill(color);
        };

        redBar.valueProperty().addListener(colorChangeListener);
        greenBar.valueProperty().addListener(colorChangeListener);
        blueBar.valueProperty().addListener(colorChangeListener);
        opacityBar.valueProperty().addListener(colorChangeListener);

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(
            textLabel,
            new Label("Red"), redBar,
            new Label("Green"), greenBar,
            new Label("Blue"), blueBar,
            new Label("Opacity"), opacityBar
        );

        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Text Color Selector with ScrollBars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ScrollBar createColorScrollBar() {
        ScrollBar sb = new ScrollBar();
        sb.setMin(0);
        sb.setMax(255);
        sb.setValue(0);
        sb.setUnitIncrement(1);
        sb.setBlockIncrement(10);
        sb.setPrefWidth(300);
        return sb;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
