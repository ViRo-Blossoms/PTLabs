package pet.store.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.dao.CustomerDao;
import pet.store.dao.EmployeeDao;
import pet.store.dao.PetStoreDao;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private CustomerDao customerDao;
		//ViRo: Do all these have to indiviually Autowired? Deeply unsure.

public PetStoreData savePetStore(PetStoreData petStoreData) {
	PetStore petStore = findOrCreatePetStore(petStoreData.getPetStoreId());
	copyPetStoreFields(petStore, petStoreData);
	PetStore psd = petStoreDao.save(petStore);
	return new PetStoreData(psd);
} //SPS

private PetStore findOrCreatePetStore(Long petStoreId) {
	PetStore petStore;
	if(Objects.isNull(petStoreId))
	{
		petStore = new PetStore();
	}
	else
	{
		petStore = findPetStoreById(petStoreId);
	}
	return petStore;
} //FOCPS

private PetStore findPetStoreById(Long petStoreId) {
	return petStoreDao.findById(petStoreId).orElseThrow(() -> new NoSuchElementException(
			"Hey, there's no store with an ID of " + petStoreId + "."));
} //FPSBI

private static void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
	petStore.setPetStoreId(petStoreData.getPetStoreId());
	petStore.setPetStoreName(petStoreData.getPetStoreName());
	petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
	petStore.setPetStoreCity(petStoreData.getPetStoreCity());
	petStore.setPetStoreState(petStoreData.getPetStoreState());
	petStore.setPetStoreZip(petStoreData.getPetStoreZip());
	petStore.setPetStorePhone(petStoreData.getPetStorePhone());
} //CPSF

@Transactional(readOnly = false)
public PetStoreEmployee savePetStoreEmployee(PetStoreEmployee petStoreEmployee, Long petStoreId) {
	PetStore petStore = findPetStoreById(petStoreId);
	Long employeeId = petStoreEmployee.getEmployeeId();
	Employee employee = findOrCreateEmployee(petStoreId, employeeId);
	copyEmployeeFields(employee, petStoreEmployee);
	employee.setPetStore(petStore);
	petStore.getEmployees().add(employee);
	Employee ed = employeeDao.save(employee);
	return new PetStoreEmployee(ed);
} //SPSE

private void copyEmployeeFields(Employee employee, PetStoreEmployee petStoreEmployee) {
	employee.setEmployeeId(petStoreEmployee.getEmployeeId());
	employee.setEmployeeFirstName(petStoreEmployee.getEmployeeFirstName());
	employee.setEmployeeLastName(petStoreEmployee.getEmployeeLastName());
	employee.setEmployeePhone(petStoreEmployee.getEmployeePhone());
	employee.setEmployeeJobTitle(petStoreEmployee.getEmployeeJobTitle());
} //CEF

private Employee findOrCreateEmployee(Long petStoreId, Long employeeId) {
	Employee employee;
	if(Objects.isNull(employeeId))
	{
		employee = new Employee();
	}
	else
	{
		employee = findEmployeeByID(petStoreId, employeeId);
	}
	return employee;
} //FOCE

private Employee findEmployeeByID(Long petStoreId, Long employeeId) {
	Employee employee = employeeDao.findById(employeeId).orElseThrow(() -> new NoSuchElementException(
			"Hey, there's no employee with an ID of " + employeeId + "."));
	if (employee.getPetStore().getPetStoreId() == petStoreId)
	{
		return employee;
	}
	else
	{
		throw new IllegalArgumentException("Hey, employee has an ID of " + employeeId + 
				" and a store ID of " + employee.getPetStore().getPetStoreId() + 
				", which doesn't match the given Store ID of " + petStoreId + ".");
	}
} //FEBI

@Transactional(readOnly = false)
public PetStoreCustomer savePetStoreCustomer(PetStoreCustomer petStoreCustomer, Long petStoreId) {
	PetStore petStore = findPetStoreById(petStoreId);
	Long customerId = petStoreCustomer.getCustomerId();
	Customer customer = findOrCreateCustomer(petStoreId, customerId);
	copyCustomerFields(customer, petStoreCustomer);
	petStore.getCustomers().add(customer);
	customer.getPetStores().add(petStore);
	Customer cd = customerDao.save(customer);
	return new PetStoreCustomer(cd);
} //SPSC

private void copyCustomerFields(Customer customer, PetStoreCustomer petStoreCustomer) {
	customer.setCustomerId(petStoreCustomer.getCustomerId());
	customer.setCustomerFirstName(petStoreCustomer.getCustomerFirstName());
	customer.setCustomerLastName(petStoreCustomer.getCustomerLastName());
	customer.setCustomerEmail(petStoreCustomer.getCustomerEmail());
} //CCF

private Customer findOrCreateCustomer(Long petStoreId, Long customerId) {
	Customer customer;
	if(Objects.isNull(customerId))
	{
		customer = new Customer();
	}
	else
	{
		customer = findCustomerByID(petStoreId, customerId);
	}
	return customer;
} //FOCC

private Customer findCustomerByID(Long petStoreId, Long customerId) {
	Customer customer = customerDao.findById(customerId).orElseThrow(() -> 
			new NoSuchElementException("Hey, theres no customer with an ID of" + customerId + "."));
	for (PetStore petStore : customer.getPetStores())
	{
		if(petStore.getPetStoreId() == petStoreId)
		{
			return customer;
		}
	}
	throw new IllegalArgumentException(
			"Hey, no match was made for any pet stores for the customer with an ID of " 
						+ customerId + "."); //ViRo: This *should* work
} //FCBI

@Transactional(readOnly = false)
public List<PetStoreData> retrieveAllPetStores() {
	List<PetStore> petStores = petStoreDao.findAll();
	List<PetStoreData> result = new LinkedList<>();
	for (PetStore petStore : petStores)
	{
		PetStoreData psd = new PetStoreData(petStore);
		psd.getCustomers().clear();
		psd.getEmployees().clear();
		result.add(psd);
	}
	return result;
} //RAPS

@Transactional(readOnly = false)
public PetStoreData retrievePetStoreById(Long petStoreId) {
	PetStore petStore = findPetStoreById(petStoreId);
	return new PetStoreData(petStore);
} //RPSBI

public void deletePetStoreById(Long petStoreId) {
	PetStore petStore = findPetStoreById(petStoreId);
	petStoreDao.delete(petStore);
} //DPSBI

}//CLASS
