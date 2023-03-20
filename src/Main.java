//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Main {
//        private String customerFile = "customers.txt";
//
//        private String productFile = "products.txt";
//        private ArrayList<Customer> customers = new ArrayList<Customer>();
//        private ArrayList<Product> products = new ArrayList<Product>();
//        private Scanner scanner = new Scanner(System.in);
//
//        public static void main(String[] args) {
//                Main store = new Main();
//                store.loadCustomers();
//                store.loadProducts();
//                store.run();
//        }
//
//        public void run() {
//                boolean running = true;
//                while (running) {
//                        System.out.println("\n=== Store Menu ===");
//                        System.out.println("1. List Customers");
//                        System.out.println("2. Add Customer");
//                        System.out.println("3. List Products");
//                        System.out.println("4. Add Product");
//                        System.out.println("5. Exit");
//                        System.out.print("Enter an option: ");
//                        String option = scanner.nextLine();
//                        switch (option) {
//                                case "1":
//                                        listCustomers();
//                                        break;
//                                case "2":
//                                        addCustomer();
//                                        break;
//                                case "3":
//                                        listProducts();
//                                        break;
//                                case "4":
//                                        addProduct();
//                                        break;
//                                case "5":
//                                        running = false;
//                                        break;
//                                default:
//                                        System.out.println("Invalid option. Please try again.");
//                                        break;
//                        }
//                }
//                saveCustomers();
//                saveProducts();
//        }
//
//        public void loadCustomers() {
//                try {
//                        File file = new File(customerFile);
//                        Scanner scanner = new Scanner(file);
//                        while (scanner.hasNextLine()) {
//                                String[] data = scanner.nextLine().split(",");
//                                Customer customer = new Customer(data[0], data[1]);
//                                customers.add(customer);
//                        }
//                        System.out.println("Customers loaded.");
//                } catch (FileNotFoundException e) {
//                        System.out.println("No customers found.");
//                }
//        }
//
//        public void loadProducts() {
//                try {
//                        File file = new File(productFile);
//                        Scanner scanner = new Scanner(file);
//                        while (scanner.hasNextLine()) {
//                                String[] data = scanner.nextLine().split(",");
//                                Product product = new Product(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
//                                products.add(product);
//                        }
//                        System.out.println("Products loaded.");
//                } catch (FileNotFoundException e) {
//                        System.out.println("No products found.");
//                }
//        }
//
//        public void saveCustomers() {
//                try {
//                        FileWriter writer = new FileWriter(customerFile);
//                        for (Customer customer : customers) {
//                                writer.write(customer.getName() + "," + customer.getEmail() + "\n");
//                        }
//                        writer.close();
//                        System.out.println("Customers saved.");
//                } catch (IOException e) {
//                        System.out.println("Error saving customers.");
//                }
//        }
//
//        public void saveProducts() {
//                try {
//                        FileWriter writer = new FileWriter(productFile);
//                        for (Product product : products) {
//                                writer.write(product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "\n");
//                        }
//                        writer.close();
//                        System.out.println("Products saved.");
//                } catch (IOException e) {
//                        System.out.println("Error saving products.");
//                }
//        }
//
//        public void listCustomers() {
//                System.out.println("\n=== Customer List ===");
//                for (Customer customer : customers) {
//                        System.out.println(customer);
//                }
//        }
//
//        public void addCustomer() {
//                System.out.print("\nEnter customer name: ");
//                String name = scanner.nextLine();
//                System.out.print("Enter customer email: ");
//                String email = scanner.nextLine();
//                Customer customer = new Customer(name, email);
//                customers.add(customer);
//                System.out.println("Customer added.");
//        }
//
//        public void listProducts() {
//                System.out.println("\n=== Product List ===");
//                System.out.printf("%-20s%-10s%-10s\n", "Name", "Price", "Quantity");
//                for (Product product : products) {
//                        System.out.printf("%-20s%-10.2f%-10d\n", product.getName(), product.getPrice(), product.getQuantity());
//                }
//        }
//        public void addProduct() {
//                System.out.print("\nEnter product name: ");
//                String name = scanner.nextLine();
//                System.out.print("Enter product price: ");
//                double price = scanner.nextDouble();
//                System.out.print("Enter product quantity: ");
//                int quantity = scanner.nextInt();
//                scanner.nextLine();
//                Product product = new Product(name, price, quantity);
//                products.add(product);
//                System.out.println("Product added.");
//        }
//
//}