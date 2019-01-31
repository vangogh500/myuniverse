/**
 * Facade for Pixi Display Object
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}


/**
 * Display Object
 */
@js.native
@JSImport("pixi.js", "DisplayObject")
class DisplayObject() extends js.Object {
  def anchor: ObservablePoint = js.native
}
