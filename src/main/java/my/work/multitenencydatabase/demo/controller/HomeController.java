package my.work.multitenencydatabase.demo.controller;

import kr.teams.web.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TeamsService teamsService;

    @GetMapping("/")
    public String hello() throws Exception {
        String dd = teamsService.encode("test");
        System.out.println(dd);
        return "index";
    }

}