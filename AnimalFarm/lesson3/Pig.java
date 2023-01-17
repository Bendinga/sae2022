package at.ac.fhwn.sae.lesson3;

public class Pig extends Animal{
    private static final String CLASS_DESCRIPTION= "This is a pig class.";
    private static int count = 0;


    /**
     * Ctor with name parameter
     * @param name the name of the horse
     */
    public Pig(String name){
        this.name = name;
        if(count < 10){
            this.id = "S00" + ++count;
        }else if (count<100){
            this.id = "S0" + ++count;
        }else{
            this.id = "S" + ++count;
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
     * @return the number of Pigs
     */
    public static int getCount(){
        return count;
    }

    /**
     *
     * @return the name of the Animal
     */
    public String getName() {
        return super.getName();
    }
}
