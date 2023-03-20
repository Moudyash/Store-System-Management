
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mian {
    public static void main(String[] args) throws IOException {
        List<Product2> products = new ArrayList<>();
        boolean exitProductsMenu = false;
        while (!exitProductsMenu) {
        System.out.println(" please Select operation from below List : ");
        System.out.println(" 1- Products .");
        System.out.println(" 2- Customers .");
            System.out.println(" 3- Exit .");

            Scanner input = new Scanner(System.in);
        System.out.print(">>>");
        switch (input.nextInt()) {
            case 1:
                product2();
                break;
            case 2:
                customer();
                break;
            case 3: exitProductsMenu=true; break;
            default:
                System.out.println(" please Select correct  Option ");

                break;
        }
        }

    }

    private static void customer() throws IOException {
        Scanner input = new Scanner(System.in);
        ShowProduct Mystore = new ShowProduct(" My Store");
        System.out.println("              " + Mystore.Name);
        System.out.println(" ------------------------------------ ");
        System.out.println(" please Select operation from below List : ");
        System.out.println(" 1- Add a new customer .");
        System.out.println(" 2- Delet a new customer .");
        System.out.println(" 3- Modify a new customer's information .");
        System.out.println(" 4- Print the customer's information .");
        System.out.println(" 5- Exit .");
        System.out.print(">>>");
        int selection1 = 0;
        int selection2 = 0;
        int selection3 = 0;
        int selection4 = 0;

        try {
            while (selection1 != 5) {
                outer:
                {
                    selection1 = input.nextInt();

                    switch (selection1) {

                        case 1:
                            Mystore.addCust();

                            System.out.println(" please Select Another Option ");
                            break;
                        case 2:
                            System.out.print(" enter id :");
                            String num = input.next();
                            int id = Integer.parseInt(num);
                            Mystore.delete_cust(id);
                            System.out.println(" please Select Another Option ");
                            break;
                        case 3:
                            System.out.println("---------------------------------------");
                            System.out.println("sub menu : ");
                            System.out.println(" 1- Individual customer ");
                            System.out.println(" 2- Factory customer ");
                            System.out.println(" 3- Exit from sub menu ");
                            System.out.print(" >>> ");
                            selection2 = input.nextInt();
                            switch (selection2) {
                                case 1:
                                    System.out.println(" enter Individual id >>>");
                                    num = input.next();
                                    id = Integer.parseInt(num);
                                    Mystore.modify_ind(id);
                                    break outer;


                                case 3:
                                    break outer;
                                default:
                                    System.out.println(" Not a Valid Selection !!!");
                                    break outer;
                            }

                        case 4:
                            System.out.println("-------------------------------------");
                            System.out.println("sub menu :");
                            System.out.println(" 1- A Specific customer ");
                            System.out.println(" 2- All individual customers ");
                            System.out.println(" 3- All Factory customers ");
                            System.out.println(" 4- All customers ");
                            System.out.println(" 5- Exit from sub menu ");
                            System.out.print(" >>> ");

                            selection4 = input.nextInt();
                            switch (selection4) {
                                case 1:
                                    System.out.print(" enter id >>>");
                                    num = input.next();
                                    id = Integer.parseInt(num);
                                    Mystore.print_spec_cust(id);
                                    break outer;
                                case 2:
                                    Mystore.print_ind_cust();
                                    break outer;
                                case 3:
                                    Mystore.print_fac_cust();
                                    break outer;
                                case 4:
                                    Mystore.print_all();

                                    break outer;
                                case 5:
                                    break outer;
                                default:
                                    System.out.println(" Not Valid Selection 4 !!!");
                                    break outer;

                            }
                        case 5:
                            System.out.println(" Good bye ^_^ ");

                            System.exit(0);
                            break;
                        default:
                            System.out.println(" Not a Valid Selection");
                            break;
                    }
                }

                System.out.println(" ---------------------------------------------");
                System.out.println(" please select operation in main menu : >>>");
            }
        } catch (Exception e) {
            System.out.println("  !!!" + e.getMessage());
        } finally {
            input.close();
        }

    }

    private static void product2() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        boolean exit = false;

        do {
            System.out.println(" ------------------------------------ ");
            System.out.println(" please Select operation from below List : ");
            System.out.println(" 1- Add a new Product .");
            System.out.println(" 2- Delete a  product .");
            System.out.println(" 3- Modify a product's information .");
            System.out.println(" 4- Get all products .");
            System.out.println(" 5- Save data .");
            System.out.println(" 6- Exit .");
            System.out.println(" 7 - Back to main menu");
            System.out.print(">>>");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {

//                    System.out.println("Enter the  id");
//                    int productId = scanner.nextInt();
//                    System.out.println("Enter the  name");
//                    scanner.nextLine();
//                    String productName = scanner.nextLine();
//
//                    System.out.println("Enter the  price");
//                    float productprice = scanner.nextFloat();
//                    System.out.println("Enter the  offer");
//                    float productoffer = scanner.nextFloat();
//                    System.out.println("Enter the date of availability (dd/mm/yyyy):");
//                    scanner.nextLine();
//                    String productdate = scanner.nextLine();
//                    Product2 newProduct = new Product2(productId, productName, productprice, productoffer, productdate);

                    productManager.addProduct(scanner);
                }
                break;
                case 2: {

                    // Delete a product
                    System.out.println("Enter the  id of the product ");
                    int deletedproductId = scanner.nextInt();
                    productManager.deleteProduct(deletedproductId);
                }
                break;
                case 3: {
                    System.out.println("Enter the ID of the product you want to update:");
                    int productId = scanner.nextInt();
                    System.out.println("Enter the new id");
                    int newproductId = scanner.nextInt();
                    System.out.println("Enter the new name");
                    scanner.nextLine();
                    String newproductName = scanner.nextLine();

                    System.out.println("Enter the new price");
                    float newproductprice = scanner.nextFloat();
                    System.out.println("Enter the new offer");
                    float newproductoffer = scanner.nextFloat();
                    System.out.println("Enter the new date");
                    scanner.nextLine();
                    String newproductdate = scanner.nextLine();
                    Product2 updated = new Product2(newproductId, newproductName, newproductprice, newproductoffer, newproductdate);

                    Product2 product = productManager.updateProduct(productId, updated);
                }
                break;
                case 4: {

                    // Get all products
                    List<Product2> products = productManager.getProducts();
                    for (Product2 product : products) {
                        System.out.println(product);
                    }
                   // productManager.readProductsFromFile();
                }
                break;
                case 5:
                    productManager.writeProductsToFile();
                    break;
                case 6:
                    System.out.println("Do you want to save data before Exit (Y/N)?");
                    scanner.nextLine();
                    String exituser = scanner.nextLine();
                    switch (exituser.charAt(0)) {
                        case 'y':
                            productManager.writeProductsToFile();
                            exit = true;

                            break;
                        case 'n': {
                            exit = true;
                            break;
                        }
                        default:
                            System.out.println("Invalid Choice");
                    }

                    break;
                case 7: exit=true;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (!exit);
    }


}

