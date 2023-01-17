package at.ac.fhwn.sae.lesson2;

public class fibonacci {
    public static void main(String [] args) {
            int i = 3;
            System.out.println("(Rekursiv)Die Fibonacci-Zahl an der Stelle " + i + " ist: " + getFibonacciRec(i));
            System.out.println("(Schleife)Die Fibonacci-Zahl an der Stelle " + i + " ist: " + getFibonacci(i));

    }

    public static long getFibonacciRec(int number){
        if (number == 0){
            return 0;
        }
        if (number == 1){
            return 1;
        }

        return getFibonacciRec(--number,0,1);

    }/**
     * Returns the fibonacci-number at any position.
     * works with rekursion.
     * example: 0 = 0; 1 = 1; 2 = 1; 3 = 2;...
     * Don't works with negativ numbers or numbers which are bigger than 92.
     *
     */
    private static long getFibonacciRec(int number, long last, long last2){
        while (number > 0){
            return getFibonacciRec(--number, last + last2, last);
        }

        return last + last2;
    }
    /**
     * Returns the fibonacci-number at any position.
     * Works with loop.
     * example: 0 = 0; 1 = 1; 2 = 1; 3 = 2;...
     * Don't works with negativ numbers or numbers which are bigger than 92.
     *
     */
    public static long getFibonacci(int number){
        if (number == 0){
            return 0;
        }
        if (number == 1){
            return 1;
        }
        long last = 1;
        long last2 = 0;
        long zw = 0;
        --number;

        while (number > 0){
            zw = last;
            last = last + last2;
            last2 = zw;
            --number;
        }
        return last;

    }


}
/*
In meinem Programm wird die Fibonacci-Zahl an einer bestimmten Stelle wiedergegeben, wobei die Stellen mit 0 beginnen. 0=0, 1=1, 2=1,....
Ein StackOverflow entsteht bei zu vielen rekursiven Aufrufen. In meinem Fall geschieht dies bei 14457 rekursiven Aufrufen, allerdings ist mir aufgefallen, dass dies nicht immer ganz gleich bleibt wenn man kleine änderungen im Code vornimmt.
Wenn negative Zahlen eingegeben werden wird bei meinem programm eine 1 zurückgegeben. Diesen Fehler könnte man einfach mit einer if Funktion unterbinden. (zb. prüfen ob die Zahl kleiner 0 ist.)
Ein Variablen-Overflow ist erkennbar an einer Minuszahl in der Ausgabe. Dies geschieht ab der Fibonacci Zahl von 47 beim Variabletyp int, diese Zahl ist einfach zu groß um als int gespeichert zu werden.
In meinem Code habe ich dann auf den Typ long gesetzt, damit kann man noch größere Zahlen darstellen, somit kann auch die 92. Fibonacci Zahl richtig dargestellt werden.
Den Variablen-Overflow kann man somit durch andere Datentypen mit mehr bits vermeiden.
*/