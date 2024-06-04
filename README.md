**Important: Don't forget to update the [Candidate README](#candidate-readme) section**

Real-time Transaction Challenge
===============================
## Overview
Welcome to Current's take-home technical assessment for backend engineers! We appreciate you taking the time to complete this, and we're excited to see what you come up with.

You are tasked with building a simple bank ledger system that utilizes the [event sourcing](https://martinfowler.com/eaaDev/EventSourcing.html) pattern to maintain a transaction history. The system should allow users to perform basic banking operations such as depositing funds, withdrawing funds, and checking balances. The ledger should maintain a complete and immutable record of all transactions, enabling auditability and reconstruction of account balances at any point in time.

## Details
The [included service.yml](service.yml) is the OpenAPI 3.0 schema to a service we would like you to create and host.

The service accepts two types of transactions:
1) Loads: Add money to a user (credit)

2) Authorizations: Conditionally remove money from a user (debit)

Every load or authorization PUT should return the updated balance following the transaction. Authorization declines should be saved, even if they do not impact balance calculation.


Implement the event sourcing pattern to record all banking transactions as immutable events. Each event should capture relevant information such as transaction type, amount, timestamp, and account identifier.
Define the structure of events and ensure they can be easily serialized and persisted to a data store of your choice. We do not expect you to use a persistent store (you can you in-memory object), but you can if you want. We should be able to bootstrap your project locally to test.

## Expectations
We are looking for attention in the following areas:
1) Do you accept all requests supported by the schema, in the format described?

2) Do your responses conform to the prescribed schema?

3) Does the authorizations endpoint work as documented in the schema?

4) Do you have unit and integrations test on the functionality?

Here’s a breakdown of the key criteria we’ll be considering when grading your submission:

**Adherence to Design Patterns:** We’ll evaluate whether your implementation follows established design patterns such as following the event sourcing model.

**Correctness**: We’ll assess whether your implementation effectively implements the desired pattern and meets the specified requirements.

**Testing:** We’ll assess the comprehensiveness and effectiveness of your test suite, including unit tests, integration tests, and possibly end-to-end tests. Your tests should cover critical functionalities, edge cases, and potential failure scenarios to ensure the stability of the system.

**Documentation and Clarity:** We’ll assess the clarity of your documentation, including comments within the code, README files, architectural diagrams, and explanations of design decisions. Your documentation should provide sufficient context for reviewers to understand the problem, solution, and implementation details.

# Candidate README
## Bootstrap instructions

1. Ensure you have Java and Maven installed on your machine.
2. Clone the repository to your local machine.
3. Navigate to the project directory.
4. Run the command `mvn spring-boot:run` to start the server.
5. The application will create an in-memory H2 database and start running on the default port (usually 8080).
6. To access the APIs you will need Postman. There is no UI yet.

## Design considerations

1. In designing this service, I chose to use Spring Boot due to its simplicity and the vast amount of out-of-the-box features it provides
2. The application is structured following the standard Maven project layout. 
3. The main application entry point is the `Foo` class, which is annotated with `@SpringBootApplication`, indicating that it's a Spring context and the main entry point of the application.
4. I decided to use JPA for data access. This allows for a clean and straightforward way to interact with the database using Java objects.
5. The database connection is managed by the `JdbcCOnnectionFactory` class, which provides a centralized place for creating database connections.


## Assumptions

1. The application is designed to run in a local development environment. For production deployment, additional considerations for security, scalability, and reliability would need to be addressed.
2. The application uses an in-memory H2 database for simplicity and ease of setup. In a real-world scenario, a more robust and persistent database system would be used.
3. The `Foo` class in [src/main/java/dev/codescreen/Foo.java](src/main/java/dev/codescreen/Foo.java) is the main entry point of the application. In a larger application, the entry point might be separated into different modules or services.
4. The application assumes a single user context, and does not handle multi-user scenarios or concurrent transactions.


## Bonus: Deployment considerations
- Containerization with Docker: This would ensure that the application runs in the same environment regardless of where it's deployed, eliminating the "it works on my machine" problem.
- Orchestration with Kubernetes: Kubernetes would help manage, scale, and maintain the application, especially if it needs to handle high traffic or run across multiple machines.
- Continuous Integration/Continuous Deployment (CI/CD): I would set up a CI/CD pipeline using a tool like Jenkins or GitHub Actions (as seen in .github/workflows/java.yml). This would automate the process of testing and deploying the application, ensuring that any changes are immediately reflected in the production environment.
- Cloud Hosting: I would consider hosting the application on a cloud platform like AWS, Google Cloud, or Azure. These platforms provide managed services for databases, storage, and compute resources, which can simplify deployment and scaling.
- Database: Currently, the application uses an in-memory H2 database, which is not suitable for production. I would switch to a more robust and persistent database system like PostgreSQL or MySQL. If hosted on a cloud platform, I might use a managed database service like Amazon RDS or Google Cloud SQL.
- Monitoring and Logging: I would integrate a monitoring and logging system like ELK stack or Datadog to track the application's performance and troubleshoot any issues.
- Security: I would ensure that all data is encrypted in transit and at rest, and follow best practices for authentication and authorization. I would also consider using a Web Application Firewall (WAF) to protect against common web exploits.

## License

At CodeScreen, we strongly value the integrity and privacy of our assessments. As a result, this repository is under exclusive copyright, which means you **do not** have permission to share your solution to this test publicly (i.e., inside a public GitHub/GitLab repo, on Reddit, etc.). <br>

## Submitting your solution

Please push your changes to the `main branch` of this repository. You can push one or more commits. <br>

Once you are finished with the task, please click the `Submit Solution` link on <a href="https://app.codescreen.com/candidate/9fdc808d-2649-4e89-9e9f-45305a089169" target="_blank">this screen</a>.