package co.usa.proyecto.proyecto.repository.crud;

import co.usa.proyecto.proyecto.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}