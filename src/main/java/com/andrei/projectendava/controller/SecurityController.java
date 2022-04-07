package com.andrei.projectendava.controller;

import com.andrei.projectendava.dao.UserAccountRepository;
import com.andrei.projectendava.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    UserAccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @GetMapping("/register")
    public String register(Model model){
        UserAccount userAccount=new UserAccount();
        model.addAttribute("userAccount",userAccount);

        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount user){
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        accountRepository.save(user);
        return "redirect:/";
    }
}
