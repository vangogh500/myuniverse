package com.github.vangogh500.myuni.renderer
package facades
package three

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import org.scalajs.dom.html.{Canvas}

/**
 * WebGL Renderer
 */
@js.native
@JSImport("three", "WebGLRenderer")
class WebGLRenderer() extends js.Object {
  def domElement: Canvas = js.native
  def setSize(width: Double, height: Double): Unit = js.native
  def render(scene: Scene, camera: OrthographicCamera): Unit = js.native
}
