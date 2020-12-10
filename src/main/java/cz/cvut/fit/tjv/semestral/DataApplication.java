package cz.cvut.fit.tjv.semestral;

import cz.cvut.fit.tjv.semestral.data.*;
import cz.cvut.fit.tjv.semestral.data.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class DataApplication {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public static void main( String[] args ) {
        SpringApplication.run( DataApplication.class, args );
    }

    @EventListener( ApplicationReadyEvent.class )
    public void afterStartup() {
        Book b = new Book();
        b.setBookName("Kafka on the shore");
        User u1 = new User();
        u1.setId(131);
        ArrayList<User> c = new ArrayList<User>();
        c.add(u1);
        b.setCreatorId(c);
        bookRepository.save(b);
    }
}
