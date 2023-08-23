package _01_AutomatenUndSprachen.ErsteAutomaten.CasinoAutomat;
//Orignial von Eren erstellt - ein wenig angepasst!
//gute JavaFX-Vorlage - speziell für Version mit parallelen Bändern!
//- Definition aber nicht 1:1 wie vorgegeben im Unterricht!
//- demnächst ggf. mal eine "Mischung" programmieren!

public class Automat {
    //Definitionen von Alphabeten und Zustandsmenge
    public enum tEingabe {Abbruch, Spielen, Einzahlen, Gewinnen, Verlieren};
    public enum tAusgabe {Spielen, Nichts, Abbruch, Spielbar, Verloren, Gewonnen};
    public enum tZustand {q1, q2, q3, q4, q5};

    private tZustand zustand;

    public Automat() {
        zustand = tZustand.q1;
    }

    public tZustand getZustand() {
        return zustand;
    }

    public void setZustand(tZustand z) {
        zustand = z;
    }

    public Object[] uebergangsfunktion(tEingabe ein, tZustand zu) {
        tAusgabe ausgabe = tAusgabe.Nichts;
        switch (zu) {
            case q1:
                switch (ein) {
                    case Einzahlen:
                        zustand = tZustand.q2;
                        ausgabe = tAusgabe.Spielbar;
                        break;
                    case Abbruch:
                    case Spielen:
                    case Gewinnen:
                    case Verlieren:
                        zustand = tZustand.q1;
                        ausgabe = tAusgabe.Nichts;
                        break;
                }
                break;
            case q2:
                switch (ein) {
                    case Abbruch:
                        zustand = tZustand.q1;
                        ausgabe = tAusgabe.Abbruch;
                        break;
                    case Spielen:
                        zustand = tZustand.q3;
                        ausgabe = tAusgabe.Spielen;
                        break;
                    case Einzahlen:
                    case Gewinnen:
                    case Verlieren:
                        zustand = tZustand.q2;
                        ausgabe = tAusgabe.Nichts;
                        break;
                }
                break;
            case q3:
                switch (ein) {
                    case Abbruch:
                        zustand = tZustand.q1;
                        ausgabe = tAusgabe.Abbruch;
                        break;
                    case Gewinnen:
                        zustand = tZustand.q5;
                        ausgabe = tAusgabe.Gewonnen;
                        break;
                    case Verlieren:
                        zustand = tZustand.q4;
                        ausgabe = tAusgabe.Verloren;
                        break;
                    case Spielen:
                    case Einzahlen:
                        zustand = tZustand.q3;
                        ausgabe = tAusgabe.Nichts;
                        break;
                }
                break;
            case q4:
                switch (ein) {
                    case Abbruch:
                        zustand = tZustand.q1;
                        ausgabe = tAusgabe.Abbruch;
                        break;
                    case Spielen:
                        zustand = tZustand.q3;
                        ausgabe = tAusgabe.Spielen;
                        break;
                    case Gewinnen:
                    case Verlieren:
                    case Einzahlen:
                        zustand = tZustand.q4;
                        ausgabe = tAusgabe.Nichts;
                        break;
                }
                break;
            case q5:
                switch (ein) {
                    case Abbruch:
                        zustand = tZustand.q1;
                        ausgabe = tAusgabe.Abbruch;
                        break;
                    case Spielen:
                        zustand = tZustand.q3;
                        ausgabe = tAusgabe.Spielen;
                        break;
                    case Gewinnen:
                    case Verlieren:
                    case Einzahlen:
                        zustand = tZustand.q5;
                        ausgabe = tAusgabe.Nichts;
                        break;
                }
        }
        Object[] ein_aus_zus = {ein, ausgabe, zustand};
        return ein_aus_zus;
    }
}

