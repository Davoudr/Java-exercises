/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022/06/24
 * purpose: "Java-Basic assignment . Summative Sums"
 */


package davoudr.javabasicassignment;


public class SummativeSums {
    public static void main (String[] args) {
        
    int[][] examples = {
        { 1, 90, -33, -55, 67, -16, 28, -55, 15 },
        { 999, -60, -77, 14, 160, 301 },
        { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100,
            110, 120, 130, 140, 150, 160, 170, 180, 190, 200, -99 
        }};

//  this loop prints sum for all the arrays in the example!    
    for(int i=0; i<examples.length; i++){
        System.out.println("#" + i + " Array Sum: "+ adder(examples[i]));
        }
    }
    
//  this class calculates the sum for all elements in the given array;
    public static int adder (int[] theArr){
        int sum = 0;
        for (int i=0; i<theArr.length; i++){
            sum += theArr[i];
        }
        return sum;
    }
  
}

