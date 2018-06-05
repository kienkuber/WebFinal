package uet.k59t.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.StudentDTOView;
import uet.k59t.model.Job;
import uet.k59t.model.Student;
import uet.k59t.repository.JobRepository;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private JobRepository jobRepository;

    public List<JobDTO> viewJobs(String token) {
        if(studentRepository.findByToken(token)!=null){
            List<JobDTO> jobDTOList = new ArrayList<>();
            List<Job> jobList = jobRepository.findAll();
            for(int i = 0; i<jobList.size(); i++){
                JobDTO jobDTO = new JobDTO();
                BeanUtils.copyProperties(jobList.get(i), jobDTO);
                jobDTOList.add(jobDTO);
            }
            return jobDTOList;

        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    public StudentDTOView updateInfo(StudentDTOView studentDTOView, String token) {
        if(studentRepository.findByToken(token)!=null){
            Student student = studentRepository.findByToken(token);
            BeanUtils.copyProperties(studentDTOView, student);
            studentRepository.save(student);
            return studentDTOView;
        }
        else throw new NullPointerException("Khong tim thay Student");
    }
}
