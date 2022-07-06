/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022/06/24
 * purpose: "Java-Basic assignment . Rock, Paper, Scissors"
 */

package davoudr.javabasicassignment;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissors {
   public static void main(String[] args) {
    
//  user chooses how many round1   
    int roundNumRequested = optionPrompt("Heccllo! Playing 1-10 round is possible. How many round do you want to play?");
    boolean willingToReplay = false;
 
//  error if round number is out of range 1-10!
    if (roundNumRequested>0 && roundNumRequested<11) {
        do {
            willingToReplay = gamePlay(roundNumRequested) ;
        } while (willingToReplay);
        System.out.println("\"Thanks for playing!\"");
    } else {
        System.out.println("Error! you chose a wrong option!");
    }
   
    }
//  -----------------------------------------------
// this class plays the game!
   public static boolean gamePlay(int requestedRoundNum) {

       Scanner input = new Scanner(System.in);
       Random randGen = new Random();
       int roundCounter = 0;
       int userWins = 0;
       int programWins = 0;
       int tieCounter = 0;
       int playerChoice = 0;
       String curentUserResult = "";
       boolean isValid = false;
       
//     playing untill we get to round limit number
       while(roundCounter < requestedRoundNum) {
           roundCounter++;
           do {
//           receiving youser's choice
             playerChoice = optionPrompt("Choose one option! 1 = Rock / 2 = Paper / 3 = Scissors");  
             if (playerChoice>0 && playerChoice<4) {
                 isValid = true;
             }
           } while(!isValid);
           
//         generating computer's choicee
           int programChoice = randGen.nextInt(3)+1;
           
//         finding the result for the game and having the records      
           switch (playerChoice){
               case 1:
                   if(programChoice==3){
                       userWins++;
                       curentUserResult = "WIN!";
                   } else if (programChoice==2){
                       programWins++;
                       curentUserResult = "LOSE!";
                   } else {
                       curentUserResult = "TIE!";
                       tieCounter++;
                   }
                   break;
               case 2:
                   if(programChoice==1){
                       userWins++; 
                       curentUserResult = "WIN!";
                   } else if (programChoice==3){
                       programWins++;
                       curentUserResult = "LOSE!";
                   } else {
                       curentUserResult = "TIE!";
                       tieCounter++;
                   }
                   break;
               case 3:
                   if(programChoice==2){
                       userWins++;      
                       curentUserResult = "WIN!";
                   } else if (programChoice==1){
                       programWins++;
                       curentUserResult = "LOSE!";
                   } else {
                       curentUserResult = "TIE!";
                       tieCounter++;
                   }
                   break;
               default:
                   curentUserResult = "TIE!";
                   tieCounter++;
                   break;
           }
       
//         making some reports for user  
           System.out.println("***YOU " + curentUserResult + "***");
           System.out.println(roundCounter + "rounds is passed and " + (requestedRoundNum-roundCounter) + " rounds is remaining!");
           System.out.println("");
           System.out.println(" YOU " + userWins + " V.S " + programWins + " COMPUTER ");
           System.out.println("and you and computer have had " + tieCounter + " ties!");
           System.out.println("--------------------------------------------");
       }
       
//     final report
       System.out.println("**********************************************");
       System.out.println("FINAL RESULT:");
       if (userWins > programWins){
           System.out.println(">>>>>>>>>YOU WIN<<<<<<<<<<");
       } else if (userWins < programWins){
           System.out.println(">>>>>>>>>YOU LOSE<<<<<<<<<<"); 
           } else {
           System.out.println(">>>>>>>>>TIE<<<<<<<<<<");
           }
       
//     checking the willingness of replay
       int willingToReplay = 0;
       do {
           willingToReplay = optionPrompt("Do you want to play again??? 1.yes / 2.no");
       } while (willingToReplay!=1 && willingToReplay!=2);
       
       if (willingToReplay == 1) {   
           return true;
       } else {
           return false;
       }
   }
   
//  ----------------------------------------------- 
// this class promt a message and return the user's input as int!
   public static int optionPrompt(String message){
        Scanner input = new Scanner(System.in);
        boolean validInput = false;
        int resultInt = 0 ;
        
        while(!validInput){
            try{
                System.out.println(message);
                String resultStr = input.nextLine();
                resultInt = Integer.parseInt(resultStr);
                validInput = true;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a valid number!");
            }
        }
        return resultInt;
   }
//  ----------------------------------------------- 

}
