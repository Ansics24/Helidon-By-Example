package de.schulte.smartbar.backoffice;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(int id) {
        super(String.format("There is not entity with id %d", id));
    }
}
