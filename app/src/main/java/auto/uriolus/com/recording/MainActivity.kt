package auto.uriolus.com.recording

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  private val INTERVAL = 10L
  var mHandler = Handler()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    circle.changeLevel(1f)
    circle.changeLevel(2f)
    circle.changeLevel(1f)
    //startRepeatingTask()
  }


  var mHandlerTask: Runnable = object : Runnable {
    override fun run() {
      circle.changeLevel(Math.random().toFloat())
      mHandler.postDelayed(this, INTERVAL)
    }
  }

  fun startRepeatingTask() {
    mHandlerTask.run()
  }

  fun stopRepeatingTask() {
    mHandler.removeCallbacks(mHandlerTask)
  }
}