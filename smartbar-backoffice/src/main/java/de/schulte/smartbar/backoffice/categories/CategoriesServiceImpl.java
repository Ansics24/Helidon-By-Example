package de.schulte.smartbar.backoffice.categories;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class CategoriesServiceImpl implements CategoriesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Category> listAll() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    @Transactional
    public Category insertNew(Category category) {
        return entityManager.merge(category);
    }

    @Override
    @Transactional
    public Category update(int id, Category category) {
        final Category existingCategory = entityManager.find(Category.class, id);
        if(existingCategory == null) {
            throw new EntityNotFoundException(id);
        }
        existingCategory.setName(category.getName());
        return existingCategory;
    }
}
