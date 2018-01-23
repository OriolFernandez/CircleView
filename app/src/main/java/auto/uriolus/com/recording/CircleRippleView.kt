package auto.uriolus.com.recording

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View


class CircleRippleView : View {
  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs,
      defStyleAttr)

  private var paint: Paint
  private var canvasSize: Int = 0
  private var radius = 0f
  private val minRadius = 30f
  private var level = 1f
  private var maxLevel = 1f;

  init {
    paint = Paint()
    paint.isAntiAlias = true
    paint.style = Paint.Style.FILL

    //Circle color
    paint.color = Color.RED
  }

  fun changeLevel(inputLevel: Float) {
    if ((inputLevel / maxLevel) > 1) {
      //Adapt to max value
      maxLevel = inputLevel
    }
    this.level = inputLevel / maxLevel
    invalidate()
  }

  public override fun onDraw(canvas: Canvas) {
    canvasSize = canvas.width;
    radius = minRadius + (((canvasSize - minRadius*2 ) / 2 ) * level)
    // circleCenter is the x or y of the view's center
    // radius is the radius in pixels of the cirle to be drawn
    // paint contains the shader that will texture the shape
    val circleCenter = (canvasSize ) / 2f
    canvas.drawCircle(circleCenter , circleCenter ,
        radius, paint)

  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    val width = measureWidth(widthMeasureSpec)
    val height = measureHeight(heightMeasureSpec)
    setMeasuredDimension(width, height)
  }

  private fun measureWidth(measureSpec: Int): Int {
    var result = 0
    val specMode = View.MeasureSpec.getMode(measureSpec)
    val specSize = View.MeasureSpec.getSize(measureSpec)

    if (specMode == View.MeasureSpec.EXACTLY) {
      // The parent has determined an exact size for the child.
      result = specSize
    } else if (specMode == View.MeasureSpec.AT_MOST) {
      // The child can be as large as it wants up to the specified size.
      result = specSize
    } else {
      // The parent has not imposed any constraint on the child.
      result = canvasSize
    }

    return result
  }

  private fun measureHeight(measureSpecHeight: Int): Int {
    var result = 0
    val specMode = View.MeasureSpec.getMode(measureSpecHeight)
    val specSize = View.MeasureSpec.getSize(measureSpecHeight)

    if (specMode == View.MeasureSpec.EXACTLY) {
      // We were told how big to be
      result = specSize
    } else if (specMode == View.MeasureSpec.AT_MOST) {
      // The child can be as large as it wants up to the specified size.
      result = specSize
    } else {
      // Measure the text (beware: ascent is a negative number)
      result = canvasSize
    }

    return result + 2
  }

}