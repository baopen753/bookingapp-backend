package org.baopen753.bookingappbackend.services.surchargeservice;

import org.baopen753.bookingappbackend.entities.MovingSurcharge;

import java.util.List;

public interface SurchargeService {
    List<MovingSurcharge> getAllMovingSurcharges();
    MovingSurcharge getMovingSurchargeById(Integer id);
    MovingSurcharge updateMovingSurcharge(Integer movingSurchargeId, MovingSurcharge movingSurcharge);
}
