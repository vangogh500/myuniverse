/**
 * Facade for Electron Display
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Electron Display
 */
@js.native
trait Display extends js.Object {
  /**
   * Unique identifier
   */
  val id: Int
  /**
   * Screen rotation
   */
  val rotation: Int
  /**
   * Display size
   */
  val workAreaSize: Size
}
