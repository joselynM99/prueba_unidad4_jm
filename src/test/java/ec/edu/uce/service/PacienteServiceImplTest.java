package ec.edu.uce.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Paciente;

@SpringBootTest
@Transactional
@Rollback(false)
class PacienteServiceImplTest {
	
	@Autowired
	private IPacienteService pacienteService;

	@Test
	void testInsertarPaciente() {
		Paciente p = new Paciente();
		p.setApellido("Mendez");
		p.setCedula("147852");
		p.setCodigoIEES("454");
		p.setEdad(20);
		p.setEstatura(1.89);
		p.setFechaNacimiento(LocalDateTime.of(1990, Month.APRIL, 10, 0, 0));
		p.setNombre("Jimena");
		p.setPeso(55.0);
		
		this.pacienteService.insertarPaciente(p);
		
		assertEquals(this.pacienteService.buscarPacientePorCedula(p.getCedula()), p);
	}
	
	@Test
	void testInsertarPaciente1() {
		Paciente p = new Paciente();
		p.setApellido("Maldonado");
		p.setCedula("872222");
		p.setCodigoIEES("879411");
		p.setEdad(20);
		p.setEstatura(1.89);
		p.setFechaNacimiento(LocalDateTime.of(1990, Month.APRIL, 10, 0, 0));
		p.setNombre("Jimena");
		p.setPeso(55.0);
		
		this.pacienteService.insertarPaciente(p);
		
		assertEquals(this.pacienteService.buscarPacientePorCedula(p.getCedula()), p);
	}

}
