package com.microservice.doctor.client;

import com.microservice.doctor.dto.AppointmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc-appointment", url="localhost:8093/api/v1/appointments")
public interface AppointmentClient {
    // Se como una especie de cajon donde vamos a recibir de appointment
// Y doctor mira lo que necesite
// Abrimos la puerta del microservicio appointment, simplemente usar el servicio web que necesitemos


        @GetMapping("/search_by_doctor/{doctorId}")
        List<AppointmentDTO> findAllStudentByDoctor(@PathVariable Long doctorId);

}
