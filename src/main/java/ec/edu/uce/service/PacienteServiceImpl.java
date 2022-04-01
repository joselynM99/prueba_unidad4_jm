package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void insertarPaciente(Paciente cita) {
		this.pacienteRepo.insertarPaciente(cita);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		return this.pacienteRepo.buscarPaciente(id);
	}

	@Override
	public void actualizarPaciente(Paciente cita) {
		this.pacienteRepo.actualizarPaciente(cita);
	}

	@Override
	public void eliminarPaciente(Integer id) {

		this.pacienteRepo.eliminarPaciente(id);
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		return this.pacienteRepo.buscarPacientePorCedula(cedula);
	}

}
