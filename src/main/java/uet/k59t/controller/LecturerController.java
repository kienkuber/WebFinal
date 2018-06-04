package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.model.Lecturer;
import uet.k59t.service.LecturerService;

@RestController
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @RequestMapping()
}
