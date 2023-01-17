package at.ac.fhwn.sae.lesson3;

public abstract class Animal {
    protected static final String DEFAULT_ID = "0";
    protected String name;
    protected String id;
    public Animal(String name, String id) {
        this.name = name;
        this.id = id;

    }
    public abstract String getID();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
