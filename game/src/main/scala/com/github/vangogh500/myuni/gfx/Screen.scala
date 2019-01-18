/**
 * Screen
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni
package gfx

import org.scalajs.dom.{document}
import org.scalajs.dom.html.Canvas

/**
 * Screen
 */
case class Screen(canvas: Canvas) {
  val gl = canvas.getContext("webgl")
}

object Screen {
  private val canvas = {
    val c = new Canvas()
    c.width = width
    c.height = height
  }
  def apply(width: Int, height: Int, bgColor: Color): Screen = {
    val c = new Canvas()
    c.width = width
    c.height = height
    bgColor.toRGBA match {
      case (r, g, b, a) =>
        c.style.backgroundColor = s"""rgba($r, $g, $b, $a)"""
    }
    Option(c.getContext("webgl")) match {
      case None => throw new Exception("Webgl not supported")
      case Some(_) => Screen(c)
    }
  }
}
