package com.rudev.hr_payroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.rudev.hr_payroll.entities.Payment;
import com.rudev.hr_payroll.services.PaymentService;

@RestController
@RequestMapping(value = "payment")
public class PaymentResource {
	
	@Autowired
	private PaymentService service;
	
	
	@HystrixCommand(fallbackMethod = "getPaymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
		
	}
	
	public ResponseEntity<Payment> getPaymentFallback(Long workerId, Integer days) {
		Payment payment = new Payment("Erro no serviço, fallback ativado!", 0.0, days);
		return ResponseEntity.ok(payment);
	}

}
