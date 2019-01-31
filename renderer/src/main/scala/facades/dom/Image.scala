/**
 * Native dom image
 */
package com.github.vangogh500.myuni.renderer
package facades
package dom

import org.scalajs.dom
import org.scalajs.dom.raw.{HTMLImageElement}
import scala.concurrent.{Future, Promise}

object Image {
  private val home = "./res/asset/sprite/salesman1"
  def load(src: String): Future[HTMLImageElement] = {
    val p = Promise[HTMLImageElement]()
    val element = dom.document.createElement("img").asInstanceOf[HTMLImageElement]
    element.onload = (e: dom.Event) => {
      p success element
    }
    element.src = "./res/asset/manifest.json" + src
    p.future
  }
}
