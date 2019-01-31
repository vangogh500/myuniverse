/**
 * Facade for Pixi Text
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
@JSImport("pixi.js", "Text")
class Text(str: String, opts: Text.Opts) extends DisplayObject {
  var x: Double = js.native
  var y: Double = js.native
  var text: String = js.native
}

object Text {
  trait Opts extends js.Object {
    val fill: Int
    val fontFamily: String
  }
  def apply(str: String, ff: String, color: Int): Text = new Text(str, new Opts {
    val fill = color
    val fontFamily = ff
  })
}
