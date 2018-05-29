package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
    Student findById(Long id);
    Student findByEmailVNU(String email);
    Student findByToken(String token);
    void deleteByEmailVNU(String emailVNU);
    List<Student> findAll();
}
