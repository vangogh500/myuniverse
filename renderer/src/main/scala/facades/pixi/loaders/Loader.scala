/**
 * Facade for Pixi Loader
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package facades
package pixi
package loaders

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}
import com.github.vangogh500.myuni.core.facades.nodejs.EventEmitter


/**
 * Pixi Loader
 */
@js.native
@JSImport("pixi.js", "loaders.Loader")
class Loader() extends EventEmitter {
  var progress: Double = js.native
  def add(name: String, path: String): Unit = js.native
  def load(): Unit = js.native
}
