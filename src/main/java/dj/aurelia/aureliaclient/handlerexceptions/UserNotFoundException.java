package dj.aurelia.aureliaclient.handlerexceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {

    public UserNotFoundException(String message) {
        super(message);
        setStatus(HttpStatus.NOT_FOUND);
    }
}
