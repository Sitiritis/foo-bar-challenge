organization := "sitiritis.me"
name := "java_foobar"

// Include only src/main/java in the compile configuration
Compile / unmanagedSourceDirectories := (Compile / javaSource).value :: Nil
// Include only src/test/java in the test configuration
Test / unmanagedSourceDirectories := (Test / javaSource).value :: Nil
// This forbids including Scala related libraries into the dependency
autoScalaLibrary := false

resolvers in ThisBuild += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "org.junit.jupiter" % "junit-jupiter" % "5.6.2" % Test,
  "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % Test,
)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
