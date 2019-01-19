name := "myuni"
organization := "com.github.vangogh500"

lazy val fastDist = taskKey[Unit]("Compile and copy paste projects and generate corresponding json file.")

lazy val core = (project in file("core"))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    name := "core",
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    npmDependencies in Compile ++= Seq(
      "electron" -> "3.0.10"
    )
  )

lazy val app = (project in file("app"))
  .dependsOn(core)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "app",
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalaJSUseMainModuleInitializer := true,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    libraryDependencies ++= {
      val scalajs_dom = "0.9.2"
      Seq(
        "org.scala-js" %%% "scalajs-dom" % scalajs_dom
      )
    },
    fastDist := {
      val mainProcessDirectory = (fastOptJS in Compile).value.data
      val files = Seq(
        mainProcessDirectory.getParentFile / "app-fastopt.js" -> baseDirectory.value / ".." / "dist" / "app.js",
        mainProcessDirectory.getParentFile / "app-fastopt.js.map" -> baseDirectory.value / ".." / "dist" / "app.js.map"
      )
      IO.copy(files, true, false, false)
    }
  )


lazy val renderer = (project in file("renderer"))
  .dependsOn(core)
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "renderer",
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalaJSUseMainModuleInitializer := true,
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    libraryDependencies ++= {
      val scalajs_dom = "0.9.2"
      Seq(
        "org.scala-js" %%% "scalajs-dom" % scalajs_dom
      )
    },
    fastDist := {
      val mainProcessDirectory = (fastOptJS in Compile).value.data
      def processFile(from: File, to: File): Unit = {
        val xs = IO.readLines(from).filter(!_.matches(".*\\s\\$e[\\s;].*"))
        IO.writeLines(to, xs)
      }
      val files = Seq(
        mainProcessDirectory.getParentFile / "renderer-fastopt.js" -> baseDirectory.value / ".." / "dist" / "res" / "js" / "renderer.js",
        mainProcessDirectory.getParentFile / "renderer-fastopt.js.map" -> baseDirectory.value / ".." / "dist" / "res" / "js" / "renderer.js.map"
      )
      files.foreach {
        case (in, out) => processFile(in, out)
      }
    }
  )
