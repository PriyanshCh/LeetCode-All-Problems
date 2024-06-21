# Write your MySQL query statement below
SELECT s.year AS year,
       s.price AS price, 
       p.product_name AS product_name
FROM Sales s
INNER JOIN Product p ON s.product_id=p.product_id;

