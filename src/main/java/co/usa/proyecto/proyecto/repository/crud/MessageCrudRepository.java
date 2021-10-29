package co.usa.proyecto.proyecto.repository.crud;

import co.usa.proyecto.proyecto.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}