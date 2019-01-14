import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImportEmployeeFromDatabase {
	public static final String SELECT_QUERY="select * from employees";
	public ArrayList<EmployeeFields> getEmployees() throws Exception{

		MysqlConnector mysqlconn=new MysqlConnector();
		Connection connection=mysqlconn.getConnection();
		Statement s=connection.createStatement();
		ResultSet rs =s.executeQuery(SELECT_QUERY);
		ArrayList<EmployeeFields> emp=new ArrayList<>();
		//Iterating the columns
		while(rs.next()) {
			Employee e=new Employee();
			e.setId(rs.getInt("Id"));
			e.setName(rs.getString("Name"));
			e.setSalary(rs.getInt("Salary"));
			e.setDept_id(rs.getInt("DepartmentId"));
			emp.add(e);
		}
		connection.close();
		return employees;
		
	}
	public void importData()throws Exception{
		ArrayList<EmployeeFields> employees =getEmployees();
		DocumentBuilderFactory f=DocumentBuilderFactory.newInstance(); 
		DocumentBuilder db=f.newDocumentBuilder();
		Document doc=db.newDocument();
		Element rootElement=doc.createElement("Employees");
		employees.stream()
				.forEach(e->{
					Element employeeElement=doc.createElement("Employee");
					Element idElement=doc.createElement("Id");
					Element nameElement=doc.createElement("Name");
					Element salaryElement=doc.createElement("Salary");
					Element deptidElement=doc.createElement("DeptId");
					
					Text id=doc.createTextNode(String.valueOf(e.getId()));
					Text name=doc.createTextNode(String.valueOf(e.getName()));
					Text salary=doc.createTextNode(String.valueOf(e.getSalary()));
					Text deptid=doc.createTextNode(String.valueOf(e.getDepartmentId()));
					
					idElement.appendChild(id);
					nameElement.appendChild(name);
					salaryElement.appendChild(salary);
					deptidElement.appendChild(deptid);
					
					employeeElement.appendChild(idElement);
					employeeElement.appendChild(nameElement);
					employeeElement.appendChild(salaryElement);
					employeeElement.appendChild(deptidElement);
					
					rootElement.appendChild(employeeElement);
				});
		doc.appendChild(rootElement);
		Transformer t=TransformerFactory.newInstance().newTransformer();
		t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream("C:\\\\Users\\\\Dileep\\\\eclipse-workspace\\\\Java_Advance\\\\src\\\\output.xml")));
		System.out.println("XML created successfully");
	}
	
}
