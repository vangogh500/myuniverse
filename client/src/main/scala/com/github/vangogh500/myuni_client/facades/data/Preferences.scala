/**
 * Preferences
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package data

import facades.electron.Screen
import scala.scalajs.js
import scala.scalajs.js.annotation._

/**
 * Resolution Preferences
 */
trait ResolutionPreferences extends js.Object {
  val width: Int
  val height: Int
}

/**
 * Resolution Preferences
 */
object ResolutionPreferences {
  def default: ResolutionPreferences = {
    val size = Screen.primaryDisplay.workAreaSize
    new ResolutionPreferences {
      val width = size.width
      val height = size.height
    }
  }
}

/**
 * Screen Preferences
 */
trait ScreenPreferences extends js.Object {
  val fullscreen: Boolean
  val resolution: ResolutionPreferences
}

/**
 * Screen Preferences
 */
object ScreenPreferences {
  def default: ScreenPreferences = new ScreenPreferences {
    val fullscreen = true
    val resolution = ResolutionPreferences.default
  }
}

/**
 * Preferences
 */
trait Preferences extends js.Object {
  val screen: ScreenPreferences
}

/**
 * Preferences
 */
object Preferences {
  def default: Preferences = new Preferences {
    val screen = ScreenPreferences.default
  }
}
