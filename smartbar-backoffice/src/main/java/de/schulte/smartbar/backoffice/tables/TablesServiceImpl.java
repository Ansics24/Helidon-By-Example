package de.schulte.smartbar.backoffice.tables;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.eclipse.microprofile.faulttolerance.Timeout;

import de.schulte.smartbar.backoffice.EntityNotFoundException;
import io.helidon.security.annotations.Authenticated;
import io.helidon.security.annotations.Authorized;

@ApplicationScoped
@Transactional
public class TablesServiceImpl implements TablesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Timeout(1000)
    public List<SmartbarTable> listAll() {
        return entityManager.createQuery("select t from SmartbarTable t", SmartbarTable.class).getResultList();
    }

    @Override
    public SmartbarTable insertNew(SmartbarTable table) {
        return entityManager.merge(table);
    }

    @Override
    public SmartbarTable update(int id, SmartbarTable table) {
        SmartbarTable existingTable = entityManager.find(SmartbarTable.class, id);
        if(existingTable == null) {
            throw new EntityNotFoundException(id);
        }
        existingTable.setName(table.getName());
        return existingTable;
    }
}
