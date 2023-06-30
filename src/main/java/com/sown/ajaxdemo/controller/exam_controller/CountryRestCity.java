package com.sown.ajaxdemo.controller.exam_controller;

import com.sown.ajaxdemo.model.exam_model.City;
import com.sown.ajaxdemo.model.exam_model.Country;
import com.sown.ajaxdemo.service.exam_service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/country")
public class CountryRestCity {
    @Autowired
    private ICountryService countryService;

    @GetMapping
    public ResponseEntity<Iterable<Country>> showCountryList(){
        return new ResponseEntity<>(countryService.findAll(), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Country> showCountryList(@PathVariable Long id){
        return new ResponseEntity<>(countryService.findById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Country> saveCountry(@RequestBody Country country) {
        return new ResponseEntity<>(countryService.save(country), HttpStatus.OK);
    }
    @PutMapping("{id}")
    private ResponseEntity<Country>updateCountry(@PathVariable Long id,@RequestBody Country country){
        Optional<Country> countryTemp= countryService.findById(id);
        if(!countryTemp.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        country.setCountryId(countryTemp.get().getCountryId());
        countryService.save(country);
        return new ResponseEntity<>(country,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<Country>deleteCountry(@PathVariable Long id){
        Optional<Country> country= countryService.findById(id);
        if(!country.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        countryService.remove(id);
        return new ResponseEntity<>(country.get(),HttpStatus.OK);
    }

}
