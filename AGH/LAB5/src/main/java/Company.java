import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {

    private Person CEO;
    private Person CTO;
    private Person CFO;
    private List<Localisation> localisationList = new ArrayList<Localisation>();

    //KONTSTRUKTORY
    Company() { }
    private static final Company instance = new Company();

    //GETTERY I SETTERY
    public Person getCEO() { return CEO; }
    public void setCEO(Person CEO) { this.CEO = CEO; }
    public Person getCTO(){ return CTO; }
    public void setCTO(Person CTO) { this.CTO = CTO; }
    public Person getCFO() { return CFO; }
    public void setCFO(Person CFO) { this.CFO = CFO; }
    public List<Localisation> getLocalisationList() {return localisationList; }
    public void setLocalisationList(List<Localisation> localisationList) { this.localisationList = localisationList; }
    public static Company getInstance() { return instance; }

    //METODY
    //SZUKANIE PO PESELU

    public Person findEmployee(String pesel){
        for (Localisation localisation:localisationList){
            Person found = localisation.findEmployee(pesel);
            if(!found.equals(null)) return found;
        }
        return null;
    }

    //LICZENIE PRACOWNIKOW
    public int numberOfEmployees(){
        int counter=0;
        for(Localisation localisation:localisationList){
            for(Department department: localisation.getDepartmentList()){
                counter+=department.getPersonList().size();
            }
        }
        return counter;
    }

    //DODAWANIE NOWYCH LOKALIZACJI
    public boolean addLocalisation(Localisation localisation){
        localisationList.add(localisation);
        return true;
    }



    //PRZECIAZENIA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(CEO, company.CEO) &&
                Objects.equals(CTO, company.CTO) &&
                Objects.equals(CFO, company.CFO) &&
                Objects.equals(localisationList, company.localisationList);
    }

    @Override
    public String toString() {
        return "Company{" +
                "CEO=" + CEO +
                ", CTO=" + CTO +
                ", CFO=" + CFO +
                ", localisationList=" + localisationList +
                '}';
    }
}
