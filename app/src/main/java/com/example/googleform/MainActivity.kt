package com.example.googleform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.TextWatcher
import android.widget.Toast
import com.example.googleform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Use current email
        binding.useCurentEmailBtn.setOnClickListener{
            currentEmailBtn()
        }
        //when checked from checkbox
        binding.showPassCheck.setOnClickListener{
            showPass()
        }
        //sign in instead
        binding.signinInsteadBtn.setOnClickListener{
            insteadBtn()
        }
        //when click Next btn
        binding.nextBtn.setOnClickListener{
            if (!IsValidFirstName())
                Toast.makeText(MainActivity@ this, "Enter valid first name", Toast.LENGTH_SHORT).show()
            else if (!isValidLastName())
                Toast.makeText(MainActivity@ this, "Enter valid last name", Toast.LENGTH_SHORT).show()
            //else if (!isValidEmail())
                //Toast.makeText(MainActivity@ this, "Enter valid email", Toast.LENGTH_SHORT).show()
            else if (!isValidPassword())
                Toast.makeText(MainActivity@ this, "Enter valid password", Toast.LENGTH_SHORT).show()
            else
                nextBtn()
        }



    }

    //first name validation
    fun IsValidFirstName(): Boolean {
        return !binding.firstNameEditText.toString().isEmpty()
    }
    //last name validation
    fun isValidLastName(): Boolean {
        return !binding.lastNameEditText.toString().isEmpty()
    }
    //email validation
    fun isValidEmail(): Boolean {
        var mailInput = binding.usernameEditText.toString().trim()

        return if (mailInput.isEmpty())
            false
        else
            android.util.Patterns.EMAIL_ADDRESS.matcher(mailInput).matches()

    }
    //password validation
    fun isValidPassword(): Boolean {
        var password = binding.passwordEditText.text.toString().trim()
        var confirmPassword = binding.passwordConfirmEditText.text.toString().trim()
        return password.equals(confirmPassword) && !password.isEmpty()
    }
    //next btn DO
    fun nextBtn() {
        return Toast.makeText(MainActivity@ this, "You are click next button", Toast.LENGTH_SHORT).show()
    }
    //sign in instead btn DO
    fun insteadBtn() {
        return Toast.makeText(MainActivity@ this, "You are click sign in instead", Toast.LENGTH_SHORT).show()
    }
    //show pass DO
    fun showPass() {
        if (binding.showPassCheck.isChecked) {
            binding.passwordEditText.inputType = InputType.TYPE_CLASS_TEXT
            binding.passwordConfirmEditText.inputType = InputType.TYPE_CLASS_TEXT
        } else {
            binding.passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            binding.passwordConfirmEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
    }
    //current email btn DO
    fun currentEmailBtn() {
        return Toast.makeText(MainActivity@ this, "You are click use current email", Toast.LENGTH_SHORT).show()
    }
}

