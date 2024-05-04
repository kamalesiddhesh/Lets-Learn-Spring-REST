package in.ashokit._JAXB_App.util;

import java.io.File;

import in.ashokit._JAXB_App.binding.Address;
import in.ashokit._JAXB_App.binding.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public class MarshallDemo {
	
	public static void main(String[] args) throws Exception {
		
		Address addr = new Address();
		addr.setCity("Mumbai");
		addr.setState("Maharashtra");
		addr.setCountry("India");
		
		Person p = new Person();
    	p.setId(101);
    	p.setName("Aniket");
    	p.setGender("Male");
    	p.setEmail("abc@xyz.com");
    	p.setAddress(addr);
    	
        JAXBContext context= JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.marshal(p, new File("person.xml"));
        System.out.println("done...............");
	}
	

}
