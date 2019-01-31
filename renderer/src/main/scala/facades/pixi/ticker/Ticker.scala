/**
 * Facade for Pixi Ticker
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi
package ticker

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}


/**
 * Pixi Ticker
 */
@js.native
trait Ticker extends js.Object {
  def FPS: Double = js.native
  def add(fn: js.Function1[Double, Unit]): Unit = js.native
}
