OAuth/OpenId connect with Keycloak
=====

A simple REST app with two end-points, one "open" and the other secured by Keycloak using OAuth2.0/OpenId Connect

This example requires Keycloak to be running locally.   
Easiest way is to run it in a container
The script `./run-keycloak.sh` will run Keycloak in a container and pre-configure the domain/client/users needed for this demo.  

Then just run the app `sbt keycloak/run`

Direct the browser to
* [http://localhost:8080/hello](http://localhost:8080/hello) for the "open" endpoint
* [http://localhost:8080/secured/hello](http://localhost:8080/hello) for the "secured" endpoint.  
  You should be redirected to a Login page at Keycloak.  
  Use _anon/secret_ as credentials



