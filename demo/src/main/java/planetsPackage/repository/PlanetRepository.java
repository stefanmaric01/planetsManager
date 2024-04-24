package planetsPackage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import planetsPackage.model.Planet;
@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {


    Page<Planet> findAllByNameStartingWithIgnoreCase(String firstLetter, Pageable pageable);


    @Query("SELECT p FROM Planet p ORDER BY SIZE(p.satellites) DESC")
    Page<Planet> findAllByOrderBySatellitesSizeDesc(Pageable pageable);

    @Query("SELECT p FROM Planet p ORDER BY SIZE(p.satellites) ASC")
    Page<Planet> findAllByOrderBySatellitesSizeAsc(Pageable pageable);
}