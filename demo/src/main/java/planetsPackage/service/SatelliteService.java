package planetsPackage.service;

import planetsPackage.dto.SatelliteDto;
import planetsPackage.exception.PlanetException;
import lombok.AllArgsConstructor;
import planetsPackage.mapper.SatelliteMapper;
import planetsPackage.model.Satellite;
import org.springframework.stereotype.Service;
import planetsPackage.repository.SatelliteRepository;

@Service
@AllArgsConstructor
public class SatelliteService {

    private final SatelliteRepository satelliteRepository;

    public Satellite createSatellite(SatelliteDto satelliteDto) {
        Satellite satellite = SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
        return satelliteRepository.save(satellite);
    }
    public SatelliteDto updateSatellite(SatelliteDto satelliteDto) {
       Satellite satellite = SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
        satellite = satelliteRepository.save(satellite);
        return SatelliteMapper.satelliteToSatelliteDto(satellite);
    }
    public SatelliteDto deleteSatellite(SatelliteDto satelliteDto) {
        Satellite satellite= SatelliteMapper.satelliteDtoToSatellite(satelliteDto);
        return SatelliteMapper.satelliteToSatelliteDto(satellite);
    }

    public Satellite findSatelliteById(Long id) {
        return satelliteRepository.findById(id)
                .orElseThrow(() -> new PlanetException("Planet not found with ID: " + id));
    }


}
