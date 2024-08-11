package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store") //ViRo: Violence.
@Slf4j
public class PetStoreController {
	
@Autowired
private PetStoreService petStoreService;

@PostMapping
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreData postPetStore(@RequestBody PetStoreData petStoreData) {
	log.info("POSTing pet Store {}", petStoreData); // ViRo: POST to Create
	return petStoreService.savePetStore(petStoreData);
}//PoPS

@PutMapping("/{petStoreId}")
public PetStoreData putPetStore(@PathVariable Long petStoreId,
		@RequestBody PetStoreData petStoreData) {
	petStoreData.setPetStoreId(petStoreId);
	log.info("PUTing pet store {}", petStoreData); // ViRo: PUT to update
	return petStoreService.savePetStore(petStoreData);
} //PuPS

@GetMapping
public List<PetStoreData> getPetStores() {
	log.info("GETting all pet stores");
	return petStoreService.retrieveAllPetStores();
} //GPS

@GetMapping("/{petStoreId}")
public PetStoreData getPetStoreById(@PathVariable Long petStoreId) {
	log.info("Searching for a store with an ID of" + petStoreId);
	return petStoreService.retrievePetStoreById(petStoreId);
} //GPSBI

@DeleteMapping("/{petStoreId}")
public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
	log.info("Hey, deleting the pet store with an ID of " + petStoreId);
	petStoreService.deletePetStoreById(petStoreId);
	Map <String, String> delMap = Map.of("message", "Store Deleted");
	return delMap;
} //DPSBI

@PostMapping("/{petStoreId}/employee")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreEmployee postEmployee(@PathVariable Long petStoreId, 
		@RequestBody PetStoreEmployee petStoreEmployee) {
	log.info("POSTing pet store employee {}", petStoreEmployee);
	return petStoreService.savePetStoreEmployee(petStoreEmployee, petStoreId);	
} //PoE

@PostMapping("/{petStoreId}/customer")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreCustomer postCustomer(@PathVariable Long petStoreId, 
		@RequestBody PetStoreCustomer petStoreCustomer) {
	log.info("PoSTing customer {}", petStoreCustomer);
	return petStoreService.savePetStoreCustomer(petStoreCustomer, petStoreId);
} //PoC

}//CLASS
