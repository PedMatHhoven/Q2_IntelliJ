package _01_AutomatenUndSprachen.Akzeptoren_DEA.SOS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main_SOS_Automat extends Application {
    public static void main(String[] args) {
        System.out.println("Eingabe: nichts | (neuer) Zustand: z0");
        launch(args);
        System.out.println("Hilfe ist Unterwegs!");
        System.out.println("Ertrinken Sie bitte nicht...");
    }
    @Override
    public void start(Stage pStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML_SOS_Automat.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        pStage.setScene(scene);
        pStage.setTitle("Digitale SOS-Übermittlung");
        pStage.show();
    }
}
