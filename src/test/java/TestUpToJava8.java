import java8.predicate.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.*;

import static java.lang.System.out;
import static java8.predicate.EmployeePredicates.*;

/**
 * Created by bfish3 on 4/13/17.
 */
public class TestUpToJava8 {
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

    employees = new ArrayList<Employee>();
    employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));
  }

  @Test
  public void testClosures() {

  }

  // http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Lambda-QuickStart/index.html
  @Test
  public void runnableTest() {
    Runnable r1 = new Runnable() {
      @Override
      public void run() {
        out.println("Hello world one!");
      }
    };

    Runnable r2 = () -> out.println("Hello world two!");

    r1.run();
    r2.run();
  }

  @Test
  public void comparatorTest() {
    // Sort with inner class
    Collections.sort(employees, new Comparator<Employee>() {
      public int compare(Employee e1, Employee e2) {
        return e1.getAge().compareTo(e2.getAge());
      }
    });

    for (Employee e : employees) {
      out.println(e);
    }

    // Use lambda instead

    // Print Asc
    Collections.sort(employees, (e1, e2) -> e1.getAge().compareTo(e2.getAge()));
    employees.forEach(out::println);

    // Print Asc, Comparator.comparing
    Collections.sort(employees, Comparator.comparing(Employee::getAge));
    employees.forEach(out::println);

    // Print Desc
    Collections.sort(employees, (e1, e2) -> e2.getAge().compareTo(e1.getAge()));
    employees.forEach(out::println);
  }

  @Test
  public void testLambdaExpression() {
    //System.out.println((int x, int y) -> x + y);
    //(String s) -> { System.out.println(s); };
  }

  // http://howtodoinjava.com/java-8/how-to-use-predicate-in-java-8/
  @Test
  public void testPredicates() {

    out.println(filterEmployees(employees, isAdultMale()));

    out.println(filterEmployees(employees, isAdultFemale()));

    out.println(filterEmployees(employees, isAgeMoreThan(35)));

    //Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
    out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
  }
}
