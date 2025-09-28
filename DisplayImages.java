import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();

        grid.add(createImageView("images/image1.jpg"), 0, 0);
        grid.add(createImageView("images/flag2.jpg"), 1, 0);
        grid.add(createImageView("images/squ3.jpeg"), 0, 1);
        grid.add(createImageView("images/stock4.jpg"), 1, 1);

        Scene scene = new Scene(grid);
        primaryStage.setTitle("Exercise14_01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ImageView createImageView(String path) {
        ImageView iv = new ImageView(new Image("file:" + path));
        iv.setFitWidth(150);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);
        return iv;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
