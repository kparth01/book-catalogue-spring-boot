# README

## Steps and commands to run the application

This application is created using Spring Boot. The tomcat is embedded in the application set-up so no need to configure it separately. In order to run the application you must need to install few things as follows.

* Java 1.8 or higher
* Maven 3 or higher
* Git Bash to run the `curl` commands.

### Steps:

* Download the project to a suitable directory.
* Open the cmd on windows/mac OS command line with Admin Privilages.
* Go to the path where you downloaded/extracted the project [eg.: C:\springBoot\project].
* Build the project and run the tests by running ```mvn clean package```
* Run the project by running the command ```mvn spring-boot:run```


## API testing commands

**Note**: `id=0` means it a new record. `id` is the unique key for each record.

- To create a new book entry use following curl command. Change the details as per your requirement except the **Id**. 
```sh
curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/book/createOrUpdate -d '{"author": { "firstName": "Chetan", "id": "0", "lastName": "Bhagat" }, "bookDesc": "Love Story", "bookName": "2 states", "id": "0"}'
```

- To update an existing book entry use following curl command. Replace **id** attribute with your desired Id.
```sh
curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" http://localhost:8080/book/createOrUpdate -d '{"author": { "firstName": "Chetan", "id": "1", "lastName": "Bhaget" }, "bookDesc": "Love Story", "bookName": "2 states", "id": "1"}'
```

- To retriving a book use following curl command. Replace **1** with your desired Id to fetch other record.
```sh
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/book/view/1'
```

- The response error message when a book with certain Id id not found is as follows:
```{"errorCode":412,"message":"Book not found with Id: 599"}```

- The response error message when book Name is not provided:
```{"errorCode":412,"message":"Book name cannot be empty."}```

- For all successful cases the response will be:
```
{
  "author": {
    "firstName": "string",
    "id": 0,
    "lastName": "string"
  },
  "bookDesc": "string",
  "bookName": "string",
  "id": 0
}
```

## Swagger UI for API testing
Additionally Swagger is also included in this project for API testing. You can hit the below link for Swagger UI and API testing from browser.
```http://localhost:8080/swagger-ui.html#!/```


