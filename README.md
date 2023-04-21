# BoyBoy web application

# End-points

# Registration end-point
*This end-point creates a new user object with the information provided by a new app user 
and saves the object in a database. It accepts first name, last name, location, phone number, email address and services then returns a message.*

# Request
* Url: `localhost:8080/api/v1/users/registration`
* Method: POST
* Header :
    * `Content-Type : application/json`
* Body:
```
{
    "firstName" : "Mercy",
    "lastName" : "Musah",
    "emailAddress" : "mercy@gmail.com",
    "phoneNumber" : "07090997892",
    "location" : "gbaja road, 345",
    "services" : "Cleaning"

}
```
* Fields :
    * `firstName`(required,String): *The first name of the registering user*
    * `lastName`(required,String): *The last name of the registering user*
    * `emailAddress`(required,String): *The email address of the registering user*
    * `phoneNumber`(required,String): *The phone number of the registering user*
    * `location`(required,String): *The address of the registering user*
    * `services`(required,String): *The service the registering user demands*
# Response 1
*Successful request*
* Status code : `200 ok`
* Body:
```
{
    "message": "User registered successfully"
}
```
* Field:
  * `message`: *Request message*

# Response 2
*Unsuccessful request due to sending a request with a null, blank, empty or invalid details*
* Status code : `400 bad request`
* Body:
```
{
    "firstName": "First name can not be blank",
    "emailAddress": "must be a well-formed email address",
    "phoneNumber": "Invalid phone number",
    "location": "Location can not be blank"
}
```
* Field:
    * `firstName`(required,String): *The first name of the registering user*
    * `emailAddress`(required,String): *The email address of the registering user*
    * `phoneNumber`(required,String): *The phone number of the registering user*
    * `location`(required,String): *The address of the registering user*

