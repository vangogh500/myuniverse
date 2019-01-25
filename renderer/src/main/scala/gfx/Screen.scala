/**
 * Screen
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package gfx

import org.scalajs.dom.{document, window}
import facades.three.{Scene, WebGLRenderer, OrthographicCamera, TextGeometry}

case class Screen(scene: Scene, camera: OrthographicCamera, renderer: WebGLRenderer) {
  def render(): Unit = {
    renderer.render(scene, camera)
  }
}

/**
 * Screen
 */
object Screen {
  def init(): Screen = {
    val (w, h) = (window.innerWidth, window.innerHeight)
    val renderer = new WebGLRenderer()
    val scene = new Scene()
    scene.add(new TextGeometry("HELLO WORLD"))
    val camera = OrthographicCamera.d2(w, h)
    renderer.setSize(w, h)
    document.body.appendChild(renderer.domElement)
    Screen(scene, camera, renderer)
  }
}
