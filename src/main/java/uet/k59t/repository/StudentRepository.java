package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.k59t.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
    Student findByEmailVNU(String email);
}
