package dj.aurelia.aureliaclient.handlerexceptions;

import org.springframework.http.HttpStatus;

public class FormException extends MonsterException {

    public FormException(String message) {
        super(message);
        setStatus(HttpStatus.BAD_REQUEST);
    }
}
