# API Authentication Guide

## Overview
This Spring application now supports dual authentication modes:
1. **Form-based authentication** for web interface
2. **HTTP Basic Authentication** for API endpoints (suitable for Postman)

## Configuration Details

### Security Configuration
The application uses two separate security configurations:

#### 1. API Security (`/api/**` endpoints)
- **Authentication Method**: HTTP Basic Authentication
- **Session Management**: Stateless
- **CSRF**: Disabled (for API compatibility)
- **Users**: 
  - Username: `admin`, Password: `password`, Roles: `USER`, `ADMIN`
  - Username: `apiuser`, Password: `apipass`, Roles: `API_USER`

#### 2. Web Security (all other endpoints)
- **Authentication Method**: Form-based login
- **Session Management**: Stateful
- **Users**:
  - Username: `admin`, Password: `password`, Roles: `USER`, `ADMIN`
  - Username: `webuser`, Password: `webpass`, Roles: `USER`

## Using Postman with API Endpoints

### Step 1: Configure Basic Authentication in Postman

1. Open Postman
2. Create a new request
3. Set the request URL to your API endpoint (e.g., `http://localhost:8080/api/test`)
4. Go to the **Authorization** tab
5. Select **Basic Auth** from the Type dropdown
6. Enter credentials:
   - **Username**: `admin` or `apiuser`
   - **Password**: `password` or `apipass`

### Step 2: Test API Endpoints

#### GET Request Example
```
URL: http://localhost:8080/api/test
Method: GET
Authorization: Basic Auth (admin/password)
```

#### POST Request Example
```
URL: http://localhost:8080/api/data
Method: POST
Authorization: Basic Auth (admin/password)
Headers: Content-Type: application/json
Body (raw JSON):
{
    "name": "Test Data",
    "value": 123
}
```

#### User Info Request
```
URL: http://localhost:8080/api/user-info
Method: GET
Authorization: Basic Auth (admin/password)
```

### Step 3: Expected Responses

#### Successful Authentication Response
```json
{
    "message": "API endpoint accessed successfully!",
    "user": "admin",
    "authorities": [
        {
            "authority": "ROLE_USER"
        },
        {
            "authority": "ROLE_ADMIN"
        }
    ],
    "timestamp": 1640995200000
}
```

#### Authentication Failure Response
- **Status Code**: 401 Unauthorized
- **Response**: Basic authentication challenge

## Available API Endpoints

| Endpoint | Method | Description | Required Role |
|----------|--------|-------------|---------------|
| `/api/test` | GET | Test endpoint | Any authenticated user |
| `/api/data` | POST | Submit data | Any authenticated user |
| `/api/user-info` | GET | Get user information | Any authenticated user |

## Troubleshooting

### Common Issues

1. **401 Unauthorized Error**
   - Check username and password are correct
   - Ensure Basic Auth is selected in Postman
   - Verify the endpoint URL is correct

2. **403 Forbidden Error**
   - User is authenticated but doesn't have required role
   - Check user roles in security configuration

3. **CORS Issues**
   - CORS is enabled in the configuration
   - Ensure proper headers are set for cross-origin requests

### Testing Without Postman

You can also test using curl:

```bash
# GET request
curl -u admin:password http://localhost:8080/api/test

# POST request
curl -u admin:password \
  -H "Content-Type: application/json" \
  -d '{"name":"test","value":123}' \
  http://localhost:8080/api/data
```

## Security Notes

1. **Password Encoding**: Passwords are encoded using BCrypt
2. **Stateless API**: API endpoints don't maintain sessions
3. **CSRF Protection**: Disabled for API endpoints only
4. **In-Memory Users**: Current configuration uses in-memory user store
   - For production, implement database-backed user authentication

## Next Steps

To enhance security for production:

1. **Database Authentication**: Replace in-memory users with database-backed authentication
2. **JWT Tokens**: Consider implementing JWT for stateless authentication
3. **Role-based Access Control**: Implement more granular permissions
4. **HTTPS**: Always use HTTPS in production
5. **Password Policies**: Implement strong password requirements

## Example Integration Code

If you need to call these APIs from another application:

```java
// Java example using RestTemplate
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setBasicAuth("admin", "password");
HttpEntity<String> entity = new HttpEntity<>(headers);

ResponseEntity<String> response = restTemplate.exchange(
    "http://localhost:8080/api/test",
    HttpMethod.GET,
    entity,
    String.class
);
```

```javascript
// JavaScript example using fetch
const credentials = btoa('admin:password');
fetch('http://localhost:8080/api/test', {
    method: 'GET',
    headers: {
        'Authorization': `Basic ${credentials}`,
        'Content-Type': 'application/json'
    }
})
.then(response => response.json())
.then(data => console.log(data));
```