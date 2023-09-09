package com.example.firstproject.service.impl;

import com.example.firstproject.DTO.WeatherDTO;
import com.example.firstproject.entity.Engineer;
import com.example.firstproject.repository.EngineerRepository;
import com.example.firstproject.service.EngineerService;
import com.example.firstproject.service.WeatherService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EngineerServiceImpl implements EngineerService {
    
    
    private EngineerRepository engineerRepository;

    public EngineerServiceImpl(EngineerRepository engineerRepository){
        this.engineerRepository = engineerRepository;
    }
    @Override
    public List<Engineer> findAll() {
        // TODO Auto-generated method stub
        List<Engineer> theEngineer =  this.engineerRepository.findAll();
        return theEngineer; 
    }
    @Override
    public Engineer findOneById(Integer id) {
        // TODO Auto-generated method stub
        Optional<Engineer> result = this.engineerRepository.findById(id);
        return result.isPresent() ? result.get() : null;
    }

    @Override
    public Engineer create(Engineer engineer) {
        // TODO Auto-generated method stub
        return engineerRepository.save(engineer);
    }
    @Override
    public void deleteById(Integer id){
        engineerRepository.deleteById(id);
    }
}
