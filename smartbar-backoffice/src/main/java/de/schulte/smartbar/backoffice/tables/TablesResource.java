package de.schulte.smartbar.backoffice.tables;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Meter;
import org.eclipse.microprofile.metrics.annotation.Metric;

import de.schulte.smartbar.backoffice.EntityNotFoundException;
import io.helidon.security.annotations.Authenticated;
import io.helidon.security.annotations.Authorized;

@Path("/tables")
@Authenticated
@Authorized
@RolesAllowed("admin")
public class TablesResource {

    @Inject
    @Metric(name = "table inserts with short names")
    private Meter counterForSmallTableNames;

    @Inject
    private TablesService tablesService;

    @GET
    public Response listAll() {
        return Response.ok(tablesService.listAll()).build();
    }

    @POST
    public Response insertNew(@Valid SmartbarTable table) {
        final SmartbarTable smartbarTable = tablesService.insertNew(table);
        if(smartbarTable.getName().length() < 4) {
            counterForSmallTableNames.mark();
        }
        return Response.status(Response.Status.CREATED).entity(smartbarTable).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") int id, SmartbarTable table) {
        try {
            final SmartbarTable smartbarTable = tablesService.update(id, table);
            return Response.ok(smartbarTable).build();
        } catch (EntityNotFoundException enfe) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
