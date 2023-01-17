package at.ac.fhwn.sae.lesson1;

import at.ac.fhwn.sae.lesson3.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int number = 42;
        int number2 = number + 2; // this is a comment
        System.out.println(number2);

        final int CONSTANT_VARIABLE = 58794858;

        //constant = 2; --> final can not be changed

        Boolean result = number == CONSTANT_VARIABLE;
        System.out.println(result);

        if (number2 < 3){
            System.out.println("number " + number2 + " is smaller than 3");

        }else{
            System.out.println("number " + number2 + " is bigger or equal than 3");
        }

        double value = 56.589437529834750235;
        System.out.println(value);
        System.out.println(String.format("value is %.2f", value));

        Scanner in = new Scanner(System.in);
        System.out.print("Enter something: ");
        String input = in.next();
        System.out.println(input);

        int enteredValue = Integer.parseInt(input);
        System.out.println(enteredValue + 5);

        Dog dog = new Dog();
        dog.getName();




    }
}
