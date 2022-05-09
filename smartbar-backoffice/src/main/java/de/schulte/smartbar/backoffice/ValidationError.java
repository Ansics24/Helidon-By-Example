package de.schulte.smartbar.backoffice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ValidationError {

    private final String path;

    private final String message;

}
