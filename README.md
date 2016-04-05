# facility-service #

### GitHub Repository ###

https://github.com/snowreen/facility-management

### Implementation ###

I used JDBC in previous project. To change it into Hibernate ORM, I have created “hibernate.cfg.xml” which has the session factory configuration to connect to MYSQL database and all hibernate mapping file locations.

Hibernate mapping files, *.hbm.xml, specifies the mapping between Java class and the database table, also has relationships defined between classes.

HibernateMYSQLHelper class is a helper class, which initializes a static final SessionFactory object. 

All the DAOs have the methods to query database. For fetching data, I have used mostly HQL.

Now, to have loose coupling in project, I have created interfaces. Then I have added Spring beans inside “resources/META-INF/app-context.xml” and injected dependencies using “setter” methods.  For scope, most of them have “prototype” scope.

Then in FacilityClient class, I have created a static object of ApplicationContext by reading app-context.xml from classpath, so that I can get an object of a bean from applicationContext by the bean id.

### How to Run the Project ###

All spring and hibernate libraries can be found inside libs folder. Please add those in your classpath after importing in IDE.

Database DDL statements are available inside database.txt (attached with email and also available in Github https://github.com/snowreen/facility-management) . You can run it from command line using following command (change path to this file path, mysql server needs to be started before that):

mysql < {path}/database.txt

Please change mysql database username and password according to yours in hibernate.cfg.xml file.

### For Testing ###

FacilityClient.java has the main method to test this application.
