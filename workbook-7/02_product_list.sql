-- Question 2: write a query to list the product Id, product name and unity price of every product
SELECT ProductID, ProductName, UnitPrice
FROM products;

-- Question 3: same as Q2 except order in ascending order by price 
SELECT ProductID, ProductName, UnitPrice
FROM products
ORDER BY UnitPrice ASC;


-- Question 4: what products are carried where the unit price is 7.50 or less
SELECT ProductID, ProductName, UnitPrice
FROM products
WHERE UnitPrice <= 7.50;

-- Question5: products we carry where we have at least 100 units on hand. desc order by price

SELECT ProductID, ProductName, UnitPrice, QuantityPerUnit
FROM products
WHERE QuantityPerUnit < 100 
ORDER BY UnitPrice desc;

-- Question 6: same as 5 except if two or more products have same price, list in asc order by price
SELECT ProductID, ProductName, UnitPrice, QuantityPerUnit
FROM products
WHERE QuantityPerUnit < 100 
ORDER BY UnitPrice DESC, ProductName ASC; 

-- Question7: Products we carry where no units on hand but 1 or mroe on backorder, order by productname
SELECT ProductID, ProductName, UnitPrice, UnitsOnOrder
FROM products
WHERE UnitsInStock = 0 AND UnitsOnOrder > 0 
ORDER BY ProductName;

-- Question 8: categories

-- Question 9: query thats lists all of the columns and rows of the category table. what is the seafood Id: 
-- answer: 8
SELECT *
from categories;

-- Question 10: How does it identify the type of each item sold? query to list all of the seafood items we carry 
-- has a categoryID associated to every product
SELECT ProductName, CategoryID
FROM Products
WHERE CategoryID = (
    SELECT CategoryID
    FROM Categories
    WHERE CategoryName = 'Seafood'
);

-- Question 11: first and last name of all the Nothwind Employees
select FirstName, LastName
from employees;

-- Question 12: what employees have "manager" in ther titles
SELECT FirstName, LastName, Title
from employees
WHERE Title LIKE '%Manager%';

-- Question 13: list distinct job titles in employees
select distinct Title
from employees;

-- Question 14: employeee salaries between 2000 and 2500
select EmployeeID, FirstName, Salary
from employees
where Salary between 2000 and 2500;

-- Question 15: list all info about all of northwinds suppliers
select *
from suppliers;

-- Question 16: query to list all of the items that "Tokyo traders" supplies 

SELECT ProductName, SupplierID
FROM Products
WHERE SupplierID = (
    SELECT SupplierID
    FROM suppliers
    WHERE CompanyName = 'Tokyo Traders'
);

SELECT ProductName, SupplierID
FROM Products
WHERE SupplierID = 4;
