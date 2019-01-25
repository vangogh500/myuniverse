/**
 * Three File loader
 */
package com.github.vangogh500.myuni.renderer
package facades
package three

import scala.concurrent.{Future, Promise}
import org.scalajs.dom.XMLHttpRequest
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.typedarray.{ArrayBuffer}
import com.github.vangogh500.myuni.core.facades.nodejs.Error

/**
 * File loader
 */
@js.native
@JSImport("three", "FileLoader")
class NativeFileLoader(manager: LoadingManager) extends js.Object {
  def load(path: String,
    onLoad: js.Function1[js.Object, Unit],
    onProgress: js.Function1[XMLHttpRequest, Unit],
    onError: js.Function1[Error, Unit]): Unit = js.native
  def setPath(path: String): Unit = js.native
  def setResponseType(tp: String): Unit = js.native
}

/**
 * File loader
 */
class FileLoader(native: NativeFileLoader) {
  /**
   * Load asset
   */
  def load(path: String): Future[js.Object] = {
    val promise = Promise[js.Object]()
    native.load(path, data => promise success data, xml => Unit, e => promise failure e)
    promise.future
  }
}

/**
 * File loader
 */
object FileLoader {
  def apply(manager: LoadingManager): FileLoader = new FileLoader(new NativeFileLoader(manager))
}
