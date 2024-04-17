package planetsPackage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import planetsPackage.model.Planet;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class SatelliteDto {

    private Long id;
    private String name;
    private Long surfaceArea;
    private Long mass;
    private boolean naturalSatellite;
    private Planet planet;
}
