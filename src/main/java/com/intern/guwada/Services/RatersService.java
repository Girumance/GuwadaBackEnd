package com.intern.guwada.Services;

import com.intern.guwada.Domain.Kitchen;
import com.intern.guwada.Domain.Raters;
import com.intern.guwada.Repository.RatersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RatersService {

    @Autowired
    private RatersRepository ratersRepository;
    @Autowired
    private KitechenService kitechenService;

    public void rate(Raters raters) {

        Raters raters1 = ratersRepository.findRatersByUserIdAndKitchenId(raters.getUserId(),raters.getKitchenId());

        if (raters1 == null) {
            ratersRepository.save(raters);

        }
        else {

            ratersRepository.delete(raters1);
            raters.setId(raters1.getId());
            ratersRepository.save(raters);
        }

        Optional<Kitchen> kitchen=kitechenService.getById(raters.getKitchenId());
        kitechenService.deleteKitchen(kitchen.get());
        kitchen.get().setRating(calcTotal(raters.getKitchenId()));
        kitechenService.saveKitechen(kitchen.get());



        return;


    }


    public String getRatting(String uid,String kid) {
        Raters raters1 = ratersRepository.findRatersByUserIdAndKitchenId(uid,kid);

        if(raters1==null)
            return "0";

        return raters1.getValue();
    }


    public String calcTotal(String kitId){



        ArrayList<Raters> raters=ratersRepository.findRatersByKitchenId(kitId);

        float sum=0;

        for (Raters r:raters){

            float val=Float.parseFloat(r.getValue());
            sum+=val;

        }

        float average=sum/raters.size();


        return  String.valueOf(average);


    }
}