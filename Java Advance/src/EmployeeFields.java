
public class EmployeeFields {
	private int Id;
	private String Name;
	private int Salary;
	private int DepartmentId;
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setSalary(int Salary) {
		this.Salary=Salary;
	}
	public void setDept_id(int DepartmentId) {
		this.DepartmentId=DepartmentId;
	}
	public int getId() {
		return this.Id;
	}
	public String getName() {
		return this.Name;
	}
	public float getSalary() {
		return this.Salary;
	}
	public int getDepartmentId() {
		return this.DepartmentId;
	}
}
