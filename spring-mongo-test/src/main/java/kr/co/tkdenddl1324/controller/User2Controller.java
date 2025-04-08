package kr.co.tkdenddl1324.controller;

import kr.co.tkdenddl1324.dto.User2DTO;
import kr.co.tkdenddl1324.service.User2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User2Controller {

    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model) {
        List<User2DTO> user2DTOList = service.findAll();
        model.addAttribute("users2", user2DTOList);

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }
    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        service.save(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model){
        service.findByUid(uid);
        model.addAttribute("user2", service.findByUid(uid));
        return "/user2/modify";
    }
    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        service.modify(user2DTO);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid){
        service.deleteByUid(uid);

        return "redirect:/user2/list";
    }

}
