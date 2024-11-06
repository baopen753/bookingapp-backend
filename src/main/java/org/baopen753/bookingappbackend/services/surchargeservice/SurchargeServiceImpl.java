package org.baopen753.bookingappbackend.services.surchargeservice;

import org.baopen753.bookingappbackend.entities.MovingSurcharge;
import org.baopen753.bookingappbackend.exception.DataNotFoundException;
import org.baopen753.bookingappbackend.repositories.MovingSurchargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurchargeServiceImpl implements SurchargeService {

    private final MovingSurchargeRepository movingSurchargeRepository;

    @Autowired
    public SurchargeServiceImpl(MovingSurchargeRepository movingSurchargeRepository) {
        this.movingSurchargeRepository = movingSurchargeRepository;
    }


    @Override
    public List<MovingSurcharge> getAllMovingSurcharges() {
        List<MovingSurcharge> movingSurcharges = movingSurchargeRepository.findAll();
        return movingSurcharges;
    }


    @Override
    public MovingSurcharge getMovingSurchargeById(Integer id) {
        MovingSurcharge movingSurcharge = movingSurchargeRepository.findById(id).orElse(null);
        if (movingSurcharge == null) throw new DataNotFoundException("Moving Surcharge", id);
        return movingSurcharge;
    }

    @Override
    public MovingSurcharge updateMovingSurcharge(Integer movingSurchargeId, MovingSurcharge movingSurchargeFromRequest) {
        MovingSurcharge movingSurcharge = movingSurchargeRepository.findById(movingSurchargeId).orElse(null);

        if (movingSurcharge == null) throw new DataNotFoundException("Moving Surcharge ", movingSurchargeId);

        movingSurchargeRepository.save(movingSurchargeFromRequest);
        return movingSurchargeFromRequest;
    }
}
