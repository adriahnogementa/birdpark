## Software Architecture II - Semester 6 - Summer Semester 2024

### Programming Task

#### Project Description
This project involves the development of a web application to support the establishment of a bird park at the Weserufergelände in Hameln. The software will enable visitors to obtain information about attractions (individual enclosures or shows) and tours in advance.

### Implementation Details

#### Technologies Used
- Backend: Spring Boot with Java, PostgreSQL database
- Docker for containerization
- Swagger for API documentation
- Testing: Unit and integration tests for backend components

#### Setup Instructions
1. Clone the repository to your local machine.
2. Navigate to the root directory of the project.
3. Ensure you have Docker installed on your machine.
4. Run `docker build -t birdpark-db .` to build the container.
5. Run `docker run -d --name my-birdpark-db -p 5432:5432 birdpark-db ` to start the DB container.
6. Start the Application `BirdparkApplication.java`.
7. You can test with `http://localhost:8080/openingtime/get`.

#### Usage only with Frontend (https://github.com/Louiz7007/Vogelpark_Frontend)
- Visit the homepage to view basic information about the bird park.
- Navigate to the attractions page to view and filter attractions based on tags.
- Check out the tours page to see available tours and their details.
- Administrators can access the administration interface to make changes to attractions and tours.

#### API Documentation
- The API documentation is available using Swagger/OpenAPI.
- Access the documentation at `http://localhost:8080/swagger-ui.html`.

#### License
This project is licensed under the [MIT License](LICENSE).

---

You may need to adjust some sections based on the specifics of your project, such as adding contributors, additional setup instructions, or any other relevant details.
