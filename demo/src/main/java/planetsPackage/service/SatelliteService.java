package planetsPackage.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import planetsPackage.dto.SatelliteDto;
import planetsPackage.exception.PlanetBadRequestException;
import planetsPackage.exception.PlanetNotFoundException;
import planetsPackage.mapper.SatelliteMapper;
import planetsPackage.model.Planet;
import planetsPackage.model.Satellite;
import planetsPackage.repository.PlanetRepository;
import planetsPackage.repository.SatelliteRepository;

@Service
@AllArgsConstructor
public class SatelliteService {

    private final SatelliteRepository satelliteRepository;

    private final PlanetRepository planetRepository;

    public Page<SatelliteDto> getAllSatellites(org.springframework.data.domain.Pageable pageable) {
        return satelliteRepository.findAll(pageable)
                .map(SatelliteMapper::satelliteToSatelliteDto);

    }

    public SatelliteDto createSatellite(SatelliteDto satelliteDto) {
        Satellite satellite = SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
        Planet planet = planetRepository.findById(satelliteDto.getPlanetId())
                .orElseThrow(() -> new PlanetNotFoundException("Planet not found with ID: " + satelliteDto.getPlanetId()));
        planet.getSatellites().add(satellite);
        planetRepository.save(planet);
        return SatelliteMapper.satelliteToSatelliteDto(satellite);
    }

    public Satellite updateSatellite(SatelliteDto satelliteDto) {
        try {
            Satellite satellite = SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
            satelliteRepository.save(satellite);
            return SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
        }
        catch (Exception e) {
            throw new PlanetNotFoundException("Satellite not found with ID: " + satelliteDto.getPlanetId());
        }
    }

    public void deleteSatellite(Long id) {
    try{
        satelliteRepository.deleteById(id);
    }
    catch(Exception e){

        throw new PlanetNotFoundException("Satellite not found with ID: " + id);
    }
    }

    public Satellite findSatelliteById(Long id) {
        return satelliteRepository.findById(id)
                .orElseThrow(() -> new PlanetNotFoundException("Satellite not found with ID: " + id));
    }
}
