package com.microservice.patient.controller;

import com.microservice.patient.entities.Patient;
import com.microservice.patient.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatient(@RequestBody Patient patient) {
        patientService.save(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@RequestBody Patient patient, @PathVariable Long id) {
        patient.setId(id);
        patientService.save(patient);
        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        patientService.deleteById(id);
        return ResponseEntity.ok("Patient deleted");
    }

    @GetMapping("/search-appointment/{patientId}")
    public ResponseEntity<?> findAppointmentByPatientsId(@PathVariable Long patientId) {
        return ResponseEntity.ok(patientService.findAppointmentsByPacientId(patientId));
    }

    }
