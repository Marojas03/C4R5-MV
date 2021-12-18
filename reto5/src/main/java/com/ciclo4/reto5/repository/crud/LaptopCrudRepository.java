package com.ciclo4.reto5.repository.crud;

import com.ciclo4.reto5.model.Laptop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LaptopCrudRepository extends MongoRepository<Laptop, Integer> {

    //Para seleccionar el producto con id maximo // Para que en el front el id se cree solo
    Optional<Laptop> findTopByOrderByIdDesc();

    public List<Laptop> findByPriceLessThanEqual(double price);

    @Query("{'description':{'$regex': '?0','$options':'i'}}")
    public List<Laptop> findByDescriptionLike(String description);

}
