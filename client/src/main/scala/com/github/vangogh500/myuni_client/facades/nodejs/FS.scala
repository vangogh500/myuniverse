/**
 * Facade for FS
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package facades
package nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs._

/**
 * FS
 */
@js.native
@JSImport("fs", JSImport.Namespace)
object FS extends js.Object {
  /**
   * Returns true if the path exists, false otherwise
   * @param path path to test
   */
  def existsSync(path: String): Boolean = js.native
  /**
   * Writes file
   * @param path file path
   * @param data data to write to file
   */
  def writeFileSync(path: String, data: String): Unit = js.native
}
