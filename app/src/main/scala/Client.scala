/**
 * Client
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.app

import scala.concurrent.ExecutionContext.Implicits.global
import com.github.vangogh500.myuni.core.store.Preferences
import com.github.vangogh500.myuni.core.facades.electron.{App, BrowserWindow}

/**
 * Client
 */
object Client {
  /**
   * Main
   */
  def main(args: Array[String]): Unit = {
    App.on("ready", () => {
      Preferences.load() map { config =>
        val win = BrowserWindow(
          fullscreen = config.screen.fullscreen,
          width = config.screen.resolution.width,
          height = config.screen.resolution.height,
          frame = false,
          show = false
        )
        win.loadFile("./res/index.html")
        win.on("ready-to-show", () => win.show())
        win.on("closed", () => App.quit())
      }
    })
    App.on("window-all-closed", () => App.quit())
  }
}
