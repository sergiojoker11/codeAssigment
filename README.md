Java Standalone application + Spring 4.3.11 (Spring Data 1.11.7) + Hibernate 5.2.11 + HSQLDB 2.4.0 (in memory)

The maven build created two JAR files. One has dependendecies and the other does not. To execute it from command line, use the one with dependencies.

# codeAssigment
2nd step of a selection process

Scripts are run at ejecution time to create SQL tables and insert the information provided in the code assigment.
The order of the discounts matter (in case there is an offer applicable to the same set of products) -> the second one won't get applied. So, a product can only have an offer applied.
