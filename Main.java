import java.text.MessageFormat;
import java.util.Random;
import java.util.Scanner;  // Import the Scanner class


public class Main {
    static int correctNumber;
    static String playerName;

    static String defaultName = "Meg";

    static int attemptsRemaining;

     enum Difficulties{
        Easy,
        Medium,
        Hard
    }

    static Difficulties difficulty;


    public static void main(String[] args) {
        //Setting the players default name

        playerName = defaultName;

        System.out.println("Welcome to my game.");
        System.out.println("===============================");
        System.out.println("Before we begin, please tell me your name:");

        RetrieveName(false);


       BeginGame();

    }

    public static void RetrieveName(Boolean nameRetrieved)
    {
        if(!nameRetrieved) {
            Scanner name = new Scanner(System.in);  // Create a Scanner object
            playerName = name.next();

        }else{
            System.out.println("Oops, it looks like I already have your name saved\nLet me find it...");
            playerName = defaultName;
        }
    }

    public static void BeginGame() {

        System.out.printf("Hello %s! I hope your enjoy your experience.", playerName);
        System.out.println();
        System.out.println("This game has 3 difficulties. Easy (1), Medium (2) & Hard (3).");
        System.out.println("Please type the difficulty of the number you want.");

        GrabUserDifficulty();
        correctNumber = GenerateRandomNumber();
        GrabUserGuess(correctNumber);
    }

    public static int GenerateRandomNumber(){

        Random rand = new Random();
        return
        switch (difficulty){
            case Easy ->  correctNumber = rand.nextInt(10) + 1;

            case Medium -> correctNumber = rand.nextInt(20) + 1;

            case Hard -> correctNumber = rand.nextInt(50) + 1;

        };



    }

    public static void GrabUserGuess(int correctNumber){
        Scanner guess = new Scanner(System.in);  // Create a Scanner object
        int userGuess = guess.nextInt();
        CheckUserGuess(correctNumber, userGuess);

    }

    public static void CheckUserGuess(int correctAnswer, int userGuess){
        Result(userGuess == correctAnswer);
    }

    public static void Result(boolean complete){
        if (complete) {
            System.out.println("Game Finished! Well Done");
        } else {

            attemptsRemaining--;
            if(attemptsRemaining >= 1){
                System.out.println("Try Again ...");
                GrabUserGuess(correctNumber);
            }else{
                System.out.println("GAME OVER! You ran out of lives.");
            }



        }
    }

    public static void GrabUserDifficulty(){
        Scanner guess = new Scanner(System.in);  // Create a Scanner object
        int userDifficulty = guess.nextInt();
        //Make sure the chosen difficulty is within the correct bounds.
        if(userDifficulty >= 1 && userDifficulty <= 3)
        {
            switch (userDifficulty){
                case 1:
                    difficulty = Difficulties.Easy;
                    attemptsRemaining = 5;
                    System.out.println("You've chosen Easy ... Hah!");
                    System.out.println("You must guess a number between 1 - 10. You get 5 attempts.");
                    break;
                case 2:
                    difficulty = Difficulties.Medium;
                    attemptsRemaining = 5;
                    System.out.println("You've chosen Medium ... Interesting!");
                    System.out.println("You must guess a number between 1 - 20. You get 5 attempts.");
                    break;
                case 3:
                    difficulty = Difficulties.Hard;
                    attemptsRemaining = 10;
                    System.out.println("You've chosen Hard ... Gamer!");
                    System.out.println("You must guess a number between 1 - 50. You get 10 attempts.");
                    break;
            }
        }
        else{

            System.out.println("That's not a valid difficulty buster!");
            System.out.println("This game has 3 difficulties. Easy (1), Medium (2) & Hard (3).");
            System.out.println("Please type the difficulty number you want (1-3), then press 'Enter'.");

        }



    }



}
