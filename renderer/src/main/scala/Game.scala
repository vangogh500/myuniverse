package com.github.vangogh500.myuni.renderer

import org.scalajs.dom.{document}
import org.scalajs.dom.html

object Main extends App {
  val c = document.createElement("CANVAS").asInstanceOf[html.Canvas]
  c.width = 1600
  c.height = 900
  val gl = c.getContext("webgl")
  gl.clearColor(0.0, 0.0, 0.0, 1.0)
  gl.clear(gl.COLOR_BUFFER_BIT)
  document.getElementById("app").appendChild(c)
}
