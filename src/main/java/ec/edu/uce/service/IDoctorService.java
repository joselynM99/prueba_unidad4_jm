package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {
	
	void insertarDoctor(Doctor cita); // C

	Doctor buscarDoctor(Integer id); // R

	void actualizarDoctor(Doctor cita); // U

	void eliminarDoctor(Integer id); // D
	
	Doctor buscarDoctorPorCedula(String cedula);

}
