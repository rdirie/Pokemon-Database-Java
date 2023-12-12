public class GymLeader extends Trainer {
    //Instance Variables 
        private Gym gym;
        private boolean ChampionBattle;
        private String motto;
        private int aceLevel;
        public static int numGymLeaders;
    //Constructor
    public GymLeader(){
        super();
        numGymLeaders++;
    }
    //Mutators
    public void setGym(Gym gym) {
        this.gym = gym;
    }
    public void setChampionBattle(boolean ChampionBattle){
        this.ChampionBattle = ChampionBattle;
    }
    public void setMotto(String motto){
        if(motto.equals(""))
            throw new IllegalArgumentException("Leader Motto cannot be empty");
        this.motto = motto;
    }

    public void setAceLevel(int aceLevel){
        if(aceLevel < 0 || aceLevel > 100)
            throw new IllegalArgumentException("Ace Level can't be less than 0 or greater than 100");
        this.aceLevel = aceLevel;
    }
    //Accessors
    public Gym getGym() { return this.gym; }
    public boolean getChampionBattle() { return this.ChampionBattle; } 
    public String getMotto() { return this.motto; } 
    public int getAceLevel() { return this.aceLevel; } 
    public static int getNumGymLeaders() { return numGymLeaders; }  
    
    //Special Purpose Method
    public String toString(){
        return super.toString() + "\n\n"
        + "Leader Info: \n"
        + " Champion Battle Eligible: " + this.getChampionBattle() + "\n"
        + " Gym: " + this.gym.getGymName() + "\n"
        + " Motto: " + getMotto() + "\n"
        + " Ace Level: " + getAceLevel() + "\n";
    }
}


