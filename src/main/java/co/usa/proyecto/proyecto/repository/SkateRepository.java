package co.usa.proyecto.proyecto.repository;

import co.usa.proyecto.proyecto.model.Skate;
import co.usa.proyecto.proyecto.repository.crud.SkateCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SkateRepository {
    @Autowired
    private SkateCrudRepository skateCrudRepository;

    public List<Skate> getAll(){
        return (List<Skate>) skateCrudRepository.findAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateCrudRepository.findById(id);
    }

    public Skate save(Skate c){
        return skateCrudRepository.save(c);
    }
}