package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Reservation;
import co.usa.proyecto.proyecto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation c){
        if(c.getIdReservation()==null){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> caux=reservationRepository.getReservation(c.getIdReservation());
            if (!caux.isPresent()){
                return reservationRepository.save(c);
            }else{
                return c;
            }
        }
    }
}