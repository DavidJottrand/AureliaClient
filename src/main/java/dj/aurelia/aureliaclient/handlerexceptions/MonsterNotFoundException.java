package dj.aurelia.aureliaclient.handlerexceptions;

import org.springframework.http.HttpStatus;

public class MonsterNotFoundException extends MonsterException {

    public MonsterNotFoundException(String message) {
        super(message);
        setStatus(HttpStatus.NOT_FOUND);
    }
}
