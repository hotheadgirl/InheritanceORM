/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceorm;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Yoga
 */
public class InheritanceORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        while( i==0 ){
            System.out.println("Employee management");
            System.out.println("1 Fulltime employee");
            System.out.println("2 Parttime employee");
            System.out.println("3 Exit");
            System.out.println("Press no. for Choose type of employee => ");
            Scanner sc = new Scanner(System.in);
            int type = sc.nextInt();
            if (type == 1 ){
            System.out.println("choose manu for mange employee");
            System.out.printf("1 add\n2 edit\n3 remove");  
            int Manu = sc.nextInt();
                if(Manu == 1){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    System.out.print("Enter Name : ");
                    String name = sc.next();
                    System.out.print("Enter Salary : ");
                    int salary = sc.nextInt();
                    FullTimeEmployee emp = new FullTimeEmployee();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    persist(emp);
                }
                else if (Manu == 2){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    FullTimeEmployee emp;
                    emp = FullTimeTable.findById(id);
                    if(emp != null){
                    System.out.print("Enter Name : ");
                    String name = sc.next();
                    System.out.print("Enter Salary : ");
                    int salary = sc.nextInt();
                    emp.setName(name);
                    emp.setSalary(salary);
                    FullTimeTable.edit(emp);
                    }
                }
                else if (Manu == 3){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    FullTimeEmployee emp = FullTimeTable.findById(id);
                    if(emp != null) FullTimeTable.remove(emp);
                }
                
            }
            else if (type == 2){
                System.out.println("choose manu for mange employee");
                System.out.printf("1 add\n2 edit\n3 remove");  
                int Manu = sc.nextInt();
                if(Manu == 1){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    System.out.print("Enter Name : ");
                    String name = sc.next();
                    System.out.print("Enter Hours of work : ");
                    int hr = sc.nextInt();
                    PartTimeEmployee emp = new PartTimeEmployee();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setHoursWork(hr);
                    persist(emp);
                }
                else if (Manu == 2){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    PartTimeEmployee emp;
                    emp = PartTimeTable.findById(id);
                    if(emp != null){
                    System.out.print("Enter Name : ");
                    String name = sc.next();
                    System.out.print("Enter Hours of work : ");
                    int hr = sc.nextInt();
                    emp.setName(name);
                    emp.setHoursWork(hr);
                    PartTimeTable.edit(emp);
                    }
                }
                else if (Manu == 3){
                    System.out.print("Enter ID : ");
                    long id = sc.nextLong();
                    PartTimeEmployee emp = PartTimeTable.findById(id);
                    if(emp != null) PartTimeTable.remove(emp);
                }
            }
            else { i = 1; }
        }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("InheritanceORMPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
