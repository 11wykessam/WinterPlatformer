import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Simple game programmed over the Winter 2019/2020 break.
 * @author Samuel Wykes
 */
public class WinterGame extends Application {

    // the window the program runs in.
    private Stage window;

    // the scene for the actual gameplay.
    private Scene gameScene;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Executed when the program first starts.
     * @param primaryStage The window the program is being ran in.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // set up the window.
        window = primaryStage;
        window.setTitle("Winter common.Game");
        window.setResizable(false);

        // set up the scene.
        gameScene = new Scene(FXMLLoader.load(getClass().getResource("FXML/game-screen.fxml")));
        window.setScene(gameScene);

        window.show();
    }
}
