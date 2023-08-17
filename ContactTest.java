import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	// Test for working contact creation with specific values
	@Test
	void testContactClass() {
		Contact newContact = new Contact("1001", "Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		// Check if the contact is correctly initialized with the specified values
		assertTrue(newContact.getFirstName().equals("Bob"));
		assertTrue(newContact.getLastName().equals("Builder"));
		assertTrue(newContact.getContactId().equals("1001"));
		assertTrue(newContact.getPhone().equals("2813308004"));
		assertTrue(newContact.getAddress().equals("16000 Amazon Trail Macon, GA 68793"));
	}

	// Test for too long ID
	@Test
	void testContactClassIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10000000000", "Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for null ID
	@Test
	void testContactClassIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for too long first name
	@Test
	void testContactClassFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bobsworth123456", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for null first name
	@Test
	void testContactClassFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", null, "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for too long last name
	@Test
	void testContactClassLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", "Builder123456", "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for null last name
	@Test
	void testContactClassLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", null, "2813308004", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for not exactly 10 characters
	@Test
	void testContactClassPhoneNot10() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", "Builder", "281330800", "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for null phone
	@Test
	void testContactClassPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", "Builder", null, "16000 Amazon Trail Macon, GA 68793");
		});
	}

	// Test for too long address
	@Test
	void testContactClassAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793 123456");
		});
	}

	// Test for null address
	@Test
	void testContactClassAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("10001", "Bob", "Builder", "2813308004", null);
		});
	}

	// Test fName setter method
	@Test
	void testContactClassSetFirstName() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Set a new first name and check if it's updated correctly
		newContact.setFirstName("Jacob");
		assertTrue(newContact.getFirstName().equals("Jacob"));
	}

	@Test
	void testContactClassSetFirstNameTooLong() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a first name that is too long, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName("LandonTooLong");
		});
	}

	@Test
	void testContactClassSetFirstNameNull() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		//Setting a null first name, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setFirstName(null);
		});
	}

	// Test lName setter method
	@Test
	void testContactClassSetLastName() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Set a new last name and check if it's updated correctly
		newContact.setLastName("Jacobson");
		assertTrue(newContact.getLastName().equals("Jacobson"));
	}

	@Test
	void testContactClassSetLastNameTooLong() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Setting a last name that is too long, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName("JacobsonTooLong");
		});
	}

	@Test
	void testContactClassSetLastNameNull() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a null last name, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setLastName(null);
		});
	}

	// Test phone setter method
	@Test
	void testContactClassSetPhone() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Set a new phone number and check if it's updated correctly
		newContact.setPhone("8009919999");
		assertTrue(newContact.getPhone().equals("8009919999"));
	}

	@Test
	void testContactClassSetPhoneTooLong() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a phone number that is too long, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("800991999999999999");
		});
	}

	@Test
	void testContactClassSetPhoneNull() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a null phone number, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone(null);
		});
	}

	@Test
	void testContactClassSetPhoneTooShort() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a phone number that is too short, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setPhone("55");
		});
	}

	// Test address setter method
	@Test
	void testContactClassSetAddress() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Set a new address and check if it's updated correctly
		newContact.setAddress("new address 2");
		assertTrue(newContact.getAddress().equals("new address 2"));
	}

	@Test
	void testContactClassSetAddressTooLong() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting an address that is too long, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress("new address too long 1324566874685");
		});
	}

	@Test
	void testContactClassSetAddressNull() {
		Contact newContact = new Contact("845", "Landon", "Jasper", "6618886118", "new address");
		// Try setting a null address, it should throw an IllegalArgumentException
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			newContact.setAddress(null);
		});
	}
	
	@Test
    void testUniqueContactIds() {
        Contact contact1 = new Contact("1001", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1002", "Jane", "Smith", "9876543210", "456 Elm St");

        assertNotEquals(contact1.getContactId(), contact2.getContactId());
    }
}
