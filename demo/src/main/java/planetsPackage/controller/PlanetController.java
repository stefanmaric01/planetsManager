package planetsPackage.controller;


import planetsPackage.dto.PlanetDto;
import planetsPackage.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planetsPackage.repository.PlanetRepository;
import planetsPackage.service.PlanetService;

import java.util.Optional;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/all")
    public Page<PlanetDto> getAllPlanets() {
        return planetService.getAllPlanets(Pageable.unpaged());
    }

    @GetMapping("/letter")
    public Page<PlanetDto> getPlanetsByFirstLetter(
            @RequestParam(defaultValue = "A") String firstLetter,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return planetService.getAllPlanetsByFirstLetter(firstLetter, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanetDto> getPlanetById(@PathVariable Long id) {
        PlanetDto planetDto = planetService.getPlanetById(id);
        return ResponseEntity.ok().body(planetDto);
    }

    @GetMapping()
    public Page<PlanetDto> getPlanetsWithPagingAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "desc") String sort)
    {

        Pageable pageable = PageRequest.of(page, size);
        return planetService.getAllOrderByNumberOfSatellites(pageable,sort);
    }


    @PostMapping()
    public PlanetDto createPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.createPlanet(planetDto);
    }


    @PutMapping("/update")
    public ResponseEntity<Planet> updatePlanet(@RequestBody PlanetDto planetDto) {
        planetService.updatePlanet(planetDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePlanet(@PathVariable Long id) {
        planetService.deletePlanetById(id);
        return ResponseEntity.noContent().build();
    }}

