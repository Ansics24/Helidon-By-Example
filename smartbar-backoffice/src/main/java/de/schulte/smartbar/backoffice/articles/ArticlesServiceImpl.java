package de.schulte.smartbar.backoffice.articles;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import de.schulte.smartbar.backoffice.EntityNotFoundException;
import de.schulte.smartbar.backoffice.categories.Category;

@ApplicationScoped
@Transactional
public class ArticlesServiceImpl implements ArticlesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> listAll() {
        return entityManager.createQuery("select a from Article a", Article.class).getResultList();
    }

    @Override
    public Article insertNew(int categoryId, Article article) {
        final Category category = entityManager.find(Category.class, categoryId);
        if (category == null) {
            throw new EntityNotFoundException(categoryId);
        }
        Article mergedArticle = article;
        mergedArticle.setCategory(category);
        mergedArticle = entityManager.merge(mergedArticle);
        return mergedArticle;
    }

    @Override
    public Article update(int categoryId, int articleId, Article article) {
        final TypedQuery<Article> query = entityManager.createQuery("select a from Article a where a.id = :articleId " +
                "and a.category.id = :categoryId", Article.class);
        query.setParameter("articleId", articleId);
        query.setParameter("categoryId", categoryId);
        final List<Article> articles = query.getResultList();
        if (articles.isEmpty()) {
            throw new EntityNotFoundException(articleId);
        }
        final Article existingArticle = articles.get(0);
        existingArticle.setName(article.getName());
        existingArticle.setPrice(article.getPrice());
        return existingArticle;
    }
}
