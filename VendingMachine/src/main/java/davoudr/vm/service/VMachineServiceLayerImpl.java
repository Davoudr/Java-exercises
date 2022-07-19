/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.service;

import davoudr.vm.dao.VMachineAuditDao;
import davoudr.vm.dao.VMachineDao;
import davoudr.vm.dao.VMachinePersistenceException;
import davoudr.vm.dto.Change;
import davoudr.vm.dto.Item;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VMachineServiceLayerImpl implements VMachineServiceLayer {
    
    private VMachineDao dao;
    private VMachineAuditDao auditDao;
    
    public VMachineServiceLayerImpl(VMachineDao dao, VMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public List<Item> getAllItems() throws VMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemName) throws VMachinePersistenceException {
        return dao.getItem(itemName);
    }
    
    @Override
    public void addFund(float fund){
        dao.addFund(fund);
    }
    
    @Override
    public float spendMoney(float price) {
        return dao.spendMoney(price);
    }
    
    @Override
    public float getFund() {
        return dao.getFund();
    }
    
    @Override
    public String chnageToReturn(float inDollar) {
        return dao.chnageToReturn(inDollar);
    }
    
    @Override
    public String vending (float thePrice) throws VMachineInsufficientFands {
        checkFund(thePrice);
        spendMoney(thePrice);
        return chnageToReturn(getFund());
    }
    
    @Override
    public void updateInventory(String theItemName) throws VMachinePersistenceException {
        dao.updateInventory(theItemName);
    }
    
    @Override
    public void updateFile() throws VMachinePersistenceException {
        dao.updateFile();
    }
    
    @Override
    public void checkFund(float thePrice)throws VMachineInsufficientFands {
        if (thePrice > getFund()) {
            throw new VMachineInsufficientFands("Sorry! Your money is not enough to buy the sellected item!");
        }
    }
    
    @Override
    public void checkInventory(String theItemName) throws VMachineNoItemInventoryException, VMachinePersistenceException {
        boolean availability = false;
        Item itemForCheck = getItem(theItemName);
        if (itemForCheck.getInventory() == 0) {
            throw new VMachineNoItemInventoryException("Sorry! We are ran out of stock for the sellected item!");
        }
      
    }
    
    @Override
    public void writeAuditLog (String entry) throws VMachinePersistenceException {
        auditDao.writeAuditLog(entry);
    }
    
}
