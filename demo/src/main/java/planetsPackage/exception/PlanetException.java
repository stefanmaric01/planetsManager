package planetsPackage.exception;

public class PlanetException extends RuntimeException {

    public PlanetException(String message) {
        super(message);
    }

    public PlanetException(String message, Throwable cause) {
        super(message, cause);
    }
}