package ec.edu.uce.repository;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorRepo {

	void insertarDoctor(Doctor cita); // C

	Doctor buscarDoctor(Integer id); // R

	void actualizarDoctor(Doctor cita); // U

	void eliminarDoctor(Integer id); // D

	Doctor buscarDoctorPorCedula(String cedula);

}
