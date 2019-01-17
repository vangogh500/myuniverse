/**
 * Color
 * @author Kai Matsuda
 */
package com.github.vangogh500.myuni

trait Color {
  def toHexString: String
  def toRGB: (Int, Int, Int)
}

object Color {
  private val hexstring = """^([0-9a-fA-F]{6})$""".r
  private val hashhexstring = """^#([0-9a-fA-F]{6})$""".r
  private def fromHexString(hex: String): Color = new Color {
    def toHexString: String = hex
    def toRGB: (Int, Int, Int) = (
      Integer.parseInt(hex.slice(0,2), 16),
      Integer.parseInt(hex.slice(2,4), 16),
      Integer.parseInt(hex.slice(4,6), 16)
    )
  }
  def apply(str: String): Color = str match {
    case hexstring(hex) => fromHexString(hex)
    case hashhexstring(hex) => fromHexString(hex)
  }
  def apply(r: Int, g: Int, b: Int): Color = new Color {
    def toHexString: String = r.toHexString + g.toHexString + b.toHexString
    def toRGB: (Int, Int, Int) = (r, g, b)
  }
  val Black = apply(0,0,0)
}
