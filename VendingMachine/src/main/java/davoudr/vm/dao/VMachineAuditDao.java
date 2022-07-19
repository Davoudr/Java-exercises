
package davoudr.vm.dao;

/**
 *
 * @author davoudramezanikermani
 */
public interface VMachineAuditDao {
    public void writeAuditLog (String entry) throws VMachinePersistenceException;
}
