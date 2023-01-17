package at.ac.fhwn.sae.lesson1;

import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args){
        System.out.println("-------- Bmi Calculator --------");

        Scanner in = new Scanner(System.in);
        System.out.print("Input your weight in kg: ");
        String input = in.next();
        double weight = Double.parseDouble(input);
        System.out.print("Input your height in cm: ");
        input = in.next();
        double height = Double.parseDouble(input)/100;

        double bmi = weight/(Math.pow(height,2));
        String bmiKat;
        if (bmi <= 18.4){
            bmiKat = "Untergewicht";
        }else if(bmi <= 24.9){
            bmiKat = "Normalgewicht";
        }else if(bmi <= 29.9){
            bmiKat = "leichtes Übergewicht";
        }else if(bmi <= 34.9){
            bmiKat = "Übergewicht";
        }else if(bmi <= 39.9){
            bmiKat = "starkes Übergewicht";
        }else{
            bmiKat = "sehr starkes Übergewicht";
        }
        System.out.println("----------- Ergebnis -----------");
        System.out.println(String.format("Dein BMI beträgt: %.2f", bmi));
        System.out.println(bmiKat);

    }
}
