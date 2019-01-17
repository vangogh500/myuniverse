/**
 * Facade for HTML Canvas
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni
package facades
package dom

import org.scalajs.dom.{document, html}

/**
 * Facade for HTML Canvas
 */
object Canvas {
  def apply(width: Int, height: Int): html.Canvas = {
    val c = document.createElement("canvas").asInstanceOf[html.Canvas]
    c.width = width
    c.height = height
    Option(c.getContext("webgl")) match {
      case None => throw new Exception("Webgl not supported")
      case Some(_) => c
    }
  }
}
