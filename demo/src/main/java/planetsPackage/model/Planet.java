package planetsPackage.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;
import java.util.HashSet;
import java.util.Set;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "planets")
public class Planet {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;
    @Column(name = "surface_area", nullable = false)
    @NonNull
    private Long surfaceArea;
    @Column(name = "mass", nullable = false)
    @NonNull
    private Long mass;
    @Column(name = "distance_from_sun", nullable = false)
    @NonNull
    private Long distanceFromSun;
    @Column(name = "average_surface_temperature", nullable = false)
    private Long averageSurfaceTemperature;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private Set<Satellite> satellites = new HashSet<>();


}
