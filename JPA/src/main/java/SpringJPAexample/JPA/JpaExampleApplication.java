package SpringJPAexample.JPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import SpringJPAexample.JPA.Entity.Contactdb;
import SpringJPAexample.JPA.Repository.ContactdbRepository;

@SpringBootApplication
public class JpaExampleApplication implements CommandLineRunner {

	@Autowired ContactdbRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(JpaExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createContactdb();
//		listContactdb();
//		getContactdb();
//		updateContactdb();
//		deleteContactdb();
		listContactdb();
	}
	
	private void updateContactdb() {
		Integer id=1;
		Contactdb contactdb=repo.findById(id);
		contactdb.setName("raghu");
		contactdb.setEmail("raghu123@gmail.com");
		repo.update(contactdb);
	}
	
	private void deleteContactdb() {
		Integer id=2;
		repo.delete(id);
	}
	
	private void getContactdb() {
		Integer id =2;
		Contactdb contactdb=repo.findById(id);
		System.out.println(contactdb);
	}
	
	private void createContactdb() {
		Contactdb contactdb=new Contactdb();
		contactdb.setName("Raja");
		contactdb.setEmail("Raja456@gmail.com");
		contactdb.setAddress("frankfrut, Germany");
		repo.save(contactdb);
	}
	
	private void listContactdb() {
		List<Contactdb> listContactdbs=repo.findAll();
		listContactdbs.forEach(System.out::println);
	}

}
