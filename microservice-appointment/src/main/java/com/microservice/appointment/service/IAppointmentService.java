package com.microservice.appointment.service;

import com.microservice.appointment.entities.Appointment;

import java.util.List;

public interface IAppointmentService {
    List<Appointment> findAll();
    Appointment findById(Long id);
    void save(Appointment appointment);
    void deleteById(Long id);

    List<Appointment> findAllByPatientId(Long patientId);
    List<Appointment> findAllByDoctorId(Long doctorId);
}
