package _01_AutomatenUndSprachen.ErsteAutomaten.DualzahlGeradeUngerade.mitJavaFX;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private TextField tfEingabe;
    @FXML
    private TextField tfZustand;
    @FXML
    private TextField tfAusgabe;
    @FXML
    private Button btAction;

    Automat automat = new Automat();
    Automat.tEingabe eingabe;
    Automat.tAusgabe ausgabe;
    Automat.tZustand zustandNeu;
    int i = -1; //für Position des einzulesenden Zeichen

    public String GibAus(Automat.tAusgabe ausgabe) {
        //Konvertierung - Automaten-Ausgabe zu String
        String s = "";
        switch (ausgabe) {
            case  aGerade:
                s = "gerade";
                break;
            case  aUngerade:
                s = "ungerade";
                break;
        }
        return s;
    }

    public Automat.tEingabe LiesEingabe(char zeichen) {
        //Konvertierung - Character zu Automaten-Eingabe
        switch (zeichen) {
            case '0':
                eingabe = Automat.tEingabe.e0;
                break;
            case '1':
                eingabe = Automat.tEingabe.e1;
                break;
        }
        return eingabe;
    }

    public void btAction_onClick() {
        //Arbeit(sweise) des Automaten
        i++;
        int t = tfEingabe.getText().length();
        if (i < t) {
            char c = tfEingabe.getText().charAt(i);
            eingabe = LiesEingabe(c);
            ausgabe = automat.ausgabefunktion(eingabe, automat.getZustand());
            tfAusgabe.setText(GibAus(ausgabe));
            zustandNeu = automat.uebergangsfunktion(eingabe, automat.getZustand());
            automat.setZustand(zustandNeu);
            tfZustand.setText("" + automat.getZustand());
            tfZustand.setLayoutX(tfZustand.getLayoutX()+7);
            if (i == t-1) btAction.setText("Ende!");
        }
    }
}
