package at.ac.fhwn.sae.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {
    public static void main(String[] args){
        Dog kali = new Dog("kali");
        Dog dog = new Dog();
        dog.setName("Wuffi");
        System.out.println(dog.getName());
        Cat cat = new Cat();
        System.out.println(cat.getName());
        dog.bark();
        System.out.println(cat.getID());
        System.out.println(dog.getID());
        System.out.println(Dog.getCount());

        List<Animal> list = new ArrayList<>();
        list.add(kali);
        list.add(cat);
        list.add(dog);
        list.add(new Dog("billy"));
        for (int i = 0; i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
        for (Animal animal:list){
            System.out.println(animal.getID());
            if (animal instanceof Dog){
                ((Dog) animal).bark();
            }
        Person p = buildPerson(42,"Koal");
        }

    }
    static Person buildPerson(int number, String name){
        return new Person(number,name);


    }
}
