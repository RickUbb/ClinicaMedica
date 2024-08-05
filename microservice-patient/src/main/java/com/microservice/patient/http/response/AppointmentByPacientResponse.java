package com.microservice.patient.http.response;

import com.microservice.patient.dto.AppointmentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentByPacientResponse {

    private String name;
    private String lastName;
    private String email;
    private List<AppointmentDTO> appointmentDTOList;
}
