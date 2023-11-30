package _01_AutomatenUndSprachen.Turingmaschine;

import java.util.Scanner;

public class Turingmaschine {
    public static String Scanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib eine Buchstabenfolge aus dem Alphabet a^n; b^n; c^n ein. \n" +
                "(B folgt auf A, C Folgt auf B");
        String answer = scanner.nextLine();
        return answer;
    }

    public static String[] Array(String answer){
        // Eingegebenes in einen Array umwandeln
        char[] charArray = answer.toCharArray();
        // Array für die Touringmaschine vorbereiten
        String[] touringArray = new String[charArray.length+2];
        // Leeres Zeichen hinzufügen
        touringArray[0] = "|";
        // Wort in Array einfügen
        for(int i=1; i<charArray.length+1; i++){
            touringArray[i] = String.valueOf(charArray[i-1]);
        }
        //Leeres Zeichen ans Ende setzen
        touringArray[charArray.length+1] = "|";
        return touringArray;
    }

    public static void doesItWork(int j, String[] arr){
        // Überprüfung ob auf aufeinanderfolge Stimmt
        boolean work = true;

        for(int i=j; i<arr.length-1; i++){
            if(arr[i].equals("a") && !arr[i+1].equals("b")){
                if(!arr[i+1].equals("a")){
                    work=false;
                }
            }else if(arr[i].equals("b") && !arr[i+1].equals("c")){
                if(!arr[i+1].equals("b")){
                    work=false;
                }
            }
        }
        if (work){
            q0(arr, j);
        }
    }

    public static void Turing(String[] arr){
        int head =StartSuchen(arr);
        if(head!=0){
            doesItWork(head, arr);
        }
    }

    public static int StartSuchen(String[] arr){

        // Steht ein "a" am Anfang

        for(int i = 0; i< arr.length; i++){
            if(!arr[i].equals("|") && arr[i].equals("a")){
                return i;
            }
        }
        return 0;
    }

    public static void q0(String[] arr, int i){
        if(arr[i].equals("X")){
            i++;
            q0(arr,i);
        }else if(arr[i].equals("a")){
            arr[i]="X";
            i++;
            q1(arr,i);
        }else if(arr[i].equals("|")){
            qf();
        }
    }

    public static void q1(String[] arr, int i){
        if(arr[i].equals("a") || arr[i].equals("X")){
            i++;
            q1(arr, i);
        }else if(arr[i].equals("b")){
            arr[i] = "X";
            i++;
            q2(arr, i);
        }
    }

    public static void q2(String[] arr, int i){
        if(arr[i].equals("b") || arr[i].equals("X")){
            i++;
            q2(arr, i);
        }else if(arr[i].equals("c")){
            arr[i] = "X";
            i++;
            q3(arr,i);
        }
    }

    public static void q3(String[] arr, int i){
        if(arr[i].equals("c") || arr[i].equals("X")){
            i++;
            q3(arr,i);
        }else if(arr[i].equals("|")){
            i = i-1;
            q4(arr,i);
        }
    }

    public static void q4(String[] arr, int i){

        if(arr[i].equals("X")||arr[i].equals("c")||arr[i].equals("b")||arr[i].equals("a")){
            i=i-1;
            q4(arr,i);
        }else if(arr[i].equals("|")){
            i++;
            q0(arr, i);
        }
    }

    public static void qf(){
        System.out.println("Alle Buchstaben sind in der Richtigen Reihenfolge und kommen gliech oft vor");
    }

    public static void main(String[] args) {
        String word = Scanner();
        String[] list = Array(word);
        Turing(list);
    }
}
