package de.schulte.smartbar.backoffice;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import de.schulte.smartbar.backoffice.tables.TablesService;

@Liveness
@ApplicationScoped
public class DBHealthCheck implements HealthCheck {

    @Inject
    private TablesService tablesService;

    @Override
    public HealthCheckResponse call() {
        try {
            tablesService.listAll();
            return HealthCheckResponse.up("DB");
        } catch (Exception e) {
            return HealthCheckResponse.down("DB");
        }
    }

}
