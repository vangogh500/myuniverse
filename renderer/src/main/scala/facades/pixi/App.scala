/**
 * Facade for Pixi App
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.{document, window}
import org.scalajs.dom.html.{Canvas}
import ticker.Ticker


/**
 * Electron App
 */
@js.native
@JSImport("pixi.js", "Application")
class App(width: Double, height: Double) extends js.Object {
  def view: Canvas = js.native
  def stage: Container = js.native
  def screen: Rectangle = js.native
  def ticker: Ticker = js.native
}

object App {
  trait Opts extends js.Object {
    val backgroundColor: String
  }
  def apply(w: Double, h: Double): App = new App(w, h)
  def init(): App = {
    val app = App(window.innerWidth, window.innerHeight)
    document.body.appendChild(app.view)
    app
  }
}
