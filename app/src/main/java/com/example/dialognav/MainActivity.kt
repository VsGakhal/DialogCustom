package com.example.dialognav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Dialog
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dialognav.databinding.CustomLayoutBinding



class MainActivity : AppCompatActivity() {

    lateinit var tvText: TextView
    lateinit var btnDialog  : Button
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btnLogin: Button
    lateinit var tvForgotPassword: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.etEnterEmail)
        password = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvForgotPassword = findViewById(R.id.tvForgotPassword)

        btnDialog = findViewById(R.id.btnDialog)
        tvText = findViewById(R.id.tvWelcome)

        btnDialog.setOnClickListener {
            var dialogBinding = CustomLayoutBinding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etAmount.setText(tvText.text.toString())
            dialogBinding.btnOk.setOnClickListener {
                if(dialogBinding.etAmount.text.toString().isNullOrEmpty()){
                    Toast.makeText(this, "enter amount", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                tvText.setText(dialogBinding.etAmount.text.toString())

                btnLogin.setOnClickListener {
                    var enteredEmail = email.text.toString()
                    var enteredPassword = password.text.toString()
                    if (email.text.toString().isNullOrEmpty()==true){
                        email.error=resources.getString(R.string.enter_email)
                    }
                    else if(password.text.toString().isNullOrEmpty()==true){
                        password.error=resources.getString(R.string.Password)
                        password.requestFocus()
                    }
                    else if ((password.text.toString().length?:0)<6){
                        password.error=resources.getString(R.string.Password)
                    }
                    else {

                        Toast.makeText(this,R.string.imp,Toast.LENGTH_LONG).show()
                    }
                dialog.dismiss()
            }

            dialog.show()

        }
    }
}
}