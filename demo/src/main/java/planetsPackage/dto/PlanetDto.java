package planetsPackage.dto;

import lombok.Builder;
import lombok.Data;
import planetsPackage.model.Satellite;

import java.util.List;

@Builder
@Data
public class PlanetDto {
    private Long id;
    private String name;
    private Long surfaceArea;
    private Long mass;
    private Long distanceFromSun;
    private int averageSurfaceTemperature;
    private List<Satellite> satellites;
}
