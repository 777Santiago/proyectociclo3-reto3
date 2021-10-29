package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Skate;
import co.usa.proyecto.proyecto.repository.SkateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkateService {

    @Autowired
    private SkateRepository skateRepository;

    public List<Skate> getAll(){
        return skateRepository.getAll();
    }

    public Optional<Skate> getSkate(int id){
        return skateRepository.getSkate(id);
    }

    public Skate save(Skate c){
        if(c.getId()==null){
            return skateRepository.save(c);
        }else{
            Optional<Skate> caux=skateRepository.getSkate(c.getId());
            if (!caux.isPresent()){
                return skateRepository.save(c);
            }else{
                return c;
            }
        }
    }
}