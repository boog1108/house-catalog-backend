package com.zbamba.dev.housecatalog.controllers;

import com.zbamba.dev.housecatalog.entity.House;
import com.zbamba.dev.housecatalog.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/id", method = GET)
    public ResponseEntity<List<House>> getHouseById(final @RequestParam(value = "id") int id){
        return houseService.findById(id);
    }

    @RequestMapping(value = "/all", method = GET)
    public ResponseEntity<List<House>> getAll() {
        return houseService.findAll();
    }

    @RequestMapping(value = "/city", method = GET)
    public ResponseEntity<List<House>> getHouseByCity(final @RequestParam(value = "city") String city) {
        return houseService.findByCity(city);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public HttpStatus insertHouse(final @RequestParam(value = "houseType") String houseType,
                                  final @RequestParam(value = "dealType") String dealType,
                                  final @RequestParam(value = "rooms") int rooms,
                                  final @RequestParam(value = "bathrooms") int bathrooms,
                                  final @RequestParam(value = "price") float price,
                                  final @RequestParam(value = "city") String city,
                                  final @RequestParam(value = "country") String country,
                                  final @RequestParam(value = "url") String url) {
        return houseService.insertHouse(houseType, dealType, rooms, bathrooms, price, city, country, url);
    }

    @RequestMapping(value = "/delete", method = DELETE)
    public HttpStatus deleteHouse(final @RequestParam(value = "id") int id) {
        HttpStatus httpStatus = houseService.deleteHouse(id);
        System.out.println("Http statys: " + httpStatus.value());
        return httpStatus;
    }
}
