/**
 * Client
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client

import scala.concurrent.ExecutionContext.Implicits.global
import facades.electron._
import data.Store

/**
 * Client
 */
object Client {
  /**
   * Main
   */
  def main(args: Array[String]): Unit = {
    App.on("ready", () => {
      Store.load() map { store =>
        val win = BrowserWindow(
          fullscreen = store.config.screen.fullscreen,
          width = store.config.screen.resolution.width,
          height = store.config.screen.resolution.height,
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
