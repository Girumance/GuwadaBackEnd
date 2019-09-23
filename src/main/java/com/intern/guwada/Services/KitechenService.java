package com.intern.guwada.Services;


import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Repository.KitechenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KitechenService {
    @Autowired
    KitechenRepository kitechenRepository;

public ArrayList<Kitchen> getAllKitechensDetails(){

    return  kitechenRepository.findKitechenDetalils();
}


public boolean saveKitechen(Kitchen kitchen){

    return kitechenRepository.save(kitchen) !=null? true: false;
}


}
