package uet.k59t.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.LecturerDTO;
import uet.k59t.model.Job;
import uet.k59t.model.Lecturer;
import uet.k59t.repository.JobRepository;
import uet.k59t.repository.LecturerRepository;
import uet.k59t.repository.StudentRepository;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JobRepository jobRepository;

    public LecturerDTO updateInfo(LecturerDTO lecturerDTO, String token) {
        if(lecturerRepository.findByToken(token)!=null){
            Lecturer lecturer = lecturerRepository.findByToken(token);
            BeanUtils.copyProperties(lecturerDTO, lecturer);
            return lecturerDTO;
        }
        else throw new NullPointerException("Khong tim thay giao vien");
    }


    public JobDTO createJob(JobDTO jobDTO, String token) {
        if(lecturerRepository.findByToken(token)!=null){
            Job job = new Job();
            BeanUtils.copyProperties(jobDTO, job);
            job.setLecturerId(lecturerRepository.findByToken(token).getId());
            jobRepository.save(job);
            return jobDTO;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }


}
