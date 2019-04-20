import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {

    private String name;
    private DepartmentType departmentType;
    private List<Person> personList = new ArrayList<Person>();

    //KONSTRUKTORY:
    public Department(){
        setName("");
        setDepartmentType(null);
        setPersonList(null);
    }
    public Department(String name, DepartmentType departmentType){
        setName(name);
        setDepartmentType(departmentType);
        setPersonList(new ArrayList<Person>());
    }

    //GETTERY I SETTERY
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public DepartmentType getDepartmentType() { return departmentType; }
    public void setDepartmentType(DepartmentType departmentType) { this.departmentType = departmentType; }
    public List<Person> getPersonList() { return personList; }
    public void setPersonList(List<Person> personList) { this.personList = personList; }


    //METODY
    //SZUKANIE PO PESELU
    public Person findEmployee(String pesel){
        for (Person person : personList){
            if(person.getPesel().equals(pesel))
                return person;
        }
        return null;
    }

    public boolean isValid(Person person){
        if((person.getPosition()== Position.JAVA_DEVELOPER || person.getPosition()== Position.CPP_DEVELOPER) && departmentType== DepartmentType.DEVELOPMENT)
            return true;
        else if((person.getPosition()== Position.MARKETING_CONSULTANT || person.getPosition()== Position.MARKETING_RESEARCH_SPECIALIST) && departmentType== DepartmentType.MARKETING)
            return true;
        else if((person.getPosition()== Position.HR_ANALYST || person.getPosition()== Position.TRAINING_MANAGER) && departmentType== DepartmentType.HR)
            return true;
        return false;
    }

    //DODAWANIE PRACOWNIKA
    public boolean addPerson(Person person){
        if(isValid(person) && findEmployee(person.getPesel())==null){
            personList.add(person);
            return true;
        }
        return false;
    }

    //USUNIECIE PRACOWNIKA
    public boolean removePerson(Person person){
        if(this.personList.contains(person)){
            personList.remove(person);
            return true;
        }
        return false;
    }

    //PRZENIESIENIE PRACOWNIKA
    public boolean relocatePerson(Person person, Department department){
        if(this.departmentType==department.departmentType){
            if(this.personList.contains(person)){
                department.addPerson(person);
                this.personList.remove(person);
                return true;
            }
        }
        return false;
    }




    //PRZECIAZENIA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) &&
                departmentType == that.departmentType &&
                Objects.equals(personList, that.personList);
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                ", departmentType=" + departmentType +
                ", personList=" + personList +
                '}';
    }
}
