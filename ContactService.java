import java.util.ArrayList;

public class ContactService {
	//variables for creating objects
	public static String publicId;
	public String publicFirstName;
	public String publicLastName;
	public String publicPhone;
	public String publicAddress;
	
	//structure for data storage
	static ArrayList<Contact> contactList = new ArrayList<Contact>(0);
	
	//uniqueId
	public static String genUniqueId() {
		String uniqueId;
		if(contactList.isEmpty()) {
			publicId = "10000000000";
		}
		else{
			int arraySize = contactList.size();
			publicId = contactList.get(arraySize -1).getContactId();
		}
		
		//converting string to int 
		int temp = Integer.valueOf(publicId);
		
		//adding 1 to make next value
		temp +=1;
		//converting back to string for storage
		uniqueId = Integer.toString(temp);
		return uniqueId;
	}
	
	//adding contact to array
	public static void addContact(String firstName, String lastName, String phone, String address) {
		String ID = genUniqueId();
		Contact Contact = new Contact(ID, firstName,lastName, phone, address);
		contactList.add(Contact);
	}
	//adding testing contact
	public static void addContact(Contact newContact) {
		String temp = newContact.getContactId();
		for(int i=0; i<contactList.size(); i++) {
			if (temp.equals(contactList.get(i).getContactId())) {
			throw new IllegalArgumentException("Invalid Contact ID");
			}
		}
		contactList.add(newContact);
	}
	//to update
	public static void updateFirstName(String uniqueId, String publicFirstName) {
		for (int i=0; i < contactList.size(); i++) {
			if(uniqueId.compareTo(contactList.get(i).getContactId()) ==0) {
				contactList.get(i).setFirstName(publicFirstName);
			}
		}
	}
	public static void updateLastName(String uniqueId, String publicLastName ) {
		for (int i=0; i < contactList.size(); i++) {
			if(uniqueId.compareTo(contactList.get(i).getContactId()) ==0) {
				contactList.get(i).setLastName(publicLastName);
			}
		}
	}	
	public static void updatePhone(String uniqueId, String publicPhone) {
		for (int i=0; i < contactList.size(); i++) {
			if(uniqueId.compareTo(contactList.get(i).getContactId()) ==0) {
				contactList.get(i).setPhone(publicPhone);
			}
		}
	}	
	public static void updateAddress(String uniqueId, String publicAddress ) {
		for (int i=0; i < contactList.size(); i++) {
			if(uniqueId.compareTo(contactList.get(i).getContactId()) ==0) {
				contactList.get(i).setAddress(publicAddress);
			}
		}
	}	
	
	//searching index
	public static int findIndex(String uniqueId) {
	    for (int i = 0; i < contactList.size(); i++) {
	        if (uniqueId.equals(contactList.get(i).getContactId())) {
	            return i; // Contact found, return its index
	        }
	    }
	    return -1; // Contact not found, return -1
	}
	
	//searching for a contact for testing
	public static int searchContact(String uniqueId) {
	    for (Contact contact : contactList) {
	        if (uniqueId.equals(contact.getContactId())) {
	            return 1; // Contact found
	        }
	    }
	    return 2; // Contact not found
	}
	
	//deleting a contact
	public static void deleteContact(String uniqueId) {
		for (int i=0; i <contactList.size(); i++) {
			if(uniqueId.compareTo(contactList.get(i).getContactId())==0) {
				int position = i;
				contactList.remove(position);
				
			}
		
		}
	}
}