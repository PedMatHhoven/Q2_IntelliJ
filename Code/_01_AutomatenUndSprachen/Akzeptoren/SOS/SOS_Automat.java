package _01_AutomatenUndSprachen.Akzeptoren.SOS;

public class SOS_Automat {
    public SOS_Automat(){

    }

    public enum tZustand {z0, z1, z2, z3, z4, z5, z6, z7, z8, z9}
    public enum tEingabe {kurz, lang}

    tZustand zustand = tZustand.z0;

    public tZustand uebergangsfunktion(tZustand pZustand, tEingabe pEingabe) {
        zustand = pZustand;
        switch (zustand){
            case z0 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z1;
                }
            }
            case z1 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z2;
                }
                else zustand = tZustand.z0;
            }
            case z2 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z3;
                }
                else zustand = tZustand.z0;
            }
            case z3 -> {
                if (pEingabe == tEingabe.lang) {
                    zustand = tZustand.z4;
                }
            }
            case z4 -> {
                if (pEingabe == tEingabe.lang) {
                    zustand = tZustand.z5;
                }
                else zustand = tZustand.z1;
            }
            case z5 -> {
                if (pEingabe == tEingabe.lang) {
                    zustand = tZustand.z6;
                }
                else zustand = tZustand.z1;
            }
            case z6 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z7;
                }
                else zustand = tZustand.z0;
            }
            case z7 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z8;
                }
                else zustand = tZustand.z0;
            }
            case z8 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z9;
                }
                else zustand = tZustand.z0;
            }
            case z9 -> {
                if (pEingabe == tEingabe.kurz) {
                    zustand = tZustand.z3;
                }
                else zustand = tZustand.z4;
            }
        }
        return zustand;
    }
}
