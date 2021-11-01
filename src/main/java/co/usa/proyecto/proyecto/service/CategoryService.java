package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
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

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category> caux=categoryRepository.getCategory(c.getId());
            if (!caux.isEmpty()){
                if (c.getName()!=null){
                    caux.get().setName(c.getName());
                }
                if (c.getDescription()!=null){
                    caux.get().setDescription(c.getDescription());
                }
                return categoryRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id){
        Optional<Category> c=getCategory(id);
        if(!c.isEmpty()){
            categoryRepository.delete(c.get());
            return true;
        }
        return false;
    }
}