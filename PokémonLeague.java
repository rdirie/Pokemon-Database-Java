 import javax.swing.JOptionPane;
 import javax.swing.JTextArea;
 import javax.swing.JScrollPane;



public class PokémonLeague {
    public static void main(String[] args) {
        //Variable Declaration
        final int MAX_TRAINERS = 100;
        Trainer[] LeagueDatabase = new Trainer[MAX_TRAINERS];
        JOptionPane.showMessageDialog(null, "Welcome to the Pokemon League Database!");

      //   Preloaded Data for testing functions
        Gym GMU = new Gym();
        GMU.setGymName("GMU GYM");
        GMU.setGymType("College");
        GMU.setLeaderName("Professor Sultana");
        GMU.setNumTrainers(5);
        GMU.setDifficulty("End-Game");

      //   Challenger testChallenger = new Challenger();
      //   GymLeader testLeader = new GymLeader();

      //   testChallenger.setName("Trainer 1");
      //   testChallenger.setHometown("GMU");
      //   testChallenger.setID("123");
      //   testChallenger.setAge(19);
      //   testChallenger.setPokeBalance(99.758684956);
      //   testChallenger.setNumParty(5);
      //   testChallenger.setNumBadges(5);
      //   testChallenger.setPokedexPercentage(99);
      //   testChallenger.setAttemptedChallenges(5);
      //   LeagueDatabase[0] = testChallenger;

      //   testLeader.setName("Trainer 2");
      //   testLeader.setHometown("GMU");
      //   testLeader.setID("321");
      //   testLeader.setAge(23);
      //   testLeader.setPokeBalance(100);
      //   testLeader.setNumParty(6);
      //   testLeader.setGym(GMU);
      //   testLeader.setChampionBattle(true);
      //   testLeader.setMotto("Motto");
      //   testLeader.setAceLevel(56);
      //   LeagueDatabase[1] = testLeader;

        //Menu Switch Case
        int menuChoice = getLeagueOption();
        while (menuChoice != 6) {
           switch(menuChoice) {
              case 1:
                 createTrainer(LeagueDatabase);
                 break;
                 
              case 2:
                 searchTrainer(LeagueDatabase);
                 break;
                 
              case 3:
                 deleteTrainer(LeagueDatabase);
                 break;
              case 4:
                 trainerInfo(LeagueDatabase);
                 break;
              case 5:
                 Battle(LeagueDatabase);
                 break;
              default:
                 // Program should never reach this condition if logic is correct
                 throw new RuntimeException("Unknown error in menu choice");
           }
           menuChoice = getLeagueOption();
        }
        JOptionPane.showMessageDialog(null, "Thank you for accessing the league database. Have a nice day!");
   }
    public static int getLeagueOption() {
      int menuChoice;
      
      //Menu Do-While Loop
      do {
         try {
            menuChoice = Integer.parseInt(JOptionPane.showInputDialog(
               "** League Database **"
               + "\n1. Create Trainer"
               + "\n2. Search Trainer"
               + "\n3. Delete Trainer"
               + "\n4. Trainer Information"
               + "\n5. Trainer Battle"
               + "\n6. Exit"
            ));
         }
         catch (NumberFormatException e) {
            menuChoice = 0;
         }
         if (menuChoice < 1 || menuChoice > 6) {
            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
         }
      } while (menuChoice < 1 || menuChoice > 6);

      return menuChoice;
   }

public static int getTrainerOption() {
   int itemMenuChoice;
   //Menu Do-While Loop
   do {
      try {
         itemMenuChoice = Integer.parseInt(JOptionPane.showInputDialog(
            "** Pokémon League - Trainer Database **"
            + "\n1. Create Challenger"
            + "\n2. Create Gym Leader"
            + "\n3. Exit"
         ));
      }
      catch (NumberFormatException e) {
         itemMenuChoice = 0;
      }
      if (itemMenuChoice < 1 || itemMenuChoice > 3) {
         JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid menu option.");
      }
   } while (itemMenuChoice < 1 || itemMenuChoice > 3);

   return itemMenuChoice;
}

//Function: Create Items - Pick item to create
public static void createTrainer(Trainer[] LeagueDatabase){
    //here
    
   //League Menu Switch Case
      int itemMenuChoice = getTrainerOption();
      while (itemMenuChoice != 3) {
         switch(itemMenuChoice) {
            case 1:
               createChallenger(LeagueDatabase);
               break;
               
            case 2:
               createGymLeader(LeagueDatabase);
               break;
            default:
               // Program should never reach this condition if logic is correct
               throw new RuntimeException("Unknown error in menu choice");
         }
         itemMenuChoice = getTrainerOption();
      }
   }

