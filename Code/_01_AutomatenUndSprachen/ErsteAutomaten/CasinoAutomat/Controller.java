package _01_AutomatenUndSprachen.ErsteAutomaten.CasinoAutomat;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class Controller {
    @FXML
    ListView<String> Liste_Zustand = new ListView();
    @FXML
    ListView<String> Liste_Eingabe = new ListView();
    @FXML
    ListView<String> Liste_Ausgabe = new ListView();
    @FXML
    Button btn_Spielen = new Button();
    @FXML
    Button btn_Einzahlen = new Button();
    @FXML
    Button btn_Abbruch = new Button();
    @FXML
    Button btn_Gewinnen = new Button();
    @FXML
    Button btn_Verlieren = new Button();
    @FXML
    Button btn_LOS = new Button();

    Automat automat = new Automat();
    Automat.tZustand zustandNeu;
    Automat.tEingabe eingabe;
    Automat.tAusgabe ausgabe;

    Object[] ein_aus_zus;

    public void los() {
        Liste_Zustand.getItems().add(automat.getZustand().name());
    }

    public void start(Event e) {
        if (e.getSource() == btn_Spielen) eingabe = Automat.tEingabe.Spielen;
        else if (e.getSource() == btn_Abbruch) eingabe = Automat.tEingabe.Abbruch;
        else if (e.getSource() == btn_Einzahlen) eingabe = Automat.tEingabe.Einzahlen;
        else if (e.getSource() == btn_Gewinnen) eingabe = Automat.tEingabe.Gewinnen;
        else if (e.getSource() == btn_Verlieren) eingabe = Automat.tEingabe.Verlieren;
        ein_aus_zus = automat.uebergangsfunktion(eingabe, automat.getZustand());

        eingabe = (Automat.tEingabe) ein_aus_zus[0];
        ausgabe = (Automat.tAusgabe) ein_aus_zus[1];
        zustandNeu = (Automat.tZustand) ein_aus_zus[2];

        Liste_Eingabe.getItems().add(eingabe.name()+"");
        Liste_Ausgabe.getItems().add(ausgabe.name()+"");
        Liste_Zustand.getItems().add(zustandNeu.name()+"");
    }
}
