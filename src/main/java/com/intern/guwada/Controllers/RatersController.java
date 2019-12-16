package com.intern.guwada.Controllers;


import com.intern.guwada.Components.RatingWrapper;
import com.intern.guwada.Domain.Raters;
import com.intern.guwada.Services.RatersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatersController {

    @Autowired
    RatersService ratersService;

    @PostMapping("/rate")
    public void save(@RequestBody Raters raters){

        ratersService.rate(raters);

    }

    @GetMapping("/get")
    public String getRating(@RequestBody RatingWrapper ratingWrapper){

        return  ratersService.getRatting(ratingWrapper.getUserId(),ratingWrapper.getKitchenId());

    }
}
