/**
 * Screen
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package gfx

import org.scalajs.dom.{document, window}
import org.scalajs.dom.CanvasRenderingContext2D
import org.scalajs.dom.raw.WebGLRenderingContext
import org.scalajs.dom.html.{Canvas}

/**
 * Screen
 * Uses two canvases: one for gfx and one for txt
 * @constructor
 * @param gl Webgl context on gfx canvas
 * @param ctx Web2d context on txt canvas
 */
case class Screen(gl: WebGLRenderingContext, ctx: CanvasRenderingContext2D) {
  def clear(): Unit = {
    ctx.clearRect(0,0, ctx.canvas.width, ctx.canvas.height)
  }
  def fillText(txt: String, x: Int, y: Int): Unit = {
    ctx.fillText(txt, x, y)
  }
}

/**
 * Screen
 */
object Screen {
  /**
   * Intialize screen using canvases on the window
   */
  def load(): Screen = {
    val gl = document.getElementById("canvas").asInstanceOf[Canvas].getContext("webgl").asInstanceOf[WebGLRenderingContext]
    val ctx = document.getElementById("text").asInstanceOf[Canvas].getContext("2d").asInstanceOf[CanvasRenderingContext2D]
    // fix aspect ratio
    gl.canvas.width = gl.canvas.clientWidth
    gl.canvas.height = gl.canvas.clientHeight
    ctx.canvas.width = ctx.canvas.clientWidth
    ctx.canvas.height = ctx.canvas.clientHeight
    // text settings
    ctx.textBaseline = "top"
    ctx.fillStyle = "white"
    ctx.font = "24px VT323"
    Screen(gl, ctx)
  }
}
