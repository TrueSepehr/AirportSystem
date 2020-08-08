import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {


        AnchorPane loginPane = FXMLLoader.load(MainClass.class.getResource("view/LoginScene.fxml"));
        primaryStage.setScene(new Scene(loginPane));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
