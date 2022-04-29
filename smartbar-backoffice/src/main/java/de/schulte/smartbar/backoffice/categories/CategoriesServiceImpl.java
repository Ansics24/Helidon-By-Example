package de.schulte.smartbar.backoffice.categories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.schulte.smartbar.backoffice.EntityNotFoundException;

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
