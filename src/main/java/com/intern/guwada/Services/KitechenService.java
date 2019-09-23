package com.intern.guwada.Services;


import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Repository.KitechenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class KitechenService {
    @Autowired
    KitechenRepository kitechenRepository;

public ArrayList<Kitchen> getAllKitechensDetails(){

    return  kitechenRepository.findKitechenDetalils();
}

/** It Returns -1 if the owner has already created a kitechen
*   It Returns 0 if the title is already exist
*   It Returns 1 if sucessfully saved
 *  It Returns 2 if there is any error while saving
*
*
* */

public int saveKitechen(Kitchen kitchen){
    if(kitechenRepository.getByOwnerId(kitchen.getOwnerId())!=null)
       return -1;

    if( kitechenRepository.getByTitle(kitchen.getTitle())!=null)
        return 0;





    return kitechenRepository.save(kitchen) !=null? 1: 2;
}


public Optional<Kitchen> getKitechenDetails(String id){

    return kitechenRepository.findById(id);

}


}
