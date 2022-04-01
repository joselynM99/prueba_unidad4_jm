package ec.edu.uce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Doctor;

@SpringBootTest
@Transactional
@Rollback(false)
class DoctorServiceImplTest {
	
	@Autowired
	private IDoctorService doctorService;

	@Test
	void testInsertarDoctor1() {
		Doctor d1 = new Doctor();
		d1.setApellido("Moncayo");
		d1.setCedula("12554");
		d1.setCodigoSenecyt("5454");
		d1.setFechaNacimiento(LocalDateTime.of(1990, Month.APRIL, 10, 0, 0));
		d1.setNombre("Jorge");
		d1.setNumeroConsultorio("2");
		d1.setSueldo(new BigDecimal(2000));
		this.doctorService.insertarDoctor(d1);
		assertEquals(this.doctorService.buscarDoctorPorCedula(d1.getCedula()), d1);
	}
	
	@Test
	void testInsertarDoctor2() {
		Doctor d2 = new Doctor();
		d2.setApellido("Perez");
		d2.setCedula("841512");
		d2.setCodigoSenecyt("5151");
		d2.setFechaNacimiento(LocalDateTime.of(1990, Month.APRIL, 10, 0, 0));
		d2.setNombre("Jorge");
		d2.setNumeroConsultorio("8");
		d2.setSueldo(new BigDecimal(2000));
		this.doctorService.insertarDoctor(d2);
		assertEquals(this.doctorService.buscarDoctorPorCedula(d2.getCedula()), d2);
	}

}
