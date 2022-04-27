package de.schulte.smartbar.backoffice.categories;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/categories")
public class CategoriesResource {

    private final CategoriesService categoriesService;

    @Inject
    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GET
    public Response listAll() {
        return Response.ok(categoriesService.listAll()).build();
    }

    @POST
    public Response createNewCategory(Category category) {
        final Category savedCategory = categoriesService.save(category);
        return Response.status(Response.Status.CREATED).entity(savedCategory).build();
    }
}