   //Function: Create Base Trainer - Creates info used for both Challengers and Gym Leaders
   public static void baseTrainer(Trainer baseTrainer, Trainer[] LeagueDatabase){
         boolean validName = false;
         boolean validHometown = false;
         boolean validID = false;
         boolean validAge = false;
         boolean validPokeBalance = false;
         boolean validNumParty = false;
   
         //Trainer Name Exception Handling
         do {
            try {
               String name = JOptionPane.showInputDialog("Enter Trainer Name");
               baseTrainer.setName(name);
               validName = true;
            } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validName);
   
         //Trainer Hometown Exception Handling
         do {
            try {
               String hometown = JOptionPane.showInputDialog("Enter Trainer Hometown");
               baseTrainer.setHometown(hometown);
               validHometown = true;
            } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validHometown);
   
         //Trainer ID Exception Handling
         do {
            boolean newID = true;
            try {
               String ID = JOptionPane.showInputDialog("Enter Trainer ID");
               for(int i = 0; i < Trainer.getNumTrainers() - 1; i++){
                  if(ID.equalsIgnoreCase(LeagueDatabase[i].getID())){
                     newID = false;
                  }
               }
               if(newID){
                  baseTrainer.setID(ID.toUpperCase());
                  validID = true;
               }
               else{
                  JOptionPane.showMessageDialog(null, "Please enter a new, unused ID");
               }
            } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validID);

         //Trainer Age Exception Handling
         do {
         try {
               int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Trainer Age"));
               baseTrainer.setAge(age);
               validAge = true;
         } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null, "Error! Trainer Age must be a number!");
         } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         }
      } while (!validAge);
   
         //Trainer Balance Exception Handling
         do {
            try {
               double balance = Double.parseDouble(JOptionPane.showInputDialog("Enter Trainer Balance"));
               baseTrainer.setPokeBalance(balance);
               validPokeBalance = true;
            } catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Error! Trainer Balance must be a number!");
            } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validPokeBalance);

         //Trainer Num Party Exception Handling
         do {
         try {
               int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Trainer Number of Pokemon"));
               baseTrainer.setNumParty(age);
               validNumParty = true;
         } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null, "Error! Trainer Number of Pokemon must be a number up to 6!");
         } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validNumParty);
   }
    
   //Function: Create Challenger - Creates the challenger
   public static void createChallenger(Trainer[] LeagueDatabase){
      int currentTrainer = Trainer.getNumTrainers();
      if (currentTrainer < LeagueDatabase.length){
         boolean validNumBadges = false;
         boolean validPokedex = false;
         boolean validAttemptedChallenges = false;
         Challenger newChallenger = new Challenger();
         baseTrainer(newChallenger, LeagueDatabase);

         //Trainer Num Badges Exception Handling
         do {
         try {
               int badges = Integer.parseInt(JOptionPane.showInputDialog("Enter Trainer Badge Number"));
               newChallenger.setNumBadges(badges);
               validNumBadges = true;
         } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null, "Error! Trainer Badges must be a number!");
         } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validNumBadges);
   
         //Trainer Pokédex Exception Handling
         do {
            try {
               double pokedex = Double.parseDouble(JOptionPane.showInputDialog("Enter Pokédex Completion"));
               newChallenger.setPokedexPercentage(pokedex);
               validPokedex = true;
            } catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Error! Trainer Pokedex Percentage must be a number!");
            } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validPokedex);
   
         //Trainer Attempted Challenges Exception Handling
         do {
         try {
               int numChallenges = Integer.parseInt(JOptionPane.showInputDialog("Enter Trainer Number of Attempted Challenges to the League"));
               newChallenger.setAttemptedChallenges(numChallenges);
               validAttemptedChallenges = true;
         } catch(NumberFormatException e){
         JOptionPane.showMessageDialog(null, "Error! Attempted Challenges must be a number!");
         } catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, e.getMessage());
         }
         } while (!validAttemptedChallenges);
   
         //Returned Info
         LeagueDatabase[currentTrainer] = newChallenger;
      }
      else{
            JOptionPane.showMessageDialog(null, "The league database is full. No more trainers can be added.");
         }
      }

    public static void createGymLeader(Trainer[] LeagueDatabase){
         int currentTrainer = Trainer.getNumTrainers();
         if (currentTrainer < LeagueDatabase.length){
            boolean validMotto = false;
            boolean validAceLevel = false;
            GymLeader newLeader = new GymLeader();
            baseTrainer(newLeader, LeagueDatabase);
            Gym GMU = new Gym();
            GMU.setGymName("GMU GYM");
            GMU.setGymType("College");
            GMU.setLeaderName("Professor Sultana");
            GMU.setNumTrainers(5);
            GMU.setDifficulty("End-Game");
            newLeader.setGym(GMU);
            //Trainer Champion Battle Exception Handling
            int champion = 0;
            champion = JOptionPane.showConfirmDialog(null, "Eligible for Champion Battle?", "Confirmation", JOptionPane.YES_NO_OPTION);
            
            if (champion == JOptionPane.YES_OPTION)
               newLeader.setChampionBattle(true);
            else if (champion == JOptionPane.NO_OPTION)
               newLeader.setChampionBattle(false);
      
            //Trainer Motto Exception Handling
            do {
               try {
                  String motto = JOptionPane.showInputDialog("Enter Trainer Motto");
                  newLeader.setMotto(motto);
                  validMotto = true;
               } catch (IllegalArgumentException e) {
                  JOptionPane.showMessageDialog(null, e.getMessage());
            }
            } while (!validMotto);
         
            //Trainer Ace Level Exception Handling
            do {
            try {
                  int ace = Integer.parseInt(JOptionPane.showInputDialog("Enter Trainer Ace Level"));
                  newLeader.setAceLevel(ace);
                  validAceLevel = true;
            } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error! Trainer Age must be a number!");
            } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
      } while (!validAceLevel);

       //Returned Info
      LeagueDatabase[currentTrainer] = newLeader;
    }else{
            JOptionPane.showMessageDialog(null, "The league database is full. No more trainers can be added.");
         }
      }
    //Function: Search Item - Search items in League Database
    public static void searchTrainer(Trainer[] LeagueDatabase){
    if(Trainer.numTrainers== 0){
        JOptionPane.showMessageDialog(null, "No trainers to search.");
    }
    else{
        boolean properSearch = false;
        int foundPosition = -1;
        String searchTrainer = "";
        do{
            searchTrainer = JOptionPane.showInputDialog("Enter Trainer ID");
            if (searchTrainer == null || searchTrainer.equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Search Value - Please Try Again");
            }else{
                properSearch = true;
            }
        }while (!properSearch);
        for(int i = 0; i < Trainer.numTrainers; i++){
            if(LeagueDatabase[i].getID().equals(searchTrainer)){
                JOptionPane.showMessageDialog(null, "Trainer ID Found");
                foundPosition = i;
                break;
            }
            else if(LeagueDatabase[i].getName().equals(searchTrainer)){
                JOptionPane.showMessageDialog(null, "Trainer Name Found");
                foundPosition = i;
                break;
            }
        }
        if(foundPosition == -1){
            JOptionPane.showMessageDialog(null, "Trainer Not Found");
        }
        else{
            JOptionPane.showMessageDialog(null, "Search Value Data:\n" + LeagueDatabase[foundPosition].toString());
        }
    }
    }

    //Function: League Information - Display Info about League and Trainers
    public static void trainerInfo(Trainer[] LeagueDatabase){
    if(Trainer.numTrainers > 0){
        //Variable Declaration
        String output = "** League Trainers **\n";
        //Addition Loop
        for(int i = 0; i< Trainer.numTrainers; i++){
            output += (i + 1) + ")\n" + LeagueDatabase[i].toString() + "\n";
        }
        //Final Output
        JTextArea textArea = new JTextArea(20, 20);
        textArea.setText(output);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JOptionPane.showMessageDialog(null, scrollPane);
    }
    else{
        JOptionPane.showMessageDialog(null, "No trainers to display currently");
    }
    }

    //Function: Battle - Search for 2 trainers and let them battle!
    public static void Battle(Trainer[] LeagueDatabase){
    if(Trainer.numTrainers < 2){
        JOptionPane.showMessageDialog(null, "No trainers to battle.");
    }
    else{
        boolean properSearch1 = false;
        boolean properSearch2 = false;
        int foundPosition1 = -1;
        int foundPosition2 = -1;
        String searchTrainer1 = "";
        String searchTrainer2 = "";

        do{
            do{
            searchTrainer1 = JOptionPane.showInputDialog("Enter Trainer ID - Trainer 1");
            if (searchTrainer1 == null || searchTrainer1.equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Search Value - Please Try Again");
            }else{
                properSearch1 = true;
            }
            }while (!properSearch1);
         
           for(int i = 0; i < Trainer.numTrainers; i++){
            if(LeagueDatabase[i].getID().equals(searchTrainer1)){
                JOptionPane.showMessageDialog(null, "Trainer ID Found");
                foundPosition1 = i;
                break;
            }
           }
           if(foundPosition1 == -1){
            JOptionPane.showMessageDialog(null, "Trainer Not Found - Please Try Again");
           }
        }while (foundPosition1 == -1);

         do{
            do{
            searchTrainer2 = JOptionPane.showInputDialog("Enter Trainer ID - Trainer 2");
            if (searchTrainer2 == null || searchTrainer2.equals("")) {
                JOptionPane.showMessageDialog(null, "Invalid Search Value - Please Try Again");
            }else{
                properSearch2 = true;
            }
            }while (!properSearch2);
         
           for(int i = 0; i < Trainer.numTrainers; i++){
            if(LeagueDatabase[i].getID().equals(searchTrainer2)){
                JOptionPane.showMessageDialog(null, "Trainer ID Found");
                foundPosition2 = i;
                break;
            }
           }
           if(foundPosition2 == -1){
            JOptionPane.showMessageDialog(null, "Trainer Not Found - Please Try Again");
           }
        }while (foundPosition2 == -1);

        if((LeagueDatabase[foundPosition1] instanceof GymLeader) && (LeagueDatabase[foundPosition2] instanceof GymLeader) ){
            JOptionPane.showMessageDialog(null, "***Gym Leader Battle***!\n" + LeagueDatabase[foundPosition1].getName() +  " vs. " + LeagueDatabase[foundPosition2].getName());
        }
        else if((LeagueDatabase[foundPosition1] instanceof GymLeader) && !(LeagueDatabase[foundPosition2] instanceof GymLeader) ){
            JOptionPane.showMessageDialog(null, "***Gym Leader Challenge***!\n" + LeagueDatabase[foundPosition1].getName() +  " vs. " + LeagueDatabase[foundPosition2].getName());
        }
        else if(!(LeagueDatabase[foundPosition1] instanceof GymLeader) && (LeagueDatabase[foundPosition2] instanceof GymLeader) ){
            JOptionPane.showMessageDialog(null, "***Gym Leader Challenge***!\n" + LeagueDatabase[foundPosition1].getName() +  " vs. " + LeagueDatabase[foundPosition2].getName());
        }
        else{
            JOptionPane.showMessageDialog(null, "***Trainer Battle***!\n" + LeagueDatabase[foundPosition1].getName() +  " vs. " + LeagueDatabase[foundPosition2].getName());
        }
        
        int randomNumber = (int) (Math.random() * 10) + 1;

        JOptionPane.showMessageDialog(null, "***Intense Battle Noises***" );

        if(randomNumber <= 5){
            JOptionPane.showMessageDialog(null, "***Victory***!\n" + LeagueDatabase[foundPosition1].getName() +  " wins!" );
        }
        else{
            JOptionPane.showMessageDialog(null, "***Victory***!\n" + LeagueDatabase[foundPosition2].getName() +  " wins!" );
        }

    }
    } 

   public static void deleteTrainer(Trainer[] LeagueDatabase){
      if(Trainer.getNumTrainers() == 0){
         JOptionPane.showMessageDialog(null, "No trainers to remove.");
      }
      else{
         boolean properRemove = false;
         int removePosition = 0;
         //ID Check Do-While Loop
         do{
            String removeID = JOptionPane.showInputDialog("Enter the ID of the Trainer to Delete");
            if(removeID == null || removeID.equals("")) {
                  JOptionPane.showMessageDialog(null, "Improper format. Please try again");
               }
               else{
                  //Removal Search + Comparison
                  for(int i=0;i<Trainer.getNumTrainers();i++){
                     if(LeagueDatabase[i].getID().equalsIgnoreCase(removeID)){
                        properRemove = true;
                        removePosition = i;
                     }
                  }
                  //Trainer Removal + NumTrainer Decrement
                  if(properRemove){
                     LeagueDatabase[removePosition] = null;
                     for(int i = removePosition; i<Trainer.getNumTrainers(); i++){
                        LeagueDatabase[i] = LeagueDatabase[i + 1];
                     }
                     Trainer.numTrainers -= 1;
                     JOptionPane.showMessageDialog(null, "Trainer [" + removeID + "] successfully removed.");
                  }
                  else{
                     JOptionPane.showMessageDialog(null, "Trainer not found.");
                     properRemove = true;
                  }
               }
         }while(!properRemove);
      }
   }
}


