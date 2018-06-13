package uet.k59t.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String jobName;
    private String jobReq;
    private Long partnerId;
    private Long lecturerId;
    private Integer jobAvailable;
    private Integer jobLeft;

    public Integer getJobAvailable() {
        return jobAvailable;
    }

    public void setJobAvailable(Integer jobAvailable) {
        this.jobAvailable = jobAvailable;
    }

    public Integer getJobLeft() {
        return jobLeft;
    }

    public void setJobLeft(Integer jobLeft) {
        this.jobLeft = jobLeft;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobReq() {
        return jobReq;
    }

    public void setJobReq(String jobReq) {
        this.jobReq = jobReq;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Long getPartnerId() {

        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
}
