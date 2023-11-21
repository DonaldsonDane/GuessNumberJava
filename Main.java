import java.util.Random;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    static int correctNumber;

    public static void main(String[] args) {
        System.out.println("Game Begun");
        System.out.println("===============================");
        BeginGame();

    }

    public static void BeginGame() {
        correctNumber = GenerateRandomNumber();
        System.out.println("Please Guess A Number (1-50) :");
        GrabUserGuess(correctNumber);
    }

    public static int GenerateRandomNumber(){

        Random rand = new Random();
        // Obtain a number between [0 - 49].
        return rand.nextInt(50);
    }

    public static void GrabUserGuess(int correctNumber){
        Scanner guess = new Scanner(System.in);  // Create a Scanner object
        int userGuess = guess.nextInt();
        CheckUserGuess(correctNumber, userGuess);

    }

    public static void CheckUserGuess(int correctAnswer, int userGuess){
        if(userGuess == correctAnswer){
            Result(true);
        }else{
            Result(false);
        }
    }

    public static void Result(boolean complete){
        if (complete) {
            System.out.println("Game Finished! Well Done");
        } else {
            System.out.println("Try Again ...");
            System.out.println("Please Guess A Number (1-50) :");
            GrabUserGuess(correctNumber);
        }
    }



}
