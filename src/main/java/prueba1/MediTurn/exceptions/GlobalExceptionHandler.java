package prueba1.MediTurn.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new LinkedHashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }

    //Handlers de Errores relacionado con Paciente
    @ExceptionHandler(IDPacienteNoEncontradoException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(IDPacienteNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(RUTPacienteNoEncontradoException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(RUTPacienteNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PacienteDuplicadoException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(PacienteDuplicadoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(UpdatePacNoEncontradoException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(UpdatePacNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    //Handlers de Errores relacionado con Solicitud
    @ExceptionHandler(IDSolicitudNoEncontradaException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(IDSolicitudNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(UpdateSoliNoEncontradaException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(UpdateSoliNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(EspSolicitudNoEncontradaException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(EspSolicitudNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(EstadoSoliNoEncontradaException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(EstadoSoliNoEncontradaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @ExceptionHandler(PacSoliNoEncontradoException.class)
    public ResponseEntity<String> manejarPacNoEncontrado(PacSoliNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

} // Fin de la clase GlobalExceptionHandler