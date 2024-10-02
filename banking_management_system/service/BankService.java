package com.qsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AtmDao;
import com.qsp.banking_management_system.dao.BankDao;
import com.qsp.banking_management_system.dao.BranchDao;
import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.exception.AtmIdNotFound;
import com.qsp.banking_management_system.exception.BankIdNotFound;
import com.qsp.banking_management_system.exception.BranchIdNotFound;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class BankService {
	@Autowired
	BankDao bankDao;
	
	@Autowired
	ResponseStructure<Bank> responseStructure;
	
	@Autowired
	ResponseStructureList<Bank> responseStructureList;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	AtmDao atmDao;

	public ResponseStructure<Bank> saveBank(Bank bank) {
		responseStructure.setMessage("Successfully bank inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
        return responseStructure;
	}

	public ResponseStructure<Bank> fetchBankById(int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
		responseStructure.setMessage("Successfully bank fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(bankDao.fetchBankById(bankId));
        return responseStructure;
		}else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructure<Bank> deleteBankById(int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
		responseStructure.setMessage("Successfully bank deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.deleteBankById(bankId));
        return responseStructure;
	}else {
		throw new BankIdNotFound();
	}
	}

	public ResponseStructure<Bank> updateBank(int oldId, Bank newBank) {
		Bank bank=bankDao.fetchBankById(oldId);
		if(bank!=null) {
		responseStructure.setMessage("Successfully bank updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.updateBank(oldId, newBank));
        return responseStructure;
	}else {
		throw new BankIdNotFound();
	}
	}

	public ResponseStructureList<Bank> fetchAllBank() {
		responseStructureList.setMessage("Successfully fetched all bank from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAllBank());
        return responseStructureList;
	}

	public ResponseStructure<Bank> addExistingBranchToExistingBank(int branchId, int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		Branch branch=branchDao.fetchBranchById(branchId);
		if(bank!=null) {
			if(branch!=null) {
				responseStructure.setMessage("Successfully added ExistingBranchToExistingBank in DB");
				responseStructure.setStatusCode(HttpStatus.OK.value());
				responseStructure.setData(bankDao.addExistingBranchToExistingBank(branchId, bankId));
		        return responseStructure;
			}
			else {
				throw new BranchIdNotFound();
			}
		}
		else {
			throw new BankIdNotFound();
		}
	
	}
	
	public ResponseStructure<Bank> addNewBranchToExistingBank(int bankId,Branch newBranch) {
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
		responseStructure.setMessage("Successfully added NewBranchToExistingBank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewBranchToExistingBank( bankId,newBranch));
        return responseStructure;
		}else {
			throw new BankIdNotFound();
		}
	}
	
	public ResponseStructure<Bank> addExistingAtmToExistingBank(int atmId,int bankId) {
		Bank bank=bankDao.fetchBankById(bankId);
		Atm atm=atmDao.fetchAtmById(atmId);
		if(bank!=null) {
			if(atm!=null) {
		responseStructure.setMessage("Successfully added ExistingAtmToExistingBank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addExistingAtmToExistingBank(atmId, bankId));
        return responseStructure;
	        }
	        else {
		    throw new AtmIdNotFound();
	          }
        }
        else {
	      throw new BankIdNotFound();
      }
	}
	
	public ResponseStructure<Bank> addNewAtmToExistingBank(int bankId,Atm newAtm) {
		Bank bank=bankDao.fetchBankById(bankId);
		if(bank!=null) {
		responseStructure.setMessage("Successfully added addNewAtmToExistingBank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewAtmToExistingBank( bankId,newAtm));
        return responseStructure;
	}else {
		throw new BankIdNotFound();
	}
	}
}
