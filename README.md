# First Simple Hibernate Demo (**Annotation-Version**)
## Course "Hibernate Fundamentals for Absolute Beginners" on Udemy



Used the latest versions of hibaernate-core and mysql-connector-java (5.4.1.Final and 8.0.14 at the time).

## SQL - MySQL-DB is used in the Course

#### SQL to create the DataBase:
`CREATE DATABASE bookdb;`<br><br>
`CREATE TABLE 'book'`<br>`(`<br>
  `'id' int(11) NOT NULL,`<br>
  `'book_name' varchar(100) DEFAULT NULL,`<br>
  `'book_author' varchar(100) DEFAULT NULL,`<br>
  `PRIMARY KEY ('id')`<br>
`);`
<br><br>
Change the Hibernate-Config-File (src/main/resoures/hibernate.cfg.xml) according to your DB-Settings. Esp. the username and password lines ;-)
<br><br>
## Hibernate
Mapping is shown using annotations.
Annotations being covered later in the Course.
<br><br>
`@GeneratedValue(strategy=GenerationType.IDENTITY)`<br>
You have to set auto-increment on the id column for this to work, if you use the database created up there use:<br>
`ALTER TABLE book MODIFY COLUMN id INT auto_increment;`<br>

### Database changes via Hibernate
Hibernate can create, update or validate the database schema for you.<br>
First thing for this to work chang the "dialect" line according to the version of the database you are using. For mysql 4 and lower you can leave the 
>`<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>`

line as it is. For Verion 5 and higher use
>`<property name="hibernate.dialect">org.hibernate.dialect.MySQL` **5**`Dialect</property>`

Now you can enter a new line in the .cfg-file like

>`<property name="hibernate.hbm2ddl.auto">create</property>`

So the list of possible values for the property are,

* `validate`: validate the schema, makes no changes to the database.
* `update`: update the schema.
* `create`: creates the schema, destroying previous data.
* `create-drop`: drop the schema when the SessionFactory is closed explicitly, typically when the application is stopped.


### Problem with Timezone
Going strictly by the course i got the following errormessage:<br>
>`ERROR: The server time zone value 'Mitteleuropäische Zeit' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.`<br>

Adding: `?serverTimezone=UTC`<br>
to the line: `<property name="hibernate.connection.url">jdbc:mysql://localhost/bookdb</property>` <br>
in `hibernate.cfg.xml` works for now as a quick and dirty fix. So the complete line reads now:<br>
>`<property name="hibernate.connection.url">jdbc:mysql://localhost/bookdb?serverTimezone=UTC</property>`




