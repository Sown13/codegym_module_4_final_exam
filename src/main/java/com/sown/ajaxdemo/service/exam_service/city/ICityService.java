package com.sown.ajaxdemo.service.exam_service.city;

import com.sown.ajaxdemo.model.exam_model.City;
import com.sown.ajaxdemo.service.IGeneralService;

public interface ICityService extends IGeneralService<City> {
    City findCityById(Long id);
}
