package planetsPackage.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planetsPackage.dto.SatelliteDto;
import planetsPackage.model.Satellite;
import planetsPackage.service.SatelliteService;

@RestController
@RequestMapping("satellites")
public class SatelliteController {

    private final SatelliteService satelliteService;

    public SatelliteController(SatelliteService satelliteService) {
        this.satelliteService = satelliteService;

    }

    @GetMapping()
    public Page<SatelliteDto> getAllSatellites() {
        return satelliteService.getAllSatellites(Pageable.unpaged());
    }

    @PostMapping()
    public SatelliteDto addSatellite(@RequestBody SatelliteDto satelliteDto) {
        return satelliteService.createSatellite(satelliteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Satellite> updateSatellite(@RequestBody SatelliteDto satelliteDto) {
        Satellite satellite = satelliteService.updateSatellite(satelliteDto);
        return ResponseEntity.ok().body(satellite);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSatellite(@PathVariable Long id) {
        satelliteService.deleteSatellite(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Satellite> getSatelliteById(@PathVariable Long id) {
        Satellite satellite = satelliteService.findSatelliteById(id);
        return ResponseEntity.ok().body(satellite);

    }
}