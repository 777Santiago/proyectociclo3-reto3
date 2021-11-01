package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Client;
import co.usa.proyecto.proyecto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> caux=clientRepository.getClient(c.getIdClient());
            if(caux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> caux=clientRepository.getClient(c.getIdClient());
            if (!caux.isEmpty()){
                if (c.getEmail()!=null){
                    caux.get().setEmail(c.getEmail());
                }
                if (c.getPassword()!=null){
                    caux.get().setPassword(c.getPassword());
                }
                if (c.getName()!=null){
                    caux.get().setName(c.getName());
                }
                if (c.getAge()!=null){
                    caux.get().setAge(c.getAge());
                }
                return clientRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id){
        Optional<Client> c=getClient(id);
        if(!c.isEmpty()){
            clientRepository.delete(c.get());
            return true;
        }
        return false;
    }
}