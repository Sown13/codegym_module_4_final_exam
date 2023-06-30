package com.sown.ajaxdemo.repo.exam_repo;

import com.sown.ajaxdemo.model.exam_model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends JpaRepository<Country,Long> {
}
