/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpqldemo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Sindt
 */
public class Facade {

    EntityManagerFactory emf;

    public Facade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Long getEmployeeCount() {
        EntityManager em = getEntityManager();
        Long employeesTotal;
        try {
            employeesTotal = 0L;
            Query q = em.createNamedQuery("Employee.createEmployee");
            employeesTotal = (Long) q.getSingleResult();
        } finally {
            em.close();
        }
        return employeesTotal;

    }

    public List<Customer> getCustomerInCity(String city) {
        EntityManager em = getEntityManager();
        List<Customer> custList;
        try {
            custList = new ArrayList();
            Query q = em.createNamedQuery("Customer.findByCity");
            q.setParameter("city", city);
            custList = q.getResultList();

        } finally {
            em.close();
        }

        return custList;
    }

    public List<Employee> getEmployeeMaxCustomers() {
        EntityManager em = getEntityManager();
        List<Employee> empList;
        try {
            empList = new ArrayList();
            Query q = em.createNamedQuery("Employee.getEmployeeMaxCustomers");
            empList = q.getResultList();
        } finally {
            em.close();
        }
        return empList;
    }

}
