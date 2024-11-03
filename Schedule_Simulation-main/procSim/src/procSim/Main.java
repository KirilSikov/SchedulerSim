package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The following opens the GUI to the user to interact,
 * starting setting up and displaying the main landing page.
 * @author kiril and Enrik
 */
public class Main extends Application {
    private Parent root;
    private Stage appStage;

    @Override
    public void start(Stage primaryStage) {
        try {
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            appStage = new Stage();
            appStage.setTitle("Scheduling Simulator");
            appStage.setScene(new Scene(root,350,347));
            appStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
