package _01_AutomatenUndSprachen.Akzeptoren_DEA.SOS;

public class SOS_Automat {
    public enum tEingabe {kurz, lang}
    public enum tZustand {z0, z1, z2, z3, z4, z5, z6, z7, z8, z9}

    private tZustand zustand;

    public SOS_Automat() {
        zustand = tZustand.z0;
    }

    public tZustand getZustand() {
        return zustand;
    }

    public void setZustand(tZustand z) {
        zustand = z;
    }

    public tZustand uebergangsfunktion(tEingabe pEingabe, tZustand pZustand) {
        switch (pZustand) {
            case z0 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z1;
                }
            }
            case z1 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z2;
                }
                else pZustand = tZustand.z0;
            }
            case z2 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z3;
                }
                else pZustand = tZustand.z0;
            }
            case z3 -> {
                if (pEingabe == tEingabe.lang) {
                    pZustand = tZustand.z4;
                }
            }
            case z4 -> {
                if (pEingabe == tEingabe.lang) {
                    pZustand = tZustand.z5;
                }
                else pZustand = tZustand.z1;
            }
            case z5 -> {
                if (pEingabe == tEingabe.lang) {
                    pZustand = tZustand.z6;
                }
                else pZustand = tZustand.z1;
            }
            case z6 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z7;
                }
                else pZustand = tZustand.z0;
            }
            case z7 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z8;
                }
                else pZustand = tZustand.z0;
            }
            case z8 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z9;
                }
                else pZustand = tZustand.z0;
            }
            case z9 -> {
                if (pEingabe == tEingabe.kurz) {
                    pZustand = tZustand.z3;
                }
                else pZustand = tZustand.z4;
            }
        }
        return pZustand;
    }
}