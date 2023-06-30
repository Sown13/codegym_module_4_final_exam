package com.sown.ajaxdemo.repo.exam_repo;

import com.sown.ajaxdemo.model.exam_model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends JpaRepository<City,Long> {
    City findCityByCityId(Long id);
}
