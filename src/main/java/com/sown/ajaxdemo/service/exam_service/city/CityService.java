package com.sown.ajaxdemo.service.exam_service.city;

import com.sown.ajaxdemo.model.exam_model.City;
import com.sown.ajaxdemo.repo.exam_repo.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService{
    @Autowired
    ICityRepo cityRepo;
    @Override
    public Iterable<City> findAll() {

        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {

        return cityRepo.findById(id);
    }

    @Override
    public City save(City city) {
        cityRepo.save(city);
        return city;
    }

    @Override
    public void remove(Long id) {
        cityRepo.deleteById(id);
    }

    @Override
    public City findCityById(Long id) {
        return cityRepo.findCityByCityId(id);
    }
}
