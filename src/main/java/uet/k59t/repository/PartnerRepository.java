package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Partner;

import java.util.List;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {
    Partner findByUsername(String username);
    Partner findByToken(String token);
    Partner findByEmail(String email);
    List<Partner> findAll();
}
