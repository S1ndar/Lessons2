package Lambda;

public class People {
		String name;
	    int age;
	    int course;
	    double grade;
	    char sex;
		public People(String n, int a,int c, double g,char s) {
			name = n;
			age = a;
			course = c;
			grade = g;
			sex = s;
		}
		@Override
		public String toString() {
			return "\nPeople ( "+name+", "+age+", "+course+", "+grade+", "+sex+")"; 
		}
}

