name := "myuni"
organization := "com.github.vangogh500"

enablePlugins(ScalaJSPlugin)
scalaJSUseMainModuleInitializer := true
scalaJSModuleKind := ModuleKind.CommonJSModule

lazy val fastDist = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

fastDist := {
  val mainProcessDirectory = (fastOptJS in Compile).value.data
  def processFile(from: File, to: File): Unit = {
    val xs = IO.readLines(from).filter(!_.matches(".*\\s\\$e[\\s;].*"))
    IO.writeLines(to, xs)
  }
  val files = Seq(
    mainProcessDirectory.getParentFile / "myuni-fastopt.js" -> baseDirectory.value / ".." / "dist" / "res" / "js" / "game.js",
    mainProcessDirectory.getParentFile / "myuni-fastopt.js.map" -> baseDirectory.value / ".." / "dist" / "res" / "js" / "game.js.map"
  )
  files.foreach {
    case (in, out) => processFile(in, out)
  }
}

libraryDependencies ++= {
  val scalajs_dom = "0.9.2"
  Seq(
    "org.scala-js" %%% "scalajs-dom" % scalajs_dom
  )
}
