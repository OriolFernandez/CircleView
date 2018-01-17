package auto.uriolus.com.recording

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setRadius()
  }

  private fun setRadius() {
    for (i in 1..100){
      circle.changeLevel(i*0.5f)
    }
  }
}