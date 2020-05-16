package com.zbamba.dev.housecatalog.services;

import com.zbamba.dev.housecatalog.entity.House;
import com.zbamba.dev.housecatalog.repositories.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class HouseService {

    @Autowired
    private HouseRepository houseRepository;

    private static final Logger LOGGER = Logger.getLogger(HouseService.class.getName());

    public ResponseEntity<List<House>> findById(int id) {
        Optional<House> optionalHouse = houseRepository.findById(id);

        return optionalHouse.isPresent() ? new ResponseEntity<>(Collections.singletonList(optionalHouse.get()), HttpStatus.OK) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<House>> findAll() {
        List<House> houseList = houseRepository.findAll(Sort.by("id").descending());
        return houseList.isEmpty() ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    public ResponseEntity<List<House>> findByCity(String city) {
        List<House> houseList = houseRepository.findByCity(city);

        return houseList.isEmpty() ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    public HttpStatus insertHouse(String houseType, String dealType, int rooms, int bathrooms, float price, String city, String country, String url) {
        House house = houseRepository.save(new House(houseType, dealType, rooms, bathrooms, price, city, country, url));
        return  house != null ? HttpStatus.OK : HttpStatus.FORBIDDEN;
    }

    public HttpStatus deleteHouse(int id) {
        Optional<House> optionalHouse = houseRepository.findById(id);

        if(optionalHouse.isPresent()) {
            houseRepository.delete(optionalHouse.get());
            LOGGER.warning("Deleted house with id: " + id);
            return HttpStatus.OK;
        }
        LOGGER.warning("Not found house with id: " + id);
        return HttpStatus.NOT_FOUND;
    }
}
