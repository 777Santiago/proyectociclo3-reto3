package co.usa.proyecto.proyecto.repository;

import co.usa.proyecto.proyecto.model.Client;
import co.usa.proyecto.proyecto.model.Reservation;
import co.usa.proyecto.proyecto.model.custom.CountClient;
import co.usa.proyecto.proyecto.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation c){
        return reservationCrudRepository.save(c);
    }

    public void delete(Reservation c){
        reservationCrudRepository.delete(c);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClient() {
        List<CountClient> res=new ArrayList<>();
        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for (int i=0;i<report.size();i++) {
            res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }
}