package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Address;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> address = addressRepo.findById(addressId);
		if (address.isPresent()) {
			return address.get();
		} else {
			return null;
		}
	}
	
	public Address deleteAddressById(int addressId) {
//		Address address=addressRepo.findById(addressId).get();
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public Address updateAddress(int oldId,Address newAddress) {
		newAddress.setAddressId(oldId);
//		return addressRepo.save(newAddress);
		return saveAddress(newAddress);
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
