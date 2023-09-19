package _01_AutomatenUndSprachen.Akzeptoren.SOS;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller_SOS_Automat {
    @FXML
    private Button btKurz;
    @FXML
    private Button btLang;
    @FXML
    private Label lblEingabe;
    @FXML
    private Label lblMessage;

    SOS_Automat sos_automat = new SOS_Automat();
    SOS_Automat.tZustand zustand = SOS_Automat.tZustand.z0;

    public void btLang_onClick(){
        zustand = sos_automat.uebergangsfunktion(zustand, SOS_Automat.tEingabe.lang);
        String msg = lblEingabe.getText();
        lblEingabe.setText(msg + " l");
        print(zustand, SOS_Automat.tEingabe.lang);
    }

    public void btKurz_onClick(){
        zustand = sos_automat.uebergangsfunktion(zustand, SOS_Automat.tEingabe.kurz);
        String msg = lblEingabe.getText();
        lblEingabe.setText(msg + " k");
        print(zustand, SOS_Automat.tEingabe.kurz);
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
