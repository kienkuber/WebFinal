package uet.k59t.controller.dto;

public class JobDTO {
    private Long id;

    private String jobName;
    private String jobReq;
    private String partnerId;
    private String lecturerId;
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

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }
}
