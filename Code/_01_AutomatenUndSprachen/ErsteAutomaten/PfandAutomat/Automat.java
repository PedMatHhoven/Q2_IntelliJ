package _01_AutomatenUndSprachen.ErsteAutomaten.PfandAutomat;

public class Automat {
    //Definitionen von Alphabeten und Zustandsmenge
    public enum tEingabe {eEinweg, eMehrweg, eGlas, eKasten, eAuszahlen};
    public enum tAusgabe {aNichts, aX, aXplus15, aXplus25, aXplus8, aXplus240};
    public enum tZustand {z0, z1};

    private tZustand zustand;

    public Automat() {
        zustand = tZustand.z0;
    }

    public tZustand getZustand() {
        return zustand;
    }

    public void setZustand(tZustand z) {
        zustand = z;
    }

    public tZustand uebergangsfunktion(tEingabe ein, tZustand zu) {
        tZustand zus = null;
        switch (zu) {
            case z0:
                switch (ein) {
                    case eAuszahlen:
                        zus = tZustand.z0;
                        break;
                    default: zus = tZustand.z1;
                }
                break;
            case z1:
                switch (ein) {
                    case eAuszahlen:
                        zus = tZustand.z0;
                        break;
                    default: zus = tZustand.z1;
                }
                break;
        }
        return zus;
    }

    public tAusgabe ausgabefunktion(tEingabe ein, tZustand zu) {
        tAusgabe ausgabe = null;
        switch (zu) {
            case z0:
                switch (ein) {
                    case eAuszahlen:
                        ausgabe = tAusgabe.aNichts;
                        break;
                    case eGlas:
                        ausgabe = tAusgabe.aXplus8;
                        break;
                    case eEinweg:
                        ausgabe = tAusgabe.aXplus25;
                        break;
                    case eKasten:
                        ausgabe = tAusgabe.aXplus240;
                        break;
                    case eMehrweg:
                        ausgabe = tAusgabe.aXplus15;
                        break;
                } break;
            case z1:
                switch (ein) {
                    case eAuszahlen:
                        ausgabe = tAusgabe.aX;
                        break;
                    case eGlas:
                        ausgabe = tAusgabe.aXplus8;
                        break;
                    case eEinweg:
                        ausgabe = tAusgabe.aXplus25;
                        break;
                    case eKasten:
                        ausgabe = tAusgabe.aXplus240;
                        break;
                    case eMehrweg:
                        ausgabe = tAusgabe.aXplus15;
                        break;
                }
                break;
        } return ausgabe;
    }
}