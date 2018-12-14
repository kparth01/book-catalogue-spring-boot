# README

- Date created: 20180704

## How to submit your code assignment

1. Fork the project from GitLab.
2. Make your forked project to **private** from GitLab -> Settings -> General -> Permissions -> Project visibility.
3. Add member of **singtel_shijian** in **Select members to invite**, and choose the role permission to be **Developer** from GitLab -> Settings -> Members.
4. Complete your code and documentation in the forked project.
5. Upload your resume or CV in the root folder of the forked project.
6. Create a new plain text file in the root folder of the forked project. And make the file name in the format of "your employer + your full name", e.g. **Your Employer Name + John Doe**.
7. Update the forked project description in GitLab to "your employer + full name", e.g. **Your Employer Name + John Doe** from GitLab -> Settings -> General -> General project -> Project description.  
8. Notify the code assignment is done.

## Code assignment details

Imagine you are the software engineer who is going to design and develop a small application. The application is to provide 2 Restful APIs for Book.

The application has 1 domain model named "**Book**" The domain model is Book, which has below minimal information,

- Attribute to act as the unique identifier of a Book
- Attribute to show what the book is or what the book is about. This attribute is able to be understood by the human and has some meaning, for example, it is not a random number.

You can make the decision about the names and data type of above attributes.

Here is technical requirement for the application.

- Use **Spring framework**, you can consider to use Spring MVC (version >= 4.3.13.RELEASE) or preferably Spring Boot (version >= 1.5.9.RELEASE). If you choose to use Spring MVC, you need to provide the embedded web server to run your application alone without external web server (hints: for example, by using Jetty or Tomcat Maven plugin).
- The building tool is Maven 3 or preferably Gradle 4.
- 1 API with HTTP method POST to handle the new entry of Book or update the existing Book information. The HTTP request and response are in JSON format.
- 1 API with HTTP method GET to get the Book information by its unique identifier. The HTTP response is in JSON format.
- You need to have error handling and provide the meaningful error message and status.
- There is no database or external file storage required in this application. You shall not have the function with any kinds of database or storage, e.g. MySQL, H2, Postgresql, or MongoDB.
- Your code shall not be broke in a very simple test.
- It is no need to have complex code structure of the application, but the code shall be clear and able to be understood. The code also shall follow the Java coding standard.
- Consider having appropriate documentation in README.md and Javadoc.
- In the README.md, you need to complete the steps and commands section to show how to run your application, please keep it short and get to the point.
- In the README.md, you need to complete the test commands section by using `curl` to simulate the request for your 2 APIs. You need to provide the payload of the response.
- You need to provide the unit test.
- [**Bonus Question**] You can provide 2 or 3 more domain models to associate with the Book.

Please keep your implementation simple. It is no need to over design and over development. But the code shall be able to show your basic understanding of the design and development knowledge with MVC and Spring framework.

You can assume your implementation can be completed in 8 hours. Normally, it could be completed in 2 to 6 hours.

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


