/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import groupproject.Message.Priority;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Roshen
 */
public class GroupProject
{

    public static void main(String[] args) throws FileNotFoundException
    {
        MessageStore messageStore = new MessageStore();
        EmployeeStoree employeeStoree = new EmployeeStoree();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("       Adminstrator Login       ");
        System.out.println("--------------------------------");
        String userInput,passInput;
        System.out.print("Username: ");
        userInput = keyboard.nextLine();
        System.out.print("Password: ");
        passInput = keyboard.nextLine();
        boolean validateAdminLogin = messageStore.adminstratorLogin(userInput,passInput);
       // boolean validateAdminLogin = true; //TEMP 

        //messageStore.loadMessageList(); //PreData for testing purposes
        //employeeStore.loadEmployeeList();
        employeeStoree.loadData("employees.txt");
        messageStore.loadData("messages.txt");
        if (validateAdminLogin)
        {
            int mainOption = -1;
            do
            {
                System.out.println("--------------------------------");
                System.out.println("          Main Option           ");
                System.out.println("--------------------------------");
                System.out.println(" Option:                        ");
                System.out.println("|        1. Employees          |");
                System.out.println("|        2. Emails             |");
                System.out.println("|        0. Exit               |");
                System.out.println("--------------------------------");
                System.out.print(" Select option: ");
                mainOption = keyboard.nextInt();

                switch (mainOption)
                {
                    case 1:
                        int employOptions = -1;
                        do
                        {
                            System.out.println("==============================================================");
                            System.out.println("|                    EMPLOYEES MENU                          |");
                            System.out.println("==============================================================");
                            System.out.println("| Options:                                                   |");
                            System.out.println("|        1. Display all info on employees                    |");
                            System.out.println("|        2. Add an employee                                  |");
                            System.out.println("|        3. Return Specific employee details by name         |");
                            System.out.println("|        4. Return all employee names in a list              |");
                            System.out.println("|        5. Edit employee details                            |");
                            System.out.println("|        0. To Exit                                          |");
                            System.out.println("==============================================================");
                            System.out.print(" Select option: ");
                            employOptions = keyboard.nextInt();

                            switch (employOptions)
                            {
                                case 1:
                                    //employeeStore.displayEmployeeList();
                                    employeeStoree.displayEmployeeList();
                                    break;
                                case 2:
                                    employeeStoree.addEmployee();
                                    break;
                                case 3:
                                    System.out.print("Enter name: ");
                                    keyboard.nextLine();
                                    String name = keyboard.nextLine();
                                    ArrayList<Employeee> i = employeeStoree.returnSpecificEmployee(name);
                                    employeeStoree.displaySpecificList(i);
                                    break;
                                case 4:
                                    ArrayList<String> n = employeeStoree.returnEmployeeList();
                                    System.out.println(Arrays.toString(n.toArray()));
                                    break;
                                case 5:
                                    // employeeStoree.loadEmployeeList(); //TESTING PURPOSES
                                    System.out.print("Enter ID: ");
                                    int id = keyboard.nextInt();
                                    employeeStoree.editEmployee(id);
                                    break;
                                case 0:
                                    employeeStoree.writeData("employees.txt");
                                    break;
                            }

                        } while (employOptions != 0);
                        break;

                    case 2:
                        int mailOptions = -1;
                        do
                        {
                            System.out.println("==============================================================");
                            System.out.println("|                       EMAIL MENU                           |");
                            System.out.println("==============================================================");
                            System.out.println("| Options:                                                   |");
                            System.out.println("|        1. Send An Email                                    |");
                            System.out.println("|        2. Print All Email                                  |");
                            System.out.println("|        3. Display specific message by ID                   |");
                            System.out.println("|        4. Display specific message by From Email           |");
                            System.out.println("|        5. Display specific message by To Email             |");
                            System.out.println("|        6. Display message by Priority                      |");
                            System.out.println("|        7. Display message by Substring                     |");
                            System.out.println("|        8. Display message by Date                          |");
                            System.out.println("|        9. Sorted Array by ID                               |");
                            System.out.println("|        10. Sorted Array by Date                            |");
                            System.out.println("|        0. To Exit                                          |");
                            System.out.println("==============================================================");
                            System.out.print(" Select option: ");
                            mailOptions = keyboard.nextInt();

                            switch (mailOptions)
                            {
                                case 1:
                                    //Add new message
                                    System.out.print("From: ");
                                    keyboard.nextLine();
                                    String fromAddress = keyboard.nextLine();

                                    System.out.print("To: ");
                                    String toAddress = keyboard.nextLine();

                                    System.out.print("Subject: ");
                                    String subject = keyboard.nextLine();
                                    
                                    System.out.print("Priority (Low/Medium/High): ");
                                    String prior = keyboard.nextLine();
                                    Priority priority = Priority.valueOf(prior.toUpperCase());

                                    System.out.print("Message: ");
                                    String messageBody = keyboard.nextLine();
//                                    if
                                    messageStore.addMessage(fromAddress, toAddress, subject, priority, messageBody);
                                    break;
                                case 2:
                                    //Printing all the messages in the Array
                                    messageStore.printAllMessage();
                                    break;
                                case 3:
                                    System.out.print("Enter ID: ");
                                    int id = keyboard.nextInt();
                                    ArrayList<Message> i = messageStore.specificMessageByID(id);
                                    System.out.println(Arrays.toString(i.toArray()));
                                    break;
                                case 4:
                                    System.out.print("Enter FROM email: ");
                                    String fromEmail = keyboard.next();
                                    ArrayList<Message> fromMailStorer = messageStore.specificMessageByEmail(fromEmail, mailOptions);
                                    System.out.println(Arrays.toString(fromMailStorer.toArray()));
                                    break;
                                case 5:
                                    System.out.print("Enter TO email: ");
                                    String toEmail = keyboard.next();
                                    ArrayList<Message> toMailStorer = messageStore.specificMessageByEmail(toEmail, mailOptions);
                                    System.out.println(Arrays.toString(toMailStorer.toArray()));
                                    break;
                                case 6:
                                    System.out.print("Enter Priority: ");
                                    String priorty = keyboard.next();
                                    Priority priorities = Priority.valueOf(priorty);
                                    ArrayList<Message> priorBank = messageStore.specificMessageByPriority(priorities);
                                    System.out.println(Arrays.toString(priorBank.toArray()));
                                    break;
                                case 7:
                                    System.out.print("Enter String: ");
                                    String subString = keyboard.next();
                                    ArrayList<Message> stringBank = messageStore.specificMessageBySubstring(subString);
                                    System.out.println(Arrays.toString(stringBank.toArray()));
                                    break;
                                case 8:
                                    System.out.print("Enter Date: ");
                                    String date = keyboard.next();
                                    ArrayList<Message> dateBank = messageStore.specificMessageByDate(date);
                                    System.out.println(Arrays.toString(dateBank.toArray()));
                                    break;
                                case 9:
                                    System.out.print("Sorted Array by ID");
                                    ArrayList<Message> dataBank = messageStore.arrayList();
                                    Collections.sort(dataBank, new MessageStore.OrderByID());
                                    System.out.println(Arrays.toString(dataBank.toArray()));
                                    break;
                                case 10:
                                    System.out.print("Sorted Array by Date");
                                    dataBank = messageStore.arrayList();
                                    Collections.sort(dataBank, new MessageStore.OrderByDate()); //NOT WORKING
                                    System.out.println(Arrays.toString(dataBank.toArray()));
                                    break;
                                case 0:
                                    messageStore.writeData("messages.txt");
                                    break;

                            }
                        } while (mailOptions != 0);
                        break;
                }

            } while (mainOption != 0);

        }
    }
}
