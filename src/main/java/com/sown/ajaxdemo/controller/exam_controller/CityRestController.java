package com.sown.ajaxdemo.controller.exam_controller;

import com.sown.ajaxdemo.model.exam_model.City;
import com.sown.ajaxdemo.service.exam_service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/city")
public class CityRestController {
    @Autowired
    private ICityService cityService;
    @GetMapping
    public ResponseEntity<Iterable<City>> showCityList(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<City> showCityList(@PathVariable Long id){
        return new ResponseEntity<>(cityService.findCityById(id), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<City> saveCity(@RequestBody City userEntity) {
        return new ResponseEntity<>(cityService.save(userEntity), HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<City>updateCity(@PathVariable Long id,@RequestBody City city){
        Optional<City> cityTemp= cityService.findById(id);
        if(!cityTemp.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setCityId(cityTemp.get().getCityId());
        cityService.save(city);
        return new ResponseEntity<>(city,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<City>deleteCity(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        if(!city.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(city.get(),HttpStatus.OK);
    }

    @GetMapping("/update-form/{id}")
    public ResponseEntity<Optional<City>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(this.cityService.findById(id), HttpStatus.OK);
    }

}
