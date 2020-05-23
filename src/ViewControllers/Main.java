package ViewControllers;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    private Motor motor = new Motor();

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainScreen.fxml"));
        Parent root = loader.load();
        mainScreen controller = loader.<mainScreen>getController();
        controller.receiveMotorInstance(motor);

        primaryStage.setTitle("PokeCetys");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

        motor.createAllPokemon();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
