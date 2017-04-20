## The Continent, Country Name, District, City Name and City Population of for all cities with a population of over 3 million people. 
## Sort the results by Continent, Country Name, District and City Name.

SELECT cn.Continent "Continent", cn.Name "Country Name", cy.District "City District", cy.Population "Population"
FROM Country cn, City cy
WHERE cy.Population > 3000000
AND cn.Code = cy.countryCode
order by cn.Continent, cn.Name, cy.District, cy.name asc; 



## The Country Name, Language percentage, and population for all countries where English is the official language. 
	## Sort the results by descending percentage .


SELECT cn.Name "Country Name", cl.Percentage "Language Percentage", cn.Population "Population"
FROM Country cn, CountryLanguage cl
WHERE cl.IsOfficial = TRUE 
AND cl.Language = "English"
AND cl.CountryCode = cn.Code
order by cl.Percentage desc; 


## The Life Expectancy, Country Population, Country Name, Head of State and Official Language of countries with more than 
	##100 million people. Sort the results by Life Expectancy, Population.

SELECT cn.LifeExpectancy "Life Expectancy", cn.Population "Population", cn.Name "Country Name", cn.HeadOfState "Head of State", cl.Language "Official Language"
FROM Country cn, CountryLanguage cl
WHERE cl.IsOfficial = TRUE 
AND cn.Population > 100000000
AND cl.CountryCode = cn.Code
order by cn.LifeExpectancy, cn.Population asc;



## The Country Name and Capital City of countries with surface area greater than 2 million.

SELECT cn.Name "Country Name" , cn.Capital "Capital City"
FROM Country cn 
WHERE SurfaceArea > 2000000;

## The Country Name, Independence Year, Capital City Name, Language, Language Percentage, with Independence Year > 1991. 
		## Sort the results by country name ascending and language percentage Descending.

SELECT cn.Name "Country Name" , cn.IndepYear "Independence Year", cn.Capital "Capital City", cl.Language "Language", cl.Percentage "Language Percentage"
FROM Country cn, CountryLanguage cl
WHERE cn.IndepYear > 1991
AND cl.CountryCode = cn.Code
order by cn.Name asc, cl.Percentage desc; 

## Write the UPDATE statement to change the US Head of State to your name as the current President.
SELECT * FROM Country WHERE Code = "USA";

UPDATE Country 
SET HeadOfState = "Corey Acri"
WHERE Code = "USA";

	## Write a select statement to show the Head of State in the database for the USA (Show the result set)

	SELECT HeadOfState "Head of State", Name "Country" FROM Country WHERE Code = "USA";

	## Write the update statement using the same where clause from (a)
	
	## Re-run the select from (a) to show your update