/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.dto;



/*
PENNY ---> 1, 
NICKLE --> 5,
DIME ----> 10,
QUARTER -> 25,
*/

public enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    
    private final int value;
    
    private Coin (int value) {
        this.value = value;
    }
    
    public int getValue () {
        return value;
    }
}
