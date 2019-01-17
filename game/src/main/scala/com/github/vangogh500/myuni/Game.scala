package com.github.vangogh500.myuni

import org.scalajs.dom.{document}
import facades.dom.Canvas

object Main extends App {
  val c = Canvas(1600, 900)
  val gl = c.getContext("webgl")
  gl.clearColor(0.0, 0.0, 0.0, 1.0)
  gl.clear(gl.COLOR_BUFFER_BIT)
  document.getElementById("app").appendChild(c)
}
