-- Question 1: list productId, name, unit price and category name of all products. order by category name and within that by product name

select p.ProductId, p.ProductName, p.UnitPrice, categoryName
from products p
join 
categories c ON p.categoryId = c.categoryId
order by c.CategoryName, p.ProductName;

-- Question 2:  list ProductId, ProductName, UnitPrice and CategoryName  and supplier name of all products that cost more than $75. order by product name.
select p.ProductId, p.ProductName,
 p.UnitPrice, c.CategoryName, 
 s.CompanyName as 'SupplierName'
from
 Products p
join 
Categories c ON p.CategoryId = c.CategoryId
join Suppliers s ON p.SupplierId = s.SupplierId
where
 p.UnitPrice > 75
Order by p.ProductName;


-- Question 3:  list ProductId, ProductName, UnitPrice and CategoryName  and supplier name of every products. order by product name.
select p.ProductId,
 p.ProductName, p.UnitPrice,
 c.CategoryName,
 s.CompanyName as 'SupplierName'
from 
Products p
join 
Categories c ON p.CategoryId = c.CategoryId
join 
Suppliers s ON p.SupplierId = s.SupplierId
Order by p.ProductName;


-- Question 4: 
select 
  p.ProductName, 
  c.CategoryName,
  p.UnitPrice
from
  Products p
  join Categories c ON p.CategoryID = c.CategoryID
where
  p.UnitPrice = (select max(UnitPrice) from Products);
  
  
  -- Question 5: list the order id ship name ship address and shipping company name of every order that shipped to Germany
  select 
  o.OrderID,
  o.ShipName,
  o.ShipAddress,
  o.ShipCountry,
  s.CompanyName as 'ShippingCompanyName'
  
from
  Orders o
  join Shippers s on o.ShipVia = s.ShipperID
where 
  o.ShipCountry = 'Germany';
  
  -- Question 6: list the order id ship name ship address and order date of all orders that ordered "Sasquatch Ale"
  select
  o.OrderID,
  o.ShipName,
  o.ShipAddress,
  o.OrderDate,
  p.ProductName
from 
  Orders o
  join `order details`  od on o.OrderID = od.OrderID
  join Products p on od.ProductID = p.ProductID
where 
  p.ProductName = 'Sasquatch Ale';
