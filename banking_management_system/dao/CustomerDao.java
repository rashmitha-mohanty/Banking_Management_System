package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Account;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	CardDao cardDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> customer = customerRepo.findById(customerId);
		if (customer.isPresent()) {
			return customer.get();
		} else {
			return null;
		}
	}
	
	public Customer deleteCustomerById(int customerId) {
//		Customer customer=customerRepo.findById(customerId).get();
		Customer customer=fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}
	
	public Customer updateCustomer(int oldId,Customer newCustomer) {
		newCustomer.setCustomerId(oldId);
//		return customerRepo.save(newCustomer);
		return saveCustomer(newCustomer);
	}
	
	public List<Customer> fetchAllCustomer() {
		return customerRepo.findAll();
	}
	
	public Customer addExistingAccountToExistingCustomer(int accountId,int customerId) {
		Account account=accountDao.fetchAccountById(accountId);
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccount();
		list.add(account);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewAccountToExistingCustomer(int customerId,Account newAccount) {
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccount();
		list.add(newAccount);
		customer.setAccount(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingLoanToExistingCustomer(int loanId,int customerId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list=customer.getLoan();
		list.add(loan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewLoanToExistingCustomer(int customerId,Loan newLoan) {
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list=customer.getLoan();
		list.add(newLoan);
		customer.setLoan(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingCardToExistingCustomer(int cardId,int customerId) {
		Card card=cardDao.fetchCardById(cardId);
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCard();
		list.add(card);
		customer.setCard(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewCardToExistingCustomer(int customerId,Card newCard) {
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCard();
		list.add(newCard);
		customer.setCard(list);
		return saveCustomer(customer);
	}
}
