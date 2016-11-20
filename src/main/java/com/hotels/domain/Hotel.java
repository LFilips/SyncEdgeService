package com.hotels.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by lfilipponi on 11/20/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Hotel {

    long id;
    String name;
    String description;
    int rate;
    String address;
    int star;

    public Hotel() {

    }

    public Hotel(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.rate = builder.rate;
        this.address = builder.address;
        this.star = builder.star;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }


    public static class Builder {

        long id;
        String name;
        String description;
        int rate;
        String address;
        int star;

        public Builder(long id) {
            this.id = id;

        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }
        public Builder withDescription(String Description){
            this.description = description;
            return this;
        }
        public Builder withRate(int rate){
            this.rate = rate;
            return this;
        }
        public Builder withAddress(String address){
            this.address = address;
            return this;
        }
        public Builder withStar(int star){
            this.star = star;
            return this;
        }

        public Hotel build(){
            return new Hotel(this);

        }


    }

}
