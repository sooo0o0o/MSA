package kr.co.tkdenddl1324.controller;

import kr.co.tkdenddl1324.dto.User1DTO;
import kr.co.tkdenddl1324.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User1Controller {

    // **final** 주입받기위해서 꼭 필요 (@Autowired 대신)
    private final User1Service service;

    @GetMapping("/user1/list")
    public String list(Model model){
        List<User1DTO> user1DTOList = service.findAll();
        model.addAttribute("users", user1DTOList);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }
    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        service.save(user1DTO);

        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){
        service.findByUid(uid);
        model.addAttribute("user", service.findByUid(uid));

        return "/user1/modify";
    }
    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        service.modify(user1DTO);

        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){
        service.deleteByUid(uid);

        return "redirect:/user1/list";
    }

}
