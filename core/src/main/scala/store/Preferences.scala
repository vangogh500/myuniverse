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
 * Advanced screen preferences
 */
trait AdvancedScreenPreferences extends js.Object {
  val fpsCap: Int
}

/**
 * Advanced screen preferences
 */
object AdvancedScreenPreferences {
  def default: AdvancedScreenPreferences = new AdvancedScreenPreferences {
    val fpsCap = 60
  }
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
 * Screen Preferences
 */
object ScreenPreferences {
  def default: ScreenPreferences = new ScreenPreferences {
    val fullscreen = true
    val resolution = ResolutionPreferences.default
    val advanced = AdvancedScreenPreferences.default
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
  /**
   * Default preferences
   */
  def default: Preferences = new Preferences {
    val screen = ScreenPreferences.default
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
