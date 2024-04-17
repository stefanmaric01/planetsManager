package planetsPackage;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Planet {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    @NonNull
    private String name;
    @Column(name = "surfaceArea", nullable = false)
    @NonNull
    private Long surfaceArea;
    @Column(name = "mass", nullable = false)
    @NonNull
    private Long mass;
    @Column(name = "distanceFromSun", nullable = false)
    @NonNull
    private Long distanceFromSun;

    private int averageSurfaceTemperature;

    @OneToMany(mappedBy="planet")
    private List<Satellite> satellites;

}
