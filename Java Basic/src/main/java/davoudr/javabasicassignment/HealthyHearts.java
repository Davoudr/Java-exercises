/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022/06/24
 * purpose: "Java-Basic assignment . Healthy Hearts"
 */

package davoudr.javabasicassignment;

import java.util.Scanner;


public class HealthyHearts {

    public static void main(String[] args){
        
        Scanner input = new Scanner (System.in);
        boolean validInput = false;
        int ageInt = 0 ;
       
//      here we will receive the valid int for age!
        while(!validInput){
            try{
                System.out.println("What is your age?");
                String resultStr = input.nextLine();
                ageInt = Integer.parseInt(resultStr);
                validInput = true;
            }catch(NumberFormatException ex){
                System.out.println("Please enter a valid number!");
            }
        }
       
//      calculation base on given formula
        int maxRate = 220 - ageInt;
        float upperLimit =  maxRate / 2;
        int upperLimitInt = Math.round(upperLimit);
        float lowerLimit =  maxRate * 85 / 100;
        int lowerLimitInt = Math.round(lowerLimit);
        
        System.out.println("Your maximum heart rate should be " + maxRate + " beats per minute");
        System.out.println("Your target HR Zone is " + upperLimitInt + " - " + lowerLimitInt + " beats per minute");    
        
    }
  
}
