package com.intern.guwada.Controllers;


import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Services.KitechenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/kitechen")
public class KitechenController {

    @Autowired
    private KitechenService kitechenService;


    //saves to kitechen collection
    @PostMapping ("/save")
    public String saveKitechen(@RequestBody Kitchen kitechen){

      int val= kitechenService.saveKitechen(kitechen);

      switch(val){
          case -1:
              return "-1";

          case 0:
              return "0";
          case 1:
              return "1";
          case 2:
              return "2";

      }

      return "2";
    }


    //returns all kitchens detail with out menu
    @GetMapping("/getAll")
    public ArrayList<Kitchen> getAllKitechens(){


        return kitechenService.getAllKitechensDetails();

    }


    //returns single kitchen detail
    @GetMapping("/get/{id}")
public Optional<Kitchen> getKitchenDetail(@PathVariable String id){

        return kitechenService.getKitechenDetails(id);

}



}
