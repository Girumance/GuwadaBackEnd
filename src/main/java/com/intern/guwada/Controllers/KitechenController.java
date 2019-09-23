package com.intern.guwada.Controllers;


import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Services.KitechenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/kitechen")
public class KitechenController {

    @Autowired
    private KitechenService kitechenService;

    @PostMapping ("/save")
    public String saveKitechen(@RequestBody Kitchen kitechen){

        kitechenService.saveKitechen(kitechen);

        return "Done";
    }



    @GetMapping("/get")
    public ArrayList<Kitchen> getKitechen(){


        return kitechenService.getAllKitechensDetails();

    }





}
