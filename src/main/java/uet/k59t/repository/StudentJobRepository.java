package uet.k59t.repository;

import org.springframework.data.repository.CrudRepository;
import uet.k59t.model.StudentJob;

import java.util.List;

public interface StudentJobRepository extends CrudRepository<StudentJob, Long> {
    public List<StudentJob> findByJobId(Long id);
    public List<StudentJob> findByStudentId(Long id);
    public StudentJob findByStudentIdAndJobId(Long studentId, Long jobId);
}
