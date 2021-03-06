package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Lecturer;

import java.util.List;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long>{
    Lecturer findByEmailVNU(String email);
    Lecturer findByToken(String token);
    List<Lecturer> findAll();
}
