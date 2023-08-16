package ErsteAutomaten.Getraenkeautomat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simulation extends Frame {
  // Anfang Attribute
  private Label label1 = new Label();
  private Label label2 = new Label();
  private Label label3 = new Label();
  private TextField textField1 = new TextField();
  private TextField textField2 = new TextField();
  private TextField textField3 = new TextField();
  private Button button1 = new Button();
  private TextArea textArea1 = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  private JLabel jLabel1 = new JLabel();
    private ImageIcon jLabel1Icon = new ImageIcon("coke_classic.png");
  
  //globale Variablen inkl. Initialisierungen 
  Automat automat = new Automat();
  Automat.tEingabe eingabe;
  Automat.tAusgabe ausgabe;
  Automat.tZustand zustandNeu;
  int i = -1; //Position des einzulesenden Zeichens
  // Ende Attribute
  
  public Simulation(String title) {
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 274; 
    int frameHeight = 302;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    label1.setBounds(32, 144, 86, 20);
    label1.setText("Eingabeband");
    cp.add(label1);
    label2.setBounds(32, 168, 86, 20);
    label2.setText("Zustand");
    cp.add(label2);
    label3.setBounds(32, 192, 86, 20);
    label3.setText("Ausgabeband");
    cp.add(label3);
    textField1.setBounds(128, 144, 94, 20);
    cp.add(textField1);
    textField2.setBounds(128, 168, 22, 20);
    textField2.setText("z0");
    cp.add(textField2);
    textField3.setBounds(128, 192, 94, 20);
    cp.add(textField3);
    button1.setBounds(136, 224, 75, 25);
    button1.setLabel("action!");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button1_ActionPerformed(evt);
      }
    });
    cp.add(button1);
    textArea1.setBounds(96, 16, 160, 116);
    textArea1.setText("mögliche Eingabezeichen \n+ zugehörige Aktionen:\n\n'1' - 1€ rein\n'5' - 50 cent rein\n'W' - Ware anfordern\n'A' - Abbruch\n");
    textArea1.setEnabled(false);
    cp.add(textArea1);
    jLabel1.setBounds(-16, 16, 106, 122);
    jLabel1.setText("");
    jLabel1.setIcon(jLabel1Icon);
    cp.add(jLabel1);
    // Ende Komponenten
    
    setVisible(true);
  }
  
  // Anfang Methoden
  public String GibAus(Automat.tAusgabe ausgabe) {
    String s = "";
    switch (ausgabe) {
      case a1:
        s = "1 Euro zurück!";
        break;
      case a50:
        s = "50 cent zurück!";
        break;
      case aWare:
        s = "Ihr Getränk!";
        break;
      case aNichts:
        s = "Nichts!";
        break;
    }
    return s;
  }

  public Automat.tEingabe LiesEingabe(char zeichen) {
    switch (zeichen) {
      case '1': 
      eingabe = Automat.tEingabe.e1;
      break;
      case '5': 
      eingabe = Automat.tEingabe.e50;
      break;
      case 'W':  
      eingabe = Automat.tEingabe.eWare;
      break;
      case  'A': 
      eingabe = Automat.tEingabe.eAbbruch;
      break;
    }
    return eingabe;
  }
  
  public void button1_ActionPerformed(ActionEvent evt) {
    i = i+1;
    int t = textField1.getText().length();
    if (i < t) {
      char c = textField1.getText().charAt(i);
      eingabe = LiesEingabe(c);
      ausgabe = automat.ausgabefunktion(eingabe, automat.getZustand());
      textField3.setText(GibAus(ausgabe));
      zustandNeu = automat.uebergangsfunktion(eingabe, automat.getZustand());
      automat.setZustand(zustandNeu);
      textField2.setText("" + automat.getZustand());
      textField2.setBounds(textField2.getX() + 5, textField2.getY(),
              textField2.getWidth(), textField2.getHeight());
      if (i == t-1) {
        button1.setLabel("Ende!");
      }
    }
  }
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new Simulation("Getränkeautomat");
  }
}
