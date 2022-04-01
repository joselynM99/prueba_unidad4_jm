package ec.edu.uce.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCita;
import ec.edu.uce.service.IPacienteService;

@Controller
@RequestMapping("/citasMedicas/")
public class GestionCitaController {

	@Autowired
	private IGestorCita gestorCita;

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@GetMapping("agendarCita")
	public String obtenerPaginaIngresoDatos(CitaMedica cita) {

		return "citaNueva";
	}

	@PostMapping("insertarCita")
	public String insertarEstudiante(String numero, LocalDateTime fechaCita, BigDecimal valorCita,
			String cedulaDoctor, String cedulaPaciente, BindingResult result, Model modelo) {

		this.gestorCita.agendarCitaMedica(numero, fechaCita, valorCita, cedulaDoctor, cedulaPaciente);
		return "index";
	}

}
