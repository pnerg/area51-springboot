OAuth/OpenId connect with Keycloak
=====

A simple REST app with two end-points, one "open" and the other secured by Keycloak using OAuth2.0/OpenId Connect

This example requires Keycloak to be running locally.   
Easiest way is to run it in a container
The script `./run-keycloak.sh` will run Keycloak in a container and pre-configure the domain/client/users needed for this demo.  

Then just run the app `sbt keycloak/run`

# Using web browser
Direct the browser to
* [http://localhost:8080/hello](http://localhost:8080/hello) for the "open" endpoint
* [http://localhost:8080/secured/hello](http://localhost:8080/secured/hello) for the "secured" endpoint.  
  You should be redirected to a Login page at Keycloak.  
  Use _anon/secret_ as credentials

# Using Postman
Another variant is to use a commandline tool or e.g Postman to manually "login" to create a JWT and then use the resulting _access token_ in subsequent requests.   

## Aquire JWT
Configure a `POST` request to `http://127.0.0.1:8180/auth/realms/area51/protocol/openid-connect/token`. 
Add a body of type `x-www-form-urlencoded` with these keys:

|key|value|
|---|-----|
|grant_type|password|
|username|anon|
|password|secret|
|client_id|login_app|

The result is something like this:
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJnQVI2NmJUeWlIVVNlNnBldmxzWE9pOW0yVzJ1WXlySjZMZFJ4Zlo1NS00In0.eyJleHAiOjE2MjM2NjcwNTYsImlhdCI6MTYyMzY2Njc1NiwianRpIjoiNjE5YWVjZDMtNjkzOC00MzNjLTlkYWQtMDcyMjljYzE4ODRlIiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo4MTgwL2F1dGgvcmVhbG1zL2FyZWE1MSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI1NjI5ZmI3NS1kYTM5LTQ1NjUtOWRmZS1lMDhhOWY0ZThiYTMiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJsb2dpbi1hcHAiLCJzZXNzaW9uX3N0YXRlIjoiNmQwMDE3YWYtYjdiMi00MmY1LTgyZDUtNjYxNDBmNmNlZmVjIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJvZmZsaW5lX2FjY2VzcyIsInVtYV9hdXRob3JpemF0aW9uIiwidXNlciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoiSm9obiBEb2UiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhbm9uIiwiZ2l2ZW5fbmFtZSI6IkpvaG4iLCJmYW1pbHlfbmFtZSI6IkRvZSJ9.n8TfFURr_ZgWLwCGCpgOMpu9-wgFk0SZtklvsUKbsVZHkFtltTATAdr9Z3FPQSfKOcRlaUccLq1XwcjkJ6NglMmk9UfsHiGtyMrC93RsDwHFQheVPe9LeTEqN6O6A62m-Z_WRMKTJoqL0WzkVxB05CUf5j1WbBknC1IkI7-t5XuOJwEYkDqQ3ApZXSTrnfU-yk2ZOQg5GW6TXuifxINSl8e72qpF2jrgln0goXsyF0o0AxCSzp7Cv65oPajLtyuiu08BbBfdqm01sRRpESSNRSEijagpz7BnrJX8kCdolpVLbYwV2sGOGsgEliNVfXUM2q41zrJWeckztTgdAIt3NQ",
    "expires_in": 300,
    "refresh_expires_in": 1800,
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICIyYzIwMDUxYS0zNzcwLTQwN2MtYjU4Mi0yMjc5NmViZjZmOGUifQ.eyJleHAiOjE2MjM2Njg1NTYsImlhdCI6MTYyMzY2Njc1NiwianRpIjoiZGJjOTIzN2YtY2EwYi00NTcxLWIzMDktMWQyODAwM2IzM2U3IiwiaXNzIjoiaHR0cDovLzEyNy4wLjAuMTo4MTgwL2F1dGgvcmVhbG1zL2FyZWE1MSIsImF1ZCI6Imh0dHA6Ly8xMjcuMC4wLjE6ODE4MC9hdXRoL3JlYWxtcy9hcmVhNTEiLCJzdWIiOiI1NjI5ZmI3NS1kYTM5LTQ1NjUtOWRmZS1lMDhhOWY0ZThiYTMiLCJ0eXAiOiJSZWZyZXNoIiwiYXpwIjoibG9naW4tYXBwIiwic2Vzc2lvbl9zdGF0ZSI6IjZkMDAxN2FmLWI3YjItNDJmNS04MmQ1LTY2MTQwZjZjZWZlYyIsInNjb3BlIjoiZW1haWwgcHJvZmlsZSJ9.GnRQp_cAdLSXtQS28GNFaBAKuRauNKbQDcJqE34HKvw",
    "token_type": "Bearer",
    "not-before-policy": 1623654499,
    "session_state": "6d0017af-b7b2-42f5-82d5-66140f6cefec",
    "scope": "email profile"
}
```

## Invoke REST op with JWT
In Postman configure a `GET` request to `http://127.0.0.1:8080/secured/hello`.  
Under the _Authorization_ tab choose _Bearer Token_ and add the entire value of the `access_token` from the above response.  
Execute and voilá you should get a response.



