package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarDoctor(Doctor cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizarDoctor(Doctor cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void eliminarDoctor(Integer id) {
		Doctor doc = this.buscarDoctor(id);
		this.entityManager.remove(doc);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		TypedQuery<Doctor> myQuery = this.entityManager.createQuery("SELECT d FROM Doctor d WHERE d.cedula =: cedula",
				Doctor.class);

		myQuery.setParameter("cedula", cedula);

		return myQuery.getSingleResult();
	}

}
