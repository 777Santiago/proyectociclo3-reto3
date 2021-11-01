package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
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

    public Reservation update(Reservation c){
        if(c.getIdReservation()!=null){
            Optional<Reservation> caux=reservationRepository.getReservation(c.getIdReservation());
            if (!caux.isEmpty()){
                if (c.getStartDate()!=null){
                    caux.get().setStartDate(c.getStartDate());
                }
                if (c.getDevolutionDate()!=null){
                    caux.get().setDevolutionDate(c.getDevolutionDate());
                }
                return reservationRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id){
        Optional<Reservation> c=getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete(c.get());
            return true;
        }
        return false;
    }
}