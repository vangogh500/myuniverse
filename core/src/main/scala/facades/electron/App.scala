/**
 * Facade for Electron App
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import facades.nodejs.{EventEmitter}

/**
 * Electron App
 */
@js.native
@JSImport("electron", "app")
object App extends EventEmitter {
  /**
   * Quit electron
   */
  def quit(): Unit = js.native
  /**
   * Get path to file or directory associated with name
   */
  def getPath(name: String): String = js.native
}
