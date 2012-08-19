name := "lift-doc"

version := "0.0.1"

organization := "net.liftweb.doc"

scalaVersion := "2.9.1"

resolvers ++= Seq(
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases"  at "http://oss.sonatype.org/content/repositories/releases"
)

seq( webSettings :_* )

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.5-SNAPSHOT"
  Seq(
    "net.liftweb"             %% "lift-webkit"        % liftVersion                       % "compile",
    "net.liftmodules"         %% "lift-jquery-module" % (liftVersion + "-1.0-SNAPSHOT"),
    "org.eclipse.jetty"        % "jetty-webapp"       % "7.6.5.v20120716"                 % "container; test",
    "ch.qos.logback"           % "logback-classic"    % "1.0.6",
    "org.seleniumhq.selenium"  % "selenium-java"      % "2.21.0",
    "org.scalatest"           %% "scalatest"          % "2.0.M3"                          % "test"
  )
}
