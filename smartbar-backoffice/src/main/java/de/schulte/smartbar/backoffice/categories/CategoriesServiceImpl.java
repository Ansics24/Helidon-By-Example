package de.schulte.smartbar.backoffice.categories;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class CategoriesServiceImpl implements CategoriesService {

    private AtomicReference<String> categoryName = new AtomicReference<>();

    @Inject
    public CategoriesServiceImpl(@ConfigProperty(name = "app.categoryName") String categoryName) {
        this.categoryName.set(categoryName);
    }

    @Override
    public List<Category> listAll() {
        return List.of(new Category(this.categoryName.get()));
    }
}
