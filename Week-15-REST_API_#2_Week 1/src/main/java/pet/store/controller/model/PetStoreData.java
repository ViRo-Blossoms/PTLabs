package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreData {
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private Integer petStoreZip;
	private Integer petStorePhone;
	private Set<PetStoreCustomer> customers = new HashSet<>();
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	//ViRo: Huge thanks to our joyfriend Kit "The 0ne" Blossoms for peepin' this!! We miscapitalized one thing and completely ruined it ha 
public PetStoreData(PetStore petStore) {
	petStoreId = petStore.getPetStoreId();
	petStoreName = petStore.getPetStoreName();
	petStoreAddress = petStore.getPetStoreAddress();
	petStoreCity = petStore.getPetStoreCity();
	petStoreState = petStore.getPetStoreState();
	petStoreZip = petStore.getPetStoreZip();
	petStorePhone = petStore.getPetStorePhone();
	
	if (customers.isEmpty())
	{} //Lmao
	else
	{
		for (Customer customer : petStore.getCustomers()) 
		{
			PetStoreCustomer petStoreCustomer = new PetStoreCustomer(customer);
			customers.add(petStoreCustomer);
		}
	}
	
	if (employees.isEmpty())
	{} //Lmao
	else
	{
	for (Employee employee : petStore.getEmployees())
		{
			PetStoreEmployee petStoreEmployee = new PetStoreEmployee(employee);
			employees.add(petStoreEmployee);
		}
	}//ViRo: Something wrong with my drivers, Current workaround is to simply lmao this code and suddenly its fine
} //PSD

} //CLASS
