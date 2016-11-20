package com.hotels.domain;

import java.util.List;

/**
 * Created by lfilipponi on 11/20/16.
 */
public class HotelList {

    private List<Hotel> hotelList;

    public HotelList(){

    }

    public HotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }
}
