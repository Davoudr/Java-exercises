/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.ui;

import java.math.BigDecimal;
import java.util.Scanner;





public class UserIOConsoleImpl implements UserIO {

    final private Scanner console = new Scanner (System.in);
    
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public String readString(String prompt) {
        this.print(prompt);
        return console.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try{
                String userInput = this.readString(prompt);
                num = Integer.parseInt(userInput);
                invalidInput = false;
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again!");
            }
        } 
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = this.readInt(prompt);            
        } while (result < min || result > max);  
        return result;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again!");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = this.readLong(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));           
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = this.readFloat(prompt);
        } while ( result < min || result > max);
        return result;
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(prompt));                
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again");
            }
        }
    }

    @Override
    public double readDouble(String msgPrompt, double min, double max) {
        double result;
        do {
            result = readDouble(msgPrompt);
        } while (result < min || result > max);
        return result;
    }

 
}
