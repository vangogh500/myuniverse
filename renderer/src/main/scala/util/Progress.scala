/**
 * Measurable future
 */
package com.github.vangogh500.myuni.renderer
package util

class Progress(init: Float) {
  private var p = init
  def +=(a: Float): Unit = p += a
  def toFloat: Float = p
}

object Progress {
  def apply(init: Float): Progress = new Progress(init)
  def unapply(p: Progress): Option[Float] = Some(p.toFloat)
}
