package com.qsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AtmDao;
import com.qsp.banking_management_system.dto.Atm;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.dto.Owner;
import com.qsp.banking_management_system.exception.AtmIdNotFound;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class AtmService {
	@Autowired
	AtmDao atmDao;
	
	@Autowired
	ResponseStructure< Atm> responseStructure;
	
	@Autowired
	ResponseStructureList<Atm> responseStructureList;
	
	public ResponseStructure< Atm> saveAtm(Atm atm) {
		responseStructure.setMessage("Successfully atm inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(atmDao.saveAtm(atm));
        return responseStructure;
	}
	
	public ResponseStructure< Atm> fetchAtmById(int atmId) {
		Atm atm=atmDao.fetchAtmById(atmId);
		if(atm!=null) {
		responseStructure.setMessage("Successfully manager fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(atmDao.fetchAtmById(atmId));
        return responseStructure;
		}else {
			throw new AtmIdNotFound();
		}
	}
	
	public ResponseStructure< Atm> deleteAtmById(int atmId) {
		Atm atm=atmDao.fetchAtmById(atmId);
		if(atm!=null) {
		responseStructure.setMessage("Successfully manager deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.deleteAtmById(atmId));
        return responseStructure;
	}else {
		throw new AtmIdNotFound();
	}
	}
	
	public ResponseStructure< Atm> updateAtm(int oldId,Atm newAtm) {
		Atm atm=atmDao.fetchAtmById(oldId);
		if(atm!=null) {
		responseStructure.setMessage("Successfully manager updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(atmDao.updateAtm(oldId, newAtm));
        return responseStructure;
	}else {
		throw new AtmIdNotFound();
	}
	}
	
	public ResponseStructureList<Atm> fetchAllAtm() {
		responseStructureList.setMessage("Successfully fetched all atm from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(atmDao.fetchAllAtm());
        return responseStructureList;
	}
}
