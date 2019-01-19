/**
 * Facade for Electron Size
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
 * Size
 */
@js.native
trait Size extends js.Object {
  val width: Int
  val height: Int
}
