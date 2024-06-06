-- question 1: how many suppliers
select count(*)
from suppliers;

-- Question 2: sum of all employee's salary
select sum(Salary)
from employees;

-- question 3: 
select min(UnitPrice)
from products;

-- question 4: 
select avg(UnitPrice)
from products;

-- question 5: 
select max(UnitPrice)
from products;

-- question 6: 
select SupplierID, count(*) as UnitsInStock
from products
group by SupplierID;

-- uiqestion 7: 
select SupplierID, avg(UnitPrice)
from products
group by SupplierID;

-- uqestion 8: 
select SupplierID, count(*)  nums_itemsSupplied
from products
where SupplierID 
group by SupplierID
having count(*) >=5;

-- question 9: 
SELECT 
    ProductID, 
    ProductName, 
    UnitPrice * UnitsInStock AS inventory_value
FROM 
    products
ORDER BY 
    inventory_value DESC, 
    ProductName;