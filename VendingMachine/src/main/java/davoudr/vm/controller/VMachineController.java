/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.controller;

import davoudr.vm.dao.VMachinePersistenceException;
import davoudr.vm.dto.Item;
import davoudr.vm.service.VMachineInsufficientFands;
import davoudr.vm.service.VMachineNoItemInventoryException;
import davoudr.vm.service.VMachineServiceLayer;
import davoudr.vm.ui.VMachineView;


public class VMachineController {
    
//----------------------------
    private VMachineView view;
    private VMachineServiceLayer service;
//--------------   
    public VMachineController (VMachineServiceLayer service, VMachineView view) {
        this.view = view;
        this.service = service;
    }
//----------------------------
    private float userInput;
    private boolean keepGoing = true;
    private String sellectedItamStr;
    private Item sellectedItamObj;
    
    public void run()  {
        float userInput = 0;
        
        try {
            
            welcome();
            
            while (true) {
                
                startApp();
                
                userInput = getInitialSellection();
                if (userInput==0) {
                    keepGoing = false;
                    break;
                }
                getFundAndItem(userInput);
                vendProcess();
                updateBeforExit();
            }
       
        } catch (VMachinePersistenceException | VMachineInsufficientFands | VMachineNoItemInventoryException e) {
            view.displayError(e.getMessage());
        }
   
    }
    
    
    
    private void welcome() {
        view.welcomeBanner();
    }

    private void startApp() throws VMachinePersistenceException {
        view.showItemList(service.getAllItems());
    }

    private float getInitialSellection() {
        return view.prtintInitialOptionAndGetSellection();
    }
    
    private void getFund(float input) throws VMachinePersistenceException {
        view.successfulAddingFund(input);
        service.addFund(input);
        String log = "$" + String.valueOf(input) + " added.";
        service.writeAuditLog(log);
    } 
    
    private void getItem() throws VMachinePersistenceException, VMachineNoItemInventoryException {
        while (true) {
            sellectedItamStr = view.getUserSellectionFromItems();
            sellectedItamObj = service.getItem(sellectedItamStr);
            if (sellectedItamObj != null) {
                service.checkInventory(sellectedItamObj.getName());
                service.writeAuditLog(sellectedItamObj.getName() + " is sellected.");
                break;
            } else {
                view.wrongItemName();
            }
        }
    }
    
    private void getFundAndItem(float input) throws VMachinePersistenceException, VMachineNoItemInventoryException {
        getFund(input);
        getItem();
    }
    
    private void vendProcess() throws VMachineInsufficientFands, VMachinePersistenceException {
        String changeInfo = service.vending(sellectedItamObj.getCost().floatValue());
        view.successfullPurchase(changeInfo);
        service.writeAuditLog(sellectedItamObj.getName() + " is sold successfully; for $" + sellectedItamObj.getCost());
        service.writeAuditLog(changeInfo);

    }
    
    private void updateBeforExit() throws VMachinePersistenceException {
        service.updateInventory(sellectedItamStr);
        service.updateFile();
    }
}
