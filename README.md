# Instagram Backend Design
This is a backend application for Instagram built 
using Spring Boot, Java, Maven, and
MySQL database for data persistence.
The application provides two roles: 
admin and user. For users, 
it offers signup , signin and signout authentication
services and includes 
functionality such as posting, following users, 
commenting on posts, and managing followers.

## Technologies Used
* Spring Boot: Java framework for building the application
* Java: Programming language for developing the backend
* Maven: Build and dependency management tool
* MySQL: Relational database for data persistence
## Prerequisites
* Java Development Kit (JDK) installed
* Maven installed
* MySQL database server installed
## Getting Started
1. Clone this repository.
2. Set up the MySQL database:

Create a new database in MySQL.

Update the application.properties file in src/main/resources 
with your database connection details:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
spring.datasource.username=your-username
spring.datasource.password=your-password
```
## Usage
### Admin Role
* The admin role has access to administrative functions such as manage user verification(blue tick).
### User Role
Users can perform the following actions:

* Signup: Create a new account with a unique username and password.
* Signin: Authenticate using the registered username and password.
* Post: Create a new post with an image and caption.
* Comment on Post: Add comments to posts.
* View Followers/Following: Get the list of followers and users followed by the authenticated user.

## API Endpoints
The following are the API endpoints provided by the application:

* `POST /api/signup`: Create a new user account.
* ```POST /api/signin```: Authenticate and obtain an access token.
* `DELETE /api/signout`: Authenticate and delete an access token after logged out.
* `POST /api/posts`: Create a new post.
* `GET /api/posts`: Get all posts.
* `GET /api/posts/{postId}`: Get a specific post by ID.
* `POST /api/users/{userId}/follow`: Follow a user.
* `POST /api/posts/{postId}/comments`: Add a comment to a post.
* `GET /api/users/{userId}/followers`: Get followers of a user.
* `GET /api/users/{userId}/following`: Get users followed by a user.
Note: Replace {postId} and {userId} with the corresponding IDs.
  ## Contributing
  Contributions to the project are welcome! If you find any bugs or want to add new features, please open an issue or submit a pull request.