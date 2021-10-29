package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Message;
import co.usa.proyecto.proyecto.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message c){
        if(c.getIdMessage()==null){
            return messageRepository.save(c);
        }else{
            Optional<Message> caux=messageRepository.getMessage(c.getIdMessage());
            if (!caux.isPresent()){
                return messageRepository.save(c);
            }else{
                return c;
            }
        }
    }
}