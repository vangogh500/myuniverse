/**
 * Facade for Electron Rectangle
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * Rectangle
 */
@js.native
trait Rectangle extends js.Object {
  val x: Int
  val y: Int
  val width: Int
  val height: Int
}
