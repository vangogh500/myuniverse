package com.github.vangogh500.myuni.renderer

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import gfx.Screen

/**
 * Game
 */
case class Game()(implicit sc: Screen) {
  val stats = GameStats()
  /**
   * Update game state
   */
  def update(dt: Int): Unit = {
    stats.update(dt)
  }
  /**
   * Render game to screen
   */
  def render(): Unit = {
    sc.clear()
    stats.render()
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
   * Start game
   */
  def start(): Unit = {
    loop(js.Date.now().toLong)()
  }
}

/**
 * Game
 */
object Game {
  def init(): Game = {
    Game()(Screen.load())
  }
}
