package uet.k59t.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.PartnerDTO;
import uet.k59t.model.Job;
import uet.k59t.model.Partner;
import uet.k59t.repository.JobRepository;
import uet.k59t.repository.PartnerRepository;
import uet.k59t.repository.StudentRepository;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JobRepository jobRepository;


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
}
