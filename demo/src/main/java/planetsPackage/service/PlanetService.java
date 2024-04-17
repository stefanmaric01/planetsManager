package planetsPackage.service;

import planetsPackage.dto.PlanetDto;
import planetsPackage.exception.PlanetException;
import lombok.AllArgsConstructor;
import planetsPackage.mapper.PlanetMapper;
import planetsPackage.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import planetsPackage.repository.PlanetRepository;

@Service
@AllArgsConstructor
public class PlanetService {

    private final PlanetRepository planetRepository;



    public Planet getPlanetById(Long id) {
        return planetRepository.findById(id)
                .orElseThrow(() -> new PlanetException("Planet not found with ID: " + id));
    }

    public PlanetDto createPlanet(PlanetDto planetDto) {
        Planet planet = PlanetMapper.planetDtoToPlanet(planetDto);
        Planet save = planetRepository.save(planet);
        return PlanetMapper.planetToPlanetDto(save);
    }


    public Planet updatePlanet( PlanetDto planetDto) {
        Planet planet = PlanetMapper.planetDtoToPlanet(planetDto);
        planetRepository.save(planet);
        return PlanetMapper.planetDtoToPlanet(planetDto);
    }

    public void deletePlanet(Planet planetDto) {
        planetRepository.deleteById(planetDto.getId());
    }

    public Page<PlanetDto> getAllPlanets(org.springframework.data.domain.Pageable pageable) {
        return planetRepository.findAll(pageable)
                .map(PlanetMapper::planetToPlanetDto);
    }


    public Page<PlanetDto> getAllPlanetsByFirstLetter(String firstLetter, Pageable pageable) {
        return planetRepository.findAllByNameStartingWithIgnoreCase(firstLetter, pageable)
                .map(PlanetMapper::planetToPlanetDto);
    }





}
