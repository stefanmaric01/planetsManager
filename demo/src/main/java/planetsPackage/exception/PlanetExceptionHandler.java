package planetsPackage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PlanetExceptionHandler {
    @ExceptionHandler(value = {PlanetNotFoundException.class})
    public ResponseEntity<Object> handlePlanetNotFoundException(PlanetNotFoundException planetNotFoundException) {

        PlanetException planetException = new PlanetException(
                planetNotFoundException.getMessage(),
                planetNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(planetException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {PlanetBadRequestException.class})
    public ResponseEntity<Object> handlePlanetBadRequestException(PlanetBadRequestException planetBadRequestException) {

        PlanetException planetException = new PlanetException(
                planetBadRequestException.getMessage(),
                planetBadRequestException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(planetException, HttpStatus.BAD_REQUEST);
    }


}
