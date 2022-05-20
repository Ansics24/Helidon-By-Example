package de.schulte.smartbar.orderclient.login;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class LoginService implements Service {
    @Override
    public void update(Routing.Rules rules) {
        rules.post("/tables/{id}/logins", this::handleTableLogin);
    }

    private void handleTableLogin(ServerRequest serverRequest, ServerResponse serverResponse) {
        System.out.println("Table login requested");
        serverResponse.status(201).send();
    }
}
