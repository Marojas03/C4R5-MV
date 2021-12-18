package com.ciclo4.reto5.repository;

import com.ciclo4.reto5.model.User;
import com.ciclo4.reto5.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Miguel
 */

/**
 * Clase UserRepository con la anotación @Repository
 */
@Repository
public class UserRepository {
    /**
     * Instancia de la interface UserCrudRepository con la anotación @Autowired
     */
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     * Método para traer una lista con todos los usuarios
     * @return userCrudRepository.findAll()
     */
    public List<User> getAll() {
        return userCrudRepository.findAll();
    }
    /**
     * Método para buscar un usuario por su ID
     * @param id
     * @return userCrudRepository.findById(id)
     */
    public Optional<User> getUser(int id) {                                              //Buscar por ID para el metodo DELETE
        return userCrudRepository.findById(id);
    }

    /**
     * Método para buscar el último ID que haya en la base de datos, de forma descendente
     * @return userCrudRepository.findTopByOrderByIdDesc()
     */
    public Optional<User> lastUserId(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }

    /**
     * Método para buscar si un email ya se encuentra registrado
     * @param email
     * @return userCrudRepository.findByEmail(email)
     */
    public boolean existEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    /**
     * Método para saber si la combinación de email / contraseña ya se encuentra registrado
     * @param email
     * @param password
     * @return userCrudRepository.findByEmailAndPassword(email, password)
     */
    public Optional<User> authenticateUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * Método para crear un nuevo usuario, con los metodos de mongorepository
     * @param user
     * @return userCrudRepository.save(user)
     */
    public User create(User user){
        return userCrudRepository.save(user);
    }

    /**
     * Método para actualizar un usuario existente con los metodos de mongorepository
     * @param user
     */
    public void update(User user){
        userCrudRepository.save(user);
    }

    /**
     * Método para borrar un usuario, si este existe con los metodos de mongorepository
     * @param user
     */
    public void delete(User user){
        userCrudRepository.delete(user);
    }

    /**
     * Método para filtrar un usuario por el mes de nacimiento, con mongorepository
     * @param month
     * @return userCrudRepository.findByMonthBirthDay(month)
     */
    public List<User> listBirthDayMonth(String month){
        return userCrudRepository.findByMonthBirthtDay(month);
    }
}//Fin de la clase
