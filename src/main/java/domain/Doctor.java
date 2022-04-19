package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator" )
    @Column( updatable = false, nullable = false)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
}
