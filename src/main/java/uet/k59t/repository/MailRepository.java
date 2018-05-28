package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Mail;

@Repository
public interface MailRepository extends CrudRepository<Mail, Long>{
    Mail findBySender(String sender);
}
