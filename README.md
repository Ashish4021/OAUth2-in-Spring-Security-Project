OAuth2 Demo – Google Login with Spring Boot

A beginner-friendly Spring Boot project demonstrating OAuth 2.0 Login with Google using Spring Security. This project explores how users can authenticate through their Google accounts without creating or managing a separate password-based login system in the application.

🚀 Features

- Google OAuth 2.0 Login: Authenticate users using their Google accounts.
- Spring Security Integration: Secure application endpoints and configure authentication.
- OAuth2 Client Configuration: Configure Google as an OAuth2 identity provider.
- Custom Security Configuration: Use "SecurityConfig" to configure protected routes and OAuth2 login.
- Environment-Based Credentials: Store Google Client ID and Client Secret in environment variables.
- Login Success Endpoint: Display a success message after authentication.
- OAuth2 Redirect Handling: Handle Google's redirect back to the application after login.

🛠️ Technologies Used

Technology| Purpose
Java| Backend programming
Spring Boot| Application development
Spring Security| Authentication and endpoint security
Spring Security OAuth2 Client| OAuth2 login integration
Google OAuth 2.0| Identity provider for user login
Maven| Dependency management
IntelliJ IDEA| Development environment

🔄 How OAuth2 Login Works

1. The user opens the application in a browser.
2. Spring Security redirects the user to the Google login page.
3. The user signs in with their Google account and grants the requested permissions if prompted.
4. Google redirects the browser back to the application.
5. Spring Security processes the OAuth2 authorization response and establishes an authenticated session.
6. The authenticated user can access protected application endpoints.

Authentication flow:

"User → Spring Boot Application → Google Login → OAuth2 Callback → Authenticated Application"

📂 Project Structure

oauth2-demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/oauth2demo/
│       │       ├── SecurityConfig.java
│       │       └── HomeController.java
│       └── resources/
│           └── application.properties
├── pom.xml
├── .gitignore
└── README.md

The structure above is illustrative. Keep the actual package names and file locations from your project.

⚙️ Prerequisites

- Java JDK compatible with your Spring Boot version
- Maven
- IntelliJ IDEA or another Java IDE
- A Google account
- Access to Google Cloud Console

🏁 Getting Started

1. Clone the repository

git clone <your-github-repository-url>
cd oauth2-demo

2. Configure Google OAuth credentials

1. Open the "Google Cloud Console" (https://console.cloud.google.com/).
2. Create or select a Google Cloud project.
3. Configure the OAuth consent screen and audience settings as required.
4. Create an OAuth client ID for a Web application.
5. Add this authorized redirect URI:

http://localhost:8080/login/oauth2/code/google

6. Copy your Google Client ID and Client Secret.

3. Configure environment variables

Set these environment variables in your local development environment:

GOOGLE_CLIENT_ID=your-google-client-id
GOOGLE_CLIENT_SECRET=your-google-client-secret

The "application.properties" configuration should include:

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
spring.security.oauth2.client.registration.google.scope=openid,profile,email

Important: Preserve your existing database configuration if it is required by the project. Never commit Google credentials, database passwords, or other secrets to GitHub.

4. Run the application

Run the main Spring Boot application class from IntelliJ IDEA, or use:

mvn spring-boot:run

5. Test Google Login

Open the following URL in your browser:

http://localhost:8080/

Spring Security should redirect unauthenticated users to the Google login flow.

After successful authentication, the home endpoint displays:

Google Login Successful!

🔐 Security Configuration

The project uses Spring Security's OAuth2 login support.

Example configuration:

http
.authorizeHttpRequests(auth -> auth
.anyRequest().authenticated()
)
.oauth2Login(Customizer.withDefaults());

This configuration requires authentication for every application request and enables the default OAuth2 login flow.

Google's OAuth2 client configuration defines the client credentials and requested scopes:

- "openid" — requests OpenID Connect authentication.
- "profile" — requests access to permitted basic profile information.
- "email" — requests access to the user's email information.

The exact attributes available depend on the permissions granted and the provider's response.

🎯 Learning Outcomes

Through this project, I practised:

- Understanding OAuth 2.0 and OpenID Connect login.
- Integrating Google login with Spring Boot.
- Configuring OAuth2 clients in Spring Security.
- Understanding the authorization redirect and callback flow.
- Using environment variables to protect client credentials.
- Configuring authenticated endpoints.
- Accessing authentication information through Spring Security's authenticated principal.

👩‍💻 Project Purpose

This project was developed as a hands-on learning exercise to understand Google OAuth2 Login and Spring Security integration in a Spring Boot application.