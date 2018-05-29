package uet.k59t.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.LecturerDTO;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.controller.dto.StudentDTOView;
import uet.k59t.model.Admin;
import uet.k59t.model.Lecturer;
import uet.k59t.model.Student;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private PartnerRepository partnerRepository;

    //CRUD Sinh vien
    //Update hoac Create sinh vien
    public StudentDTO createStudent(StudentDTO studentDTO, String token) {
        if(token.equals(Admin.getToken())){
            if(studentRepository.findByEmailVNU(studentDTO.getEmail())!= null) {
                Student student = studentRepository.findByEmailVNU(studentDTO.getEmail());
                student.setMssv(studentDTO.getMssv());
                student.setClassroom(studentDTO.getClassroom());
                student.setGen(studentDTO.getGen());
                student.setSpeciality(studentDTO.getSpeciality());
                student.setAddress(studentDTO.getAddress());
                student.setFullName(studentDTO.getFullName());
                student.setDob(studentDTO.getDob());
                student.setEmailVNU(studentDTO.getEmail());
                student.setMeanGrade(studentDTO.getMeanGrade());
                student.setGradyear(studentDTO.getGradYear());
                student.setPassword(studentDTO.getEmail());
                studentRepository.save(student);
                return studentDTO;
            }
            else{
                Student student = new Student();
                student.setMssv(studentDTO.getMssv());
                student.setClassroom(studentDTO.getClassroom());
                student.setGen(studentDTO.getGen());
                student.setSpeciality(studentDTO.getSpeciality());
                student.setAddress(studentDTO.getAddress());
                student.setFullName(studentDTO.getFullName());
                student.setDob(studentDTO.getDob());
                student.setEmailVNU(studentDTO.getEmail());
                student.setMeanGrade(studentDTO.getMeanGrade());
                student.setGradyear(studentDTO.getGradYear());
                student.setPassword(studentDTO.getEmail());
                studentRepository.save(student);
                return studentDTO;
            }
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //Xoa mot sinh vien
    public void deleteStudent(Long id, String token) {
        if(token.equals(Admin.getToken())){
            if(studentRepository.findOne(id) != null){
                studentRepository.delete(id);
            }
            else throw new NullPointerException("Sinh vien khong ton tai");
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //Xem danh sach sinh vien
    public List<StudentDTO> viewAllStudent(String token) {
        if(token.equals(Admin.getToken())){
            List<StudentDTO> studentDTOList = new ArrayList<StudentDTO>();
            List<Student> studentList = studentRepository.findAll();
            for (int i = 0; i< studentList.size(); i++){
                StudentDTO studentDTO = new StudentDTO();
                Student student = studentList.get(i);
                studentDTO.setId(student.getId());
                studentDTO.setMssv(student.getMssv());
                studentDTO.setFullName(student.getFullName());
                studentDTO.setClassroom(student.getClassroom());
                studentDTO.setDob(student.getDob());
                studentDTO.setSpeciality(student.getSpeciality());
                studentDTOList.add(studentDTO);
            }
            return studentDTOList;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //Xem thong tin chi tiet cua mot sinh vien
    public StudentDTOView viewOneStudent(Long id, String token) {
        if(token.equals(Admin.getToken())){
            Student student = studentRepository.findOne(id);
            StudentDTOView studentDTOView = new StudentDTOView();
            BeanUtils.copyProperties(student, studentDTOView);
            return studentDTOView;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //CRUD Giang vien
    //Create va Update giang vien
    public LecturerDTO createLecturer(LecturerDTO lecturerDTO, String token) {
        if(token.equals(Admin.getToken())){
            if(lecturerRepository.findByEmailVNU(lecturerDTO.getEmailVNU())!=null){
                Lecturer lecturer = lecturerRepository.findByEmailVNU(lecturerDTO.getEmailVNU());
                BeanUtils.copyProperties(lecturerDTO, lecturer);
                lecturerRepository.save(lecturer);
                return lecturerDTO;
            }
            else{
                Lecturer lecturer = new Lecturer();
                BeanUtils.copyProperties(lecturerDTO, lecturer);
                lecturerRepository.save(lecturer);
                return lecturerDTO;
            }
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //Delete giang vien
    public void deleteLecturer(Long id, String token) {
        if(token.equals(Admin.getToken())){
            if(lecturerRepository.findOne(id)!=null){
                lecturerRepository.delete(id);
            }
            else throw new NullPointerException("Giang vien khong ton tai");
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    //View danh sach thong tin giang vien
    public List<LecturerDTO> viewAllLecturer(String token){
        if(token.equals(Admin.getToken())){
            List<LecturerDTO> lecturerDTOList = new ArrayList<>();
            List<Lecturer> lecturerList = lecturerRepository.findAll();
            for(int i = 0; i< lecturerList.size(); i++){
                LecturerDTO lecturerDTO = new LecturerDTO();
                BeanUtils.copyProperties(lecturerList.get(i), lecturerDTO);
                lecturerDTOList.add(lecturerDTO);
            }
            return lecturerDTOList;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

}
