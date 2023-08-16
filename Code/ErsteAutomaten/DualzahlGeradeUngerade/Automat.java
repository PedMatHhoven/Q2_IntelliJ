package ErsteAutomaten.DualzahlGeradeUngerade;

public class Automat {
  //Definitionen von Alphabeten und Zustandsmenge
  public enum tEingabe {e1,e0};
  public enum tAusgabe {aUngerade, aGerade};
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
    switch (zu) {
      case z0: 
      switch (ein) {
        case  e1: 
        zustand = tZustand.z0;
        break;
        case  e0: 
        zustand = tZustand.z1;
        break;
      }
      break;
      case z1: 
      switch (ein) {
        case  e1: 
        zustand = tZustand.z0;
        break;
        case  e0: 
        zustand = tZustand.z1;
        break;
      }  
      break;
    }
    return zustand;
  }  
  
  public tAusgabe ausgabefunktion(tEingabe ein, tZustand zu) {
    tAusgabe ausgabe = tAusgabe.aGerade;
    switch (zu) {
      case z0: 
      switch (ein) {
        case  e1: 
        ausgabe = tAusgabe.aUngerade;
        break;
        case  e0: 
        ausgabe = tAusgabe.aGerade;
        break;
      }
      break;
      case z1: 
      switch (ein) {
        case  e1: 
        ausgabe = tAusgabe.aUngerade;
        break;
        case  e0: 
        ausgabe = tAusgabe.aGerade;
        break;
      }  
      break;
    }
    return ausgabe;
  } 
}
