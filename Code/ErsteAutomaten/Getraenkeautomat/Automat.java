package ErsteAutomaten.Getraenkeautomat;

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
  
  public void uebergangsfunktion(tEingabe ein, tZustand zu) {
    switch (zu) {
      case z0: 
      switch (ein) {
        case e1: 
        zustand = tZustand.z1;
        break;
        case e50: 
        zustand = tZustand.z2;
        break;
        case eWare: 
        case eAbbruch: 
        zustand = tZustand.z0;
        break;
      }
      break;
      case z1: 
      switch (ein) {
        case e1: 
        case e50: 
        zustand = tZustand.z1;
        break;
        case eWare: 
        case eAbbruch: 
        zustand = tZustand.z0;
        break;
      }
      break;
      case z2: 
      switch (ein) {
        case e1: 
        zustand = tZustand.z2;
        break;
        case e50: 
        zustand = tZustand.z1;
        break;
        case eWare:
        zustand = tZustand.z2; 
        break;
        case eAbbruch: 
        zustand = tZustand.z0;
        break;
      }
      break;
    }
  }
  
  public tAusgabe ausgabefunktion(tEingabe ein, tZustand zu) {
    tAusgabe ausgabe = tAusgabe.aNichts;
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
