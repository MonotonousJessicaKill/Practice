package day12;
/**
 * ������������emp.xml�е�ÿһ��empԪ��
 * tip:���û��д���췽������ô�����������һ���չ��������еĻ��Ͳ����æ�����
 * 		���Բ��߱���̬�ԣ�ֻ�з������ж�̬��
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
	public Emp(){}//ϣ���չ���������
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
