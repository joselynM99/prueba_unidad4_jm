package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizarPaciente(Paciente cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void eliminarPaciente(Integer id) {
		Paciente pacienteABorrar = this.buscarPaciente(id);
		this.entityManager.remove(pacienteABorrar);
	}
	
	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		TypedQuery<Paciente> myQuery = this.entityManager.createQuery("SELECT c FROM Paciente c WHERE c.cedula =: cedula",
				Paciente.class);

		myQuery.setParameter("cedula", cedula);

		return myQuery.getSingleResult();
	}

}
