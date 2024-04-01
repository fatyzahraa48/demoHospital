package ma.fati.demohopital.service;

import ma.fati.demohopital.entities.Consultation;
import ma.fati.demohopital.entities.Medecin;
import ma.fati.demohopital.entities.Patient;
import ma.fati.demohopital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin  saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
