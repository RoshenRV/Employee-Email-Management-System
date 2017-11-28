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
public class Message
{
    private String fromAddress;
    private String toAddress;
    private String subject;
    private String date;
    private Priority priority;
    private String messageBody;
    private int messageID;
    
    public Message()
    {
        fromAddress = "";
        toAddress = "";
        subject = "";
        date = "";
        priority = null;
        messageBody = "";
        messageID = 0; 
    }

    public Message(String fromAddress, String toAddress, String subject, String date, Priority priority, String messageBody, int messageID)
    {
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.subject = subject;
        this.date = date;
        this.priority = priority;
        this.messageBody = messageBody;
        this.messageID = messageID;
    } 
//GETTERS
    public String getFromAddress()
    {
        return fromAddress;
    }

    public String getToAddress()
    {
        return toAddress;
    }

    public String getSubject()
    {
        return subject;
    }

    public String getDate()
    {
        return date;
    }

    public Priority getPriority()
    {
        return priority;
    }

    public String getMessageBody()
    {
        return messageBody;
    }

    public int getMessageID()
    {
        return messageID;
    }

    
    //SETTERS
    public void setFromAddress(String fromAddress)
    {
        this.fromAddress = fromAddress;
    }

    public void setToAddress(String toAddress)
    {
        this.toAddress = toAddress;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    public void setMessageBody(String messageBody)
    {
        this.messageBody = messageBody;
    }

    public void setMessageID(int messageID)
    {
        this.messageID = messageID;
    }

    @Override
    public String toString()
    {
        return "+--------------------------------------------+" 
                + "\nFrom: " + fromAddress 
                + "\nTo: " + toAddress 
                + "\nSubject: " + subject 
                + "\nDate: " + date
                + "\nPriority: " + priority 
                + "\nMessageBody: " + messageBody 
                + "\nMessageID: " + messageID +
               "\n+--------------------------------------------+" ;
    }
    
   public String save()
   {
       return fromAddress+","+toAddress+","+subject+","+date+","+priority+","+messageBody+","+messageID;
   }
   
   public enum Priority
   {
       HIGH,
       MEDIUM,
       LOW
   }
}
 