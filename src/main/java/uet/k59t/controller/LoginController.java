package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.UserDTO;
import uet.k59t.service.LoginService;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserDTO login(@RequestBody UserDTO userDTO){return loginService.login(userDTO);}

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(){loginService.logout();}

}
