import sbt._


object Dependencies extends AutoPlugin {

  // Dependency versions
  val springBootVersion = "2.2.8.RELEASE"
  val springVersion = "5.2.7.RELEASE"
  val springSecurityVersion = "5.2.5.RELEASE"
  val springCloudVersion = "2.2.2.RELEASE"
  
  object autoImport {

    // spring framework
    //val `spring-cloud-starter-consul-config` = "org.springframework.cloud" % "spring-cloud-starter-consul-config" % springCloudVersion
    //"org.springframework.cloud" % "spring-cloud-starter-consul-discovery" % springCloudVersion
    //"org.springframework.cloud" % "spring-cloud-starter-zipkin" % springCloudVersion

    val `spring-boot-autoconfigure` = "org.springframework.boot" % "spring-boot-autoconfigure" % springBootVersion
    val `spring-boot-configuration-processor` = "org.springframework.boot" % "spring-boot-configuration-processor" % springBootVersion
    val `spring-boot-starter-web` = "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion
    val `spring-boot-starter-actuator` = "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion
    val `spring-boot-starter-security` = "org.springframework.boot" % "spring-boot-starter-security" % springBootVersion

    //"org.springframework" % "spring-jms" % `spring-boot-autoconfigure`.revision % Optional
    val `spring-context-support` = "org.springframework"	% "spring-context-support" % springVersion
    val `spring-tx` = "org.springframework" % "spring-tx" % springVersion

    val `spring-retry` = "org.springframework.retry" % "spring-retry" % "1.3.1"

    val `spring-security-crypto` = "org.springframework.security" % "spring-security-crypto" % springSecurityVersion
    val `spring-security-core` = "org.springframework.security" % "spring-security-core" % springSecurityVersion
    val `spring-security-config` = "org.springframework.security" % "spring-security-config" % springSecurityVersion
    val `spring-security-web` = "org.springframework.security" % "spring-security-web" % springSecurityVersion

    //val `activemq-spring` = "org.apache.activemq" % "activemq-spring" % "5.15.13" % Optional

    val `graphql-spring-boot-starter` = "com.graphql-java" % "graphql-spring-boot-starter" % "5.0.2"
    val `graphql-java-tools` = "com.graphql-java" % "graphql-java-tools" % "5.2.4"

    val `keycloak-spring-boot-starter` = "org.keycloak" % "keycloak-spring-boot-starter" % "10.0.2" excludeAll(
      ExclusionRule(organization = "org.springframework.boot", name="spring-boot-starter" ),
      ExclusionRule(organization = "org.springframework.boot", name="spring-boot-starter-web" )
    )

    // micrometer prometheus support
    val `micrometer-registry-prometheus` = "io.micrometer" % "micrometer-registry-prometheus" % "1.6.5"

    // jackson
    val `jackson-base` = "com.fasterxml.jackson" % "jackson-base" % "2.12.2"
    val `jackson-databind` = "com.fasterxml.jackson.core" % "jackson-databind" % `jackson-base`.revision
    val `jackson-datatype-jsr310` = "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % `jackson-base`.revision

    // misc
    val httpclient = "org.apache.httpcomponents" % "httpclient" % "4.5.13"
    val `bcprov-jdk15on` = "org.bouncycastle" % "bcprov-jdk15on" % "1.68"
    val guava = "com.google.guava" % "guava" % "28.2-jre"
    val `log4j-to-slf4j` = "org.apache.logging.log4j" % "log4j-to-slf4j" % "2.14.1"
    //val `javax.jms-api` = "javax.jms" % "javax.jms-api" % "2.0.1" % "provided"
    val `javax.servlet-api` = "javax.servlet" % "javax.servlet-api" % "4.0.1" % "provided"
    val json = "org.json" % "json" % "20190722"
    val `tomcat-juli` = "org.apache.tomcat" % "tomcat-juli" % "10.0.5"

    // test scope
    val `spring-boot-starter-test` = "org.springframework.boot" % "spring-boot-starter-test" % "2.2.7.RELEASE" excludeAll(
      ExclusionRule(organization="org.junit.jupiter", name="junit-jupiter"),
      "org.junit.jupiter" % "junit-jupiter" % "5.6.2"
    )

  }

}