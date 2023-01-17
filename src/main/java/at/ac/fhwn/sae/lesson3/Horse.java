package at.ac.fhwn.sae.lesson3;

public class Horse extends Animal{
    private static final String CLASS_DESCRIPTION= "This is a horse class.";
    private static int count = 0;
    private String id;

    /**
     * Ctor with name parameter
     * @param name the name of the horse
     */
    public Horse(String name){
        this.name = name;
        if(count < 10){
            this.id = "P00" + ++count;
        }else if (count<100){
            this.id = "P0" + ++count;
        }else{
            this.id = "P" + ++count;
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
     * @return the number of Horses
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
