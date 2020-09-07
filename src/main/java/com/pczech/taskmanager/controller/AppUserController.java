package com.pczech.taskmanager.controller;

import com.pczech.taskmanager.domain.AppUser;
import com.pczech.taskmanager.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController()
@RequestMapping("/api/users")
@CrossOrigin("*")
public class AppUserController {
    private final AppUserService appUserService;

    @Autowired()
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser register(@RequestBody() @Valid() AppUser appUser, Errors errors) {
        return appUserService.register(appUser, errors);
    }
}