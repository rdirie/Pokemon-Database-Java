public class Trainer implements TrainerRegulation {
    //Instance Variables 
        private String name;
        private String hometown;
        private String ID;
        private int age;
        private double pokeBalance;
        private int numParty;
        public static int numTrainers;
    //Constructor
    public Trainer(){
        numTrainers++;
    }
    //Mutators
    public void setName(String name){
        if(name.equals(""))
            throw new IllegalArgumentException("Trainer name cannot be empty");
        this.name = name;
    }

    public void setHometown(String hometown){
        if(hometown.equals(""))
            throw new IllegalArgumentException("Hometown cannot be empty");
        this.hometown = hometown;
    }

    public void setID(String ID){
        if(ID.equals("") || ID.length() != 3)
            throw new IllegalArgumentException("ID cannot be empty - ID must be AlphaNumeric Code with a length of 3");
        this.ID = ID;
    }

    public void setAge(int age){
        if(age<minAge)
            throw new IllegalArgumentException("Trainer Age can't be less than 10");
        this.age = age;
    }

    public void setPokeBalance(double pokeBalance ) {
        if (pokeBalance < 0) {
            throw new IllegalArgumentException("Poke Balance cannot be less than 0!");
        }
        this.pokeBalance = pokeBalance;
    }
    public void setNumParty(int numParty){
        if(numParty>maxParty || numParty < 0)
            throw new IllegalArgumentException("Trainer Party Number can't be greater than 6 or less than 0");
        this.numParty = numParty;
    }
    //Accessors
    public String getName() { return this.name; }
    public String getHometown() { return this.hometown; } 
    public String getID() { return this.ID; } 
    public int getAge() { return this.age; } 
    public double getPokéBalance() { return this.pokeBalance; } 
    public int getNumParty() { return this.numParty; } 
    public static int getNumTrainers() { return numTrainers; }  
    
    //Special Purpose Method
    public String toString(){
        return "Trainer [" + this.ID + "] Info:\n"
        + " Name: " + getName() + "\n"
        + " Hometown: " + getHometown() + "\n"
        + " Age: " + getAge() + "\n"
        + " Poke Balance: ¥" + String.format("%.2f", getPokéBalance()) + "\n"
        + " Number of Pokémon: " + getNumParty();
    }
}

