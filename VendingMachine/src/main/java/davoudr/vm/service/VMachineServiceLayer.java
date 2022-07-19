
package davoudr.vm.service;

import davoudr.vm.dao.VMachinePersistenceException;
import davoudr.vm.dto.Change;
import davoudr.vm.dto.Item;
import java.util.List;

/**
 *
 * @author davoudramezanikermani
 */

public interface VMachineServiceLayer {
    
    public List<Item> getAllItems() throws VMachinePersistenceException;
    
    public Item getItem(String itemName)  throws VMachinePersistenceException; 
    
    public void addFund(float fund);
    
    public float spendMoney(float price);
    
    public float getFund();
    
    public String chnageToReturn(float inDollar);   
    
    public String vending (float price) throws VMachineInsufficientFands;
   
    public void updateInventory(String theItemName) throws VMachinePersistenceException;
    
    public void updateFile() throws VMachinePersistenceException;
    
    public void checkFund(float thePrice)throws VMachineInsufficientFands;
    
    public void checkInventory(String theItemName) throws VMachineNoItemInventoryException, VMachinePersistenceException;

    public void writeAuditLog (String entry) throws VMachinePersistenceException;
}
