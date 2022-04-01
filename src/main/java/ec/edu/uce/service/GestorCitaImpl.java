package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

@Service
public class GestorCitaImpl implements IGestorCita {

	@Autowired
	private ICitaMedicaService citaService;

	@Autowired
	private IPacienteService pacService;

	@Autowired
	private IDoctorService doctorService;

	@Override
	public void insertarNuevaCita(CitaMedica cita) {
		this.citaService.insertarCitaMedica(cita);

	}

	@Override
	public void agendarCitaMedica(String numero, LocalDateTime fechaCita, BigDecimal valorCita, String cedulaDoctor,
			String cedulaPaciente) {

		Paciente paci = this.pacService.buscarPacientePorCedula(cedulaPaciente);
		Doctor doc = this.doctorService.buscarDoctorPorCedula(cedulaPaciente);
		
		CitaMedica cita = new CitaMedica();
		cita.setFechaCita(fechaCita);
		cita.setValorCita(valorCita);
		cita.setPaciente(paci);
		cita.setDoctor(doc);
		
		this.citaService.insertarCitaMedica(cita);

	}
	
	@Override
	public void actualizarCitaMedica(String numero, String diagnostico, String receta, LocalDateTime fechaControl) {
		
	}
	

}
