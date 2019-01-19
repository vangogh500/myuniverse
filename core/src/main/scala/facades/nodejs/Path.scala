/**
 * Facade for Path
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Path
 */
@js.native
@JSImport("path", JSImport.Namespace)
object Path extends js.Object {
  /**
   * Joins all given path segments together using platform specific seperator
   * @param paths path segments
   */
  def join(paths: String*): String = js.native
}
