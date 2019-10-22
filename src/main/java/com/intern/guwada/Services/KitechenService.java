package com.intern.guwada.Services;


import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Domain.Menu;
import com.intern.guwada.Repository.KitechenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class KitechenService {
    @Autowired
    KitechenRepository kitechenRepository;

    public ArrayList<Kitchen> getAllKitechensDetails() {

        return kitechenRepository.findKitechenDetalils();
    }

    public Optional<Kitchen> getById(String id){
        return kitechenRepository.findById(id);
    }

    /**
     * It Returns -1 if the owner has already created a kitechen
     * It Returns 0 if the title is already exist
     * It Returns 1 if sucessfully saved
     * It Returns 2 if there is any error while saving
     */

    public int saveKitechen(Kitchen kitchen) {
        if (kitechenRepository.getByOwnerId(kitchen.getOwnerId()) != null)
            return -1;

        if (kitechenRepository.getByTitle(kitchen.getTitle()) != null)
            return 0;


        return kitechenRepository.save(kitchen) != null ? 1 : 2;
    }


    public Optional<Kitchen> getKitechenDetails(String id) {

        return kitechenRepository.findById(id);

    }


    public ArrayList<Menu> getMenuById(String id) {

        Kitchen kitchen=kitechenRepository.getMenuById(id);

        ArrayList<Menu> menu=kitchen.getMenu();

        return menu;
    }


    public Kitchen getByOwnerId(String id) {

        Kitchen kitchen = kitechenRepository.getByOwnerId(id);

        return kitchen == null ? null : kitchen;
    }


    public int UpdateMenu(String id, Menu menu) {

        Kitchen kitchen = kitechenRepository.getByOwnerId(id);

        if (kitchen != null) {
            kitechenRepository.delete(kitchen);
            kitchen.getMenu().add(menu);
            kitechenRepository.save(kitchen);

            return 1;
        } else
            return -1;


    }


    public int deleteMenu(String id, String title) {

        int x = 0;
        boolean check = true;
        Kitchen kitchen = kitechenRepository.getByOwnerId(id);
        Kitchen orginal = kitechenRepository.getByOwnerId(id);
        for (; x < kitchen.getMenu().size(); x++) {

            if (kitchen.getMenu().get(x).getTitle().equals(title)) {
                kitchen.getMenu().remove(x);
                kitechenRepository.delete(orginal);
                kitechenRepository.save(kitchen);


                return 1;
            }
        }

        System.out.println(title);


        return -1;
    }


    public int addMenu(String id, Menu menu){

        Kitchen kitchen=kitechenRepository.getByOwnerId(id);
        Kitchen orignal=kitechenRepository.getByOwnerId(id);
        if(kitchen!=null){
            kitchen.getMenu().add(menu);
            kitechenRepository.delete(orignal);
            kitechenRepository.save(kitchen);
            return 1;
        }


        return -1;

    }

    public Menu getMenuByTitle(String id,String title){

        Optional<Kitchen> kitchen=kitechenRepository.findById(id);
        if(kitchen.isPresent()){

            for(Menu menu:kitchen.get().getMenu()){

                if(menu.getTitle().equals(title))
                    return  menu;


            }

        }

        return null;
    }


}
