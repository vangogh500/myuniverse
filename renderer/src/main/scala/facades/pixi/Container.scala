/**
 * Facade for Pixi Container
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}


/**
 * Electron App
 */
@js.native
@JSImport("pixi.js", "Container")
class Container() extends js.Object {
  var width: Double = js.native
  var height: Double = js.native
  def addChild(child: DisplayObject): Unit = js.native
  def removeChild(child: DisplayObject): Unit = js.native
}
