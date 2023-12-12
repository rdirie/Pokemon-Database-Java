public class Challenger extends Trainer {
    //Instance Variables 
        private int numBadges;
        private double pokedexPercentage;
        private int attemptedChallenges;
        public static int numChallengers;
    //Constructor
    public Challenger(){
        super();
        numChallengers++;
    }
    //Mutators
    public void setNumBadges(int numBadges){
        if(numBadges < 0 || numBadges > 8){
            throw new IllegalArgumentException("Number of badges cannot be less than 0 or greater than 8");
        }
        this.numBadges = numBadges;
    }

    public void setPokedexPercentage(double pokedexPercentage){
        if(pokedexPercentage < 0 || pokedexPercentage > 100){
            throw new IllegalArgumentException("Pokedex percentage cannot be less than 0 or greater than 100");
        }
        this.pokedexPercentage = pokedexPercentage;
    }

    public void setAttemptedChallenges(int attemptedChallenges){
        if(attemptedChallenges < 0){
            throw new IllegalArgumentException("Attempted challenges cannot be less than 0");
        }
        this.attemptedChallenges = attemptedChallenges;
    }

    
    //Accessors
    public int getNumBadges() { return this.numBadges; }
    public double getPokedexPercentage() { return this.pokedexPercentage;}
    public int getAttemptedChallenges() { return this.attemptedChallenges;}
    public static int getNumChallengers() { return numChallengers;} 
    
    //Special Purpose Method
    public String toString(){
        return super.toString() + "\n\n"
        + "Challenger Info: "
        + " Number of Badges: " + getNumBadges() + "\n"
        + " Pokedex Percentage: " + String.format("%.2f", getPokedexPercentage()) + "%\n"
        + " Attempted Challenges: " + getAttemptedChallenges() + "\n";
    }
}


