package _01_AutomatenUndSprachen.Akzeptoren_DEA.SOS;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller_SOS_Automat {
    @FXML
    private Label lblEingabe;
    @FXML
    private Label lblMessage;

    SOS_Automat sos_automat = new SOS_Automat();
    SOS_Automat.tEingabe eingabe;
    SOS_Automat.tZustand zustandNeu;

    public void btLang_onClick() {
        eingabe = SOS_Automat.tEingabe.lang;
        zustandNeu = sos_automat.uebergangsfunktion(eingabe, sos_automat.getZustand());
        sos_automat.setZustand(zustandNeu);
        String msg = lblEingabe.getText();
        lblEingabe.setText(msg + " l");
        print(zustandNeu, SOS_Automat.tEingabe.lang);
    }

    public void btKurz_onClick() {
        eingabe = SOS_Automat.tEingabe.kurz;
        zustandNeu = sos_automat.uebergangsfunktion(eingabe, sos_automat.getZustand());
        sos_automat.setZustand(zustandNeu);
        String msg = lblEingabe.getText();
        lblEingabe.setText(msg + " k");
        print(zustandNeu, SOS_Automat.tEingabe.kurz);
    }

    public void print(SOS_Automat.tZustand pZustand, SOS_Automat.tEingabe pEingabe) {
        System.out.println("Eingabe: " + pEingabe + " | (neuer) Zustand: " + pZustand);
        if (pZustand == SOS_Automat.tZustand.z9){
            System.out.println("SOS-NACHRICHT FERTIG ÜBERMITTELT!\n\n");
            lblMessage.setVisible(true);
            lblMessage.setText("SOS-NACHRICHT FERTIG ÜBERMITTELT!");
        }
        else lblMessage.setVisible(false);
    }
}
