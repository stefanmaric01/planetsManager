package planetsPackage.mapper;

import planetsPackage.dto.SatelliteDto;
import planetsPackage.model.Satellite;

public class SatelliteMapper {

    public static SatelliteDto satelliteToSatelliteDto(Satellite satellite) {
        return SatelliteDto.builder()
                .id(satellite.getId())
                .name(satellite.getName())
                .surfaceArea(satellite.getSurfaceArea())
                .mass(satellite.getMass())
                .naturalSatellite(satellite.isNaturalSatellite())
                .build();
    }

    public static Satellite satelliteDtoToSatellite(SatelliteDto satelliteDto) {
        return Satellite.builder()
                .id(satelliteDto.getId())
                .name(satelliteDto.getName())
                .surfaceArea(satelliteDto.getSurfaceArea())
                .mass(satelliteDto.getMass())
                .naturalSatellite(satelliteDto.isNaturalSatellite())
                .build();
    }

}
