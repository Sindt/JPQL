/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpqldemo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class JPQLDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQLDemoPU");
        EntityManager em = emf.createEntityManager();
        
        
        Facade f = new Facade(emf);
        
        System.out.println(f.getCustomerInCity("Barcelona"));
        
        System.out.println(f.getEmployeeCount());
        
        System.out.println(f.getEmployeeMaxCustomers().get(0));
        
        
        Query q =  em.createNamedQuery("Customer.findByCity");
        q.setParameter("city", "NYC");
        List<Customer> customers = q.getResultList();
           
        for (Customer customer : customers) {
            System.out.println("Navn =" + customer.getCustomerName());
        }
        
        Customer cust = em.find(Customer.class, 103);
        System.out.println("Cust name =" + cust.getCustomerName());
        
    }
    
}
