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
import android.widget.TextView
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
        var LD = 0
        var texttt = findViewById<EditText>(R.id.Texttt)
        var three_part = findViewById<LinearLayout>(R.id.LDpart)
        var four_part = findViewById<LinearLayout>(R.id.four_part)
        var ImV = findViewById<ImageView>(R.id.ImV)
        val gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            // Обработчик двойного клика
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
        val gestureDetector1 = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            //обработчик лонг клика
            override fun onLongPress(e: MotionEvent) {
                if (LD == 0) {
                    LD = 1
                    three_part.background =
                        AppCompatResources.getDrawable(this@MainActivity, R.color.purple)
                } else {
                    LD = 0
                    three_part.background =
                        AppCompatResources.getDrawable(this@MainActivity, R.color.black)
                }
            }
        })
        var Texttttt = findViewById<TextView>(R.id.textttttttt)
        texttt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Проверяем введенный текст и изменяем содержимое three_part
                if (s?.toString()?.lowercase()?.contains("samsung") == true) {
                    Texttttt?.text = "ААА"
                }
            }

            override fun afterTextChanged(s: Editable?) {}
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
        three_part.setOnTouchListener { _, event ->
            gestureDetector1.onTouchEvent(event)
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