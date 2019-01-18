/**
 * Store
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni_client
package data

import facades.electron.App
import facades.nodejs.{Path, FS}
import scala.scalajs.js.JSON

/**
 * Store
 */
object Store {
  val config = {
    val path = Path.join(App.getPath("userData"), "config.json")
    println(path)
    if(FS.existsSync(path)) {
      Preferences.default
    } else {
      val pref = Preferences.default
      FS.writeFileSync(path, JSON.stringify(value = pref, space = "\t"))
      pref
    }
  }
}
