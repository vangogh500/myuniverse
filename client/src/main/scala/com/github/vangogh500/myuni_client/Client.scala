/**
 * Client
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client

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
      val win = BrowserWindow(
        width = 1600,
        height = 900,
        frame = false
      )
      win.loadFile("./res/index.html")
      println(Store.config)
    })
    App.on("window-all-closed", () => App.quit())
  }
}
