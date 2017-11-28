/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

/**
 *
 * @author user
 */
public class contractor extends Employeee {

  
    
    public contractor(String name, int employeeID, String dateOfBirth, String emailAddress, int phone, String password, Double hoursWorked, Double hourlyRate) {
        super(name, employeeID, dateOfBirth, emailAddress, phone, password);
    }

}
