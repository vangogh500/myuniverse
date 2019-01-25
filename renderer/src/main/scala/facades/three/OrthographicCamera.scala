package com.github.vangogh500.myuni.renderer
package facades
package three

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Scene
 */
@js.native
@JSImport("three", "OrthographicCamera")
class OrthographicCamera(left: Double, right: Double, top: Double, bottom: Double, near: Double, far: Double) extends js.Object

object OrthographicCamera {
  def d2(width: Double, height: Double): OrthographicCamera = new OrthographicCamera(
    -width/2.0, width.toDouble/2.0,
    height/2.0, -height/2.0,
    -100, 100
  )
}
