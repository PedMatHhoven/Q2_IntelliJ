package _01_AutomatenUndSprachen.Akzeptoren.ungeradeAnzahlEinsen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GUI extends JFrame {
  // Anfang Attribute
  private TextField textField1 = new TextField();
  private Label label1 = new Label();
  private TextField textField2 = new TextField();
  private Label label2 = new Label();
  private Button button1 = new Button();
  
  Automat automat = new Automat();
  Automat.tEingabe eingabe;
  // Ende Attribute
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 303; 
    int frameHeight = 123;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    textField1.setBounds(104, 16, 150, 20);
    cp.add(textField1);
    label1.setBounds(32, 16, 62, 20);
    label1.setText("Eingabe:");
    cp.add(label1);
    textField2.setBounds(184, 56, 70, 20);
    cp.add(textField2);
    label2.setBounds(104, 56, 70, 20);
    label2.setText("akzeptiert?");
    cp.add(label2);
    button1.setBounds(24, 48, 59, 25);
    button1.setLabel("pr�fen");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    setTitle("Ungerade Anzahl 1en?");
    // Ende Komponenten
    
    setVisible(true);
  } // end of public GUI
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI("GUI");
    
  } // end of main
  
  public void gibAntwort(Automat.tZustand zustand){
    if(zustand == Automat.tZustand.zGerade){
      textField2.setText("NEIN");
    } else {
      textField2.setText("JA");
    } 
  }
  
  public void button1_ActionPerformed(ActionEvent evt) {
    automat.reset();
    String eingabe = textField1.getText();
    int len = eingabe.length();
    System.out.println(len);
    for (int i = 0; i < len; i++) {
      if (eingabe.charAt(i) == '1') {
        automat.uebergangsfunktion(Automat.tEingabe.e1, automat.getZustand());
      } else {
        automat.uebergangsfunktion(Automat.tEingabe.e0, automat.getZustand());
      } 
    } 
    gibAntwort(automat.getZustand());
  } 
  // Ende Methoden
} // end of class GUI
