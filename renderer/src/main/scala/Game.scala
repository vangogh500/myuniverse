package com.github.vangogh500.myuni.renderer

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import gfx.Screen
import input.Keyboard

/**
 * Game
 */
case class Game(state: GameState)(implicit sc: Screen, keys: Keyboard) {
  /**
   * Keydown event
   * @param keyCode key code
   */
  private def onKeyDown(keyCode: Int): Unit = {
    state.onKeyDown(keyCode)
  }
  /**
   * Update game state
   */
  private def update(dt: Int): Unit = {
    state.update(dt)
  }
  /**
   * Render game to screen
   */
  private def render(): Unit = {
    sc.clear()
    state.render()
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
    keys.onKeyDown(onKeyDown)
    loop(js.Date.now().toLong)()
  }
}

/**
 * Game
 */
object Game {
  def init(): Game = {
    Game(GameState())(Screen.load(), Keyboard.load())
  }
}
