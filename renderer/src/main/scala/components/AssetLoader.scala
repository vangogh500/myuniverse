package com.github.vangogh500.myuni.renderer
package components

import scala.concurrent.{Future, ExecutionContext, Promise}
import facades.pixi.{Text, App => PIXI}

class AssetLoader(pixi: PIXI)(implicit ec: ExecutionContext) {
  val view = {
    val txt = Text("Loading: 0", "VT323", 0xFFFFFF)
    txt.anchor.set(0.5, 0.5)
    txt.x = pixi.screen.width / 2
    txt.y = pixi.screen.height / 2
    txt
  }
  def mount(): Unit = {
    pixi.stage.addChild(view)
  }
  def unmount(): Unit = {
    pixi.stage.removeChild(view)
  }
  def onKeyDown(keyCode: Int): Unit = ()
  def update(dt: Double): Unit = {
    view.text = s"Loading: ${pixi.loader.progress}"
  }
  def add(bundle: String): Unit = {
    Manifest.getBundle("test") foreach { bundle =>
      bundle.imgs.foreach(img => pixi.loader.add(img, Manifest.directory + "/sprite/" + img))
    }
  }
  def load(): Future[Unit] = {
    val p = Promise[Unit]()
    pixi.loader.on("complete", () => {
      p success Unit
    })
    pixi.loader.load()
    p.future
  }
}
