mvn test

TODO:
1. Configure logback.xml (in main/resources and test/resources)
2. Change all System.out to proper logging using slf4j and logback
3. All junit methods should use appropriate assertions
4. All hard coded values of parameters should come from configuration files. 
(from test/resources and main/resources for tests and main code respectively)  
5. Implement QueryPlanExecution and QueryPlanAbstract
6. Implement query and schema classes appropriately
