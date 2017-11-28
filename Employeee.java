/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author Roshen
 */
public class Employeee
{

    private String name;
    private int employeeID;
    private String dateOfBirth;
    private String emailAddress;
    private int phone;
    private String password;
    private Double salary;
    private Double hoursWorked;
    private Double hourlyRate;

    public Employeee(String name, int employeeID, String dateOfBirth, String emailAddress, int phone, String password)
    {
        this.name = name;
        this.employeeID = employeeID;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.password = password;
    }
    
   // For agent
    public Employeee(String name, int employeeID, String dateOfBirth, String emailAddress, int phone, String password, Double salary)
    {
        this.name = name;
        this.employeeID = employeeID;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
        this.phone = phone;
        this.password = password;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getEmployeeID()
    {
        return employeeID;
    }

    public void setEmployeeID(int employeeID)
    {
        this.employeeID = employeeID;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    public int getPhone()
    {
        return phone;
    }

    public void setPhone(int phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return "+--------------------------------------------+"
                + "\nName: " + name 
                + "\nEmployee ID: " + employeeID 
                + "\nDate Of Birth: " + dateOfBirth 
                + "\nEmail Address: " + emailAddress 
                + "\nPhone: " + phone +
                "\n+--------------------------------------------+";
    }
    
    @Override
    public Employeee clone()
	{
		Employeee clone = new Employeee(this.name, this.employeeID, this.dateOfBirth, this.emailAddress, this.phone, this.password);
		return clone;
	}

}
