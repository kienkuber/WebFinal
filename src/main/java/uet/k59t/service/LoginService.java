package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentRepository;

@Service
public class LoginService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    public UserDTO login(UserDTO userDTO) {return null;
    }

    public void logout() {
    }
}
