package _01_AutomatenUndSprachen.Compiler_MinSort_korrigiert;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {
    @FXML private TextField tfErsteZahl;
    @FXML private TextField tfZweiteZahl;
    @FXML private TextField tfDritteZahl;
    @FXML private TextField tfVierteZahl;
    @FXML private TextField tfFuenfteZahl;
    @FXML private Label lbSortiert;

    public static int[] MinSort(int[] r) {
        int i = 0;
        int n = r.length-1;
        int min, j, temp;
        while (i < n) {
            min = i;
            j = i+1;
            while (j <= n) {
                if (r[j]<r[min]) {
                    min=j;
                }
                j=j+1;
            }
            temp = r[i];
            r[i]=r[min];
            r[min] = temp;
            i=i+1;
        }
        return r;
    }

    public void btFuelle_onClick() {
        Random rand = new Random();
        int a = rand.nextInt(100); tfErsteZahl.setText(""+a);
        a = rand.nextInt(100); tfZweiteZahl.setText(""+a);
        a = rand.nextInt(100); tfDritteZahl.setText(""+a);
        a = rand.nextInt(100); tfVierteZahl.setText(""+a);
        a = rand.nextInt(100); tfFuenfteZahl.setText(""+a);
    }

    public void btSortiere_onClick() {
        lbSortiert.setText("sortiert:   ");
        int[] Zahlen = new int[5];
        Zahlen[0] = Integer.parseInt(tfErsteZahl.getText());
        Zahlen[1] = Integer.parseInt(tfZweiteZahl.getText());
        Zahlen[2] = Integer.parseInt(tfDritteZahl.getText());
        Zahlen[3] = Integer.parseInt(tfVierteZahl.getText());
        Zahlen[4] = Integer.parseInt(tfFuenfteZahl.getText());
        MinSort(Zahlen);
        for (int i=0;i<5;i++) lbSortiert.setText(lbSortiert.getText() + Zahlen[i] + ", ");
    }
}
