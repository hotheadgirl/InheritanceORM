/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Yoga
 */
@Entity
@DiscriminatorValue("FULLTIME")
public class FullTimeEmployee extends Employee implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private int salary;

    public int getSalary() {
        return salary;
    }
    
    public void setSalary(int salary) {
         this.salary = salary;
         
    }
   
}
