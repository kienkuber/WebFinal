package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.StudentDTOView;
import uet.k59t.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/student/update", method = RequestMethod.POST)
    public StudentDTOView updateInfo(@RequestBody StudentDTOView studentDTOView, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return studentService.updateInfo(studentDTOView, token);
    }

    @RequestMapping(value = "/view/alljobs", method = RequestMethod.GET)
    public List<JobDTO> viewJobs(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return studentService.viewJobs(token);
    }

    @RequestMapping(value = "/job/registry/{jobId}", method = RequestMethod.GET)
    public JobDTO registryJob(@RequestBody long jobId, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return studentService.registryJob(jobId, token);
    }
}
