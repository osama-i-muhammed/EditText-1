package com.duhok_tech.aqarat.menuActivit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.duhok_tech.aqarat.R
import android.widget.Toast
import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.util.Log
import kotlinx.android.synthetic.main.activity_call.*
import android.graphics.Paint.UNDERLINE_TEXT_FLAG




class Call : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        btEmailSalar.setOnClickListener {
            sendEmail("salarkhalid97@gmail.com")
        }
        btEmailSalar.paintFlags = btEmailSalar.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btEmailOsama.paintFlags = btEmailOsama.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btPhoneSalar.paintFlags = btPhoneSalar.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btPhoneOsama.paintFlags = btPhoneOsama.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        btEmailOsama.setOnClickListener {
            sendEmail("zduhoki93@gmail.com")
        }
        btPhoneSalar.setOnClickListener { dialContactPhone("009647503505440") }
        btPhoneOsama.setOnClickListener { dialContactPhone("009647503505440") }
    }

    private fun dialContactPhone(phoneNumber: String) {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)))
    }
    protected fun sendEmail(sender:String) {
        Log.i("Send email", "")

        val TO = arrayOf(sender)
        val CC = arrayOf("xyz@gmail.com")
        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type = "text/plain"


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
//        emailIntent.putExtra(Intent.EXTRA_CC, CC)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject")
        emailIntent.putExtra(Intent.EXTRA_TEXT, "\n\n\n\n\nFrom "+getString(R.string.app_name))

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            finish()
            Log.i("Finished sending email", "")
        } catch (ex: android.content.ActivityNotFoundException) {
            Toast.makeText(this@Call,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show()
        }

    }

}
