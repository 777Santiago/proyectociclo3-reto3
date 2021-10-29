package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Category;
import co.usa.proyecto.proyecto.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux=categoryRepository.getCategory(c.getId());
            if (!caux.isPresent()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
}