package org.baopen753.bookingappbackend.repositories;

import org.baopen753.bookingappbackend.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT a FROM Appointment a WHERE a.customer.userId = :customerId ")
    List<Appointment> findAppointmentByCustomerId(Integer customerId);

    @Query("SELECT a FROM Appointment a WHERE a.payment.paymentId =: paymentId")
    Appointment findAppointmentByPaymentId(Integer paymentId);
}



