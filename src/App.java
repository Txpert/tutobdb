import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myObjectDB");
        EntityManager em = emf.createEntityManager();
        
        //Erstellen (Create)
        em.getTransaction().begin();
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
        em.persist(book1);

        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        em.persist(book2);

        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}
