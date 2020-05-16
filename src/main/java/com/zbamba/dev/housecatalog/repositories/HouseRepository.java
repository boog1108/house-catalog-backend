package com.zbamba.dev.housecatalog.repositories;

import com.zbamba.dev.housecatalog.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

    List<House> findByDealType(String dealType);

    List<House> findByCity(String city);

    List<House> findByCountry(String country);

    List<House> findByRoomsIsBetween(int minRooms, int maxRooms);

    List<House> findByBathroomsIsBetween(int minBathrooms, int maxBathrooms);

    List<House> findByPriceIsBetween(float minPrice, float maxPrice);
}
