package at.ac.fhwn.sae.lesson3;

public class Dog extends Animal{

    private static final String CLASS_DESCRIPTION= "This is a dog class.";

    private String DEFAULT_DOG_NAME = "Hundi";
    private static int count = 0;
    private String id;

    /**
     * Ctor with name parameter
     * @param name the name of the dog
     */
    public Dog(String name){
        this.name = name;
        this.id = "D" + ++count;
    }

    /**
     * Parameterless Ctor for dog
     * Default name is Hundi
     */
    public Dog(){
        this.name = DEFAULT_DOG_NAME;
        this.id = "D" + ++count;
    }

    public void bark(){
        System.out.println("Wuff! Wuff!");
    }


    public String getID() {

        return id;
    }

    /**
     *
     * @return the number of Dogs
     */
    public static int getCount(){
        return count;
    }
}


