import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExportEmployeeToDatabase {
	public static final String INSERTQUERY="insert into employees values(?,?,?,?)";
	public void export() {	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{	ArrayList<EmployeeFields> employees=new ArrayList<>();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("C:\\Users\\Dileep\\eclipse-workspace\\Java_Advance\\src\\input.xml"));
			document.getDocumentElement().normalize();
			NodeList childNodes = document.getElementsByTagName("Employee");
			for(int i = 0; i < childNodes.getLength(); i++)
			{	EmployeeFields emp=new Employee();
				Node node = childNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					emp.setId(Integer.parseInt(element.getElementsByTagName("Id").item(0).
							getChildNodes().item(0).getNodeValue()));
					emp.setName((element.getElementsByTagName("Name").item(0).
							getChildNodes().item(0).getNodeValue()));
					emp.setSalary(Integer.parseFloat(element.getElementsByTagName("Salary").item(0).
							getChildNodes().item(0).getNodeValue()));
					emp.setDept_id(Integer.parseInt(element.getElementsByTagName("DepartmentId").item(0).
							getChildNodes().item(0).getNodeValue()));
					empl.add(employee);
				}
			}
			addEmployeesIntoDatabase(employees);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addEmployeesIntoDatabase(ArrayList<Employee> employees) throws Exception{

		MysqlConnector mysqlconn=new MysqlConnector();
		Connection connection=mysqlconn.getConnection();
		PreparedStatement ps=connection.prepareStatement(INSERTQUERY);
		for(int i=0;i<employees.size();i++) {
			Employee e=employees.get(i);
			ps.setInt(1,e.getId());
			ps.setString(2,e.getName());
			ps.setFloat(3, e.getSalary());
			ps.setInt(4,e.getDepartmentId());
			ps.addBatch();
		}
		ps.executeBatch();
		connection.close();
	}
	
}
