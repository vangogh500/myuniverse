package com.github.vangogh500.myuni.renderer

import gfx.Screen

/**
 * Game stats
 */
case class GameStats() {
  var fps: Int = 0
  def update(dt: Int): Unit = {
    fps = 1000/dt
  }
  def render()(implicit sc: Screen): Unit = {
    sc.fillText(fps + "", 10, 10)
  }
}
