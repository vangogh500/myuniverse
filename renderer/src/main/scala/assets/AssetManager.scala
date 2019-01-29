package com.github.vangogh500.myuni.renderer
package assets

import scala.collection.mutable.Map
import org.scalajs.dom.raw.{HTMLImageElement}
import facades.dom.Image

/**
 * Asset manager manifest.json
 */
object AssetManager {
  var imgs = Map[String, HTMLImageElement]()
  var progress = 0.0

  def load(pkg: String): Unit = {
    progress = 0.0
  }
}
