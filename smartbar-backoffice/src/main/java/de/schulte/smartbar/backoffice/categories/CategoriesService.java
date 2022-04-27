package de.schulte.smartbar.backoffice.categories;

import java.util.List;

public interface CategoriesService {

    List<Category> listAll();

    Category insertNew(Category category);

    Category update(int id, Category category);

}
