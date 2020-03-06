package dj.aurelia.aureliaclient.handlerexceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode
public abstract class CharacterException extends RuntimeException{

    private HttpStatus status;

    public CharacterException(String message) {
        super(message);
    }
}
