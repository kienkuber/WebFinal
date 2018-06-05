package uet.k59t.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uet.k59t.controller.dto.JobDTO;
import uet.k59t.controller.dto.PartnerDTO;
import uet.k59t.service.PartnerService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @RequestMapping(value = "/partner/update", method = RequestMethod.POST)
    public PartnerDTO updateInfo(@RequestBody PartnerDTO partnerDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return partnerService.updateInfo(partnerDTO, token);
    }

    @RequestMapping(value = "/partner/create/job", method = RequestMethod.POST)
    public JobDTO createJob(@RequestBody JobDTO jobDTO, HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("auth-token");
        return partnerService.createJob(jobDTO, token);
    }

}
