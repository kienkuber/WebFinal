package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Partner;

@Repository
public interface PartnerRepository extends CrudRepository<Partner, Long> {
    Partner findByUsername(String username);
}
