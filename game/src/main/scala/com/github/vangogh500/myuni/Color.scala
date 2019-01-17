/**
 * Color
 * @author Kai Matsuda
 */
trait Color {
  def toString: String
  def toRGB: (Int, Int, Int)
}

class HexColor(hexStr: String) {
  def toString: String = str
  def toRGB: (Int, Int, Int) = (
    Integer.parseInt(hex.slice(0,2), 16)),
    Integer.parseInt(hex.slice(2,4), 16)),
    Integer.parseInt(hex.slice(4,6), 16)
  )
}

object Color {
  private val regex = """^#([0-9a-fA-F]{6})$""".r
  def apply(str: String): Color = str match {
    case regex(hex) => new Color {
      def toString: String = str
      def toRGB: (Int, Int, Int) = (
        Integer.parseInt(hex.slice(0,2), 16)),
        Integer.parseInt(hex.slice(2,4), 16)),
        Integer.parseInt(hex.slice(4,6), 16)
      )
    }
    case _ => throw new Exception("Invalid color " + str)
  }
}
