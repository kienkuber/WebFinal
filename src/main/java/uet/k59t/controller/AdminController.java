package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //Xoa sinh vien
    @RequestMapping(value = "/delete/student", method = RequestMethod.POST)
    public StudentDTO deleteStudent(@RequestBody StudentDTO studentDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return adminService.deleteStudent(studentDTO, token);
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

    //Update giang vien

    //Delete giang vien

    //Xem danh sach giang vien

    //Xem thong tin tung giang vien


    //CRUD Partner
    //Create partner

    //Update partner

    //Delete partner

    //Xem danh sach partner

    //Xem thong tin tung partner

}
