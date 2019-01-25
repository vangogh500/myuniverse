package com.github.vangogh500.myuni.renderer

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import gfx.Screen
import input.Keyboard
import facades.three.{Scene, LoadingManager, OrthographicCamera}
import org.scalajs.dom.{document, window}

/**
 * App
 */
class App() {
  val screen = Screen.init()
  val manager = new LoadingManager()
  var fps = 0
  var debug = false
  /**
   * Keydown event
   * @param keyCode key code
   */
  def onKeyDown(keyCode: Int): Unit = {
    keyCode match {
      case 114 => debug = !debug
      case _ =>
    }
  }
  /**
   * Update state
   * @param dt Change in time
   */
  def update(dt: Int): Unit = {
    fps = 1000/dt
  }
  /**
   * Render app
   */
  def render(): Unit = {
    screen.render()
  }
  /**
   * Game loop
   * @param d0 Time of previous loop iteration
   */
  private def loop(t0: Long): () => Unit = () => {
    val t1 = js.Date.now().toLong
    val dt = (t1 - t0).toInt
    if(dt < (1000 / 60)) {
      global.window.requestAnimationFrame(loop(t0))
    }
    else {
      global.window.requestAnimationFrame(loop(t1))
      update(dt)
      render()
    }
  }
  /**
   * Start container
   */
  def start(): Unit = {
    Keyboard.onKeyDown(onKeyDown)
    loop(js.Date.now().toLong)()
  }
}

object App {
  def init(): App = new App()
}
