name := "worktimesheet"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "postgresql" % "postgresql" % "8.4-702.jdbc4"
)

play.Project.playScalaSettings

ScoverageSbtPlugin.instrumentSettings

ScoverageSbtPlugin.ScoverageKeys.excludedPackages in ScoverageSbtPlugin.scoverage :=
  "<empty>;Reverse.*;.*AuthService.*;models.data..*"
