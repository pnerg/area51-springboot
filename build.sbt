import sbt.Keys.publishArtifact

name := "area51-springboot"
organization := "org.dmonix"
version := "0.0.0"
publishArtifact := false
publishArtifact in (Compile, packageBin) := false
publishArtifact in (Compile, packageDoc) := false
publishArtifact in (Compile, packageSrc) := false

//shared settings for all modules
val baseSettings = Seq(
  organization := "org.dmonix",
  version := "0.0.0",
  publishArtifact := false,
  publishArtifact in (Compile, packageBin) := false,
  publishArtifact in (Compile, packageDoc) := false,
  publishArtifact in (Compile, packageSrc) := false,
  crossPaths := false,
  autoScalaLibrary := false,
  excludeDependencies ++= `global-excludes`,
  mainClass in (Compile, run) := Some("org.dmonix.area51.Main"),
  testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a")),
  libraryDependencies ++= Seq(
    `spring-boot-autoconfigure`,
    `spring-boot-configuration-processor`,
    `spring-boot-starter-web`,
    `spring-boot-starter-actuator`,
    //`spring-boot-starter-security`, //adds automated login/security
    `spring-boot-starter-jetty`,
    `spring-context-support`,
    `spring-tx`,
    `spring-retry`,
    `micrometer-registry-prometheus`,
    `jackson-base`,
    `jackson-databind`,
    `jackson-datatype-jsr310`,
    httpclient,
    `bcprov-jdk15on`,
    `log4j-to-slf4j`,
    `javax.servlet-api`,
    json,
    //`tomcat-juli`,
    `spring-boot-starter-test` % Test,
    junit % Test
  )
)

lazy val app = (project in file("app"))
  .settings(baseSettings)

lazy val rest = (project in file("rest"))
  .settings(baseSettings)

lazy val graphql = (project in file("graphql"))
  .settings(baseSettings)
  .settings(
    libraryDependencies ++= Seq(
      `graphql-spring-boot-starter`,
      `graphql-java-tools`
    )
  )

lazy val keycloak = (project in file("keycloak"))
  .settings(baseSettings)
  .settings(
    libraryDependencies ++= Seq(
      `keycloak-spring-boot-starter`,
    )
  )

lazy val consul = (project in file("consul"))
  .settings(baseSettings)
  .settings(
    libraryDependencies ++= Seq(
      `spring-cloud-starter-consul-discovery`
    )
  )