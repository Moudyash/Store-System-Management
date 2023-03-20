import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;




public class Customer {
    protected int ID ; //بيانات الخاصة بالعميل
    protected String Name ; 
    protected String Address ; 
    int count ;
    public void Customer (int ID , String Name , String Address) throws IOException{   
   
    }

    
    public void setID(int ID) {
        this.ID = ID;
    }
      
    public int getID() {
        return ID;
    }

    
    public void setName(String Name) {
        if(Name.length()<=8){ 
        this.Name = Name;
        }
        else{
            System.out.print(" Wrong input for Name");}
    }
   
    public String getName() {
        return Name;
    }

    
    
  public void setAddress(String Address) {
        this.Address = Address;
    }
     
    public String getAddress() {
        return Address;
    }

   
         
         @Override
    public String toString() {//دالة طباعة لبيانات العميل 
        return "Customer{" + "ID=" + ID + ", Name=" + Name + ", Address=" + Address + '}';
    }



}
