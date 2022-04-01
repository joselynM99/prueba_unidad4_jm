package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import ec.edu.uce.modelo.CitaMedica;

public interface IGestorCita {

	void insertarNuevaCita(CitaMedica cita);

	void agendarCitaMedica(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String cedulaDoctor, String cedulaPaciente);

	void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl);

}
