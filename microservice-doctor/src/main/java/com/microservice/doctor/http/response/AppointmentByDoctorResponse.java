package com.microservice.doctor.http.response;

import com.microservice.doctor.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentByDoctorResponse {

    private String name;
    private String lastName;
    private String speciality;
    private List<AppointmentDTO> appointmentDTOList;

}
