import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

public class ShowProduct extends Customer {

    static FileWriter fw;


    static {
        try {
            fw = new FileWriter("C:\\Users\\Medo\\IdeaProjects\\untitled13\\src\\customers.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedWriter bw = new BufferedWriter(fw);
    String Name;

    Customer[] custs = null;

    int size = 0;


    public ShowProduct(String Name) throws IOException {
        this.Name = Name;

        custs = new Customer[10];
    }

    public void addCust() throws IOException {
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        fw.write(" The data of customer : \n");
        fw.write("-------------------------------------\n");
        fw.write(" ID | Name | Address \n");
        System.out.print("Type of Customer >>> 1) Indinidual or 2) Factory\n>>>");
        int selection = input1.nextInt();
        if (selection == 1) {
            Customer new_ind_cust = new Individual();
            System.out.print("please insert data of individual customer :\n");
            System.out.println("id : " + (size + 1));
            fw.write(""+size+1);
            new_ind_cust.setID(size + 1);
            System.out.print(" name : ");
            String name=input2.nextLine();
            new_ind_cust.setName(name);
            fw.write("   "+name);

            System.out.print(" address :");
            String address=input2.nextLine();

            new_ind_cust.setAddress(address);

            fw.write("   "+address);

            System.out.print(" phone number : ");
            String phonenumber=input2.nextLine();

            ((Individual) new_ind_cust).setPhoneNumber(phonenumber);
            fw.write("   "+phonenumber+"\n");

            custs[size] = new_ind_cust;
            fw.close();

            size++;
        } else if (selection == 2) {
            Customer new_fac_cust = new Factory();
            System.out.print("please insert data of factory customer : \n");
            System.out.println(" id : " + (size + 1));
            new_fac_cust.setID(size + 1);
            fw.write(size+1);
            System.out.print("name : ");
            Name=input2.nextLine();
            new_fac_cust.setName(Name);
            fw.write("   "+Name);

            System.out.print("address : ");
            Address=input2.nextLine();
            new_fac_cust.setAddress(Address);

            fw.write(            ("   "+Address));
            System.out.println("Add is Done ^_^ ");
            custs[size] = new_fac_cust;

            size++;
            closefw();
        } else {
            System.out.println("invalid selection !!!!");
        }
    }

    public static void closefw() throws IOException {
    fw.close();

    }

//////////methd

    public void print_ind_cust() {
        if (size != 0) {
            System.out.println(" The List of Individual customer : ");
            System.out.println("-------------------------------------");
            System.out.println(" ID | Name | Address | Phone Namber ");
            int count = 0;
            for (Customer var : custs) {
                if (var instanceof Individual) {
                    System.out.println(var.toString());
                    count++;
                }
            }
            System.out.println(" Total : " + count + " individual customer ");
        } else {
            System.out.println(" not found !!!");
        }
    }

    public void print_spec_cust(int id) {
        try {

            for (int i = 0; i < custs.length; i++) {
                if (id == custs[i].getID()) {
                    System.out.println(" The data of customer : ");
                    fw.write(" The data of customer : ");

                    System.out.println(" ------------------------------- ");
                    System.out.println(" ID | Name | Address | Phone Namber ");
                    System.out.println(custs[i].getID() + custs[i].getName() + custs[i].getAddress() + custs[i]);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println(" not found ");
        }
    }

    public void print_fac_cust() {
        if (size != 0) {
            System.out.println(" The List of Factory customer : ");
            System.out.println("-------------------------------------");
            System.out.println(" ID | Name | Address ");


            int count = 0;
            for (Customer var : custs) {
                if (var instanceof Factory) {
                    System.out.println(var.toString());
                    count++;
                }
            }
            System.out.println(" Total : " + count + " Factory customer ");
        } else {
            System.out.println(" not found !!!");
        }
    }

    public void print_all() throws IOException {

        if (size != 0) {
            System.out.println(" The List of Factory customer : ");

            System.out.println("-------------------------------------");
            System.out.println(" ID | Name | Address ");
            int count = 0;
            for (Customer var : custs) {
                if (var instanceof Customer) {
                    System.out.println(var.toString());
                  //  fw.write(var.Address.toString());

                    count++;
                }
            }
            System.out.println(" Total : " + count + " Factory customer ");
            fw.write(" Total : " + count + " Factory customer ");
        } else {
            System.out.println(" not found !!!");
        }
    }





    public void delete_cust(int id) {
        try {
            if (custs != null) {
                for (int i = 0; i < custs.length; i++) {
                    if (custs[i].getID() == id) {
                        custs[i] = null;
                        size--;
                        System.out.println("deleted done ^_^ ");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("not found");
        }
    }

    public void modify_ind(int id) {
        try {
            if (custs != null) {
                for (int i = 0; i < custs.length; i++) {
                    if (custs[i].getID() == id) {
                        Scanner input = new Scanner(System.in);

                        System.out.println(" id : " + (id));


                        System.out.print(" name : ");
                        custs[i].setName(input.next());
                        System.out.print(" address : ");
                        System.out.print(" address : ");
                        custs[i].setAddress(input.next());
                        System.out.print(" phone number  : ");
                        ((Individual) custs[i]).setPhoneNumber(input.next());

                        break;
                    }
                }
            }
            System.out.println(" edit done ^_^ ");
        } catch (Exception e) {
            System.out.println("not found");
        }
    }





}