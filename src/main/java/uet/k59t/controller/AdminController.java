package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uet.k59t.controller.dto.LecturerDTO;
import uet.k59t.controller.dto.PartnerDTO;
import uet.k59t.controller.dto.StudentDTO;
import uet.k59t.controller.dto.StudentDTOView;
import uet.k59t.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    //CRUD Sinh vien
    //Create sinh vien
    @RequestMapping(value = "/create/student", method = RequestMethod.POST)
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createStudent(studentDTO, token);
    }

    //Update sinh vien
    @RequestMapping(value = "/update/student", method = RequestMethod.POST)
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createStudent(studentDTO, token);
    }

    //Delete sinh vien
    @RequestMapping(value = "/delete/student/{studentId}", method = RequestMethod.GET)
    public void deleteStudent(@PathVariable("studentId") Long id, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        adminService.deleteStudent(id, token);
    }

    //Xem danh sach sinh vien
    @RequestMapping(value = "read/allstudents", method = RequestMethod.GET)
    public List<StudentDTO> viewAllStudent(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.viewAllStudent(token);
    }

    //Xem thong tin tung sinh vien
    @RequestMapping(value = "read/student/{studentId}", method = RequestMethod.GET)
    public StudentDTOView viewOneStudent(@PathVariable("studentId") Long id, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.viewOneStudent(id, token);
    }


    //CRUD Giang vien
    //Create giang vien
    @RequestMapping(value = "/create/lecturer", method = RequestMethod.POST)
    public LecturerDTO createLecturer(@RequestBody LecturerDTO lecturerDTO, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createLecturer(lecturerDTO, token);
    }

    //Update giang vien
    @RequestMapping(value = "/update/lecturer", method = RequestMethod.POST)
    public LecturerDTO updateLecturer(@RequestBody LecturerDTO lecturerDTO, HttpServletRequest httpServletRequest) {
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createLecturer(lecturerDTO, token);
    }
    //Delete giang vien
    @RequestMapping(value = "/delete/lecturer/{lecturerId}", method = RequestMethod.GET)
    public void deleteLecturer(@PathVariable("lecturerId") Long id, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        adminService.deleteLecturer(id, token);
    }

    //Xem danh sach thong tin giang vien
    @RequestMapping(value = "/read/alllecturers", method = RequestMethod.GET)
    public List<LecturerDTO> viewAllLecturer(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.viewAllLecturer(token);
    }

    //CRUD Partner
    //Create partner
    @RequestMapping(value = "/create/partner", method = RequestMethod.POST)
    public PartnerDTO createPartner(@RequestBody PartnerDTO partnerDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createPartner(partnerDTO, token);
    }
    //Update partner
    @RequestMapping(value = "/update/partner", method = RequestMethod.POST)
    public PartnerDTO updatePartner(@RequestBody PartnerDTO partnerDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.createPartner(partnerDTO, token);
    }
    //Delete partner
    @RequestMapping(value = "/delete/partner/{partnerID}", method = RequestMethod.GET)
    public void deletePartner(@PathVariable("partnerID") Long id, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        adminService.deletePartner(id, token);
    }

    //Xem danh sach thong tin partner
    @RequestMapping(value = "/read/allpartners", method = RequestMethod.GET)
    public List<PartnerDTO> viewPartner(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.viewAllPartner(token);
    }
}
