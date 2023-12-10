# spring-boot-bookstore

#### pre-requisite
1. software installation /misc/software installation guide.docx
2. run script using dbeaver into postgres database  /scripts/db/V1.1.0_ddl_project.sql

####  start application
mvn install
mvn spring-boot:run

#### testing
1. after server started, use Postman.
2. import the collection into Postman, /postman-collection/bookstore.postman_collection.json
3. to test all the related API.
4. refer to unit test document :   /misc/unit_test.docx