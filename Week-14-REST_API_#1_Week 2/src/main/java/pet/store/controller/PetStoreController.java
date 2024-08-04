package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

@RestController
//@RequestMapping("/pet_store") ViRo: Violence.
@Slf4j
public class PetStoreController {
	
@Autowired
private PetStoreService petStoreService;

@PostMapping("/pet_store")
@ResponseStatus(code = HttpStatus.CREATED)
public PetStoreData postPetStore(@RequestBody PetStoreData petStoreData) {
	log.info("POSTing pet Store {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
}//PoPS

@PutMapping("/pet_store/{pet_store_id}")
public PetStoreData putPetStore(@PathVariable Long PetStoreId,
		@RequestBody PetStoreData petStoreData) {
	petStoreData.setPetStoreId(PetStoreId);
	log.info("PUTing pet store {}", petStoreData);
	return petStoreService.savePetStore(petStoreData);
} //PuPS

}//CLASS
