package SpringJPAexample.JPA.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import SpringJPAexample.JPA.Entity.Contactdb;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ContactdbRepository {

		@Autowired
		private EntityManager entityManager;
		
		@Transactional
		public void save(Contactdb contactdb) {
			entityManager.persist(contactdb);
		}
		
		public List<Contactdb> findAll(){
			String jpql="Select c from Contactdb c";
			TypedQuery<Contactdb> query=entityManager.createQuery(jpql, Contactdb.class);
			return query.getResultList();
		}
		
		public Contactdb findById(Integer id) {
			return entityManager.find(Contactdb.class, id);
			
		}
		
		@Transactional
		public Contactdb update(Contactdb contactdb){
			return entityManager.merge(contactdb);
		}
		
		@Transactional
		public void delete(Integer id) {
			Contactdb contactdb=entityManager.find(Contactdb.class, id);
			entityManager.remove(contactdb);
		}
		
}
