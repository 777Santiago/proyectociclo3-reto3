package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
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

    public Skate update(Skate c){
        if(c.getId()!=null){
            Optional<Skate> caux=skateRepository.getSkate(c.getId());
            if (!caux.isEmpty()){
                if (c.getName()!=null){
                    caux.get().setName(c.getName());
                }
                if (c.getBrand()!=null){
                    caux.get().setBrand(c.getBrand());
                }
                if (c.getYear()!=null){
                    caux.get().setYear(c.getYear());
                }
                if (c.getDescription()!=null){
                    caux.get().setDescription(c.getDescription());
                }
                return skateRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id){
        Optional<Skate> c=getSkate(id);
        if(!c.isEmpty()){
            skateRepository.delete(c.get());
            return true;
        }
        return false;
    }
}