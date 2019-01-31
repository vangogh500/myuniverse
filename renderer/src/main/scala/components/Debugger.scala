package com.github.vangogh500.myuni.renderer
package components

import scala.concurrent.ExecutionContext
import scala.scalajs.js
import scala.scalajs.js.Dynamic.global
import facades.pixi.{Text, App => PIXI}
import input.Keyboard

/**
 * Debugger
 */
class Debugger(pixi: PIXI) {
  var show = false
  val view = {
    val txt = Text("FPS: 0", "VT323", 0xFFFFFF)
    txt.anchor.set(1,0)
    txt.x = pixi.screen.width - 10
    txt.y = 10
    txt
  }
  def toggleShow(): Unit = show match {
    case true =>
      pixi.stage.removeChild(view)
      show = false
    case false =>
      pixi.stage.addChild(view)
      show = true
  }
  /**
   * Keydown event
   * @param keyCode key code
   */
  def onKeyDown(keyCode: Int): Unit = {
    keyCode match {
      case 114 => toggleShow()
      case _ => ()
    }
  }
  /**
   * Update state
   * @param dt Change in time
   */
  def update(dt: Double): Unit = show match {
    case true => view.text = s"FPS: ${pixi.ticker.FPS.toInt}"
    case false => ()
  }
}
