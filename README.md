## 1. Project Title:

Evergreen Bookstore ... An E-Commerce Bookstore Application


## 2. Project Description:

A complete e-commerce bookstore website that sells books using Java 17, Java Servlet, JSP, Hibernate framework and MySQL 
(It's an Eclipse project).

Functionality:

1. Customer -> register to write review / purchase books, search, view new books, view books by category, view books details and reviews,
   search, write review for books, order books, check book order status / shopping history. 

3. Adminstrator -> manage admin users, manage categories, manage books, manage customers, manage reviews (but cannot write review),
   manage orders (but cannot create orders), view statistical information.


## 3. Tech Stack: 

- Java 17
- Java JSP
- Java Servlet
- JavaServer Pages (JSP)
- JSP Standard Tag Library (JSTL)
- Apache Tomcat 10 Server
- Hibernate framework with JPA
- HTML & CSS & Bootstrap & JavaScript
- JavaScript & jQuery
- MySQL Database
- Maven
- Paypal Payments REST API 


## 4. Installation:

i. Clone the git repo

```
https://github.com/AAdewunmi/Book-Store-ECommerce-Application.git
```

ii. Open project folder

iii. Explore

😎


## 5. How To Use:

i. Set up MySQL database. I have included all the SQL queries in "src/main/java/mysql_commands/mysql_commands.txt".

-  Create Admin and Customer Users.

ii. Configure the application's connection to database in "src/main/java/META-INF/persistence.xml".
      Within "persistence.xml" add your MySQL username and password.

      
      ```
      <?xml version="1.0" encoding="UTF-8"?>
        <persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
        	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
        	version="2.1">
        	<persistence-unit name="Book-Store-ECommerce-Application">
        		<properties>
        			<property name="javax.persistence.jdbc.url"
        				value="jdbc:mysql://localhost:3306/bookstoredb?autoReconnect=true" />
        			<property name="javax.persistence.jdbc.user" value="YOUR PASSWORD" />
        			<property name="javax.persistence.jdbc.password" value="YOUR USERNAME" />
        			<property name="javax.persistence.jdbc.driver"
        				value="com.mysql.cj.jdbc.Driver" />
        			<property name="hibernate.show_sql" value="true" />
        			<property name="hibernate.format_sql" value="true" />
        		</properties>
        	</persistence-unit>
        </persistence>
      ```

iii. Run MySQL server

iv. Open project in Eclipse IDE and run on server (Apache Tomcat 10 Server)

v. View Customer landing page. URL: http://localhost:8081/BookStoreWebsite/

vi. View Admin landing page: URL: http://localhost:8081/BookStoreWebsite/admin/login.jsp


## 6. Demo

### - Admin Login:

![Admin Login ](https://github.com/user-attachments/assets/bc741368-1832-401c-a3f5-7a60eef9e351)


### - Admin Dashboard:

![Admin Dashboard ](https://github.com/user-attachments/assets/31ce0080-fddb-430c-8332-d473e8b2497f)


### - Admin Customers Management Dashboard:

![Admin Manage Customers ](https://github.com/user-attachments/assets/aaa9d924-fb34-490a-bfd6-2f7c15431612)


### - Customers Landing Page:

![Online Books Store](https://github.com/user-attachments/assets/d92183e2-b385-43d2-9a44-df32a6988123)


### - Customers Login:

![Customer Login](https://github.com/user-attachments/assets/978b3264-5595-4370-9b1a-602340910a85)


### - Customers Order History Dashboard:

![My Order History ](https://github.com/user-attachments/assets/cafbd868-77ba-478e-a30f-cdbe1c63aaf6)


## 7. Contributing:

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## 8. #TODO

i. PayPal payment integration (including credit card payment): Classes and methods for payment have been coded up but commented. 
  This has been done because a business Paypal account is required to access Paypal Payments REST API and sandbox.

ii. Use Bootstrap for responsive UI: You are welcome to refactor the project to become more responsive by using Bootstrap 
  (https://getbootstrap.com/). 


## 9. Adapted from: 

UDEMY Course Name: Java Servlet, JSP and Hibernate: Build eCommerce Website

Created by: Nam Ha Minh

Last updated: 05/2024

URL: https://www.udemy.com/course/java-servlet-jsp-and-hibernate-build-a-complete-website/
