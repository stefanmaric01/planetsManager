package planetsPackage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Satellite {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Long surfaceArea;
    private Long mass;
    private boolean naturalSatellite;
    @ManyToOne
    private Planet planet;
}
