package com.besugos.aula24exloginrefeito

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.besugos.aula24exloginrefeito.users.UserService
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.lang.Exception

class LoginFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab
    private lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_login, container, false)

        minhaView.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            if (validaEntradas(minhaView)) {

                val user = minhaView.findViewById<TextInputEditText>(R.id.editTextUserNameLogin).text.toString()
                val pass = minhaView.findViewById<TextInputEditText>(R.id.editTextPasswordLogin).text.toString()


                try {
                    val user = UserService.logIn(user, pass)
                    val nome = user!!.email
                    Toast.makeText(activity, "Login successful", Toast.LENGTH_LONG).show()

                } catch (e: Exception) {
                    Snackbar.make(minhaView, "e-mail / senha incorretos", Snackbar.LENGTH_LONG)
                        .setAction("Tentar novamente?") {
                            // Responds to click on the action
                        }
                        .show()
                }
                //Toast.makeText(minhaView.context, "Login realizado", Toast.LENGTH_LONG).show()
            }
        }

        minhaView.findViewById<TextInputEditText>(R.id.editTextUserNameLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                minhaView.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = ""
            }
        })

        minhaView.findViewById<TextInputEditText>(R.id.editTextPasswordLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                minhaView.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
            }
        })

        minhaView.findViewById<Button>(R.id.btnSignUpLogin).setOnClickListener {
            mudarTabListener.mudarTab(LOGIN_FRAGMENT)
        }

        return minhaView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = "Password Vazio"
            resultado = false
        }

        return resultado
    }

    fun userNameAlterado(username: String) {
        val edtUserName = minhaView.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        edtUserName.setText(username)
        val edtPassword = minhaView.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)
        edtPassword.text?.clear()
        edtPassword.requestFocus()
    }
}
