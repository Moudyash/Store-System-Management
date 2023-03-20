public class Individual extends Customer{
    
    
    private String PhoneNumber ;
    
    
    public void Individual (int id , String name , String address , String phoneNumber){   
    super.ID = id ;
    super.Name = name ; 
    super.Address = address ;
    this.PhoneNumber = phoneNumber ;
    }
    
    
    public void setID(int ID){   
    super.ID = ID ;
    }
    
    public int getID(){  
    return super.ID ;
    }
    
    
    public void setName(String Name){  
    super.Name = Name ;
    }
    
    public String getName(){  
    return super.Name ;   }
    
    
    
    public void setAddress(String Address){  
    super.Address = Address ;  }
    
    
    public String getAddress(){  
    return super.Address ; 
    }
    
    

   public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    @Override
    public String toString(){  
    return   String.format("%-3a|%-6a|-9a|%-14a",this.ID, this.Name, this.Address , this.PhoneNumber);

    
    }
}
