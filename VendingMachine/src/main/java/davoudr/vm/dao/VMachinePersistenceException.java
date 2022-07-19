/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.dao;


public class VMachinePersistenceException extends Exception {

    public VMachinePersistenceException (String message) {
        super(message);
    }
    
    public VMachinePersistenceException (String message, Throwable cause) {
        super(message, cause);
    }
}
