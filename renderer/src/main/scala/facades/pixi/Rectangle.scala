/**
 * Facade for Pixi Rectangle
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}


/**
 * Rectangle
 */
@js.native
@JSImport("pixi.js", "Rectangle")
class Rectangle(x: Double, y: Double, w: Double, h: Double) extends js.Object {
  var width: Double = js.native
  var height: Double = js.native
}
