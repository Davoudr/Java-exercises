
package davoudr.vm;

import davoudr.vm.controller.VMachineController;
import davoudr.vm.dao.VMachineAuditDao;
import davoudr.vm.dao.VMachineAuditDaoImpl;
import davoudr.vm.dao.VMachineDao;
import davoudr.vm.dao.VMachineDaoImpl;
import davoudr.vm.service.VMachineNoItemInventoryException;
import davoudr.vm.service.VMachineServiceLayer;
import davoudr.vm.service.VMachineServiceLayerImpl;
import davoudr.vm.ui.UserIO;
import davoudr.vm.ui.UserIOConsoleImpl;
import davoudr.vm.ui.VMachineView;

/**
 *
 * @author davoudramezanikermani
 */



public class App {
    
    
    public static void main(String[] args) {

//----------------------------------------        
        UserIO appIO = new UserIOConsoleImpl();
        VMachineView appView = new VMachineView(appIO);
//-------------------  
        VMachineDao appDao = new VMachineDaoImpl();
        VMachineAuditDao appAuditDao = new VMachineAuditDaoImpl();
        
        VMachineServiceLayer appService = 
                new VMachineServiceLayerImpl(appDao,appAuditDao);
//------------------- 
        VMachineController appController = 
                new VMachineController(appService, appView);
//----------------------------------------         
        appController.run();
    }
}
