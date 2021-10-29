package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Score;
import co.usa.proyecto.proyecto.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score c){
        if(c.getIdScore()==null){
            return scoreRepository.save(c);
        }else{
            Optional<Score> caux=scoreRepository.getScore(c.getIdScore());
            if (!caux.isPresent()){
                return scoreRepository.save(c);
            }else{
                return c;
            }
        }
    }
}