# Library Management System

With the graduation project of DRC Java Bootcamp (Kodla, Kariyerine Başla Java Bootcamp) which is a library management system, you can perform the necessary operations in the library system. The project was created in such a way that a category and an author can have more than one book (for uml diagram of the project: images/LibraryManagementSystem.png). You can add, update, search and list each of them.

## Requirements

* Java 8 or newer version
* Apache Maven
* Spring Boot 2.6.7
-----
## Technologies
* Spring Data JPA
* Lombok
* H2 Database
* ModelMapper
* Unit Test (JUnit 5)
* Rest API
-----
## H2 Database Connection
```
server.port=8098
spring.datasource.url=jdbc:h2:mem:Library-Management-System
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=fy
spring.datasource.password=734236
```
The project can be reached at http://localhost:8098/h2-console

-----
## Installation
Clone the relevant project
```
git clone https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz.git
```
-----
## Some Examples of REST API Action

<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/1.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/2.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/3.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/4.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/5.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/6.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/7.png">
<img src="https://github.com/DRC-JAVA-Bootcamp/bitirme-projesi-frtyildiz/blob/main/images/8.png">

## License
MIT


