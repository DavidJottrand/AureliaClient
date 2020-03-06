package dj.aurelia.aureliaclient.handlerexceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MonsterException.class)
    public ResponseEntity<Object> handleMonsterException(MonsterException ex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("status", ex.getStatus().value() + "");
        return ResponseEntity.status(ex.getStatus()).body(map);
    }


    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleUserException(UserException ex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("status", ex.getStatus().value() + "");
        return ResponseEntity.status(ex.getStatus()).body(map);
    }

    @ExceptionHandler(CharacterException.class)
    public ResponseEntity<Object> handleCharacterException(CharacterException ex) {
        HashMap<String, String> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("status", ex.getStatus().value() + "");
        return ResponseEntity.status(ex.getStatus()).body(map);
    }
}
