package de.schulte.smartbar.backoffice.tables;

import static org.eclipse.microprofile.health.HealthCheckResponse.down;
import static org.eclipse.microprofile.health.HealthCheckResponse.up;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
@Readiness
public class TablesServiceReadynessCheck implements HealthCheck {

    private static final String NAME = "TablesServiceLoad";

    @Inject
    private TablesServiceImpl tablesService;

    @Override
    public HealthCheckResponse call() {
        final double oneMinuteRate = tablesService.getMeter().getOneMinuteRate();
        return oneMinuteRate < 0.1 ? up(NAME) : down(NAME);
    }

}
