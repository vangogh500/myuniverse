/**
 * Facade for Electron BrowserWindowOptions
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Options used for constructing a BrowserWindow
 */
trait BrowserWindowOptions extends js.Object {
  /**
   * Window visibility
   */
  val show: js.UndefOr[Boolean]
  /**
   * Width of window
   */
  val width: js.UndefOr[Int]
  /**
   * Height of window
   */
  val height: js.UndefOr[Int]
  /**
   * Window frame type
   */
  val frame: js.UndefOr[Boolean]
  /**
   * Window title bar style (mac OS only)
   */
  val titleBarStyle: js.UndefOr[String]
  /**
   * Full screen mode
   */
  val fullscreen: js.UndefOr[Boolean]
}

/**
 * Options used for constructing a BrowserWindow
 */
object BrowserWindowOptions {
  /**
   * Instantiate a BrowserWindowOptions
   * @param w Window width
   * @param h Window height
   * @param f Window frame type
   * @param tbs Window title bar style (mac OS only)
   */
  def apply(
    sw: js.UndefOr[Boolean],
    w: js.UndefOr[Int],
    h: js.UndefOr[Int],
    f: js.UndefOr[Boolean],
    tbs: js.UndefOr[String],
    fs: js.UndefOr[Boolean],
  ) = new BrowserWindowOptions {
    val show = sw
    val width = w
    val height = h
    val frame = f
    val titleBarStyle = tbs
    val fullscreen = fs
  }
}
