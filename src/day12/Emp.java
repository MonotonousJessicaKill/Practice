package day12;
/**
 * 该类用于描述emp.xml中的每一个emp元素
 * tip:如果没有写构造方法，那么编译器会添加一个空构造器；有的话就不会帮忙添加了
 * 		属性不具备多态性，只有方法具有多态性
 * @author wu.jielin
 *
 */
public class Emp {
	private int id;
	private String name;
	private int age;
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gedner) {
		this.gender = gedner;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private int salary;
	public Emp(){}//希望空构造器可用
	public Emp(int id, String name, int age, String gedner, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gedner;
		this.salary = salary;
	}
	public String toString(){
		return "id"+id+",name"+name+",age"+age+",gende"+gender+",salary"+salary;
	};
}
