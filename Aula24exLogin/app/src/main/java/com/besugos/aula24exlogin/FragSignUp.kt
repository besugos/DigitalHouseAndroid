package com.besugos.aula24exlogin

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.besugos.aula24exlogin.users.UserService
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_frag_sign_up.*
import java.lang.Exception

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragSignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragSignUp : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val let = arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewSignup =  inflater.inflate(R.layout.fragment_frag_sign_up, container, false)
        val main = super.getActivity()
        val viewLogin = FragLogin

        val etUsername = viewSignup.findViewById<TextInputEditText>(R.id.etMailSignup)
        val etPass1 = viewSignup.findViewById<TextInputEditText>(R.id.etPassSignup)
        val etPass2 = viewSignup.findViewById<TextInputEditText>(R.id.etRptPassSignup)
        val cbAgree = viewSignup.findViewById<CheckBox>(R.id.cbAgree)
        val btnSignUp = viewSignup.findViewById<Button>(R.id.btnSignup)
        val pager = main?.findViewById<ViewPager>(R.id.view_pager)
        val tab = main?.findViewById<TabLayout>(R.id.tab_layout)

        etUsername.text?.clear()
        etPass1.text?.clear()
        etPass2.text?.clear()
        cbAgree.isChecked = false

        btnSignUp.setOnClickListener { it: View? ->
            if (etUsername.text.isNullOrEmpty()) {
                etUsername.error = "Campo vazio"
            } else if (etPass1.text.isNullOrEmpty()) {
                etPass1.error = "Campo vazio"
            } else if (etPass2.text.isNullOrEmpty()) {
                etPass2.error = "Campo vazio"
            } else if (etPass1.text.toString() != etPass2.text.toString()) {
                etPass2.error = "Senhas não coincidem"
            } else if (!cbAgree.isChecked) {
                cbAgree.error = "É necessário concordar com os termos"
            } else {

                val user = etMailSignup.text.toString()
                val pass = etPassSignup.text.toString()

                try {
                    UserService.register(user, pass)
                    //Toast.makeText(this@FragSignUp!!, "Usuário cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    Snackbar.make(viewSignup, "Username created with success", Snackbar.LENGTH_LONG)
                        .show()




                } catch (e: Exception) {
                    Snackbar.make(viewSignup, e.message!!, Snackbar.LENGTH_LONG)
                        .setAction("Tentar novamente?") {
                            // Responds to click on the action
                        }
                        .show()
                }
            }
        }





        return viewSignup
    }


}