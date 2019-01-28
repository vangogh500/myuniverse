package com.github.vangogh500.myuni.renderer
package facades
package three

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Text Geometry
 */
@js.native
@JSImport("three", "TextGeometry")
class TextGeometry(text: String, opts: TextGeometry.Opts) extends js.Object

object TextGeometry {
  trait Opts extends js.Object {
    val font: Font
    val size: Option[Float]
    val height: Option[Float]
  }
  object Opts {
    def apply(f: Font, s: Option[Float], h: Option[Float]) = new Opts {
      val font = f
      val size = s
      val height = h
    }
  }
  def apply(
    text: String,
    font: Font,
    size: Option[Float] = None,
    height: Option[Float] = None): TextGeometry = new TextGeometry(text, Opts(font, size, height))
}
