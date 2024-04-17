package planetsPackage.controller;


import planetsPackage.dto.PlanetDto;
import planetsPackage.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import planetsPackage.service.PlanetService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;


    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
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
    public ResponseEntity<Planet> getPlanetById(@PathVariable Long id) {
        Planet planet = planetService.getPlanetById(id);
        return ResponseEntity.ok().body(planet);
    }

    @GetMapping("/planets")
    public Page<PlanetDto> getPlanetsWithPagingAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("satellites.size").descending());
        return planetService.getAllPlanets(pageable);
    }

    @PostMapping()
    public PlanetDto createPlanet(@RequestBody PlanetDto planetDto) {
        return planetService.createPlanet(planetDto);
    }

    @PutMapping("/planets/{id}")
    public ResponseEntity<Planet> updatePlanet( @RequestBody PlanetDto planetDto) {
        Planet updatedPlanet = planetService.updatePlanet(planetDto);
        return ResponseEntity.ok().body(updatedPlanet);
    }

    @DeleteMapping("/planets/{id}")
    public ResponseEntity<Void> deletePlanet(@RequestBody Planet planet ){
        planetService.deletePlanet(planet);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/planets/letter")
//    public Page<PlanetDto> getPlanetsByFirstLetter(
//            @RequestParam(defaultValue = "A") String firstLetter,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//
//        Pageable pageable = PageRequest.of(page, size);
//        return planetService.getAllPlanetsByFirstLetter(firstLetter, pageable);
//
//
//    }
//
//    @GetMapping("/planets/{id}")
//    public Planet getPlanetById(
//            @RequestParam Long id) {
//            return planetService.getPlanetById(id);
//    }
//
//    @GetMapping("/planets/planets")
//    public Page<PlanetDto> getPlanetsWithPagingAndSorting(
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by("satellites.size").descending());
//        return planetService.getAllPlanets(pageable);
//    }
//
//
//    @PostMapping("/planets")
//    public ResponseEntity<Planet> createPlanet(@RequestBody PlanetDto planetDto) {
//        Planet createdPlanet = planetService.createPlanet(planetDto);
//        return ResponseEntity.created(URI.create("/planets/" + createdPlanet.getId())).body(createdPlanet);
//    }
//
//    @PostMapping("/planets")
//    public Planet updatePlanet(@RequestBody PlanetDto planet) {
//        return planetService.updatePlanet(planet);
//    }
//
//    @PostMapping("/planets")
//    public PlanetDto deletePlanet(@RequestBody Planet planet) {
//        return planetService.deletePlanet(planet);
//    }

}
