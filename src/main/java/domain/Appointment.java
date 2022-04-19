package domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator" )
    @Column( nullable = false)
    private UUID id;
    @Temporal(TemporalType.DATE)
    private Date date = new Date();
    @ManyToOne()
    private Doctor doctor;
    @ManyToOne
    private Patient patient;
    @OneToOne(mappedBy = "appointment")
    private Consultation consultation;

    public Appointment( Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }
}
