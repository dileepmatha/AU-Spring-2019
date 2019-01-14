public class Main {

	public static void main(String[] args)throws Exception {
		//Inserting data into database from input.xml file
		new ExportEmployeeToDatabase().export();
		
		//data from database to output.xml file
		new ImportEmployeeFromDatabase().importData();
	}

}
