package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
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
}