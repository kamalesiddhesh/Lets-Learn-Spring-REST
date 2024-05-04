package in.ashokit._JAXB_App;

import java.io.File;

import in.ashokit._JAXB_App.binding.Person;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception{
	/*
    	Person p = new Person();
    	p.setId(101);
    	p.setName("Siddhesh");
    	p.setGender("Male");
    	p.setEmail("abc@xyz.com");
    	
        JAXBContext context= JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.marshal(p, new File("person.xml"));
        System.out.println("done...............");
    */
// -------------------------------------------------------------------------------------------------------------------------------------------------------------------------    	
// 		Unmarshalling XML file data     	
    	JAXBContext context = JAXBContext.newInstance(Person.class);
    	Unmarshaller unmarshaller = context.createUnmarshaller();
    	
    	Person p = (Person)unmarshaller.unmarshal(new File("person.xml"));
    	
    	System.out.println(p);
    }
}
