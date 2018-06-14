package uet.k59t.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.JobStudentDTO;
import uet.k59t.controller.dto.PartnerDTO;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.model.Job;
import uet.k59t.model.Partner;
import uet.k59t.model.Student;
import uet.k59t.model.StudentJob;
import uet.k59t.repository.JobRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentJobRepository;
import uet.k59t.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartnerService {
    @Autowired private PartnerRepository partnerRepository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private JobRepository jobRepository;
    @Autowired private StudentJobRepository studentJobRepository;

    public PartnerDTO updateInfo(PartnerDTO partnerDTO, String token) {
        if(partnerRepository.findByToken(token)!=null){
            Partner partner = partnerRepository.findByToken(token);
            BeanUtils.copyProperties(partnerDTO, partner);
            partnerRepository.save(partner);
            return partnerDTO;
        }
        else throw new NullPointerException("Khong tim thay Partner");
    }

    public JobDTO createJob(JobDTO jobDTO, String token) {
        if(partnerRepository.findByToken(token)!= null){
            Job job = new Job();
            BeanUtils.copyProperties(jobDTO, job);
            job.setPartnerId(partnerRepository.findByToken(token).getId());
            jobRepository.save(job);
            return jobDTO;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }


    public List<JobStudentDTO> viewRegisteredStudent(String token) {
        if(partnerRepository.findByToken(token)!=null){
            List<Job> jobs = jobRepository.findByPartnerId(partnerRepository.findByToken(token).getId());
            List<StudentJob> studentJobs = new ArrayList<>();
            for(int i = 0; i<jobs.size(); i++){
                List<StudentJob> studentJobs1 = studentJobRepository.findByJobId(jobs.get(i).getId());
                studentJobs.addAll(studentJobs1);
            }
            List<JobStudentDTO> jobStudentDTOS = new ArrayList<>();
            for(int i = 0; i< studentJobs.size(); i++){
                JobStudentDTO jobStudentDTO = new JobStudentDTO();
                //set name
                jobStudentDTO.setJobId(studentJobs.get(i).getJobId());
                //set jobId
                jobStudentDTO.setJobName(jobRepository.findOne(studentJobs.get(i).getJobId()).getJobName());
                //set studentDTO
                Student student = studentRepository.findOne(studentJobs.get(i).getStudentId());
                StudentDTO studentDTO = new StudentDTO();
                BeanUtils.copyProperties(student, studentDTO);
                jobStudentDTO.setStudentDTO(studentDTO);
                jobStudentDTOS.add(jobStudentDTO);
            }
            return jobStudentDTOS;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }

    public JobStudentDTO acceptRegistry(JobStudentDTO jobStudentDTO, String token) {
        if(partnerRepository.findByToken(token)!=null){
            Student student = studentRepository.findOne(jobStudentDTO.getStudentDTO().getId());
            student.setJobId(jobStudentDTO.getJobId());
            studentRepository.save(student);
            return jobStudentDTO;
        }
        else throw new NullPointerException("Khong co quyen nay");
    }
}
