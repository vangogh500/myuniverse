package com.github.vangogh500.myuni.renderer

import scala.concurrent.ExecutionContext.Implicits.global
import facades.pixi.{App => PIXI}


object Main {
  def main(args: Array[String]): Unit = {
    Launcher.init()
  }
}
