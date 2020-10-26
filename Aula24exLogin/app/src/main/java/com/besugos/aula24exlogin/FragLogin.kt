package com.besugos.aula24exlogin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.besugos.aula24exlogin.users.UserService
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_frag_login.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragLogin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragLogin : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val viewLogin = inflater.inflate(R.layout.fragment_frag_login, container, false)
        // Inflate the layout for this fragment
        // minhaView.findViewById<TextView>(R.id.txtMeuTextoFrag).text = param1

        val etUsername = viewLogin.findViewById<TextInputEditText>(R.id.etMailLogin)
        val etPass = viewLogin.findViewById<TextInputEditText>(R.id.etPassLogin)
        val btnLogin = viewLogin.findViewById<Button>(R.id.btnLogin)

        etUsername.text?.clear()
        etPass.text?.clear()

        btnLogin.setOnClickListener {
            if (etUsername.text.isNullOrEmpty()) {
                etUsername.error = "Campo vazio"
            } else if (etPass.text.isNullOrEmpty()) {
                etPass.error = "Campo vazio"
            } else {
                val mail = etMailLogin.text.toString()
                val pass = etPassLogin.text.toString()
                try {
                    val user = UserService.logIn(mail, pass)
                    val nome = user!!.email


                    Toast.makeText(activity, "Login successful", Toast.LENGTH_LONG).show()

                } catch (e: Exception) {
                    Snackbar.make(viewLogin, "e-mail / senha incorretos", Snackbar.LENGTH_LONG)
                        .setAction("Tentar novamente?") {
                            // Responds to click on the action
                        }
                        .show()
                }


            }


        }

        return viewLogin
    }

    companion object {


        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            FragLogin().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }


}


