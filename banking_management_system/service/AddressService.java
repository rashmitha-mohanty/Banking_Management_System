package com.qsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.qsp.banking_management_system.dao.AddressDao;
import com.qsp.banking_management_system.dto.Address;
import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.dto.Owner;
import com.qsp.banking_management_system.exception.AddressIdNotFound;
import com.qsp.banking_management_system.exception.EmployeeIdNotFound;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setMessage("Successfully address inserted in DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(addressDao.saveAddress(address));
        return responseStructure;
	}
	
	public ResponseStructure<Address> fetchAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
		responseStructure.setMessage("Successfully address fetched from DB");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(addressDao.fetchAddressById(addressId));
        return responseStructure;
		}else {
			throw new AddressIdNotFound();
		}
	}
	
	public ResponseStructure<Address> deleteAddressById(int addressId) {
		Address address=addressDao.fetchAddressById(addressId);
		if(address!=null) {
		responseStructure.setMessage("Successfully address deleted from DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.deleteAddressById(addressId));
        return responseStructure;
	}else {
		throw new AddressIdNotFound();
	}
	}
	
	public ResponseStructure<Address> updateAddress(int oldId,Address newAddress) {
		Address address=addressDao.fetchAddressById(oldId);
		if(address!=null) {
		responseStructure.setMessage("Successfully address updated in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(addressDao.updateAddress(oldId, newAddress));
        return responseStructure;
	}else {
		throw new AddressIdNotFound();
	}
	}
	
	public ResponseStructureList<Address> fetchAllAddress() {
		responseStructureList.setMessage("Successfully fetched all address from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(addressDao.fetchAllAddress());
        return responseStructureList;
	}
}
