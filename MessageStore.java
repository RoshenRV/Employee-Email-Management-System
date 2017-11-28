/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupproject;

import static groupproject.Message.Priority.HIGH;
import static groupproject.Message.Priority.LOW;
import static groupproject.Message.Priority.MEDIUM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Roshen
 */
public class MessageStore
{

    private ArrayList<Message> messageBank = new ArrayList<>();

    public MessageStore()
    {

    }

    public boolean adminstratorLogin(String userInput, String passInput)
    {
        Scanner keyboard = new Scanner(System.in);
        String username = "username", password = "password";
        boolean adminLog = false;
        int loginAttempts = 0;

        while (adminLog == false && loginAttempts != 3)
        {
            if (userInput.equals(username) && passInput.equals(password))
            {
                adminLog = true;

            }
            else
            {
                loginAttempts++;
                System.out.println("Sorry Incorrect Username or Password. Please Try Again!");
            }
            if (loginAttempts == 3)
            {
                System.out.println("-------------------------------------");
                System.out.println("3 Failed Attempts --> SYSTEM LOCKED!! \nPlease Re-run the program");
                System.out.println("-------------------------------------");
            }
        }

        return adminLog;
    }

//    public void loadMessageList()
//    {
//        messageBank.add(new Message("a@mail.com", "f@mail.com", "hello", 1997-06-12, HIGH, "hello world jones", 12345));
//        messageBank.add(new Message("a@mail.com", "b@mail.com", "hello", "08-07-13", HIGH, "hello world hillary", 6789));
//        messageBank.add(new Message("g@mail.com", "c@mail.com", "hello", "21-01-14", LOW, "hello world jones", 46852));
//        messageBank.add(new Message("g@mail.com", "d@mail.com", "hello", "19-03-15", MEDIUM, "hello world nick", 2355));
//        messageBank.add(new Message("t@mail.com", "e@mail.com", "hello", "04-08-15", HIGH, "hello world bob", 7521));
//    }

    public void loadData(String file) throws FileNotFoundException
    {
        try
        {
            File dataFile = new File(file);
            Scanner sc = new Scanner(dataFile).useDelimiter(",");

            while (sc.hasNext())
            {
                String fromAddress = sc.next();
                //System.out.println("fromAddress: " + fromAddress);

                String toAddress = sc.next();
//                System.out.println("toAddress: " + toAddress);

                String subject = sc.next();
//                System.out.println("subject: " + subject);

                String date = sc.next();
//                System.out.println("date: " + date);

                String priority = sc.next();
                Message.Priority prior=  Message.Priority.valueOf(priority.toUpperCase());
//                System.out.println("priority: " + priority);

                String messageBody = sc.next();
//                System.out.println("messageBody: " + messageBody);

                int messageID = sc.nextInt();
//                System.out.println("messageID: " + messageID);

                messageBank.add(new Message(fromAddress, toAddress, subject, date, prior, messageBody, messageID));

            }
            sc.close();
        } catch (IOException e)
        {
            
        }
        System.out.println("\nData Loaded fromt the file");
    }

    public void writeData(String outputFile)
    {
        try
        {
            PrintWriter writer = new PrintWriter(outputFile);

            for (Message e : messageBank)
            {
                writer.print(e.save() + ",");
            }
            writer.close();
        } catch (FileNotFoundException ex)
        {
            System.out.print("There was an error saving the messages");
        }

    }

    public void addMessage(String fromAddress, String toAddress, String subject, Message.Priority priority, String messageBody)
    {
        String date = date();
        int messageID = randomNumber();
        messageBank.add(new Message(fromAddress, toAddress, subject, date, priority, messageBody, messageID));
    }

    public String date()
    {
        Format formatter = new SimpleDateFormat("dd-MM-yy");
        String s = formatter.format(new Date());

        return s;
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

    // Ensure the storedEmail is unique
    public boolean idChecker(int id)
    {
        boolean check = true;
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message getMessage = messageBank.get(i);
            if (id == getMessage.getMessageID())
            {
                check = false;
            }
        }

        return check;
    }

    public void printAllMessage()
    {
        for (Message x : messageBank)
        {
            System.out.println(x);
        }
    }

    public ArrayList<Message> specificMessageByID(int msgID)
    {
        ArrayList<Message> msgs = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            int id = e.getMessageID(); // Getting the name from the object
            if (id == msgID)// Deciding if their the same
            {
                msgs.add(e);// Adding them to an arraylist
            }
        }

        return msgs;
    }

    public ArrayList<Message> specificMessageByEmail(String email, int num)
    {

        ArrayList<Message> mails = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedEmail = ""; // Getting the name from the object
            if (num == 4)
            {
                storedEmail = e.getFromAddress();
            }
            else
            {
                storedEmail = e.getToAddress();
            }

            if (storedEmail.equals(email))// Deciding if their the same
            {
                mails.add(e);// Adding them to an arraylist
            }
        }

        return mails;
    }

    public ArrayList<Message> specificMessageByPriority(Message.Priority prior)
    {
        ArrayList<Message> priorBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            Message.Priority storedPrior = e.getPriority(); // Getting the name from the object
            if (storedPrior.equals(prior))// Deciding if their the same
            {
                priorBank.add(e);// Adding them to an arraylist
            }
        }

        return priorBank;
    }

    public ArrayList<Message> specificMessageBySubstring(String prior)
    {
        ArrayList<Message> stringBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedString = e.getMessageBody(); // Getting the name from the object
            if (storedString.toLowerCase().contains(prior.toLowerCase()))// Deciding if their the same
            {
                stringBank.add(e);// Adding them to an arraylist
            }
        }

        return stringBank;
    }

    public ArrayList<Message> specificMessageByDate(String date)
    {
        ArrayList<Message> dateBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            String storedDate = e.getDate(); // Getting the name from the object
            if (storedDate.equals(date))// Deciding if their the same
            {
                dateBank.add(e);// Adding them to an arraylist
            }
        }

        return dateBank;
    }

    public ArrayList<Message> arrayList()
    {
        ArrayList<Message> dataBank = new ArrayList<Message>();
        for (int i = 0; i < messageBank.size(); i++)
        {
            Message e = messageBank.get(i); // Getting the mails object
            dataBank.add(e);

        }

        return dataBank;
    }

    public static class OrderByID implements Comparator<Message>
    {

        @Override
        public int compare(Message o1, Message o2)
        {
            return o1.getMessageID() > o2.getMessageID() ? 1 : (o1.getMessageID() < o2.getMessageID() ? -1 : 0);
        }
    }

    public static class OrderByDate implements Comparator<Message>
    {

        @Override
        public int compare(Message o1, Message o2)
        {
            return o1.getDate().compareTo(o2.getDate());
        }
    }

}
