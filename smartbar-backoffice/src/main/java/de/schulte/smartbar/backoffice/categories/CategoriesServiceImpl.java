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

    private AtomicReference<String> categoryName = new AtomicReference<>();

    @Inject
    public CategoriesServiceImpl(@ConfigProperty(name = "app.categoryName") String categoryName) {
        this.categoryName.set(categoryName);
    }

    @Override
    @Transactional
    public List<Category> listAll() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }
}
