package co.usa.proyecto.proyecto.repository.crud;

import co.usa.proyecto.proyecto.model.Client;
import co.usa.proyecto.proyecto.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ClientCrudRepository extends CrudRepository <Client,Integer> {
}