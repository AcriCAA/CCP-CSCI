/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package employee_array;

import java.io.*;

/**
 *
 * @author volkovao
 */
public class Employee extends Person  implements Serializable
{
   
    
    public String id;
    public String dep;
    public double hours;
    public double rate;
    public double gross;

    public Employee() 
    {
        super();
        id = null;
        dep = null;
        hours = 0;
        rate = 0;
        gross = 0;
    }

    public Employee(String newLname, String newMname, String newFname, String newAddress, String newSsn, String newId, String newDep, double newHours, double newRate) 
    {
        super(newLname, newMname, newFname, newAddress, newSsn);
        id = newId;
        dep = newDep;
        hours = newHours;
        rate = newRate;
    }		
    
    public void setInfoE(String newLname, String newMname, String newFname, String newAddress, String newSsn, String newId, String newDep, double newHours, double newRate)
    {
        setInfoP(newLname, newMname, newFname, newAddress, newSsn);
        id = newId;
        dep = newDep;
        hours = newHours;
        rate = newRate;
    }
    
    public String getId()
    {
        return id;
    }
    
    public String getDep()
    {
        return dep;
    }
    
    public double getHours()
    {
        return hours;
    }
    
    public double getRate()
    {
        return rate;
    }
       
    public double getGross()
    {
        return (hours * rate);
    }
    
    public void makeCopy(Employee newEmployee)
    {
        super.getCopy();
        id = newEmployee.id;
        dep = newEmployee.dep;
        hours = newEmployee.hours;
        rate = newEmployee.rate;
        gross = newEmployee.gross;
    }
    
    public Employee getCopy()
    {
        Employee copyEInfo = new Employee();
        return copyEInfo;
    }

    public String toEString()
    {  
        return (super.toPString() + "\nID #: " + id + "\nDepartment: " + dep + "\nHours worked: " + hours + "\nRate: " + rate + "\nGross salary: " + getGross());
    }
}


  


