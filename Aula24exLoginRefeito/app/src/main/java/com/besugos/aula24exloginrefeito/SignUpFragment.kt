package com.besugos.aula24exloginrefeito

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.besugos.aula24exloginrefeito.users.UserService
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_sign_up.*

class SignUpFragment : Fragment() {

    private lateinit var mudarTabListener: IMudarTab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        val txtEditUserName = view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp)

        view.findViewById<MaterialButton>(R.id.btnSignUp).setOnClickListener {

            val user = edtTextUserNameSignUp.text.toString()
            val pass = etPassSignup.text.toString()
            if (validaEntradas(view)) {
                try {

                    UserService.register(user, pass)

                    Snackbar.make(view, "Username created with success", Snackbar.LENGTH_SHORT)
                        .show()

                    val nomeRegistrado = txtEditUserName.text.toString()

                    view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp).text?.clear()
                    view.findViewById<TextInputEditText>(R.id.etPassSignup).text?.clear()
                    view.findViewById<TextInputEditText>(R.id.etRptPassSignup).text?.clear()

                    mudarTabListener.mudarTab(SIGN_UP_FRAGMENT)
                    mudarTabListener.userNameAlterado(nomeRegistrado)



                } catch (e: Exception) {
                    Snackbar.make(view, e.message!!, Snackbar.LENGTH_LONG)
                        .setAction("Tentar novamente?") {
                            // Responds to click on the action
                        }
                        .show()
                }
            }

        }

        view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.findViewById<TextInputLayout>(R.id.txtUserNameSignup).error = ""
            }
        })

        view.findViewById<TextInputEditText>(R.id.etPassSignup).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.findViewById<TextInputLayout>(R.id.txtPasswordSignup).error = ""
            }
        })

        view.findViewById<TextInputEditText>(R.id.etRptPassSignup).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignup).error = ""
            }
        })

        return view
    }

    fun validaEntradas(view: View): Boolean {
        var resultado = true

        val edtUserName = view.findViewById<TextInputEditText>(R.id.edtTextUserNameSignUp)
        val edtPassword = view.findViewById<TextInputEditText>(R.id.etPassSignup)
        val edtRptPassword = view.findViewById<TextInputEditText>(R.id.etRptPassSignup)

        if (edtUserName.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtUserNameSignup).error = "Username Vazio"
            resultado = false
        }

        if (edtPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignup).error = "Password Vazio"
            resultado = false
        }

        if (edtPassword.text.toString().length < 8) {
            view.findViewById<TextInputLayout>(R.id.txtPasswordSignup).error = "Password deve ter 8 caracteres ou mais"
            resultado = false
        }

        if (edtRptPassword.text?.trim()!!.isBlank()) {
            view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignup).error = "Password Vazio"
            resultado = false
        }

        if (edtPassword.text.toString() != edtRptPassword.text.toString()) {
            view.findViewById<TextInputLayout>(R.id.txtRepeatPasswordSignup).error = "Passwords não coincidem"
            resultado = false
        }

        if (!(cbAgree.isChecked)) {
            view.findViewById<CheckBox>(R.id.cbAgree).error = "Passwords não coincidem"
            resultado = false
        }

        return resultado
    }



    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }
}