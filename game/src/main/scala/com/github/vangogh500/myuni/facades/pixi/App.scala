/**
 * Facade for PIXI App
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.raw.Node

/**
 * Pixi application
 * @constructor
 * @param args Constructor arguments
 */
@js.native
@JSImport("pixi.js", "Application")
class App(w: Int, height: Int) extends js.Object {
  def view: Node = js.native
}
