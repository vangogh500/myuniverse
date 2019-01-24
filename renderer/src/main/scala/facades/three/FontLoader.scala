package com.github.vangogh500.myuni.renderer
package facades
package three

import scala.concurrent.{Future, Promise}
import org.scalajs.dom.XMLHttpRequest
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import com.github.vangogh500.myuni.core.facades.nodejs.Error

/**
 * Native Font loader
 */
@js.native
@JSImport("three", "FontLoader")
class NativeFontLoader() extends js.Object {
  def load(path: String,
    onLoad: js.Function1[js.Object, Unit],
    onProgress: js.Function1[XMLHttpRequest, Unit],
    onError: js.Function1[Error, Unit]): Unit = js.native
  def parse(json: js.Object): js.Object = js.native
}

/**
 * Font loader
 */
class FontLoader(native: NativeFontLoader) {
  /**
   * Load asset
   */
  def load(path: String): Future[js.Object] = {
    val promise = Promise[js.Object]()
    native.load(path, data => promise success data, xml => Unit, e => promise failure e)
    promise.future
  }
  def parse(json: js.Object): js.Object = native.parse(json)
}

/**
 * Font loader
 */
object FontLoader {
  def apply(): FontLoader = new FontLoader(new NativeFontLoader())
}
