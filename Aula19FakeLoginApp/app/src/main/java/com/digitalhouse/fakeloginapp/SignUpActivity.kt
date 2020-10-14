package com.digitalhouse.fakeloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import com.digitalhouse.fakeloginapp.users.UserService
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.lang.Exception

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnLogInSignup.setOnClickListener {
            finish()
        }

        checkReadSignup.setOnCheckedChangeListener { _, isChecked ->
            btnSignUpSignup.isEnabled = isChecked
        }
        
        btnSignUpSignup.setOnClickListener { 
            if (etNameSignup.text.toString() == "") {
                etNameSignup.error = "Campo vazio"
            } else if (etMailSignup.text.toString() == "") {
                etMailSignup.error = "Campo vazio"
            } else if (etPassSignup.text.toString() == "") {
                etPassSignup.error = "Campo vazio"
            } else {
                val nome = etNameSignup.text.toString()
                val mail = etMailSignup.text.toString()
                val pass = etPassSignup.text.toString()

                try {
                    UserService.register(nome, mail, pass)
                    finish()
                    Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show()
                } catch (e: Exception) {
                    Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}