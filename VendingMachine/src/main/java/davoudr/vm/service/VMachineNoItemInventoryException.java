/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.service;


public class VMachineNoItemInventoryException extends Exception {

    public VMachineNoItemInventoryException (String message) {
        super(message);
    }
    
    public VMachineNoItemInventoryException (String message, Throwable cause) {
        super(message, cause);
    }
}
