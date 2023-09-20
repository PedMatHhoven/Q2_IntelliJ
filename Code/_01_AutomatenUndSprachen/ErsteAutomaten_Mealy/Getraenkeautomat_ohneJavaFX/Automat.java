package _01_AutomatenUndSprachen.ErsteAutomaten_Mealy.Getraenkeautomat_ohneJavaFX;

public class Automat {
  //Definitionen von Alphabeten und Zustandsmenge
  public enum tEingabe {e1, e50, eWare, eAbbruch};
  public enum tAusgabe {a1, a50, aWare, aNichts};
  public enum tZustand {z0, z1, z2};
  
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
        case e1: 
        zus = tZustand.z1;
        break;
        case e50: 
        zus = tZustand.z2;
        break;
        case eWare: 
        case eAbbruch: 
        zus = tZustand.z0;
        break;
      }
      break;
      case z1: 
      switch (ein) {
        case e1: 
        case e50: 
        zus = tZustand.z1;
        break;
        case eWare: 
        case eAbbruch: 
        zus = tZustand.z0;
        break;
      }
      break;
      case z2: 
      switch (ein) {
        case e1: 
        zus = tZustand.z2;
        break;
        case e50: 
        zus = tZustand.z1;
        break;
        case eWare:
        zus = tZustand.z2;
        break;
        case eAbbruch: 
        zus = tZustand.z0;
        break;
      }
      break;
    }
    return zus;
  }
  
  public tAusgabe ausgabefunktion(tEingabe ein, tZustand zu) {
    tAusgabe ausgabe = null;
    switch (zu) {
      case z0: 
      ausgabe = tAusgabe.aNichts;
      break;
      case z1: 
      switch (ein) {
        case e1: 
        ausgabe = tAusgabe.a1;
        break;
        case e50: 
        ausgabe = tAusgabe.a50;
        break;
        case eWare:
        ausgabe = tAusgabe.aWare; 
        break;
        case eAbbruch: 
        ausgabe = tAusgabe.a1;
        break;
      }
      break;
      case z2: 
      switch (ein) {
        case e1: 
        ausgabe = tAusgabe.a1;
        break;
        case e50: 
        ausgabe = tAusgabe.aNichts;
        break;
        case eWare:
        ausgabe = tAusgabe.aNichts;
        break; 
        case eAbbruch: 
        ausgabe = tAusgabe.a50;
        break;
      }
      break;
    }
    return ausgabe;
  }
}
