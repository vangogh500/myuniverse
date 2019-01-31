package com.github.vangogh500.myuni.renderer

import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import facades.pixi.{Text, App => PIXI}
import input.Keyboard

/**
 * Launcher
 */
class Launcher(pixi: PIXI) {
  var debug = false
  val view = {
    val txt = Text("FPS: 0", "VT323", 0xFFFFFF)
    txt.anchor.set(1,0)
    txt.x = pixi.screen.width - 10
    txt.y = 10
    txt
  }

  def toggleDebug(): Unit = debug match {
    case true =>
      pixi.stage.removeChild(view)
      debug = false
    case false =>
      pixi.stage.addChild(view)
      debug = true
  }
  /**
   * Keydown event
   * @param keyCode key code
   */
  def onKeyDown(keyCode: Int): Unit = {
    keyCode match {
      case 114 => toggleDebug()
      case _ => ()
    }
  }
  /**
   * Update state
   * @param dt Change in time
   */
  def update(dt: Double): Unit = {
    view.text = s"FPS: ${pixi.ticker.FPS.toInt}"
  }
}

object Launcher {
  def init(): Launcher = {
    val pixi = PIXI.init()
    val launcher = new Launcher(pixi)
    pixi.ticker.add(delta => launcher.update(delta))
    Keyboard.onKeyDown(launcher.onKeyDown)
    launcher
  }
}
