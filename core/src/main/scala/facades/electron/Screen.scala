/**
 * Facade for Electron Screen
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package facades
package electron

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Native object
 */
@js.native
@JSImport("electron", "screen")
object NativeScreen extends js.Object {
  def getPrimaryDisplay(): Display = js.native
  def getDisplayNearestPoint(p: Point): Display = js.native
}

/**
 * Electron Screen
 */
object Screen extends js.Object {
  /**
   * Get primary display
   */
  def primaryDisplay: Display =  NativeScreen.getPrimaryDisplay()
  /**
   * Finds the display that most closely intersects the provided bounds
   */
  def getDisplayNearestPoint(p: Point): Display = NativeScreen.getDisplayNearestPoint(p)
  /**
   * Finds the display that most closely intersects the provided bounds
   */
  def getDisplayNearestPoint(x1: Int, y1: Int): Display = NativeScreen.getDisplayNearestPoint(new Point {
    val x: Int = x1
    val y: Int = y1
  })
  def getDisplayNearestWindow(win: BrowserWindow): Display = {
    val bounds = win.getBounds()
    NativeScreen.getDisplayNearestPoint(new Point {
      val x: Int = bounds.x
      val y: Int = bounds.y
    })
  }
}
