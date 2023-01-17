package at.ac.fhwn.sae.lesson3;

public class Cat extends Animal{
    private static final String DEFAULT_CAT_NAME = "Katze";


    public Cat(){
        this.name = DEFAULT_CAT_NAME;
    }


    public String getID() {
        return DEFAULT_ID;
    }
}
