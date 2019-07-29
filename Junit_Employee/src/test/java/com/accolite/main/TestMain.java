package com.accolite.main;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.accolite.main.Main;
import com.accolite.pojo.Employee;

@FixMethodOrder(MethodSorters.DEFAULT)
public class TestMain {

	private Main app = new Main();
	private static Employee emp = new Employee();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		emp.setEmpId(121);
		emp.setEmpName("Mudita");
		emp.setDept("Software");
		emp.setSalary(100000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test case being tested...");
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected=NullPointerException.class)
	public void testIsListEmp()
	{
		assertNotEquals("true",app.isListEmpty());
	}
	

	@Test
	public void testAddEmployee() {
		assertEquals(emp,app.addEmployee(emp));
	}

	@Test(expected=NullPointerException.class)
	public void testListEmployee()
	{
		assertNotEquals("false",app.ListEmployee());
	}
	
	@Test
	public void testGetEmployee() {
		assertEquals(1,app.getEmployee("Mudita"));
	}
	
	@Test
	public void testUpdateEmployee()
	{
		assertNotEquals(emp.getEmpName(),app.updateEmployee("MuditaSaxena", 2019));
		assertNotEquals("not found",app.updateEmployee("MuditaSaxena", 2019));
		assertNotNull(app.updateEmployee("MuditaSaxena", 2019));
	}
	
	@Test
	public void testDeleteEmployee() {
		assertNotEquals(1,app.deleteEmployee(2019));
	}
	
	@Test
	public void testGetSalaryFromDept()
	{
		assertNotNull(app.getSalaryFromDept("Software"));
	}
}
