package com.gabea.mbaapi.repository;

import com.gabea.mbaapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
