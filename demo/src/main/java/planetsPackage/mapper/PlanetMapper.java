package planetsPackage.mapper;

import lombok.Builder;
import planetsPackage.model.Planet;
import planetsPackage.dto.PlanetDto;
@Builder
public class PlanetMapper {

    public static PlanetDto planetToPlanetDto(Planet planet) {
        return PlanetDto.builder()
                .id(planet.getId())
                .name(planet.getName())
                .surfaceArea(planet.getSurfaceArea())
                .mass(planet.getMass())
                .distanceFromSun(planet.getDistanceFromSun())
                .averageSurfaceTemperature(planet.getAverageSurfaceTemperature())
                .satellites(planet.getSatellites())
                .build();
    }

    public static Planet planetDtoToPlanet(PlanetDto dto) {
        return Planet.builder()
                .id(dto.getId())
                .name(dto.getName())
                .surfaceArea(dto.getSurfaceArea())
                .mass(dto.getMass())
                .distanceFromSun(dto.getDistanceFromSun())
                .averageSurfaceTemperature(dto.getAverageSurfaceTemperature())
                .satellites(dto.getSatellites())
                .build();
    }
}
