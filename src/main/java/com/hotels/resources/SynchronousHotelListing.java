package com.hotels.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hotels.domain.HotelList;
import com.hotels.facade.HotelFacade;

/**
 * Created by lfilipponi on 11/20/16.
 */
@Controller
public class SynchronousHotelListing {

    @Autowired
    HotelFacade hotelFacade;


    @RequestMapping(value = "/Sync/edgeSearch/{city}", method = RequestMethod.GET)
    @ResponseBody
    public HotelList HotelList(@PathVariable String city) {

        System.out.println("Operation done by"+Thread.currentThread().getName());

        return hotelFacade.getHotelList(city);
    }
}
