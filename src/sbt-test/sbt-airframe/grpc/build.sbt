import wvlet.airframe.sbt.http.AirframeHttpPlugin

val buildSettings: Seq[Def.Setting[_]] = Seq(
  testFrameworks += new TestFramework("wvlet.airspec.Framework"),
  libraryDependencies += "org.wvlet.airframe" %% "airspec" % sys.props("airframe.version") % "test"
)

lazy val root =
  project
    .settings(buildSettings)
    .aggregate(api, server)

lazy val api =
  project
    .in(file("api"))
    .settings(buildSettings)
    .settings(
      libraryDependencies += "org.wvlet.airframe" %% "airframe-http" % sys.props("airframe.version")
    )

lazy val server =
  project
    .in(file("server"))
    .enablePlugins(AirframeHttpPlugin)
    .settings(buildSettings)
    .settings(
      Test / fork := true,
      airframeHttpGeneratorOption := "-l trace",
      airframeHttpClients := Seq(
        "example.api:grpc"
      ),
      libraryDependencies ++= Seq(
        "org.wvlet.airframe" %% "airframe-http-grpc" % sys.props("airframe.version")
      )
    )
    .dependsOn(api)