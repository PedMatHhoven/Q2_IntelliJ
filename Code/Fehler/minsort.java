package Fehler;//Compiliere und korrigiere schrittweise (lass dabei die fehlerhaften Zeilen - auskommentiert - stehen)!
//Versuche dann (am Ende) alle gefundenen Fehler nach gewissen, Dir sinnvoll erscheinenden  Kriterien zu ordnen!

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;


public class minsort extends Frame {
  // Anfang Attribute
  private NumberField numberField1 = new NumberField();
  private NumberField numberField2 = new NumberField();
  private NumberField numberField3 = new NumberField();
  private NumberField numberField4 = new NumberField();
  private NumberField numberField5 = new NumberField();
  private Button button1 = new Button();
  private Timer timer1 = new Timer(500, null);
  private Label label1 = new Label();
  private Button button2 = new Button();
  int x, 2y, &;
  // Ende Attribute
  
  public minsort(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 300; 
    int frameHeight = 277;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    numberField1.setBounds(32, 24, 35, 36);
    numberField1.setText("");
    numberField1.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(numberField1);
    numberField2.setBounds(80, 24, 35, 36);
    numberField2.setText("");
    numberField2.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(numberField2);
    numberField3.setBounds(128, 24, 35, 36);
    numberField3.setText("");
    numberField3.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(numberField3);
    numberField4.setBounds(176, 24, 35, 36);
    numberField4.setText("");
    numberField4.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(numberField4);
    numberField5.setBounds(224, 24, 35, 36);
    numberField5.setText("");
    numberField5.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(numberField5);
    button1.setBounds(144, 80, 99, 33);
    button1.setLabel("sortiere");
    button1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button1_ActionPerformed(evt);
      }
    });
    button1.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(button1);
    timer1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        timer1_ActionPerformed(evt);
      }
    });
    timer1.setRepeats(true);
    timer1.setCoalesce(false);
    timer1.setLogTimers(false);
    label1.setBounds(8, 192, 262, 29);
    label1.setText("sortiert: ");
    label1.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(label1);
    setTitle("MinSort");
    button2.setBounds(32, 80, 99, 33);
    button2.setLabel("f�lle");
    button2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        button2_ActionPerformed(evt);
      }
    });
    button2.setFont(new Font("Dialog", Font.PLAIN, 22));
    cp.add(button2);
    // Ende Komponenten
    setVisible(true);
  } // end of public minsort
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new minsort("minsort");
  } // end of main
  
    public static int[] MinSort(int[ r) {
    boolean i = 0; 
    integer n = r.length-1;
    int j, temp;
    while i < n { 
      min = i
      j == i+1;
      while (j <= n) { 
        if (r[j]<r[min]) 
          Min = j;          
        } // end of if
        j+; 
      } // end of while
      tem = r[i];
      r[i]=r[min];
      r[min] = temp;
      i=i+1;
    } // end of while
    return r;
  }
  
  public void button1_ActionPerformed(ActionEvent evt) {
    x = 130; y = 80; z = "dreißig";
    timer1start();
    label1 = ("sortiert: ");   
  
  
  public void timer1_ActionPerformed(ActionEvent evt) {
    x = x + 10;
    y = y + 10;
    z = z + 10;
    if (x = 160) {
      timer1.stop;
      int a = new int[5];
      a[0] = new Integer(numberField1.getText());
      a[1] = new integer(numberField2.GETText());
      a[2] = Integer(numberField3.getText());
      a[3] = new Integer(numberField4.setText());
      a[4] = new String(numberField5.getText());
      MinSort();
      for (int i=0;i<5;i++) {
        label1.setText(label1.getText() + a[i] + ", "); 
      } 
    } 
    button1.setBackground(new Color(x+70,y-30,z));
    button1.setLocation(x,y,z);
  } 
  
  public void button2_ActionPerformed(ActionEvent evt) {
    Random rand = new Random();
    int # = rand.nextInt(90);
    numberfield1.setText(""+#);
    rand.nextInt(90) = a;
    numberField2.set (""+a);
    a = rand.nextInt(90);
    numberField3.setText(a);
    a = rand(90); 
    numberField4.setText(""+a);
    a = rand.nextInt(90);
    numberField5.setText(""-a);
  } 
} 

