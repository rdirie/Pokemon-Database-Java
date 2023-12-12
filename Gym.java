public class Gym {
    //Instance Variables 
        private String gymName;
        private String gymType;
        private String leaderName;
        private int numTrainers;
        private String difficulty;
        public static int numGyms;
    //Constructor
    public Gym(){
        numGyms++;
    }
    //Mutators
    public void setGymName(String gymName){
        if(gymName.equals(""))
            throw new IllegalArgumentException("Gym Name cannot be empty");
        this.gymName = gymName;
    }
    public void setGymType(String gymType){
        if(gymType.equals(""))
            throw new IllegalArgumentException("Gym Type cannot be empty");
        this.gymName = gymType;
    }
    public void setLeaderName(String leaderName){
        if(leaderName.equals(""))
            throw new IllegalArgumentException("Leader Name cannot be empty");
        this.leaderName = leaderName;
    }
    public void setNumTrainers(int numTrainers){
        if(numTrainers<0)
            throw new IllegalArgumentException("Number of Trainers can't be less than 0");
        this.numTrainers = numTrainers;
    }
    public void setDifficulty(String difficulty){
        if(difficulty.equals("") || (!difficulty.equalsIgnoreCase("early-game") && 
        !difficulty.equalsIgnoreCase("mid-game") &&
        !difficulty.equalsIgnoreCase("end-game")))
            throw new IllegalArgumentException("Difficulty must be 'Early-Game', 'Mid-Game', or 'End-Game'");
        this.difficulty = difficulty;
    }
    //Accessors
    public String getGymName() { return this.gymName; }
    public String getGymType() { return this.gymType; }
    public String getLeaderName() { return this.leaderName; }
    public int getNumTrainers() { return this.numTrainers; }
    public String getDifficulty() { return this.difficulty; }
    public static int getNumGyms() { return numGyms; }  
    
    //Special Purpose Method
    public String toString(){
        return "Gym Info: "
        + " Name: " + getGymName() + "\n"
        + " Type: " + getGymType() + "\n"
        + " Leader Name: " + getLeaderName() + "\n"
        + " Number of Trainers: " + getNumTrainers() + "\n"
        + " Difficulty: " + getDifficulty() + "\n";
    }
}



