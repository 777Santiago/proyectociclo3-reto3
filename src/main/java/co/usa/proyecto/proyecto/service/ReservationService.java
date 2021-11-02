package co.usa.proyecto.proyecto.service;

import co.usa.proyecto.proyecto.model.Admin;
import co.usa.proyecto.proyecto.model.Reservation;
import co.usa.proyecto.proyecto.model.custom.CountClient;
import co.usa.proyecto.proyecto.model.custom.DescriptionAmount;
import co.usa.proyecto.proyecto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

    public DescriptionAmount getStatusReport(){
        List<Reservation> completed=reservationRepository.getReservationByDescription("completed");
        List<Reservation> cancelled=reservationRepository.getReservationByDescription("cancelled");

        DescriptionAmount descAmt= new DescriptionAmount((completed.size()), cancelled.size());
        return descAmt;
    }

    public List<Reservation> getReservationPeriod(String d1, String d2){
        SimpleDateFormat parser=new SimpleDateFormat( "yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try{
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne,dateTwo);
        }
        return new ArrayList<>();
    }
}