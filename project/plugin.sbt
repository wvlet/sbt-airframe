addSbtPlugin("org.xerial.sbt"     % "sbt-sonatype"             % "3.9.7")
addSbtPlugin("com.github.sbt"     % "sbt-pgp"                  % "2.1.2")
addSbtPlugin("org.scoverage"      % "sbt-scoverage"            % "1.8.1")
addSbtPlugin("org.scalameta"      % "sbt-scalafmt"             % "2.4.2")
addSbtPlugin("com.eed3si9n"       % "sbt-buildinfo"            % "0.10.0")

addDependencyTreePlugin

// For setting explicit versions for each commit
addSbtPlugin("com.dwijnand" % "sbt-dynver" % "4.1.1")

// For sbt-airframe
libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

scalacOptions ++= Seq("-deprecation", "-feature")