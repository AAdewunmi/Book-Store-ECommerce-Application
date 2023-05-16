
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UsersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user1 = new Users();
		user1.setEmail("bill.gates@microsoft.com");
		user1.setFullName("Bill Gates");
		user1.setPassword("wordwordword");
		
		EntityManagerFactory entityManagerFactory = 
		Persistence.createEntityManagerFactory("Book-Store-ECommerce-Application");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A Users object was persisted");
	}

}
