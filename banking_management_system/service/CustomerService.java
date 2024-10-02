package com.qsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AccountDao;
import com.qsp.banking_management_system.dao.CardDao;
import com.qsp.banking_management_system.dao.CustomerDao;
import com.qsp.banking_management_system.dao.LoanDao;
import com.qsp.banking_management_system.dto.Account;
import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Customer;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.exception.AccountIdNotFound;
import com.qsp.banking_management_system.exception.CardIdNotFound;
import com.qsp.banking_management_system.exception.CustomerIdNotFound;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.exception.LoanIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	ResponseStructure<Customer> responseStructure;
	
	@Autowired
	ResponseStructureList<Customer> responseStructureList;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CardDao cardDao;
	
	@Autowired
	LoanDao loanDao;
	
	public ResponseStructure<Customer> saveCustomer(Customer customer) {
		responseStructure.setMessage("Successfully customer inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
        return responseStructure;
	}
	
	public ResponseStructure<Customer> fetchCustomerById(int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully customer fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(customerDao.fetchCustomerById(customerId));
        return responseStructure;
	}else {
		throw new CustomerIdNotFound();
	}
	}
	
	public ResponseStructure<Customer> deleteCustomerById(int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully customer deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.deleteCustomerById(customerId));
        return responseStructure;
	}else {
		throw new CustomerIdNotFound();
	}
	}
	
	public ResponseStructure<Customer> updateCustomer(int oldId,Customer newCustomer) {
		Customer customer=customerDao.fetchCustomerById(oldId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully customer updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.updateCustomer(oldId, newCustomer));
        return responseStructure;
	}else {
		throw new CustomerIdNotFound();
	}
	}
	
	public ResponseStructureList< Customer> fetchAllCustomer() {
		responseStructureList.setMessage("Successfully fetched all customer from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomer());
        return responseStructureList;
	}
	
	public ResponseStructure<Customer> addExistingAccountToExistingCustomer(int accountId,int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		Account account=accountDao.fetchAccountById(accountId);
		if(customer!=null) {
			if(account!=null) {
		
		responseStructure.setMessage("Successfully added ExistingAccountToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingAccountToExistingCustomer(accountId, customerId));
        return responseStructure;
			}
			else {
				throw new AccountIdNotFound();
			}
		}else {
			throw new CustomerIdNotFound();
		}
	}
	
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(int customerId,Account newAccount) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully added NewAccountToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewAccountToExistingCustomer(customerId, newAccount));
        return responseStructure;
		}else {
			throw new CustomerIdNotFound();
		}
	}
	
	public ResponseStructure<Customer> addExistingLoanToExistingCustomer(int loanId,int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		Loan loan=loanDao.fetchLoanById(loanId);
		if(customer!=null) {
			if(loan!=null) {
		responseStructure.setMessage("Successfully added ExistingLoanToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingLoanToExistingCustomer(loanId, customerId));
        return responseStructure;
	}
	else {
		throw new LoanIdNotFound();
	}
}else {
	throw new CustomerIdNotFound();
}
	}
	
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(int customerId,Loan newLoan) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully added NewLoanToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewLoanToExistingCustomer(customerId, newLoan));
        return responseStructure;
	}else {
		throw new CustomerIdNotFound();
	}
	}
	
	public ResponseStructure<Customer> addExistingCardToExistingCustomer(int cardId,int customerId) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		Card card=cardDao.fetchCardById(cardId);
		if(customer!=null) {
			if(card!=null) {
		responseStructure.setMessage("Successfully added ExistingCardToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingCardToExistingCustomer(cardId, customerId));
        return responseStructure;
	}
	else {
		throw new CardIdNotFound();
	}
}else {
	throw new CustomerIdNotFound();
}
	}
	
	public ResponseStructure<Customer> addNewCardToExistingCustomer(int customerId,Card newCard) {
		Customer customer=customerDao.fetchCustomerById(customerId);
		if(customer!=null) {
		responseStructure.setMessage("Successfully added NewCardToExistingCustomer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewCardToExistingCustomer(customerId, newCard));
        return responseStructure;
	}else {
		throw new CustomerIdNotFound();
	}
	}
}
