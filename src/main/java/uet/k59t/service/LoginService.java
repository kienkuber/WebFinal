package uet.k59t.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.model.*;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentRepository;

import javax.validation.constraints.Null;
import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    public UserDTO login(UserDTO userDTO) {
        if (userDTO.getUserName().equals("admin") && userDTO.getPassword().equals("admin")){
            UserDTO admin = new UserDTO();;
            Admin.setToken(UUID.randomUUID().toString());
            admin.setRole(Role.ADMIN);
            admin.setToken(Admin.getToken());
            return admin;
        }
        else if(studentRepository.findByEmailVNU(userDTO.getUserName())!=null){
            Student student = studentRepository.findByEmailVNU(userDTO.getUserName());
            if(student.getPassword().equals(userDTO.getPassword())) {
                student.setToken(UUID.randomUUID().toString());
                studentRepository.save(student);
                UserDTO result = new UserDTO();
                result.setUserName(student.getEmailVNU());
                result.setRole(Role.STUDENT);
                result.setToken(student.getToken());
                return result;
            }
            else throw new NullPointerException("Mat khau khong chinh xac");
        }
        else if(lecturerRepository.findByEmailVNU(userDTO.getUserName()) != null){
            Lecturer lecturer = lecturerRepository.findByEmailVNU(userDTO.getUserName());
            if(lecturer.getPassword().equals(userDTO.getPassword())) {
                lecturer.setToken(UUID.randomUUID().toString());
                lecturerRepository.save(lecturer);
                UserDTO result = new UserDTO();
                result.setUserName(lecturer.getEmailVNU());
                result.setRole(Role.LECTURER);
                result.setToken(lecturer.getToken());
                return result;
            }
            else throw new NullPointerException("Mat khau khong chinh xac");
        }
        else if(partnerRepository.findByUsername(userDTO.getUserName())!= null){
            Partner partner = partnerRepository.findByUsername(userDTO.getUserName());
            if(partner.getPassword().equals(userDTO.getPassword())){
                partner.setToken(UUID.randomUUID().toString());
                partnerRepository.save(partner);
                UserDTO result = new UserDTO();
                result.setUserName(partner.getUsername());
                result.setRole(Role.PARTNER);
                result.setToken(partner.getToken());
                return result;
            }
            else throw new NullPointerException("Mat khau khong chinh xac");
        }
        else throw  new NullPointerException("Ten dang nhap hoac mat khau khong dung");
    }

    public void logout(String token) {
        if(Admin.getToken().equals(token)){
            Admin.setToken(null);
        }
        else if(studentRepository.findByToken(token)!= null){
            Student student  = studentRepository.findByToken(token);
            student.setToken(null);
            studentRepository.save(student);
        }
        else if(lecturerRepository.findByToken(token)!= null){
            Lecturer lecturer = lecturerRepository.findByToken(token);
            lecturer.setToken(null);
            lecturerRepository.save(lecturer);
        }
        else if(partnerRepository.findByToken(token) != null){
            Partner partner = partnerRepository.findByToken(token);
            partner.setToken(null);
            partnerRepository.save(partner);
        }

    }

    public UserDTO changePassword(UserDTO userDTO, String token) {
        if (studentRepository.findByToken(token) != null) {
            Student student = studentRepository.findByToken(token);
            student.setPassword(userDTO.getPassword());
            studentRepository.save(student);
            UserDTO result = new UserDTO();
            result.setUserName(student.getEmailVNU());
            result.setPassword(student.getPassword());
            return result;
        } else if (lecturerRepository.findByToken(token) != null) {
            Lecturer lecturer = lecturerRepository.findByToken(token);
            lecturer.setPassword(userDTO.getPassword());
            lecturerRepository.save(lecturer);
            UserDTO result = new UserDTO();
            result.setUserName(lecturer.getEmailVNU());
            result.setPassword(lecturer.getPassword());
            return result;
        } else if (partnerRepository.findByToken(token) != null){
            Partner partner = partnerRepository.findByToken(token);
            partner.setPassword(userDTO.getPassword());
            partnerRepository.save(partner);
            UserDTO result = new UserDTO();
            result.setUserName(partner.getUsername());
            result.setPassword(partner.getPassword());
            return result;
        }
        else throw new NullPointerException("khong tim thay User");
    }
}
