package ejercicioUno.controllersAdvices;


import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler( {HttpMessageNotReadableException.class})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleRequestParseException(HttpMessageNotReadableException exception){
        Map<String, Object> body = new HashMap<>();
        body.put("mensaje", "El cuerpo de la solicitud es invalido");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler( {HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleMethodNotAllowed(HttpRequestMethodNotSupportedException exception){
        Map<String, Object> body = new HashMap<>();
        exception.printStackTrace();
        body.put("mensaje", "El recurso solicitado no existe.");
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(body);
    }
}
