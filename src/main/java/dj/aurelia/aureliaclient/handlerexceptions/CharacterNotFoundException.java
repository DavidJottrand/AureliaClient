package dj.aurelia.aureliaclient.handlerexceptions;

import org.springframework.http.HttpStatus;

public class CharacterNotFoundException extends CharacterException {

    public CharacterNotFoundException(String message) {
        super(message);
        setStatus(HttpStatus.NOT_FOUND);
    }
}
