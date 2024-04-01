package ma.fati.demohopital.repositories;

import ma.fati.demohopital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient,Long> {
Patient findByNom(String name);
}

