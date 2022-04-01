package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.repository.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void insertarDoctor(Doctor cita) {
		this.doctorRepo.insertarDoctor(cita);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.doctorRepo.buscarDoctor(id);
	}

	@Override
	public void actualizarDoctor(Doctor cita) {
		this.doctorRepo.actualizarDoctor(cita);		
	}

	@Override
	public void eliminarDoctor(Integer id) {
		this.doctorRepo.eliminarDoctor(id);		
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		return this.doctorRepo.buscarDoctorPorCedula(cedula);
	}

}

