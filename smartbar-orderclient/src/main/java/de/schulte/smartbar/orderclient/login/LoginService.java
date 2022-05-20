package de.schulte.smartbar.orderclient.login;

import de.schulte.smartbar.orderclient.ResourceNotFoundException;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class LoginService implements Service {
    @Override
    public void update(Routing.Rules rules) {
        rules.post("/tables/{id:\\d+}/logins", this::handleTableLogin);
    }

    private void handleTableLogin(ServerRequest serverRequest, ServerResponse serverResponse) {
        final int tableId = Integer.parseInt(serverRequest.path().param("id"));
        System.out.println("Table login requested for table " + tableId);
        serverResponse.status(201).send();
    }
}
