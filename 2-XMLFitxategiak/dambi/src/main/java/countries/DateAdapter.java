package countries;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    
    public LocalDate unmarshal(String date) throws Exception{
        return LocalDate.parse(date);
    }

    
    public String marshal(LocalDate date) throws Exception{
        return date.toString();
    }
}
