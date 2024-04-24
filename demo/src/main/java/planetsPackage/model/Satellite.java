package planetsPackage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "satellites")
public class Satellite {

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
    @Column(name = "natural_Satellite", nullable = false)
    private boolean naturalSatellite;


}
