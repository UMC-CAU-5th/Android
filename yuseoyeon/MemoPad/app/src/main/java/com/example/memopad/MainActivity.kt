package com.example.memopad

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.memopad.databinding.ActivityMainBinding
import com.example.memopad.databinding.ActivityMemoViewBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    lateinit var memotext:String
    private var gson: Gson =Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFinish.setOnClickListener {

        }
    }


    override fun onResume() {
        super.onResume()
        val sharedPreferences=getSharedPreferences("memo", MODE_PRIVATE)
        val memoJson=sharedPreferences.getString("memoData",null)

        memotext=if(memoJson!=null){
            gson.fromJson(memoJson,String::class.java)
        }
        else ""

        binding.memoEditText.text=Editable.Factory.getInstance().newEditable(memotext)

    }

    override fun onRestart() {
        super.onRestart()
        val builder=AlertDialog.Builder(this)
            .setMessage("이어서 작성하시겠습니까?")
            .setNegativeButton("네"){dialog, which -> Toast.makeText(this,"다시작성",Toast.LENGTH_SHORT).show() }
            .setPositiveButton("아니요"){dialog,which->
                    binding.memoEditText.text=Editable.Factory.getInstance().newEditable("")}
            .show()
    }

    override fun onPause() {
        super.onPause()
        memotext=binding.memoEditText.text.toString()
        val sharedPreferences=getSharedPreferences("memo", MODE_PRIVATE)
        val editor=sharedPreferences.edit()
        val memoJson=gson.toJson(memotext)
        editor.putString("memoData",memoJson)

        editor.apply()
    }

}