package at.ac.fhwn.sae.lesson3;

public class Cow extends Animal{
    private static final String CLASS_DESCRIPTION= "This is a cow class.";
    private static int count = 0;


    /**
     * Ctor with name parameter
     * @param name the name of the cow
     */
    public Cow(String name){
        this.name = name;
        if(count < 10){
            this.id = "K00" + ++count;
        }else if (count<100){
            this.id = "K0" + ++count;
        }else{
            this.id = "K" + ++count;
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
     * @return the number of Cow
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
