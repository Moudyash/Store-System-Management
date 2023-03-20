import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    //create arraylist off Products2
    Scanner scanner = new Scanner(System.in);

    private List<Product2> products = new ArrayList<>();
    //addproduct() method take argument Product2 and add this product to the arraylist

    public void addProduct(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter the id:");
        int productId = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                productId = Integer.parseInt(scanner.nextLine());
                if (getProductById(productId) != null) {
                    System.out.println("Error: Product with ID " + productId + " already exists. Please enter a different ID.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer ID.");
            }
        }

        System.out.println("Enter the name:");
        String productName = scanner.nextLine();

        System.out.println("Enter the price:");
        float productPrice = 0;
        validInput = false;
        while (!validInput) {
            try {
                productPrice = Float.parseFloat(scanner.nextLine());
                if (productPrice < 0) {
                    System.out.println("Error: Price must be a positive number.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid floating-point price.");
            }
        }

        System.out.println("Enter the offer:");
        float productOffer = 0;
        validInput = false;
        while (!validInput) {
            try {
                productOffer = Float.parseFloat(scanner.nextLine());
                if (productOffer < 0) {
                    System.out.println("Error: Offer must be a positive number.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid floating-point offer.");
            }
        }

        System.out.println("Enter the date of availability (dd/mm/yyyy):");
        String productDate = scanner.nextLine();

        Product2 newProduct = new Product2(productId, productName, productPrice, productOffer, productDate);
        products.add(newProduct);
        System.out.println("Product added successfully.");
    }

    public void addProducta(Product2 product) {
        // Check if the product ID is already in use
        while (getProductById(product.getID()) != null) {
            System.out.println("ID already in use. Please enter another ID.");
            product.setID(scanner.nextInt());
            scanner.nextLine(); // consume the newline character
        }
        products.add(product);
    }
    public Product2 getProductById(int productID) {
        for (Product2 product : products) {
            if (product.getID() == productID) {
                return product;
            }
        }
        System.out.println("Product with ID " + productID + " not found.");
        return null;
    }


    public ProductManager() {
        readProductsFromFile();
    }

    public void deleteProduct(int productID) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == productID) {
                products.remove(i);
                break;
            }
        }
    }

    public Product2 updateProduct(int productId, Product2 updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getID() == productId) {
                // Found the product with the given ID, update its fields
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        // If we reach here, we didn't find the product with the given ID
        System.out.println("Product with ID " + productId + " not found.");
        return updatedProduct;
    }
    public List<Product2> getProducts() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        }else  System.out.println(" ID | Name    | Price   | Offer   | Date \n");
        return products;
    }
    public void writeProductsToFile() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Medo\\IdeaProjects\\untitled13\\src\\products.txt");
            writer.write(" The List of  Products : \n");
            writer.write("-------------------------------------\n");
            writer.write(" ID | Name | Price | Offer | Date \n");
            for (Product2 product : products) {
                writer.write(product.getID() + "," + product.getName() + "," + product.getPrice() + "," + product.getOffer() + "," + product.getDateOfAvailability() + "\n");
            }
            writer.close();
            System.out.println("Products written to file.");
        } catch (IOException e) {
            System.out.println("Error writing products to file: " + e.getMessage());
        }
    }
    public void readProductsFromFile() {
        try {
            FileReader  fileReader = new FileReader ("C:\\Users\\Medo\\IdeaProjects\\untitled13\\src\\products.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            br.readLine(); // skip the first line
            br.readLine(); // skip the first line
            br.readLine(); // skip the first line

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                double offer = Double.parseDouble(parts[3]);
                String date = parts[4];
                Product2 product = new Product2(id, name, price, offer, date);
                products.add(product);
            }
            br.close();
            fileReader.close();
            System.out.println("Products loaded successfully from file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
