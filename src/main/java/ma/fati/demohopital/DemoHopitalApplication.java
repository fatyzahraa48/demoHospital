package ma.fati.demohopital;

import ma.fati.demohopital.entities.*;
import ma.fati.demohopital.repositories.ConsultationRepository;
import ma.fati.demohopital.repositories.MedecinRepository;
import ma.fati.demohopital.repositories.PatientRepository;
import ma.fati.demohopital.repositories.RendezVousRepository;
import ma.fati.demohopital.entities.*;
import ma.fati.demohopital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoHopitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoHopitalApplication.class, args);

    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository, MedecinRepository medecinRepository){
        return args -> {
            Stream.of("younesse","yassine","mohamed")
                    .forEach(name->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Reda","Mustapha","ashraf")
                    .forEach(name->{
                        Medecin medecin=new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentitste");
                        hospitalService.saveMedecin(medecin);
                    });

            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("mohamed");
            Medecin medecin=medecinRepository.findByNom("reda");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = rendezVousRepository.save(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("rapport de la consultation.......");
            hospitalService.saveConsultation(consultation);



        };

    }

}
