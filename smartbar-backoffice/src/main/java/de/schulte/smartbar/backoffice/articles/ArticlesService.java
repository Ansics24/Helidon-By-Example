package de.schulte.smartbar.backoffice.articles;

import java.util.List;

public interface ArticlesService {

    List<Article> listAll();

    Article insertNew(int categoryId, Article article);

    Article update(int categoryId, int articleId, Article article);

}
