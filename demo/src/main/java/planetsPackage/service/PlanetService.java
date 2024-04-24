package planetsPackage.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import planetsPackage.dto.PlanetDto;
import planetsPackage.exception.PlanetBadRequestException;
import planetsPackage.exception.PlanetNotFoundException;
import planetsPackage.mapper.PlanetMapper;
import planetsPackage.model.Planet;
import planetsPackage.repository.PlanetRepository;

@Service
@AllArgsConstructor
@Data
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetDto getPlanetById(Long id) {
        Planet planet = planetRepository.findById(id)
                .orElseThrow(() -> new PlanetNotFoundException("Planet not found"));
        return PlanetMapper.planetToPlanetDto(planet);
    }

    public PlanetDto createPlanet(PlanetDto planetDto) {
        try {
            Planet planet = planetRepository.save(PlanetMapper.planetDtoToPlanet(planetDto));
            return PlanetMapper.planetToPlanetDto(planet);
        } catch (Exception e) {
            throw new PlanetBadRequestException("Error creating planet:" + e.getMessage(),e.getCause());

        }
    }


    public Planet updatePlanet(PlanetDto planetDto) {
        if (!planetRepository.existsById(planetDto.getId())) {
            throw new PlanetBadRequestException("Cannot update planet that does not exist!");
        } else {
            try {
               return planetRepository.save(PlanetMapper.planetDtoToPlanet(planetDto));
            } catch (DataAccessException e) {
                throw new PlanetBadRequestException("Error updating a planet" + e.getMessage());
            }
        }
    }

    public void deletePlanetById(Long id) {
        try {
            planetRepository.deleteById(id);
        } catch (Exception e) {
            throw new PlanetNotFoundException("Error deleting planet: ",e.getCause() );
        }
    }

    public Page<PlanetDto> getAllPlanets(Pageable pageable) {
        return planetRepository.findAll(pageable)
                .map(PlanetMapper::planetToPlanetDto);
    }


    public Page<PlanetDto> getAllPlanetsByFirstLetter(String firstLetter, Pageable pageable) {
        return planetRepository.findAllByNameStartingWithIgnoreCase(firstLetter, pageable)
                .map(PlanetMapper::planetToPlanetDto);
    }

    public Page<PlanetDto> getAllOrderByNumberOfSatellites(Pageable pageable,String sort) {

         if (sort.equals("asc")) {
            return planetRepository.findAllByOrderBySatellitesSizeAsc(pageable)
                    .map(PlanetMapper::planetToPlanetDto);
        }else{
            return planetRepository.findAllByOrderBySatellitesSizeDesc(pageable)
                    .map(PlanetMapper::planetToPlanetDto);
        }
    }

}
