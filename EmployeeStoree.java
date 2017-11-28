/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Roshen
 */
public class EmployeeStoree
{

    private ArrayList<Employeee> employeeBank = new ArrayList<>();

    public EmployeeStoree()
    {

    }

    public void loadData(String file) throws FileNotFoundException
    {
        try
        {
            File dataFile = new File(file);
            Scanner sc = new Scanner(dataFile).useDelimiter(",");

            while (sc.hasNext())
            {
                String name = sc.next();
                int employID = sc.nextInt();
                String dateOfBirth = sc.next();
                String mail = sc.next();
                int phoneNum = sc.nextInt();
                String password = sc.next();
                
                employeeBank.add(new Employeee(name, employID, dateOfBirth, mail, phoneNum, password));
                //System.out.println(str);
            }
            sc.close();
        } catch (IOException e)
        {
        }
    }

    public void writeData(String outputFile)
    {

        try
        {
            PrintWriter writer = new PrintWriter(outputFile);

            for (Employeee e : employeeBank)
            {
                writer.println(e.save());
                writer.print(",");
            }
            writer.close();
        } catch (FileNotFoundException ex)
        {
            System.out.print("There was an error saving the employees");
        }

    }

//    public void loadEmployeeList() //FOR TESTING PURPOSES
//    {
//        employeeBank.add(new Employeee("John Knox", 57447, "26-06-1964", "abcdef@gmail.com", 1234, "helloworld"));
//        employeeBank.add(new Employeee("Harry Potter", 12415, "13-04-1977", "qwer@gmail.com", 5678, "aasd"));
//        employeeBank.add(new Employeee("Danjo Butcher", 21312, "06-02-1967", "zxcv@gmail.com", 9102, "qwer"));
//        employeeBank.add(new Employeee("Bob Ridley", 12312, "17-11-1989", "asdf@gmail.com", 3456, "zxcv"));
//        employeeBank.add(new Employeee("Tom Riddle", 46664, "14-10-1987", "hello@gmail.com", 7890, "1234"));
//    }

    public void addEmployee()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = keyboard.nextLine();

        int employeeID = randomNumber();

        System.out.print("Enter Date of Birth: ");
        String dateOfBirth = keyboard.nextLine();

        System.out.print("Enter Email: ");
        String emailAddress = keyboard.nextLine();

        System.out.print("Enter Phone: ");
        int phoneNumber = keyboard.nextInt();

        System.out.print("Enter Password: ");
        keyboard.nextLine();
        String password = keyboard.nextLine();

        employeeBank.add(new Employeee(name, employeeID, dateOfBirth, emailAddress, phoneNumber, password));

    }
    
    public enum Priority 
    {
        High,
        Medium,
        Low
        
    }

    public int randomNumber()
    {
        boolean end = true;
        int id = 0;
        Random r = new Random();

        while (end)
        {
            id = r.nextInt(100009);

            if (idChecker(id))
            {
                end = !end;
            }
        }
        return id;
    }

    public boolean idChecker(int id)
    {
        boolean check = true;
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee getID = employeeBank.get(i);
            if (id == getID.getEmployeeID())
            {
                check = false;
            }
        }

        return check;
    }

    public String checkEmail(String email)
    {

        Scanner sc = new Scanner(System.in);
        boolean end = true;
        String newEmail = email;

        while (end)
        {
            if (!emailChecker(newEmail))
            {
                end = !end;
            }
            else
            {
                System.out.println("The address " + newEmail + " already exists. \n Try again");
                newEmail = sc.nextLine();
            }
        }

        return newEmail;
    }

    public boolean emailChecker(String email)
    {
        boolean check = false;
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee getEmployee = employeeBank.get(i);
            if (email.equals(getEmployee.getEmailAddress()))
            {
                check = true;
            }
        }

        return check;
    }

    // Displays all details of employees
    public void displayEmployeeList()
    {
        for (Employeee p : employeeBank)
        {
            System.out.println(p);
        }
    }

    public void displaySpecificList(ArrayList<Employeee> e)
    {
        for (Employeee p : e)
        {
            System.out.println(p);
        }
    }

    public ArrayList<String> returnEmployeeList()
    {
        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i);// Getting the employeeStorer object
            String name = e.getName();// Getting the name from the object
            names.add(name);// adding that name to an arraylist 
        }
        return names;
    }

    public ArrayList<Employeee> returnSpecificEmployee(String name)
    {
        ArrayList<Employeee> employee = new ArrayList<Employeee>();
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i); // Getting the employeeStorer object
            String ename = e.getName(); // Getting the name from the object
            if (ename.equals(name))// Deciding if their the same
            {
                employee.add(e);// Adding them to an arraylist
                System.out.println("Matched");
            }
            else
            {
                System.out.println("UNMatched");
            }
        }

        return employee;
    }
    
    public void editEmployee(int ID)
    {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Employeee> employeeStorer = new ArrayList<Employeee>();
        Employeee person = new Employeee("", 0, "", "", 0, "");
        for (int i = 0; i < employeeBank.size(); i++)
        {
            Employeee e = employeeBank.get(i); // Getting the employeeStorer object
            int employID = e.getEmployeeID(); // Getting the name from the object

            if (employID == ID)
            {
                person = e;
            }
        }
        int option = -1;
        do
        {
            System.out.println(
                    "\n 1: Edit name"
                    + "\n 2: Edit date of birth"
                    + "\n 3: Edit email address"
                    + "\n 4: Edit phone number"
                    + "\n 5: Edit password"
                    + "\n 0: Exit"
            );
            System.out.print("Select option: ");
            option = keyboard.nextInt();
            keyboard.reset();
            switch (option)
            {
                case 1:
                    System.out.println("Current name: " + person.getName());
                    System.out.print("New Name: ");

                    String bufferReleaser = keyboard.nextLine();
                    String name = keyboard.nextLine();
                    person.setName(name);
                    break;
                case 2:
                    System.out.println("Current Date of Birth: " + person.getDateOfBirth());
                    System.out.print("New Date of Birth: ");
                    String bufferReleaser2 = keyboard.nextLine();
                    String dob = keyboard.nextLine();
                    person.setDateOfBirth(dob);
                    break;
                case 3:
                    System.out.println("Current email address: " + person.getEmailAddress());
                    System.out.print("New email: ");
                    String bufferReleaser3 = keyboard.nextLine();
                    String email = keyboard.nextLine();
                    String checkedEmail = checkEmail(email);
                    person.setEmailAddress(checkedEmail);
                    break;
                case 4:
                    System.out.println("Current phone number " + person.getPhone());
                    System.out.print("New phone number: ");
                    int phone = keyboard.nextInt();
                    person.setPhone(phone);
                    break;
                case 5:
                    System.out.println("Current password " + person.getPassword());
                    System.out.print("New password: ");
                    String bufferReleaser4 = keyboard.nextLine();
                    String password = keyboard.nextLine();
                    person.setPassword(password);
                    break;
            }

        } while (option != 0);
        System.out.println("Updated Information" + "\n" + person);
    }
}
