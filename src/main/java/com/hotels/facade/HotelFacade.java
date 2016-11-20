package com.hotels.facade;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotels.domain.Hotel;
import com.hotels.domain.HotelList;
import rx.Observable;

/**
 * Created by lfilipponi on 11/20/16.
 */
@Service
public class HotelFacade {


    private static String HOTEL_LIST_BY_CITY_BASE_URL = "http://localhost:8081/search";

    @Autowired
    RestTemplate restTemplate;

    /**
     *
     * emits an observable with the hotel list
     *
     * @param city
     * @return the observable hotelList
     */
    public Observable<HotelList> getObservableHotelList(String city){

        HotelList list = restTemplate.getForObject(HOTEL_LIST_BY_CITY_BASE_URL + "/" + city, HotelList.class);

          return Observable.just(list);

    }

    public HotelList getHotelList(String city){

        return restTemplate.getForObject(HOTEL_LIST_BY_CITY_BASE_URL + "/" + city, HotelList.class);

    }


}
