package com.spb.SpringBootDemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spb.SpringBootDemo.dao.cluster.CityDao;
import com.spb.SpringBootDemo.service.ICityService;
import com.spb.SpringBootDemo.vo.City;

@Service
public class CityServiceImpl implements ICityService {

	@Autowired
    private CityDao cityDao;

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }

    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }

}
