package weapon.db.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Manufacturer {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manufacturerId;
	private Long manufacturerName;
	
@EqualsAndHashCode.Exclude
@ToString.Exclude
@ManyToMany(cascade = CascadeType.ALL)
	private Set<Weapon> weapons = new HashSet<>();
}// CLASS


// ViRo: 
//
//		>Manufacturer ID: X
//			This is automatically generated and is used for identification and index purposes only.
//
//		>Weapon ID: Y
//			The ID number of the weapon being manufactured. This should be taken from the weapon once it is
//			placed in the database to avoid headaches.
//
//		>Manufacturer Name: Barrett Firearms Manufacturing
//			Name of the manufacturer.
//
//		} Many to Many with Weapon
//			Many manufacturers make many weapons and many weapons are made by many manufactures.
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////