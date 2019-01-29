/**
 * Screen
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni.renderer
package gfx

import org.scalajs.dom.{document, window}
import org.scalajs.dom.CanvasRenderingContext2D
import org.scalajs.dom.raw.{WebGLRenderingContext, HTMLImageElement}
import org.scalajs.dom.html.{Canvas}

/**
 * Screen
 */
object Screen {
  def width = ctx.canvas.width
  def height = ctx.canvas.height
  private val gl = document.getElementById("canvas").asInstanceOf[Canvas].getContext("webgl").asInstanceOf[WebGLRenderingContext]
  private val ctx = document.getElementById("text").asInstanceOf[Canvas].getContext("2d").asInstanceOf[CanvasRenderingContext2D]
  def clear(): Unit = {
    ctx.clearRect(0,0, ctx.canvas.width, ctx.canvas.height)
  }
  def fillTextTopLeft(txt: String, x: Int, y: Int): Unit = {
    ctx.textAlign = "left"
    ctx.fillText(txt, x, y)
  }
  def fillTextTopRight(txt: String, x: Int, y: Int): Unit = {
    ctx.textAlign = "right"
    ctx.fillText(txt, width - x, y)
  }
  def resize(): Unit = {
    gl.canvas.width = gl.canvas.clientWidth
    gl.canvas.height = gl.canvas.clientHeight
    ctx.canvas.width = ctx.canvas.clientWidth
    ctx.canvas.height = ctx.canvas.clientHeight
    ctx.textBaseline = "top"
    ctx.fillStyle = "white"
    ctx.font = "24px VT323"
  }
  def drawImage(img: HTMLImageElement, dx: Int, dy: Int): Unit = {
    ctx.drawImage(img, dx, dy)
  }
}
