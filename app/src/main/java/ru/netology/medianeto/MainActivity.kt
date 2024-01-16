package ru.netology.medianeto

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private val observer = MediaLifecycleObserver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(observer)

        findViewById<View>(R.id.play).setOnClickListener{
            observer.apply {
                resources.openRawResource(R.raw.sample).use { afd ->
                    mediaPlayer?.setDataSource(afd.fileDescriptor,afd.startoffset,afd.length)
                }
            }.play()
            }
        }
    }
}