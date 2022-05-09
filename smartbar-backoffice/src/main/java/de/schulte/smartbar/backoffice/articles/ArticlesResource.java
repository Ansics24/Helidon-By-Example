package de.schulte.smartbar.backoffice.articles;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;

import de.schulte.smartbar.backoffice.EntityNotFoundException;

@Path("/categories")
@Singleton
public class ArticlesResource {

    @Inject
    private ArticlesService articlesService;

    @GET
    @Path("/articles")
    public Response listAll() {
        return Response.ok(articlesService.listAll()).build();
    }

    @POST
    @Path("/{categoryId}/articles")
    @Metered(name = "modifying/inserting articles", reusable = true)
    public Response createNewArticle(@PathParam("categoryId") int categoryId, Article article) {
        try {
            return Response.status(Response.Status.CREATED)
                    .entity(articlesService.insertNew(categoryId, article))
                    .build();
        } catch (EntityNotFoundException enfe) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{categoryId}/articles/{articleId}")
    @Metered(name = "modifying/inserting articles", reusable = true)
    public Response update(@PathParam("categoryId") int categoryId, @PathParam("articleId") int articleId, Article article) {
        try {
            return Response.ok(articlesService.update(categoryId, articleId, article)).build();
        } catch (EntityNotFoundException enfe) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
