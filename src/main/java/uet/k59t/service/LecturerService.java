package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.StudentRepository;

public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
}
