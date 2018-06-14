package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.JobStudentDTO;
import uet.k59t.controller.dto.LecturerDTO;
import uet.k59t.model.Job;
import uet.k59t.model.Lecturer;
import uet.k59t.service.LecturerService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @RequestMapping(value = "lecturer/update", method = RequestMethod.POST)
    public LecturerDTO updateInfo(@RequestBody LecturerDTO lecturerDTO, HttpServletRequest httpServletRequest){
        String token  = httpServletRequest.getHeader("auth-token");
        return lecturerService.updateInfo(lecturerDTO, token);
    }

    @RequestMapping(value = "lecturer/create/job", method = RequestMethod.POST)
    public JobDTO createJob(@RequestBody JobDTO jobDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return lecturerService.createJob(jobDTO, token);
    }

    @RequestMapping(value = "/partner/view/registry", method = RequestMethod.GET)
    public List<JobStudentDTO> viewRegisteredStudent(HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("auth-token");
        return lecturerService.viewRegisteredStudent(token);
    }

    @RequestMapping(value = "/partner/acceptregistry", method = RequestMethod.POST)
    public JobStudentDTO acceptRegistry(@RequestBody JobStudentDTO jobStudentDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return lecturerService.acceptRegistry(jobStudentDTO, token);
    }
}
