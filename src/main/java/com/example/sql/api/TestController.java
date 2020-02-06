package com.example.sql.api;

import com.example.sql.model.entity.*;
import com.example.sql.services.*;
import com.github.javafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class TestController {
    private final CategoryService categoryService;
    private final CustomerService customerService;
    private final EmployeeService employeeService;
    private final OrdersService ordersService;
    private final ProductsService productsService;
    private final ShippersService shippersService;
    private final SuppliersService suppliersService;


    Integer rand = new Random().nextInt(15 + 1);
    double min = 1.50d;
    double max = 100.12d;
    double random = new Random().nextDouble();
    Faker faker = new Faker();

    public TestController(CategoryService categoryService, CustomerService customerService,
                          EmployeeService employeeService, OrdersService ordersService,
                          ProductsService productsService, ShippersService shippersService,
                          SuppliersService suppliersService) {
        this.categoryService = categoryService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.ordersService = ordersService;
        this.productsService = productsService;
        this.shippersService = shippersService;
        this.suppliersService = suppliersService;
    }


    @PostMapping("/addBase")
    public void addBase() {
        for (int i = 0; i < 50; i++) {
            Category category = new Category();
            Customer customer = new Customer();
            Employee employee = new Employee();
            Orders order = new Orders();
            Products product = new Products();
            Shippers shipper = new Shippers();
            Suppliers supplier = new Suppliers();


            double drand = min + (random * (max - min));
            String shipname = faker.funnyName().name();
            String name = faker.name().fullName();
            String supplierName = faker.name().fullName();
            String fname = faker.name().firstName();
            String lname = faker.name().lastName();
            String funnyname = faker.funnyName().name();
            String funnyname2 = faker.funnyName().name();
            Date birthdate = faker.date().birthday();
            String country = faker.country().name();
            String country2 = faker.country().name();
            String address = faker.address().fullAddress();
            String address2 = faker.address().fullAddress();

            String city = faker.country().capital();
            String city2 = faker.country().capital();
            String postalCode = faker.country().countryCode2();
            String postalCode2 = faker.country().countryCode3();
            String food = faker.commerce().productName();
            String food2 = faker.commerce().productName();
            String unit = faker.commerce().productName();
            double price2 = drand;
            String phone = faker.phoneNumber().phoneNumber();
            String phone2 = faker.phoneNumber().phoneNumber();

            String sentence = faker.lorem().sentence(rand);
            String word = faker.lorem().word();
            String lorem = faker.lorem().characters(2);


            customer.setCustomerName(name);
            customer.setContactName(funnyname);
            customer.setAddress(address);
            customer.setCity(city);
            customer.setPostalCode(postalCode);
            customer.setCountry(country);
            customerService.save(customer);

            category.setCategoryName(food);
            category.setDescription(sentence);
            categoryService.save(category);

            employee.setFirstName(fname);
            employee.setLastName(lname);
            employee.setBirthDate(birthdate);
            employee.setPhoto(word);
            employee.setNotes(lorem);
            employeeService.save(employee);

            shipper.setShipperName(shipname);
            shipper.setPhone(phone);
            shippersService.save(shipper);

            supplier.setSupplierName(supplierName);
            supplier.setContactName(funnyname2);
            supplier.setAddress(address2);
            supplier.setCity(city2);
            supplier.setPostalCode(postalCode2);
            supplier.setCountry(country2);
            supplier.setPhone(phone2);
            suppliersService.save(supplier);

            product.setProductName(food2);
            product.setUnit(unit);
            product.setPrice(price2);
            product.setCategory(category);
            product.setSuppliers(supplier);
            productsService.save(product);

        }
    }

    @GetMapping("/addOrders")
    public void addOrders() {

        try {


            Date orderDate = faker.date().birthday();
            List<Products> products = (List<Products>) productsService.listAll();
            Customer customer = customerService.getById(13);
            Shippers shipper = shippersService.getById(34);
            Employee employee = employeeService.getById(27);
            Orders order = new Orders();
            Random random = new Random();
            int rand = 1 + random.nextInt(20) % 20;
            int quantity = 5 + random.nextInt(30) % 30;

            order.setOrderDate(orderDate);
            order.setCustomer(customer);
            order.setEmployee(employee);
            order.setShippers(shipper);
            List<OrderDetails> orderDetails = new ArrayList<>();
            for (int k = 0; k < rand; k++) {
                OrderDetails details = new OrderDetails();
                details.setProduct(products.get(k));
                details.setQuantity(quantity);
                details.setOrders(order);
                orderDetails.add(details);
            }
            order.setOrderDetails(orderDetails);
            ordersService.save(order);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
