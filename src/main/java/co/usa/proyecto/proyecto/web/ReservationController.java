package co.usa.proyecto.proyecto.web;

import co.usa.proyecto.proyecto.model.Client;
import co.usa.proyecto.proyecto.model.Reservation;
import co.usa.proyecto.proyecto.model.custom.CountClient;
import co.usa.proyecto.proyecto.model.custom.DescriptionAmount;
import co.usa.proyecto.proyecto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation c){
        return reservationService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation c){
        return reservationService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public DescriptionAmount getReservationDescriptionStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-client")
    public List<CountClient> getCountClient(){
        return reservationService.getTopClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
        return reservationService.getReservationPeriod(d1, d2);
    }
}