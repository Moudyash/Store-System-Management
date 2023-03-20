import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date ;
import java.util.Scanner ;



public class Factory extends Customer {
    
    //////مصفوفة اوبجكت من كلاس المنتجات
    int size = 0 ;

    public void Factory(){
    super.ID = 0 ;
    super.Name = null ;
    super.Address = null ;
    }
    
    public void Factory(int id , String name , String address){   
    super.ID = id ; 
    super.Name = name ; 
    super.Address = address ; 
    }
    
          
    
    @Override
    public void setID(int ID){   
    super.ID = ID ;
    }
    
    public int getID(){ 
    return  super.ID ;
    }
    
    
    public void setName(String Name ){    
    super.Name = Name ;
    }
    
    public String getName(){    
    return super.Name ;}
    
    
    public void setAddress(String Address){
        super.Address = Address ;}
    
    public String getAddress(){   
    return super.Address ; 
    }
    
    
     //////////method add new product///////////
    

    
    /////////print product/////////////

    //////////delet product/////////////    


   @Override
   public String toString(){  
   return String.format("%-3a|%-6a|-9a",this.ID, this.Name, this.Address);
   
   }
  }
