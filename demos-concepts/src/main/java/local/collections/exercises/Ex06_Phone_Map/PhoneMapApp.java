package local.collections.exercises.Ex06_Phone_Map;

import java.util.Map;
import java.util.HashMap;

public class PhoneMapApp {

    private Map<String, Employee> phoneDirectory = new HashMap<>
    
    public void addEntry(Employee employee){
        String key = generateKey(employee);
        phoneDirectory.put(key, employee);
    }


    private Integer generateKey(Employee employee) {
        StringBuilder key = new StringBuilder();
        key.append(employee.name.tolowerCase().trim());

    if (employee.surname != null && !employee.surname2.isEmpty()) {
        key.append( " ").append(employee.surname.tolowerCase().trim());
    }

    if (employee.surname2 != null && !employee.surname2.isEmpty()) {
        key.append( " ").append(employee.surname.tolowerCase().trim());
    }
    System.out.println(key);

    return key.toString().hashCode();
}

public static void main(String[] args) {
    PhoneMapApp phoneagende = new PhoneMapApp();
    phoneAgende.addEntry(new Employee(0, null, null, null, null))

}