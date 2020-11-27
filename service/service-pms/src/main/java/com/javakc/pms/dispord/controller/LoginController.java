package com.javakc.pms.dispord.controller;


import com.javakc.commonutils.api.APICODE;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pms/user")
@CrossOrigin
public class LoginController {

    @PostMapping("login")
    public APICODE login() {
        return APICODE.OK().data("token", "admin");
    }

    @GetMapping("info")
    public APICODE info() {
        return APICODE.OK().data("roles", "[admin]").data("name", "admin").data("avatar", "http://img0.imgtn.bdimg.com/it/u=1782959667,617309577&fm=26&gp=0.jpg");
    }

}
