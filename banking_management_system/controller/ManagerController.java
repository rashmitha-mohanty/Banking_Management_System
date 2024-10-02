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

import com.qsp.banking_management_system.dto.Manager;
import com.qsp.banking_management_system.service.ManagerService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;
	
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/fetchManagerById")
	public ResponseStructure<Manager> fetchManagerById(@RequestParam int managerId) {
		return managerService.fetchManagerById(managerId);
	}
	
	@DeleteMapping("/deleteManagerById")
	public ResponseStructure<Manager> deleteManagerById(@RequestParam int managerId) {
         return managerService.deleteManagerById(managerId);
	}
	
	@PutMapping("/updateManager")
	public ResponseStructure<Manager> updateManager(@RequestParam int oldId,@RequestBody Manager newManager) {
		 return managerService.updateManager(oldId, newManager);
	}
	
	@GetMapping("/fetchAllManager")
	public ResponseStructureList<Manager> fetchAllManager() {
		return managerService.fetchAllManager();
	}
}
