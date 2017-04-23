package java8.predicate;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bfish3 on 4/21/17.
 */
public class Employee {
  public Employee(Integer id, Integer age, String gender, String fName, String lName){
    this.id = id;
    this.age = age;
    this.gender = gender;
    this.firstName = fName;
    this.lastName = lName;
  }

  @Getter @Setter private Integer id;
  @Getter @Setter private Integer age;
  @Getter @Setter private String gender;
  @Getter @Setter private String firstName;
  @Getter @Setter private String lastName;

  @Override
  public String toString() {
    return this.id.toString()+" - "+this.age.toString(); //To change body of generated methods, choose Tools | Templates.
  }
}
