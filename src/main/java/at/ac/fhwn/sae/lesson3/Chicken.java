package at.ac.fhwn.sae.lesson3;

public class Chicken extends Animal{
    private static final String CLASS_DESCRIPTION= "This is a chicken class.";
    private static int count = 0;
    private String id;

    /**
     * Ctor with name parameter
     * @param name the name of the chicken
     */
    public Chicken(String name){
        this.name = name;
        if(count < 10){
            this.id = "H00" + ++count;
        }else if (count<100){
            this.id = "H0" + ++count;
        }else{
            this.id = "H" + ++count;
        }
    }

    /**
     *
     * @return the ID of the Animal
     */
    public String getID() {

        return id;
    }

    /**
     *
     * @return the number of Chicken
     */
    public static int getCount(){
        return count;
    }

    public String getName() {
        return super.getName();
    }
}

