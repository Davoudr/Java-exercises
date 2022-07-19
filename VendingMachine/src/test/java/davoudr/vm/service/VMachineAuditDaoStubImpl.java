/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.service;

import davoudr.vm.dao.VMachineAuditDao;
import davoudr.vm.dao.VMachinePersistenceException;


public class VMachineAuditDaoStubImpl implements VMachineAuditDao {

    @Override
    public void writeAuditLog(String entry) throws VMachinePersistenceException {
        // no action
    }

}
