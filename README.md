Java Standalone application + Spring 4.3.11 (Spring Data 1.11.7) + Hibernate 5.2.11 + HSQLDB 2.4.0 (in memory)

The maven build created two JAR files. One has dependendecies and the other does not. To execute it from command line, use the one with dependencies.

Unix command to execute the program:

`java -jar PriceBasket-1.0-SNAPSHOT-jar-with-dependencies.jar` [Product names split by spaces]

# codeAssigment
2nd step of a selection process

Scripts are run at ejecution time to create SQL tables and insert the information provided in the code assigment.
Logger is disabled. To enable it, just toggle the last 2 lines of the file log4j.properties and generate the jar file again.
Tests are run against the production database. In order to improve this, it might be great to be able to set up the database for some scenarios.

Assumtions:
- The order of the discounts matter (in case there is an offer applicable to the same set of products) -> the second one won't get applied. So, a product can only have an offer applied.
- Offers can only have 5 items and applied to 5 items.
