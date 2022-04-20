package de.schulte.smartbar.backoffice.categories;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriesServiceImpl implements CategoriesService {
    @Override
    public List<Category> listAll() {
        return List.of(new Category("Drinks"), new Category("Food"));
    }
}
