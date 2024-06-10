-- Question 1: add new supplier
INSERT INTO suppliers
 (
	CompanyName
)
VALUES 
(
	'New Supplier Inc'
);

-- Question 2: add new product by supplier from Q1
INSERT INTO Products 
(	
	ProductName,
    SupplierID,
    CategoryID,
    UnitPrice,
    UnitsInStock
)
VALUES
 (	
	'Soda (NP)',
    30,
    1,
    9.99,
    100
);

-- Question 3: list all products and their suppliers
SELECT 
  p.ProductName,
  s.CompanyName
FROM 
  Products p
  JOIN Suppliers s ON p.SupplierID = s.SupplierID;
  
-- Question 4: raise the price of the new product by %15
UPDATE Products
SET UnitPrice = UnitPrice * 1.15
WHERE ProductName = 'Soda (NP)';

-- Question 5: list all products and their suppliers
SELECT 
  p.ProductName,
  s.CompanyName
FROM 
  Products p
  JOIN Suppliers s ON p.SupplierID = s.SupplierID;
  
-- Question 6: delete new product
DELETE FROM Products
WHERE ProductName = 'Soda (NP)';

-- Question 6: delete new supplier
DELETE FROM suppliers
WHERE CompanyName = 'New Supplier Inc';

-- Question 7 & 8: list all products and list all suppliers
SELECT *
FROM Products;

SELECT *
FROM Suppliers;


