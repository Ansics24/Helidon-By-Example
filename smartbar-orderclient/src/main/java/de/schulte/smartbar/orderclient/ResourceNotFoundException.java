package de.schulte.smartbar.orderclient;

import io.helidon.common.http.Http;
import io.helidon.webserver.HttpException;

public class ResourceNotFoundException extends HttpException {
    public ResourceNotFoundException() {
        super("Sorry but there is no such resource", Http.Status.NOT_FOUND_404);
    }
}
