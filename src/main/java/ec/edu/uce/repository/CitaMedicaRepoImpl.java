package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		this.entityManager.persist(cita);
	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		this.entityManager.merge(cita);
	}

	@Override
	public void eliminarCitaMedica(Integer id) {
		CitaMedica citEl = this.buscarCitaMedica(id);
		this.entityManager.remove(citEl);
	}
	
	@Override
	public CitaMedica buscarCitaPorNumero(String numeroCita) {
		TypedQuery<CitaMedica> myQuery = this.entityManager.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita =: numeroCita",
				CitaMedica.class);

		myQuery.setParameter("numeroCita", numeroCita);

		return myQuery.getSingleResult();
	}

}
