/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022/06/24
 * purpose: "Java-Basic assignment . Dog Genetics "
 */


package davoudr.javabasicassignment;

import java.util.Random;
import java.util.Scanner;


public class DogGenetics {
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        String[] dogsBreeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        int dedicatedPercentage = 0;
        int newRandInt = 0;
        
        System.out.println("What is your dog's name?");
        String dogName = input.nextLine();
        
        System.out.println("Well then, I have this highly reliable report on Sir Fluffy McFlufferkins Esquire's prestigious background right here." + "\n");
        System.out.println("Sir Fluffy McFlufferkins Esquire is:" + "\n");
        
//      each loop we will have a random percentage for next breeds based on remainder of percentage!
        for (int i=0; i<dogsBreeds.length-1; i++){
            newRandInt = randInRemainder(100-dedicatedPercentage);
            dedicatedPercentage += newRandInt;
            
            System.out.println(newRandInt + "% " + dogsBreeds[i]);
        }
        System.out.println((100-dedicatedPercentage) + "% " + dogsBreeds[dogsBreeds.length-1] + "\n");
        System.out.println("\nWow, that's QUITE the dog!");
    }
    
//  this class gives a random nomber between 0 to the parameter that is receiving!
    public static int randInRemainder(int remainder){
        Random randGen = new Random();
        int randValue = randGen.nextInt(remainder+1);
        return randValue;
    }
}




