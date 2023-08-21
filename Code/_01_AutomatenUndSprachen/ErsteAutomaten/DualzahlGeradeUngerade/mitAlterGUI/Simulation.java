package _01_AutomatenUndSprachen.ErsteAutomaten.DualzahlGeradeUngerade.mitAlterGUI;

import java.awt.*;
import java.awt.event.*;

public class Simulation extends Frame {
    // Anfang Attribute
    private Label label1 = new Label();
    private Label label2 = new Label();
    private Label label3 = new Label();
    private Label label4 = new Label();
    private TextField textField1 = new TextField();
    private TextField textField2 = new TextField();
    private TextField textField3 = new TextField();
    private Button button1 = new Button();

    Automat automat = new Automat();
    Automat.tEingabe eingabe;
    Automat.tAusgabe ausgabe;
    Automat.tZustand zustandNeu;
    int i = -1; //für Position des einzulesenden Zeichen

    // Ende Attribute

    public Simulation(String title) {
        // Frame-Initialisierung
        super(title);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) { dispose(); }
        });
        int frameWidth = 264;
        int frameHeight = 239;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        setResizable(false);
        Panel cp = new Panel(null);
        add(cp);
        // Anfang Komponenten

        label1.setBounds(24, 64, 54, 20);
        label1.setText("Eingabe");
        cp.add(label1);
        label2.setBounds(24, 96, 54, 20);
        label2.setText("Zustand");
        cp.add(label2);
        label3.setBounds(24, 128, 54, 20);
        label3.setText("Ausgabe");
        cp.add(label3);
        textField1.setBounds(88, 64, 134, 20);
        cp.add(textField1);
        textField2.setBounds(88, 96, 30, 20);
        textField2.setText("z0");
        cp.add(textField2);
        textField3.setBounds(88, 128, 134, 20);
        cp.add(textField3);
        button1.setBounds(120, 160, 75, 25);
        button1.setLabel("action");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                button1_ActionPerformed(evt);
            }
        });
        cp.add(button1);
        label4.setBounds(56, 24, 143, 20);
        label4.setText("GERADE vs. UNGERADE");
        cp.add(label4);
        // Ende Komponenten

        setVisible(true);
    } // end of public test

    // Anfang Methoden
    public String GibAus(Automat.tAusgabe ausgabe) {
        //Konvertierung - Automaten-Ausgabe zu String
        String s = "";
        switch (ausgabe) {
            case  aGerade:
                s = "gerade";
                break;
            case  aUngerade:
                s = "ungerade";
                break;
        }
        return s;
    }

    public Automat.tEingabe LiesEingabe(char zeichen) {
        //Konvertierung - Character zu Automaten-Eingabe
        switch (zeichen) {
            case '0':
                eingabe = Automat.tEingabe.e0;
                break;
            case '1':
                eingabe = Automat.tEingabe.e1;
                break;
        }
        return eingabe;
    }

    public static void main(String[] args) {
        new Simulation("test");
    }

    public void button1_ActionPerformed(ActionEvent evt) {
        //Arbeit(sweise) des Automaten
        i++;
        int t = textField1.getText().length();
        if (i < t) {
            char c = textField1.getText().charAt(i);
            eingabe = LiesEingabe(c);
            ausgabe = automat.ausgabefunktion(eingabe, automat.getZustand());
            textField3.setText(GibAus(ausgabe));
            zustandNeu = automat.uebergangsfunktion(eingabe, automat.getZustand());
            automat.setZustand(zustandNeu);
            textField2.setText("" + automat.getZustand());
            textField2.setBounds(textField2.getX()+5,
                    textField2.getY(), textField2.getWidth(),
                    textField2.getHeight());
            if (i == t-1) {
                button1.setLabel("Ende!");
            }
        }
    }
    // Ende Methoden
} // end of class test