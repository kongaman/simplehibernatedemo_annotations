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

### Problem with Timezone
Going strictly by the course i got the following errormessage:<br>
>`ERROR: The server time zone value 'Mitteleuropäische Zeit' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.`<br>

Adding: `?serverTimezone=UTC`<br>
to the line: `<property name="hibernate.connection.url">jdbc:mysql://localhost/bookdb</property>` <br>
in `hibernate.cfg.xml` works for now as a quick and dirty fix. So the complete line reads now:<br>
>`<property name="hibernate.connection.url">jdbc:mysql://localhost/bookdb?serverTimezone=UTC</property>`




