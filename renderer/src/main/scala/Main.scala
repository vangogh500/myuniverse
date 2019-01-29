package com.github.vangogh500.myuni.renderer

import scala.concurrent.ExecutionContext.Implicits.global
import com.github.vangogh500.myuni.core.facades.electron.{App => ElectronApp}


object Main {
  def main(args: Array[String]): Unit = {
    new App().start()
  }
}
