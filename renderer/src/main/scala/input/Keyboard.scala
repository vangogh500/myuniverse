package com.github.vangogh500.myuni.renderer
package input

import org.scalajs.dom
import scala.scalajs.js.Dynamic.global

/**
 * Keyboard
 */
object Keyboard {
  def onKeyDown(fn: Int => Unit): Unit = {
    global.addEventListener("keydown", (e: dom.KeyboardEvent) => {
      fn(e.keyCode)
    })
  }
}
