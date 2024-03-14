package _02_ProjektSQLite;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class GUI_SQLite extends Frame {
  // Anfang Attribute
  static DatabaseConnector myDatabase;
  private JTextField jTextField1 = new JTextField();
  private JButton btSQL = new JButton();
  private JButton btStart = new JButton();
  private JLabel lErgebnis = new JLabel();
  private JTable jTable1 = new JTable(0, 1);
    private DefaultTableModel jTable1Model = (DefaultTableModel) jTable1.getModel();
    private JScrollPane jTable1ScrollPane = new JScrollPane(jTable1);
  // Ende Attribute
  
  public GUI_SQLite() {
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 832; 
    int frameHeight = 422;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("GUI_MySQL");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    jTextField1.setBounds(32, 48, 758, 28);
    cp.add(jTextField1);
    btSQL.setBounds(280, 88, 227, 25);
    btSQL.setText("Führe SQL-Befehl aus");
    btSQL.setMargin(new Insets(2, 2, 2, 2));
    btSQL.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btSQL_ActionPerformed(evt);
      }
    });
    cp.add(btSQL);
    btStart.setBounds(280, 8, 227, 25);
    btStart.setText("Starte Verbindung zur Datenbank");
    btStart.setMargin(new Insets(2, 2, 2, 2));
    btStart.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        btStart_ActionPerformed(evt);
      }
    });
    cp.add(btStart);
    lErgebnis.setBounds(360, 128, 79, 23);
    lErgebnis.setText("Ergebnis:");
    lErgebnis.setFont(new Font("Dialog", Font.BOLD, 16));
    cp.add(lErgebnis);
    jTable1ScrollPane.setBounds(128, 160, 540, 150);
    jTable1.setEnabled(false);
    jTable1.getColumnModel().getColumn(0).setHeaderValue("Leere Tabelle");
    jTable1.setRowHeight(18);
    cp.add(jTable1ScrollPane);
    // Ende Komponenten
    setVisible(true);
  }
  // Anfang Methoden
  
  public static void main(String[] args) {
    new GUI_SQLite();
  }
  
  public void btSQL_ActionPerformed(ActionEvent evt) {
    //SQL-Abfrage wird an die Datenbank weitergegeben!
    myDatabase.executeStatement(jTextField1.getText()); 
    System.out.println(myDatabase.getErrorMessage());
    //Ergebnistabelle der SQL-Abfrage wird in myQueryResult abgespeichert!
    QueryResult myQueryResult = myDatabase.getCurrentQueryResult(); 
    //Hilfsvariablen
    int Spalten = myQueryResult.getColumnCount(); 
    int Zeilen = myQueryResult.getRowCount(); 
    String [] Spaltentitel = myQueryResult.getColumnNames();
    String [][] Daten = myQueryResult.getData(); 
    //Anpassen der Tabellengröße an (Ergebnistabelle der) SQL-Abfrage
    jTable1Model.setRowCount(Zeilen);
    jTable1Model.setColumnCount(Spalten);
    //Einfügen der Spaltenüberschriften
    for (int i=0; i<Spalten; i++) {
      jTable1.getColumnModel().getColumn(i).setHeaderValue(Spaltentitel[i]);
    }
    //Einfügen der Daten
    for (int i=0; i<Zeilen; i++) {
      for (int j=0; j<Spalten; j++) {
        jTable1.setValueAt(Daten[i][j],i,j);
      }
    }
  }

  public void btStart_ActionPerformed(ActionEvent evt) {
    //Vorsicht! SQLite-Treiber muss im Projekt eingebunden sein!
    //dazu unter Fenster-Konfiguration Java-Interpreter die jar-Datei unter Classpath-User laden!
    myDatabase = new DatabaseConnector("",0,"Code/_02_ProjektSQLite/Bank.db3","","");
    //Fehlermeldungen ggf. auch testweise provozieren!
    if (myDatabase.getErrorMessage() != null) 
    jTextField1.setText("Fehler! " + myDatabase.getErrorMessage());
    else jTextField1.setText("Okay, die Datenbank ist bereit! Notiere hier Deine SQL-Anfrage!");
  }
  // Ende Methoden
}

