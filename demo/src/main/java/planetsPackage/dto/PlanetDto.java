package planetsPackage.dto;

import lombok.Builder;
import lombok.Data;
import planetsPackage.model.Satellite;

import java.util.List;
import java.util.Set;

@Builder
@Data
public class PlanetDto {
    private Long id;
    private String name;
    private Long surfaceArea;
    private Long mass;
    private Long distanceFromSun;
    private Long averageSurfaceTemperature;
    private Set<Satellite> satellites;

}
