package _01_AutomatenUndSprachen.ErsteAutomaten.PfandAutomat;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Simulation {
    @FXML
    private ListView lv;

    Automat automat = new Automat();
    Automat.tEingabe eingabe;
    Automat.tAusgabe ausgabe;
    Automat.tZustand zustandNeu;
    public int x=0; //weiterer Speicher

    public String GibAus(Automat.tAusgabe aus) {
        String s = "";
        switch (aus) {
            case aXplus25:
                s = "25 cent mehr";
                x+=25;
                break;
            case aXplus15:
                s = "15 cent mehr!";
                x+=15;
                break;
            case aXplus8:
                s = "8 cent mehr";
                x+=8;
                break;
            case aXplus240:
                s = "240 cent mehr";
                x+=240;
                break;
            case aX:
                s = "Hier Ihre " +  x + " cent";
                x = 0;
                break;
            case aNichts:
                s = "Leider keine Ausgabe!";
                break;
        }
        return s;
    }

    public void arbeite() {
        ausgabe = automat.ausgabefunktion(eingabe, automat.getZustand());
        zustandNeu = automat.uebergangsfunktion(eingabe, automat.getZustand());
        automat.setZustand(zustandNeu);
        lv.getItems().add(GibAus(ausgabe) + ", " + zustandNeu);
    }

    public void btGlas_onClick() {
        eingabe = Automat.tEingabe.eGlas;
        arbeite();
    }

    public void btKasten_onClick() {
        eingabe = Automat.tEingabe.eKasten;
        arbeite();
    }

    public void btEinweg_onClick() {
        eingabe = Automat.tEingabe.eEinweg;
        arbeite();
    }

    public void btMehrweg_onClick() {
        eingabe = Automat.tEingabe.eMehrweg;
        arbeite();
    }

    public void btAuszahlen_onClick() {
        eingabe = Automat.tEingabe.eAuszahlen;
        arbeite();
    }
}