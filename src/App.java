import model.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.objectdb.o.HMP.f;

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

        //Abfragen (Read)
        List<Book> books = em.createQuery("SELECT b FROM Book b WHERE b.year > 1955", Book.class).getResultList();
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " (" + book.getYear() + ")");
        }

        //Aktualisieren (Update)
        em.getTransaction().begin();
        book1.setTitle("Nineteen Eighty-Four");
        em.getTransaction().commit();

        //Löschen (Delete)
        em.getTransaction().begin();
        // em.remove(em.find(Book.class, 3));
        // em.remove(em.find(Book.class, 4));
        // em.remove(em.find(Book.class, 5));
        // em.remove(em.find(Book.class, 6));

        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}
