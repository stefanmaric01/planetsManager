package planetsPackage.exception;

public class PlanetBadRequestException extends  RuntimeException {
    public PlanetBadRequestException(String message) {
        super(message);
    }

    public PlanetBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
