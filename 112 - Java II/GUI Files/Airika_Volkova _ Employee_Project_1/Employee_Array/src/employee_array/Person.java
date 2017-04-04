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
public class Person implements Serializable
{
    private String lName;
    private String mName;
    private String fName;
    private String address;
    private String ssn;

    public Person()
    {
        lName = null;
        mName = null;
        fName = null;
        address = null;
        ssn = null;
    }

    public Person(String newLname, String newMname, String newFname, String newAddress, String newSsn)
    {
        setInfoP(newLname, newMname, newFname, newAddress, newSsn);
    }

    public void setInfoP(String newLname, String newMname, String newFname, String newAddress, String newSsn)
    {
       lName = newLname;
       mName = newMname;
       fName = newFname;
       address = newAddress;
       ssn = newSsn;
    }

    public String getLname()
    {
        return lName;
    }

    public String getMname()
    {
        return mName;
    }

    public String getFname()
    {
        return fName;
    }

    public String getAddress()
    {
        return address;
    }

    public String getSsn()
    {
        return ssn;
    }

    public void makeCopy(Person newPerson)
    {
        lName = newPerson.lName;
        mName = newPerson.mName;
        fName = newPerson.fName;
        address = newPerson.address;
        ssn = newPerson.ssn;
    }

    public Person getCopy()
    {
        Person copyPInfo = new Person(lName, mName, fName, address, ssn);
        return copyPInfo;
    }

    public String toPString()
    {  
        return("\n\nLast Name: " + lName + "\nMiddle Name: " + mName + "\nFirst Name: " + fName + "\nAddress: " + address + "\nSSN#: " + ssn);
    }
}



  

