/**
 * Preferences
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.core
package store

import scala.concurrent.{Future, ExecutionContext}
import facades.nodejs.{Path, FS}
import facades.electron.{App, Screen}
import scala.scalajs.js

/**
 * Resolution Preferences
 */
trait ResolutionPreferences extends js.Object {
  val width: Int
  val height: Int
}

/**
 * Advanced screen preferences
 */
trait AdvancedScreenPreferences extends js.Object {
  val fpsCap: Int
}

/**
 * Screen Preferences
 */
trait ScreenPreferences extends js.Object {
  val fullscreen: Boolean
  val resolution: ResolutionPreferences
  val advanced: AdvancedScreenPreferences
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
  /**
   * Default preferences
   */
  def default: Preferences = {
    val size = Screen.primaryDisplay.workAreaSize
    new Preferences {
      val screen = new ScreenPreferences {
        val fullscreen = true
        val resolution = new ResolutionPreferences {
          val width = size.width
          val height = size.height
        }
        val advanced = new AdvancedScreenPreferences {
          val fpsCap = 60
        }
      }
    }
  }
  /**
   * Load preferences
   */
  def load()(implicit ec: ExecutionContext): Future[Preferences] = {
    val path = Path.join(App.getPath("userData"), "config.json")
    if(FS.existsSync(path)) {
      FS.readFile(path) map { data =>
        js.JSON.parse(data.toString()).asInstanceOf[Preferences]
      }
    } else {
      val config = Preferences.default
      FS.writeFile(path, js.JSON.stringify(value = config, space = "\t")) map { _ => config }
    }
  }
}
