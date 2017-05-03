import java8.predicate.Employee;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.*;
import java.util.function.Supplier;

import static java.lang.System.out;
import static java8.predicate.EmployeePredicates.*;
import static org.junit.Assert.assertEquals;

public class UpToJava8Test {
  private List<Employee> employees;
	
	@Rule
	public TestName name = new TestName();

  @Before
  public void setUp() throws Exception {
		out.println(name.getMethodName());
		
    // TODO: Replace with the builder pattern
    // http://www.vogella.com/tutorials/DesignPatternBuilder/article.html
    Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
    Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
    Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
    Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
    Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
    Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
    Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
    Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
    Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
    Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

    employees = new ArrayList<>();
    employees.addAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10));
  }

  @Test
  public void closures() {

  }

  // http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
  @Test
  public void runnable() {
    Runnable r1 = () -> out.println("Hello world one!");

    Runnable r2 = () -> out.println("Hello world two!");

    r1.run();
    r2.run();
  }

  @Test
  public void comparator() {
    // Sort with inner class
    employees.sort(Comparator.comparing(Employee::getAge));

    for (Employee e : employees) {
      out.println(e);
    }

    // Use lambda instead

    // Print Asc
    employees.sort(Comparator.comparing(Employee::getAge));
    employees.forEach(out::println);

    // Print Asc, Comparator.comparing
    employees.sort(Comparator.comparing(Employee::getAge));
    employees.forEach(out::println);

    // Print Desc
    employees.sort((e1, e2) -> e2.getAge().compareTo(e1.getAge()));
    employees.forEach(out::println);
  }

  @Test
  public void lambdaExpression() {
    //System.out.println((int x, int y) -> x + y);
    //(String s) -> { System.out.println(s); };
  }

  // http://howtodoinjava.com/java-8/how-to-use-predicate-in-java-8/
  @Test
  public void predicates() {

    out.println(filterEmployees(employees, isAdultMale()));

    out.println(filterEmployees(employees, isAdultFemale()));

    out.println(filterEmployees(employees, isAgeMoreThan(35)));

    //Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
    out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
  }

  @Test
  public void supplier() {
    Supplier<String> i = () -> "java2s.com";

    assertEquals("java2s.com", i.get());
  }
}
