
package davoudr.vm.dao;

import davoudr.vm.dto.Change;
import davoudr.vm.dto.Item;
import java.util.List;


/**
 *
 * @author davoudramezanikermani
 */
public interface VMachineDao {
    
    public List<Item> getAllItems() throws VMachinePersistenceException;
    
    public Item getItem(String itemName)  throws VMachinePersistenceException;
    
    public void addFund(float fund);
    
    public float getFund();
    
    public float spendMoney(float price);
    
    public String chnageToReturn(float inDollar);
    
    public void updateInventory(String theItemName) throws VMachinePersistenceException;
    
    public void updateFile() throws VMachinePersistenceException;
}
