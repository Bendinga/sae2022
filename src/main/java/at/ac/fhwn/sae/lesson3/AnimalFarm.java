package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalFarm {
    public static void main(String[] args){
        int selection = 0;
        ArrayList<Animal> list = new ArrayList<>();
        System.out.println("----- Das ist eine Animal Farm -----");
        System.out.println(" ");
        while (selection != 5){
            System.out.println("Was möchten Sie tun:");
            System.out.println(" ");
            System.out.println("1. Tier hinzufügen");
            System.out.println("2. Tiere anzeigen");
            System.out.println("3. Tiere nach Art anzeigen");
            System.out.println("4. Tier entfernen");
            System.out.println("5. Programm beenden");
            Scanner select = new Scanner(System.in);
            selection = Integer.parseInt(select.next());

            if (selection == 1){
                System.out.println("Welche Tierart wollen Sie hinzufügen:");
                printSpecies();
                list.add(addAnimal());

            }else if(selection == 2){
                showAnimals(list,0);

            }else if(selection == 3){
                System.out.println("Welche Tierart wollen Sie anzeigen lassen:");
                printSpecies();
                selection = Integer.parseInt(select.next());
                showAnimals(list, selection);


            }else if(selection == 4){
                System.out.println("Welche Tierart wollen Sie entfernen:");
                printSpecies();
                int i = removeAnimal(list);
                list.remove(i);

            }
        }
        System.out.println("Programm wurde beendet!");
    }

    /**
     * prints all Possibel species
     */
    private static void printSpecies(){
        System.out.println(" ");
        System.out.println("1. Pferd");
        System.out.println("2. Kuh");
        System.out.println("3. Schwein");
        System.out.println("4. Huhn");

    }

    /**
     * Creates a new Animal by asking for the Animal species and the name
     * @return the new Animal
     */
    static Animal addAnimal(){
        Scanner input = new Scanner(System.in);
        int selection;
        selection = Integer.parseInt(input.next());
        System.out.println("Geben Sie einen Namen für das Tier ein:");
        String name = input.next();
        if (selection == 1){
            return new Horse(name);

        }else if(selection == 2){
            return new Cow(name);

        }else if(selection == 3){
            return new Pig(name);

        }else if(selection == 4){
            return new Chicken(name);

        }
        return null;
    }

    /**
     *
     * @param list  The list of animals to show
     * @param species   The integer of the Species
     */
    private static void showAnimals(ArrayList<Animal> list, int species){
        System.out.println(String.format("%3s", "Nr") + ". | " + String.format("%-4s", "ID") + " | " + "Name");
        System.out.println("----------------------");
        int number = 1;
        if(species == 0){
            for (Animal animal:list) {
                System.out.println(String.format("%3s", number++) + ". | " + String.format("%-4s", animal.getID()) + " | " + animal.getName());
            }
        }else if (species == 1){
            for (Animal animal:list) {
                if (animal instanceof Horse) {
                    System.out.println(String.format("%3s", number++) + ". | " + String.format("%-4s", animal.getID()) + " | " + animal.getName());
                }
            }
        }else if (species == 2){
            for (Animal animal:list) {
                if (animal instanceof Cow) {
                    System.out.println(String.format("%3s", number++) + ". | " + String.format("%-4s", animal.getID()) + " | " + animal.getName());
                }
            }
        }else if (species == 3){
            for (Animal animal:list) {
                if (animal instanceof Pig) {
                    System.out.println(String.format("%3s", number++) + ". | " + String.format("%-4s", animal.getID()) + " | " + animal.getName());
                }
            }
        }else if (species == 4){
            for (Animal animal:list) {
                if (animal instanceof Chicken) {
                    System.out.println(String.format("%3s", number++) + ". | " + String.format("%-4s", animal.getID()) + " | " + animal.getName());
                }
            }
        }
    }

    /**
     *
     * @param list The list of Animals
     * @return The index of the Animal to remove in the list
     */
    private static int removeAnimal(ArrayList<Animal> list){
        int count = 0;
        int selection = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner select = new Scanner(System.in);
        selection = Integer.parseInt(select.next());
        for (Animal animal:list){

            if (animal instanceof Horse){
                if (selection == 1){
                    numbers.add(count);
                }
            }else if (animal instanceof Cow){
                if (selection == 2){
                    numbers.add(count);
                }
            }else if (animal instanceof Pig){
                if (selection == 3){
                    numbers.add(count);
                }
            }else if (animal instanceof Chicken){
                if (selection == 4){
                    numbers.add(count);
                }
            }
            count ++;
        }
        showAnimals(list, selection);
        System.out.println("Nummer des Tieres das gelöscht werden soll:");
        int nr = Integer.parseInt(select.next());
        System.out.println(numbers.get(nr-1));
        int i = numbers.get(nr-1);
        return i;
    }
}
