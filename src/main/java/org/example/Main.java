package org.example;

import com.mysql.cj.conf.PropertyDefinitions;
import org.example.manager.CategoryManager;
import org.example.manager.ProductManager;
import org.example.model.Category;
import org.example.model.Product;

import java.util.Scanner;

public class Main implements Commands {
    private static ProductManager productManager = new ProductManager();
    private static CategoryManager categoryManager = new CategoryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_CATEGORY:
                    addCategory();
                    break;
                case EDIT_CATEGORY_BY_ID:
                    editCategory();
                    break;
                case DELETE_CATEGORY_BY_ID:
                    deleteCategory();
                    break;
                case ADD_PRODUCT:
                    addProduct();
                    break;
                case EDIT_PRODUCT_BY_ID:
                    editProduct();
                    break;
                case DELETE_PRODUCT_BY_ID:
                    deleteProduct();
                    break;
                case PRINT_SUM_OF_PRODUCTS:
                    printSum();
                    break;

                case PRINT_MAX_OF_PRICE_PRODUCT:
                    printMax();
                    break;
                case PRINT_MIN_OF_PRICE_PRODUCT:
                    printMin();
                    break;
                case PRINT_AVG_OF_PRICE_PRODUCT:
                    printAvg();
                    break;
                default:
                    System.out.println("WRONG COMMAND: TRY AGAIN!!");
            }
        }
    }

    private static void addCategory() {
        System.out.println("Please input category name");
        String name = scanner.nextLine();
        Category category = new Category(name);
        categoryManager.add(category);
    }

    private static void editCategory() {
        System.out.println("Please input category id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input category name");
        String name = scanner.nextLine();
        Category category = new Category(id, name);
        categoryManager.updateCategory(category);
    }

    private static void deleteCategory() {
        System.out.println("Please input category id");
        int id = Integer.parseInt(scanner.nextLine());
        categoryManager.deleteCategoryById(id);
    }

    private static void addProduct() {
        System.out.println("Please input product name");
        String name = scanner.nextLine();
        System.out.println("Please input product description");
        String description = scanner.nextLine();
        System.out.println("Please input product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("PLease input product quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input product categoryId");
        int categoryId = Integer.parseInt(scanner.nextLine());
        Product product = new Product(name, description, price, quantity, categoryId);
        productManager.add(product);
    }

    private static void editProduct() {
        System.out.println("Please input product new id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input product new name");
        String name = scanner.nextLine();
        System.out.println("Please input product new description");
        String description = scanner.nextLine();
        System.out.println("Please input new price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input new quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Please input new categoryId");
        int categoryId = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, description, price, quantity, categoryId);
        productManager.updateProduct(product);
    }

    private static void deleteProduct() {
        System.out.println("Please input product id");
        int id = Integer.parseInt(scanner.nextLine());
        productManager.deleteProductById(id);
    }

    private static void printSum() {
        int sum = productManager.getProductCount();
        System.out.println(sum);
    }

    private static void printMax() {
        double max = productManager.getMaxPrice();
        System.out.println(max);
    }

    private static void printMin() {
        double min = productManager.getMinPrice();
        System.out.println(min);
    }

    private static void printAvg() {
        double avg = productManager.getAVGPrice();
        System.out.println(avg);
    }
}