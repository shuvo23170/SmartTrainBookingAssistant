package com.shuvo.smarttrainbookingassistant

import android.app.Activity
import android.os.Bundle
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var fromInput: EditText
    private lateinit var toInput: EditText
    private lateinit var dateInput: EditText
    private lateinit var trainInput: EditText
    private lateinit var countInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pad = (20 * resources.displayMetrics.density).toInt()
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
            setBackgroundColor(0xFFF5F7FA.toInt())
        }
        val heading = TextView(this).apply {
            text = "Smart Train Booking Assistant"
            textSize = 22f
            setTextColor(0xFF12345A.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 12, 0, 20)
        }
        root.addView(heading, match())
        fromInput = field("From station (e.g. Dhaka)")
        toInput = field("To station (e.g. Chattogram)")
        dateInput = field("Journey date (DD-MM-YYYY)")
        trainInput = field("Preferred train (optional)")
        countInput = field("Passenger count", "1")
        listOf(fromInput, toInput, dateInput, trainInput, countInput).forEach { root.addView(it, match()) }

        root.addView(Button(this).apply {
            text = "Copy journey details"
            setOnClickListener { copyDetails() }
        }, match())
        root.addView(Button(this).apply {
            text = "Open Bangladesh Railway website"
            setOnClickListener { openRailwaySite() }
        }, match())
        root.addView(TextView(this).apply {
            text = "This app helps prepare your trip details. You must complete availability checks, CAPTCHA/OTP, booking and payment yourself on the official railway website."
            textSize = 13f
            setTextColor(0xFF555555.toInt())
            setPadding(4, 20, 4, 4)
        }, match())
        setContentView(root)
    }

    private fun field(hintText: String, value: String = "") = EditText(this).apply {
        hint = hintText
        setText(value)
        textSize = 16f
        singleLine = true
        setPadding(12, 8, 12, 8)
    }

    private fun match() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply { bottomMargin = (8 * resources.displayMetrics.density).toInt() }

    private fun copyDetails() {
        val details = "From: ${fromInput.text}\nTo: ${toInput.text}\nDate: ${dateInput.text}\nTrain: ${trainInput.text}\nPassengers: ${countInput.text}"
        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("Train journey details", details))
        Toast.makeText(this, "Journey details copied", Toast.LENGTH_SHORT).show()
    }

    private fun openRailwaySite() {
        val url = "https://eticket.railway.gov.bd/"
        val chromeIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.android.chrome")
        try {
            startActivity(chromeIntent)
        } catch (_: Exception) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }
    }
}
