package com.github.vangogh500.myuni.renderer

import scala.concurrent.ExecutionContext
import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import facades.pixi.{Text, App => PIXI}
import input.Keyboard
import components.{Debugger, AssetLoader}
import facades.pixi.loaders.Loader

/**
 * Launcher
 */
class Launcher(pixi: PIXI)(implicit ec: ExecutionContext) {
  var debug = false
  val debugger = new Debugger(pixi)
  val loader = {
    val manager = new AssetLoader(pixi)
    manager.mount()
    manager.add("test")
    manager.load().foreach(Unit => {
      println("test")
    })
    manager
  }
  /**
   * Keydown event
   * @param keyCode key code
   */
  def onKeyDown(keyCode: Int): Unit = {
    debugger.onKeyDown(keyCode)
    loader.onKeyDown(keyCode)
  }
  /**
   * Update state
   * @param dt Change in time
   */
  def update(dt: Double): Unit = {
    debugger.update(dt)
    loader.update(dt)
  }
}

object Launcher {
  def init()(implicit ec: ExecutionContext): Launcher = {
    val pixi = PIXI.init()
    val launcher = new Launcher(pixi)
    pixi.ticker.add(delta => launcher.update(delta))
    Keyboard.onKeyDown(launcher.onKeyDown)
    launcher
  }
}
