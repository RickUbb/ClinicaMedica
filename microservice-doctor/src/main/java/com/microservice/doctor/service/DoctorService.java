package com.microservice.doctor.service;

import com.microservice.doctor.client.AppointmentClient;
import com.microservice.doctor.dto.AppointmentDTO;
import com.microservice.doctor.entities.Doctor;
import com.microservice.doctor.persistence.DoctorRepository;
import com.microservice.doctor.http.response.AppointmentByDoctorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IDoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentClient appointmentClient;

    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public AppointmentByDoctorResponse findAppointmentsByDoctorId(Long doctorId) {
        //Consultar el doctor
        Doctor doctor = doctorRepository.findById(doctorId).orElse(new Doctor());
        //Obtener los apointments
        List<AppointmentDTO> appointmentDTOList = appointmentClient.findAllStudentByDoctor(doctorId);

        return AppointmentByDoctorResponse.builder()
                .name(doctor.getName())
                .lastName(doctor.getLastName())
                .speciality(doctor.getSpeciality())
                .appointmentDTOList(appointmentDTOList)
                .build();
    }


}
