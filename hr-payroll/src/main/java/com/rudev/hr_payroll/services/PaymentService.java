package com.rudev.hr_payroll.services;

import org.springframework.stereotype.Service;

import com.rudev.hr_payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Ruben", 200.0, days);
	}
}
