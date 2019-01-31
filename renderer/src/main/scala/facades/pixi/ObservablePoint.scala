/**
 * Facade for Pixi Observable Point
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}


/**
 * Observable Point
 */
@js.native
@JSImport("pixi.js", "ObservablePoint")
class ObservablePoint(cd: js.Function, scope: js.Object, x: Double, y: Double) extends js.Object {
  def set(x2: Double, y2: Double): Unit = js.native
}
