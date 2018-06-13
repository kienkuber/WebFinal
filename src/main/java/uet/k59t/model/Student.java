package uet.k59t.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mssv;
    private String classroom;
    private String gen;
    private String speciality;
    private String address;
    private String fullName;
    private String dob;
    private String emailVNU;
    private float meanGrade;
    private String gradyear;
    private String emailPersonal;
    private String skypeID;
    private String facebook;
    private String phone;
    private String position;
    private String language;
    private String certification;
    private String jobExp;
    private String hobby;
    private String orientation;
    private String note;
    private String password;
    private String token;
    private String reportURL;
    private String comment;
    private float score;
    private Long jobId;
    private Long teacherId;

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }


    private static final Role role = Role.STUDENT;

    public static Role getRole() {
        return role;
    }

    public String getReportURL() {
        return reportURL;
    }

    public void setReportURL(String reportURL) {
        this.reportURL = reportURL;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailVNU() {
        return emailVNU;
    }

    public void setEmailVNU(String emailVNU) {
        this.emailVNU = emailVNU;
    }

    public float getMeanGrade() {
        return meanGrade;
    }

    public void setMeanGrade(float meanGrade) {
        this.meanGrade = meanGrade;
    }

    public String getGradyear() {
        return gradyear;
    }

    public void setGradyear(String gradyear) {
        this.gradyear = gradyear;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getSkypeID() {
        return skypeID;
    }

    public void setSkypeID(String skypeID) {
        this.skypeID = skypeID;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getJobExp() {
        return jobExp;
    }

    public void setJobExp(String jobExp) {
        this.jobExp = jobExp;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
