package _01_AutomatenUndSprachen.Akzeptoren_DEA.ungeradeAnzahlEinsen_ohneJavaFX;

public class Automat {
  //Definition der Alphabete
  public enum tZustand{zGerade, zUngerade};
  public enum tEingabe{e0, e1};
  
  private tZustand zustand;
  
  public Automat(){
    zustand = tZustand.zGerade;
  }

  public tZustand getZustand(){
    return zustand;
  }

  public void setZustand(tZustand z) {
    zustand = z;
  }

  public tZustand uebergangsfunktion(tEingabe ein, tZustand zu){
    tZustand zus = null;
    switch (zu) {
      case zGerade: 
      switch(ein){
        case e0:
        zus = tZustand.zGerade;
        break;
        case e1:
        zus = tZustand.zUngerade;
        break;
      }
      break;
      case zUngerade: 
      switch (ein) {
        case  e0: 
        zus = tZustand.zUngerade;
        break;
        case  e1: 
        zus = tZustand.zGerade;
        break;  
      } 
      break;
    }
    return zus;
  }
}