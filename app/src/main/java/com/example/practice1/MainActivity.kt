package com.example.practice1
import android.view.GestureDetector.OnDoubleTapListener
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Проверка на дабл клик
        var condtionForRD = 0
        var LK = 0
        var four_part = findViewById<LinearLayout>(R.id.four_part)
        var ImV = findViewById<ImageView>(R.id.ImV)
        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            // Обработчик двойного клика
            override fun onLongPress(e: MotionEvent) {
                if (LK == 0) {
                    LK = 1

                }
            }
            override fun onDoubleTap(e: MotionEvent): Boolean {
                 if (ImV.visibility == View.VISIBLE){
                    ImV.visibility = View.INVISIBLE
                }
                else{
                    ImV.visibility = View.VISIBLE
                }
                return true
            }
        })

        //Просто кнопка, меняющая цвет фона
        var button = findViewById<Button>(R.id.MyFirstButton)
        var backGroung = findViewById<LinearLayout>(R.id.BG)
        var colorNow1 = "red"
        button.setOnClickListener{
            if (colorNow1 == "red") {
                colorNow1 = "yellow"
                backGroung.background = AppCompatResources.getDrawable(this, R.color.yellow)
            }
            else{
                colorNow1 = "red"
                backGroung.background = AppCompatResources.getDrawable(this, R.color.red)
            }
        }
        // Назначаем обработчик касаний для всей активности
        // не совсем понимаю, почему именно так, но работает
        four_part.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }

    }


    override fun onStart(){
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }
}