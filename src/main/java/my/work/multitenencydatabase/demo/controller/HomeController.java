package my.work.multitenencydatabase.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.teams.web.service.TeamsService;

@Controller
public class HomeController {

    @Autowired
    private TeamsService teamsService;

    @GetMapping("/")
    public String hello(Model model) throws Exception {
        String encode = teamsService.encode("test");
        System.out.println("출력=>" + encode);
        model.addAttribute("message", encode);
        return "index";
    }

}
