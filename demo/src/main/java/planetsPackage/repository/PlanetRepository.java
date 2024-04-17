package planetsPackage.repository;

import io.micrometer.common.lang.NonNull;
import planetsPackage.model.Planet;
import planetsPackage.model.Satellite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    List<Planet> findAllBySatellites(List<Satellite> satellites, Pageable pageable);


    @NonNull
    Optional<Planet> findById(@NonNull Long id);


    Page<Planet> findAllByNameStartingWithIgnoreCase(String firstLetter, Pageable pageable);
}