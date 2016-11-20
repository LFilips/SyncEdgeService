package com.hotels.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import com.hotels.domain.Hotel;
import com.hotels.domain.HotelList;
import com.hotels.facade.HotelFacade;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by lfilipponi on 11/20/16.
 */
@Controller
public class AsynchronousHotelListing {

    @Autowired
    HotelFacade hotelFacade;


    @RequestMapping(value="/Async/edgeSearch/{city}", method= RequestMethod.GET)
    @ResponseBody
    public DeferredResult<HotelList> HotelList(@PathVariable String city){

        DeferredResult<HotelList> deferredResult = new DeferredResult<>();

        //no call will be performed till the subscription, and will be executed by a IO tread from rx
        //i can defin a custom thread pool for these operations
        hotelFacade.getObservableHotelList(city).subscribeOn(Schedulers.io()).subscribe(new Subscriber<HotelList>() {
            @Override
            public void onCompleted() {
                System.out.println("Operation done by"+Thread.currentThread().getName());

            }

            @Override
            public void onError(Throwable throwable) {
                deferredResult.setErrorResult("There was an error");

            }

            @Override
            public void onNext(HotelList list) {
                deferredResult.setResult(list);
            }
        });

        return  deferredResult;
    }
}
