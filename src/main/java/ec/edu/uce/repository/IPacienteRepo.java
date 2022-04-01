package ec.edu.uce.repository;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepo {
	
	void insertarPaciente(Paciente cita); // C

	Paciente buscarPaciente(Integer id); // R

	void actualizarPaciente(Paciente cita); // U

	void eliminarPaciente(Integer id); // D

	Paciente buscarPacientePorCedula(String cedula);

	
	

}
