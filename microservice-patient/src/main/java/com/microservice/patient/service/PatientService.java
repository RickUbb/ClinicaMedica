package com.microservice.patient.service;

import com.microservice.patient.client.AppointmentClient;
import com.microservice.patient.dto.AppointmentDTO;
import com.microservice.patient.entities.Patient;
import com.microservice.patient.persistence.PatientRepository;
import com.microservice.patient.http.response.AppointmentByPacientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentClient appointmentClient;

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public AppointmentByPacientResponse findAppointmentsByPacientId(Long patientId) {
        //Consultar el patient
        Patient patient = patientRepository.findById(patientId).orElse(new Patient());
        //Obtener los apointments
        List<AppointmentDTO> appointmentDTOList = appointmentClient.findAllStudentByPatient(patientId);

        return AppointmentByPacientResponse.builder()
                .name(patient.getName())
                .lastName(patient.getLastName())
                .email(patient.getEmail())
                .appointmentDTOList(appointmentDTOList)
                .build();
    }
}

//private String name;
//private String lastName;
//private String email;
//private List<AppointmentDTO> appointmentDTOList;