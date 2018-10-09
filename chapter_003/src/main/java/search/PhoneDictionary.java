package search;
import java.util.*;
public class PhoneDictionary {
private List<Person> persons = new ArrayList();
public void add(Person person){
    this.persons.add(person);
}
    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подходящих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.toString().contains(key)){
                result.add(person);
            }

        }
        return result;
    }
}