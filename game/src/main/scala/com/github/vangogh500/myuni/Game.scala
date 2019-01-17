package com.github.vangogh500.myuni

import org.scalajs.dom.{document}
import facades.dom.Canvas

object Main extends App {
  val c = Canvas(1600, 900)
  document.getElementById("app").appendChild(c)
}
