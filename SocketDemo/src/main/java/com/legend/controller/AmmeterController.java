package com.legend.controller;

import com.legend.dao.domain.condition.AmmeterCondition;
import com.legend.service.AmmeterService;
import com.legend.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell-pc on 2017/9/7.
 */

@RestController
@RequestMapping(value = "/ammeter", method = RequestMethod.POST)
public class AmmeterController {

    @Autowired
    private AmmeterService ammeterService;

    @PostMapping(value = "/updateStatus")
    public Results updateAmmeterStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status){
        return ammeterService.updateAmmeterStatus(status,id);
    }

    @PostMapping(value = "/list")
    public Results list(@RequestBody AmmeterCondition ammeterCondition){

         return ammeterService.list(ammeterCondition);

    }


}
