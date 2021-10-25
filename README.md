#e-shop ecommerce project

E-shop is an ecommerce project built with the following: Spring framework, java, mySQL and maven as a build tool. You
#Features
RestAPI that includes the following:
Add products to database
Find products by Id
Find all products
Delete product

Spring MVC with thymeleaf template engine for viewing product details
#Installation
Step1:  Clone repository
Step2:  Install dependencies: cd into the root folder and run the following comman:
`mvn install`
Step3:  Setup database: run sql script in the db folder
`src/main/resource/db/setup-db.sql`
Step4:  Run the project 
`mvn spring-boot-run`