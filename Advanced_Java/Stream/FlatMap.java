package Stream;

import java.util.ArrayList;
import java.util.List;
// Intermediate method
public class FlatMap {
// Работает с элементами элементов sourse
	public static void main(String[] args) {
	      Human h1 = new Human(20, "bob",'m');
	      Human h2 = new Human(24, "tom",'m');
	      Human h3 = new Human(33, "rick",'m');
	      Human h4 = new Human(32, "ann",'f');
	      Human h5 = new Human(51, "mike",'m');
	      
	      School s1 = new School("Harvard");
	      School s2 = new School("HSE");
          s1.addSchool(h1);     
          s1.addSchool(h2);     
          s1.addSchool(h3);
          
          s2.addSchool(h4);
          s2.addSchool(h5);     
          
          List<School> GrandSchool = new ArrayList<School>();
          GrandSchool.add(s1);
          GrandSchool.add(s2);
	      
          // flatMap()                      
          GrandSchool.stream().flatMap(s -> s.getSchoolList().stream()).forEach(e->System.out.println(e.getName()));// Вывелись имена всех студентов
          // Возвращает stream для каждого schoolList, образует один большой stream и с помощью forEach(), выводит каждый элемент этого list                         
	}

}


class School{
	String name;
	List<Human> schoolList;
	public School(String n) {
         name = n;
         schoolList = new ArrayList<Human>();
	}
	public List<Human> getSchoolList() {
		return schoolList;
	}
	
	public void addSchool(Human h) {
		schoolList.add(h);
	}
} 
