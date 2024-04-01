package ma.fati.demohopital.repositories;

import ma.fati.demohopital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
Medecin findByNom(String nom);
}
