package com.qsp.banking_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Account;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.service.CustomerService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}

	@DeleteMapping("/deleteCustomerById")
	public ResponseStructure<Customer> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}

	@PutMapping("/updateCustomer")
	public ResponseStructure<Customer> updateCustomer(@RequestParam int oldId, @RequestBody Customer newCustomer) {
		return customerService.updateCustomer(oldId, newCustomer);
	}

	@GetMapping("/fetchAllCustomer")
	public ResponseStructureList<Customer> fetchAllCustomer() {
		return customerService.fetchAllCustomer();
	}

	@PutMapping("/addExistingAccountToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(@RequestParam int accountId,@RequestParam int customerId) {
	       return customerService.addExistingAccountToExistingCustomer(accountId, customerId);
		}

	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int customerId,@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(customerId, newAccount);
	}
	
	@PutMapping("/addExistingLoanToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(@RequestParam int loanId,@RequestParam int customerId) {
	       return customerService.addExistingLoanToExistingCustomer(loanId, customerId);
		}

	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(@RequestParam int customerId,@RequestBody Loan newLoan) {
		return customerService.addNewLoanToExistingCustomer(customerId, newLoan);
	}
	
	@PutMapping("/addExistingCardToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(@RequestParam int cardId,@RequestParam int customerId) {
	       return customerService.addExistingCardToExistingCustomer(cardId, customerId);
		}

	@PutMapping("/addNewCardToExistingCustomer")
	public ResponseStructure<Customer> addNewCardToExistingCustomer(@RequestParam int customerId,@RequestBody Card newCard) {
		return customerService.addNewCardToExistingCustomer(customerId, newCard);
	}
}
