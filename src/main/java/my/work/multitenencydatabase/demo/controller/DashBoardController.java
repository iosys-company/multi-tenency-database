package my.work.multitenencydatabase.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.work.multitenencydatabase.security.domain.User;

@Controller
@RequestMapping("/dashboard")
public class DashBoardController {
    @GetMapping
    public String dashboard(Model model) {
        // 현재 시스템 시간을 출력한다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getPrincipal();
        User user = (User) authentication.getPrincipal();
        // 로그인 한 사용자의 이름을 출력한다.
        model.addAttribute("username", user.getFirstName() + " " + user.getLastName());
        // 현시 시스템 YYYY-MM-DD HH:MM:SS 형태로 출력한다.
        model.addAttribute("systemTime", new java.util.Date());
        model.addAttribute("message", "환영합니다.");
        return "dashboard";
    }
}
