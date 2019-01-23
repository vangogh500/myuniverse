package com.github.vangogh500.myuni.renderer

import gfx.Screen

/**
 * Game stats
 */
case class GameState() {
  /** Whether to show debug */
  var debug = false
  /** FPS */
  var fps: Int = 0
  /**
   * Keydown event
   * @param keyCode key code
   */
  def onKeyDown(keyCode: Int): Unit = keyCode match {
    case 114 => debug = !debug
  }
  /**
   * Update state
   * @param dt Change in time
   */
  def update(dt: Int): Unit = {
    fps = 1000/dt
  }
  /**
   * Render state
   * @param sc screen object used for rendering
   */
  def render()(implicit sc: Screen): Unit = {
    if(debug) {
      sc.fillTextRight("fps: " + fps, sc.width - 10, 10)
    }
  }
}
