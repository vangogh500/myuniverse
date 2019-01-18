/**
 * Facade for Electron Point
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * Point
 */
trait Point extends js.Object {
  val x: Int
  val y: Int
}
