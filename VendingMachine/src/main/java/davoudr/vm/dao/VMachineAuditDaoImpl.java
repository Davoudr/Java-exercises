/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class VMachineAuditDaoImpl implements VMachineAuditDao {
    
    private static String AUDIT_FILE = "audit.txt";
//-------------------------------------------      
    public VMachineAuditDaoImpl () {
       AUDIT_FILE = "audit.txt";
    }
        
    public VMachineAuditDaoImpl (String auditFileName) {
        AUDIT_FILE = auditFileName;
    }
//------------------------------------------- 
    
    public void writeAuditLog (String entry) throws VMachinePersistenceException {
        
        PrintWriter pw;
        
        try {
            pw = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VMachinePersistenceException("Could not persist audit information!", e);
        }
        
        LocalDateTime dateTimeLog = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy - hh:mm:ss -------> ");
        String formatted = dateTimeLog.format(formatter);
        pw.println(formatted + entry);
        pw.flush();
        pw.close();
    }
}
