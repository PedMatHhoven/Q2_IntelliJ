package _01_AutomatenUndSprachen.Akzeptoren_DEA.ungeradeAnzahlEinsen;

public class Automat{
  //Definition der Alphabete
  public enum tZustand{zGerade, zUngerade};
  public enum tEingabe{e0, e1};
  
  private tZustand zustand;
  
  public Automat(){
    zustand = tZustand.zGerade;
  }
  
  public void reset() {
    zustand = tZustand.zGerade;
  }
  
  public tZustand getZustand(){
    return zustand;
  }
  
  public void uebergangsfunktion(tEingabe ein, tZustand zu){
    switch (zu) {
      case zGerade: 
      switch(ein){
        case e0: 
        zustand = tZustand.zGerade;
        break;
        case e1:
        zustand = tZustand.zUngerade;
        break;
      }
      break;
      case zUngerade: 
      switch (ein) {
        case  e0: 
        zustand = tZustand.zUngerade;
        break;
        case  e1: 
        zustand = tZustand.zGerade;
        break;  
      } 
      break;
    } 
  }
}