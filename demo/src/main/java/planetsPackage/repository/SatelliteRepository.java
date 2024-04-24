package planetsPackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import planetsPackage.model.Satellite;

@Repository
public interface SatelliteRepository extends JpaRepository<Satellite, Long>{

    @Override
    boolean existsById(Long id);
}
