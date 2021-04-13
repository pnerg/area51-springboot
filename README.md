# Area51 Spring Boot
Playground for Spring boot

sub-project to test individually:
* [A simple REST based interface](rest)
* [A graphql based interface](graphql)
* [A OAuth2.0/OpenId connect secured application using Keycloak](keycloak)

All sub-modules share the same base dependencies, some add own for the sake of their purpose.   
I've replaced Tomcat with Jetty as webcontainer, mostly because I like Jetty more.