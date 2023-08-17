import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ContactServiceTest {
	//creating contacts with unique ID using add contact
	@Test
	void testContactServiceClass() {
		ContactService.addContact("Bob", "Builder", "2813308004",
				"16000 Amazon Trail Macon,GA 68793");
		// Ensure the contact has the expected values
				assertTrue(ContactService.contactList.get(0).getContactId().equals("1000000001"));
				assertTrue(ContactService.contactList.get(0).getFirstName().equals("Bob"));
				assertTrue(ContactService.contactList.get(0).getLastName().equals("Builder"));
				assertTrue(ContactService.contactList.get(0).getPhone().equals("2813308004"));
				assertTrue(ContactService.contactList.get(0).getAddress().equals("16000 Amazon Trail Macon, GA 68793"));
			}
	// Test deleting a contact
		@Test
		void testContactServiceDelete() {
			// Add a contact for testing deletion
			ContactService.addContact("Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
			
			
			// Delete the contact and check if the deletion was successful
			ContactService.deleteContact("1000000003");
			assertTrue(ContactService.searchContact("1000000003") == 2);
		}
		
		// Test updating the first name of a contact
		@Test
		void testContactServiceUpdateFirstName() {
			// Add a contact for testing name update
			ContactService.addContact("Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
			int size = ContactService.contactList.size();
			
			// Update the first name and check if the change was successful
			ContactService.updateFirstName("1000000003", "Mary");
			assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Mary"));
		}
		
		// Test updating the last name of a contact
		@Test
		void testContactServiceUpdateLastName() {
			// Add a contact for testing last name update
			ContactService.addContact("Bob", "Builder", "2813308004", "16000 Amazon Trail Macon, GA 68793");
			int size = ContactService.contactList.size();
			
			// Update the last name and check if the change was successful
			ContactService.updateLastName("1000000003", "Poppins");
			assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Poppins"));
		}
		


	}


	
		

