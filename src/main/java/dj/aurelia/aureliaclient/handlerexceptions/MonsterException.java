package dj.aurelia.aureliaclient.handlerexceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode
public abstract class MonsterException extends RuntimeException{

    private HttpStatus status;

    public MonsterException(String message) {
        super(message);
    }
}
