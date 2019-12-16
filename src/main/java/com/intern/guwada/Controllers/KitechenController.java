package com.intern.guwada.Controllers;


import com.intern.guwada.Components.MenuDeleteWrapper;
import com.intern.guwada.Components.SearchWraper;
import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Domain.Menu;
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
    @PostMapping("/save")
    public String saveKitechen(@RequestBody Kitchen kitechen) {

        return kitechenService.saveKitechen(kitechen);
    }


    //returns all kitchens detail with out menu
    @GetMapping("/getAll")
    public ArrayList<Kitchen> getAllKitechens() {


        return kitechenService.getAllKitechensDetails();


    }


    //returns single kitchen detail
    @GetMapping("/get/{id}")
    public Optional<Kitchen> getKitchenDetail(@PathVariable String id) {

        return kitechenService.getKitechenDetails(id);

    }

    @GetMapping("/getmenu/{id}")
    public ArrayList<Menu> getMenuById(@PathVariable String id) {

        return kitechenService.getMenuById(id);
    }

    @GetMapping("/getrealmenu/{id}")
    public ArrayList<Menu> getRealMenuById(@PathVariable String id) {

        return kitechenService.getMenuByRealId(id);
    }


    @GetMapping("/isKitchen/{id}")
    public String isKitchenAvaliableById(@PathVariable String id){
        Kitchen kit=kitechenService.getByOwnerId(id);
        return  kit==null ? "false" :kit.getId();


    }


    @GetMapping("/owner/{id}")
    public Kitchen getByOwnerId(@PathVariable String id) {
        return kitechenService.getByOwnerId(id);
    }

    @GetMapping("/update/{id}")
    public int updateMenu(@PathVariable String id, @RequestBody Menu menu) {

        return kitechenService.UpdateMenu(id, menu);

    }

    @PostMapping("/delete/{id}")
    public int deleteMenu(@PathVariable String id, @RequestBody MenuDeleteWrapper title) {
        return kitechenService.deleteMenu(id, title.getTitle());

    }
    @CrossOrigin
    @PostMapping("/addMenu/{id}")
    public int addMenu(@PathVariable String id,@RequestBody Menu menu){

        return kitechenService.addMenu(id,menu);
    }

    @PostMapping("/search")
    public ArrayList<SearchWraper> search(@RequestBody SearchWraper search){
        return kitechenService.search(search.getSearch());
        }

        @GetMapping("/bytitle/{title}")
        public String getKitByTitle(@PathVariable String title){

        Kitchen kitchen=kitechenService.getKitchenByTitle(title.toUpperCase());
        return kitchen ==null? "" :kitchen.getId();
        }


}
