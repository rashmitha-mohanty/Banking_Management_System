package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.dto.Bank;
import com.qsp.banking_management_system.dto.Branch;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.BankRepo;

@Repository
public class BankDao {
	@Autowired
	BankRepo bankRepo;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	AtmDao atmDao;
	
	public Bank saveBank(Bank bank) {
		return bankRepo.save(bank);
	}
	
	public Bank fetchBankById(int bankId) {
		Optional<Bank> bank = bankRepo.findById(bankId);
		if (bank.isPresent()) {
			return bank.get();
		} else {
			return null;
		}
	}
	
	public Bank deleteBankById(int bankId) {
//		Bank bank=bankRepo.findById(bankId).get();
		Bank bank=fetchBankById(bankId);
		bankRepo.delete(bank);
		return bank;
	}
	
	public Bank updateBank(int oldId,Bank newBank) {
		newBank.setBankId(oldId);
//		return bankRepo.save(newBank);
		return saveBank(newBank);
	}
	
	public List<Bank> fetchAllBank() {
		return bankRepo.findAll();
	}
	
	public Bank addExistingBranchToExistingBank(int branchId,int bankId) {
		Branch branch=branchDao.fetchBranchById(branchId);
		Bank bank=fetchBankById(bankId);
		List<Branch> list=bank.getBranch();
		list.add(branch);
		bank.setBranch(list);
		return saveBank(bank);	
	}
	
//	public Bank addExistingBranchToExistingBank(int branchId,int bankId) {
//		List< Branch> list=branchDao.fetchAllBranch();
//		Bank bank=fetchBankById(bankId);
//		bank.setBranch(list);
//		return saveBank(bank);	
//	}
	
	public Bank addNewBranchToExistingBank(int bankId,Branch newBranch) {
	    Bank bank=fetchBankById(bankId);
	    List<Branch> list=bank.getBranch();
	    list.add(newBranch);
	    bank.setBranch(list);
	    return saveBank(bank);
	}
	
	public Bank addExistingAtmToExistingBank(int atmId,int bankId) {
		Atm atm=atmDao.fetchAtmById(atmId);
		Bank bank=fetchBankById(bankId);
		List<Atm> list=bank.getAtm();
		list.add(atm);
		bank.setAtm(list);
		return saveBank(bank);
	}
	
	public Bank addNewAtmToExistingBank(int bankId,Atm newAtm) {
	    Bank bank=fetchBankById(bankId);
	    List<Atm> list=bank.getAtm();
	    list.add(newAtm);
	    bank.setAtm(list);
	    return saveBank(bank);
	}
}
