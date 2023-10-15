import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import views.Book;

public class MaSuperApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        primaryStage.setTitle("Ma première application JavaFX");


        Book b = new Book();

        BorderPane root = new BorderPane();

        root.setStyle("-fx-background-color: #171f34;");;
        root.setCenter(b);
        Scene main = new Scene(root,1280,720);
        primaryStage.setResizable(false);
        primaryStage.setScene(main);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
