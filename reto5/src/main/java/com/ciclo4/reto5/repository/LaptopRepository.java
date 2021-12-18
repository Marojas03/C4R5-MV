package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.Laptop;
import com.ciclo4.reto5.repository.crud.LaptopCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LaptopRepository {

    @Autowired
    private LaptopCrudRepository laptopCrudRepository;

    public List<Laptop> getAll(){
        return laptopCrudRepository.findAll();
    }

    public Optional<Laptop> getLaptop(int id){                          //Buscar por ID para el metodo delete
        return laptopCrudRepository.findById(id);
    }

    public Optional<Laptop> lastUserId(){
        return laptopCrudRepository.findTopByOrderByIdDesc();
    }

    public Laptop create(Laptop laptop){
        return laptopCrudRepository.save(laptop);
    }

    public void update(Laptop laptop){
        laptopCrudRepository.save(laptop);
    }

    public void delete(Laptop laptop){
        laptopCrudRepository.delete(laptop);
    }

    public List<Laptop> productByPrice(double price){
        return laptopCrudRepository.findByPriceLessThanEqual(price);
    }

    public List<Laptop> findByDescriptionLike(String description){
        return laptopCrudRepository.findByDescriptionLike(description);
    }

}
