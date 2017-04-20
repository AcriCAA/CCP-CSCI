-- ## ACRI EMPLOYEE DB ASSIGNMENT

-- ## Employee Number, Name (Last, first) AS name, gender, salary,
-- ## department number and department name for all female department managers (4)

SELECT e.emp_no, concat(last_name, ', ' ,first_name) Name, gender, salary, d.dept_no, d.dept_name
from employees e, salaries s, dept_manager dm, departments d
WHERE e.emp_no = s.emp_no
AND e.emp_no = dm.emp_no
AND dm.dept_no = d.dept_no
AND current_date between dm.from_date AND dm.to_date
AND current_date between s.from_date and s.to_date
AND gender = 'F';

-- ## Employee name gender and salary with a current salary over 150,000 (15)
SELECT concat(last_name, ', ' ,first_name) Name, gender, salary
from employees e, salaries s
WHERE s.salary > 150000
AND s.to_date = '9999-01-01'
AND e.emp_no = s.emp_no;


-- ## Department name and employee name of all department managers (9)

SELECT d.dept_name Department, concat(last_name, ', ' ,first_name) Name
FROM employees e, dept_manager dm, departments d
WHERE dm.emp_no = e.emp_no
AND dm.dept_no = d.dept_no
AND dm.to_date = '9999-01-01'; 

-- ## Employee Name and title of employees that 
-- ##started in department number 'd009' between Feb 1st and 10th of 1985 (24)
SELECT concat(last_name, ', ' ,first_name) Name, title Title
FROM employees e, titles t, dept_emp de
WHERE e.emp_no = t.emp_no
AND e.emp_no = de.emp_no
AND de.from_date > '1985-01-31'
AND de.from_date < '1985-02-11'
AND t.from_date > '1985-01-31'
AND t.from_date < '1985-02-11'
AND de.dept_no = 'd009';


-- ## Count of people with birth dates greater than Jan, 1st 1965. 
-- ## Group by birth date. (31)

SELECT count(*) Count, e.birth_date "Birth Date"
FROM employees e 
WHERE e.birth_date > '1965-01-01'
group by e.birth_date;



-- ## Show total number of employees by Department Number and Department Name (4)

SELECT d.dept_name "Department Name", de.dept_no "Department Number", count(de.emp_no) "Total Number of Employees"
FROM dept_emp de, departments d 
WHERE de.dept_no = d.dept_no
GROUP BY de.dept_no;

