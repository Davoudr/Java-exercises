/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */



package davoudr.vm.service;


public class VMachineInsufficientFands extends Exception {

    public VMachineInsufficientFands (String message) {
        super(message);
    }
    
    public VMachineInsufficientFands (String message, Throwable cause) {
        super(message, cause);
    }
}


