package _01_AutomatenUndSprachen.ErsteAutomaten_Mealy.CasinoAutomat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        pStage.setScene(scene);
        pStage.show();
        pStage.setTitle("Faires Casino");
    }
}

