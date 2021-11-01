package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
import co.usa.proyecto.proyecto.model.Client;
import co.usa.proyecto.proyecto.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin c){
        if(c.getId()==null){
            return adminRepository.save(c);
        }else{
            Optional<Admin> caux=adminRepository.getAdmin(c.getId());
            if (caux.isPresent()){
                return adminRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Admin update(Admin c){
        if(c.getId()!=null){
            Optional<Admin> caux=adminRepository.getAdmin(c.getId());
            if (!caux.isEmpty()){
                if (c.getName()!=null){
                    caux.get().setName(c.getName());
                }
                if (c.getEmail()!=null){
                    caux.get().setEmail(c.getEmail());
                }
                if (c.getPassword()!=null){
                    caux.get().setPassword(c.getPassword());
                }
                return adminRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id){
        Optional<Admin> c=getAdmin(id);
        if(!c.isEmpty()){
            adminRepository.delete(c.get());
            return true;
        }
        return false;
    }
}