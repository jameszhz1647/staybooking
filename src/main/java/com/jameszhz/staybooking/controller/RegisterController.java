package com.jameszhz.staybooking.controller;

import com.jameszhz.staybooking.model.User;
import com.jameszhz.staybooking.model.UserRole;
import com.jameszhz.staybooking.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController  // 集合了@controller 和 @ResponseBody
public class RegisterController {
    private RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/register/guest")
    public void addGuest(@RequestBody User user) { //@RequestBody JSON -> Obj
        registerService.add(user, UserRole.ROLE_GUEST);
    }

    @PostMapping("/register/host")
    public void addHost(@RequestBody User user) {
        registerService.add(user, UserRole.ROLE_HOST);
    }
}
