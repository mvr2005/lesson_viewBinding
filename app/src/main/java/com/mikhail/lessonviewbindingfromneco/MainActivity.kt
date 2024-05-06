package com.mikhail.lessonviewbindingfromneco

/* ссылка на документацию https://developer.android.com/topic/libraries/view-binding
шаг 1 идем в Grable Scripts -> build.grable.kts(Modul :app)(открываем) в модуле android
пишем      buildFeatures {
               viewBinding = true
           }
           применить изменения в этомже окне  -> Sync new
шаг2    создаеь переменную lateinit var bindingClass = ActivityMainBinding <- класс который
        пишется по названию layout вместо _ идет большая буква следующего слова

шаг3      перед setContentView пишем
            bindingClass = ActivityMainBinding.inflate(layoutInflater)

шаг4        в аргументах setContentView  пишем (bindingClass.root)

                                ИТОГ
            Сейчас к любому злементу экрана обращаемся через переменную и id
                                bindingClass.tx1
*/

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mikhail.lessonviewbindingfromneco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var bindingClass : ActivityMainBinding    // шаг2

   val a = 324
   val b = 34


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingClass = ActivityMainBinding.inflate(layoutInflater)     // шаг3
        setContentView(bindingClass.root)                               //шаг4
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        bindingClass.tx1.text = "привет"                                //итог

        bindingClass.bt1.setOnClickListener {
            if (bindingClass.tx2.visibility == View.GONE) {
                bindingClass.tx2.visibility = View.VISIBLE
            } else {bindingClass.tx2.visibility = View.GONE}
        }

        bindingClass.bt10.setOnClickListener {
            val result = a * b
            bindingClass.tx10.text = "рузультат равен - $result"           //можно так (правельнее)
        }
        bindingClass.bt20.setOnClickListener {
            val result = a + b
            bindingClass.tx10.text = "рузультат равен - " + result.toString()            //а мщжно так
        }
        bindingClass.bt30.setOnClickListener {
            val result = a - b
            bindingClass.tx10.text = result.toString()
        }


    }
}