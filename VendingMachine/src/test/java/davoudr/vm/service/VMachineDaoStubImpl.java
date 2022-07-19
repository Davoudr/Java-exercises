/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.service;

import davoudr.vm.dao.VMachineDao;
import davoudr.vm.dao.VMachinePersistenceException;
import davoudr.vm.dto.Change;
import davoudr.vm.dto.Item;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;


public class VMachineDaoStubImpl implements VMachineDao {
    
    public Item availableItem;
    public Item NotAvailableItem;
    private float fund = 7;
    
    public VMachineDaoStubImpl () {
        availableItem = new Item ("Coca");
        availableItem.setCost(BigDecimal.ONE);
        availableItem.setInventory(10);
        
        NotAvailableItem = new Item ("Pepsi");
        NotAvailableItem.setCost(BigDecimal.ZERO);
        NotAvailableItem.setInventory(0);
    }
    
    public VMachineDaoStubImpl (Item testItem)  {
        this.availableItem = testItem;
    }
    
    

    @Override
    public List<Item> getAllItems() throws VMachinePersistenceException {
        List<Item> itemList = new ArrayList<>();
        itemList.add(availableItem);
        itemList.add(NotAvailableItem);
        return itemList;
    }

    @Override
    public Item getItem(String itemName) throws VMachinePersistenceException {
        if (itemName == availableItem.getName()) {
            return availableItem;
        } else if (itemName == NotAvailableItem.getName()) {
            return NotAvailableItem;
        } else {
            return null;
        }
    }

    @Override
    public void addFund(float theFund) {
        fund = 8;
    }

    @Override
    public float getFund() {
        return fund;
    }

    @Override
    public float spendMoney(float theFund) {
        fund = 6;
        return fund;
    }

    @Override
    public String chnageToReturn(float inDollar) {
        Change change = new Change (BigDecimal.ONE.setScale(2, RoundingMode.HALF_UP));
        return change.toString();
    }

    @Override
    public void updateInventory(String theItemName) throws VMachinePersistenceException {
        if (theItemName == availableItem.getName()) {
            availableItem.setInventory(9);
        }
    }

    @Override
    public void updateFile() throws VMachinePersistenceException {
        //no action
    }

}
