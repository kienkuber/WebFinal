package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import uet.k59t.model.Job;

import java.util.List;

public interface JobRepository extends CrudRepository<Job, Long> {
    List<Job> findAll();
}
