/**
 * Facade for Electron BrowserWindow
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import nodejs._

/**
 * Browser window
 * @constructor
 * @param args Constructor arguments
 */
@js.native
@JSImport("electron", "BrowserWindow")
class BrowserWindow(args: BrowserWindowOptions) extends js.Object {
  /**
   * Web contents
   */
  val webContents: WebContents = js.native
  /**
   * Load resource
   * @param src String representing path to resource
   */
  def loadFile(src: String): Unit = js.native
  /**
   * Bounds of the window
   */
  def getBounds(): Rectangle = js.native
}

/**
 * Browser window
 */
object BrowserWindow {
  /**
   * Instantiate a BrowserWindow
   * @param show Window visiblity
   * @param width Width of window
   * @param height Height of window
   * @param frame Window frame type
   * @param titleBarStyle Window title bar style (mac OS only)
   * @param fullscreen Full screen mode
   */
  def apply(
    show: js.UndefOr[Boolean] = js.undefined,
    width: js.UndefOr[Int] = js.undefined,
    height: js.UndefOr[Int] = js.undefined,
    frame: js.UndefOr[Boolean] = js.undefined,
    titleBarStyle: js.UndefOr[String] = js.undefined,
    fullscreen: js.UndefOr[Boolean] = js.undefined
  ) = new BrowserWindow(BrowserWindowOptions(show, width, height, frame, titleBarStyle, fullscreen))
}
