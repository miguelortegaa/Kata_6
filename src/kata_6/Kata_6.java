package kata_6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import pojo.University;

public class Kata_6 {

    public static void main(String[] args) {
        System.getProperty("java.classpath");
        WebLoader webLoader = new WebLoader();
        String url = "http://universities.hipolabs.com/search?country=spain";
        String json = webLoader.getFrom(url);
        
        Type listType = new TypeToken<ArrayList<University>>(){}.getType();
        List<University> universityList = new Gson().fromJson(json, listType);
        
        for (University university : universityList) {
            System.out.println(university.getName() + "  =  " + university.getWebPages());
        }
        
        System.out.println("----------------------" +
                           "\n---------XML---------");
        
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance( University.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(universityList.get(0), System.out);
            
        } catch (JAXBException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
