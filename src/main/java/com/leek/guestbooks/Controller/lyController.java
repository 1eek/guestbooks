package com.leek.guestbooks.Controller;

import com.leek.guestbooks.Service.lyService;
import com.leek.guestbooks.pojo.ly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class lyController {
    @Autowired
    lyService lyService;

    @RequestMapping("/ly/all")
    public Iterable<ly> getAll() {
        return lyService.getAll();
    }

}
