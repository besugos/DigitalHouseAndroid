package com.digitalhouse.fakeloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        UserService.register("Felipe", "felipe@mail.com", "123")
//        UserService.logIn("felipe@mail.com", "123")

        btnCreateLogin.setOnClickListener {
            etMailLogin.text?.clear()
            etPassLogin.text?.clear()
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogInLogin.setOnClickListener {
            if (etMailLogin.text.toString() == "") {
                etMailLogin.error = "Campo vazio"
            } else if (etPassLogin.text.toString() == "") {
                etPassLogin.error = "Campo vazio"
            } else {
                val mail = etMailLogin.text.toString()
                val pass = etPassLogin.text.toString()
                try {
                    val user = UserService.logIn(mail, pass)
                    val nome = user!!.name
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra("NOME", nome)
                    startActivity(intent)
                } catch (e:Exception) {
                    Snackbar.make(telaLogin, "e-mail / senha incorretos", Snackbar.LENGTH_LONG)
                        .setAction("Tentar novamente?") {
                            // Responds to click on the action
                        }
                        .show()


                }




            }
        }

    }
}