package com.example.calculadoraspinnerlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.calculadoraspinnerlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var vec=ArrayList<String>(4)
        vec.add("Suma")
        vec.add("Resta")
        vec.add("Multiplicación")
        vec.add("División")
        val adaptador= ArrayAdapter(this,R.layout.item_lista,R.id.txtItem,vec)
        binding.spLista.adapter=adaptador

        binding.spSpinner.adapter=adaptador
        var resultado=""



        binding.spLista.setOnItemClickListener { adapterView, view, i, l ->
            when(i){
                0 ->
                    try {
                        resultado=((Integer.parseInt(binding.txtOperador1.text.toString()).toFloat()+(Integer.parseInt(binding.txtOperador2.text.toString()).toFloat())).toString())

                    }catch (e:java.lang.Exception){
                        Toast.makeText(this, "El número introducido no es válido", Toast.LENGTH_SHORT).show()
                    }

                1 ->
                    try {
                        resultado=((Integer.parseInt(binding.txtOperador1.text.toString()).toFloat()-(Integer.parseInt(binding.txtOperador2.text.toString()).toFloat())).toString())
                    }catch (e:java.lang.Exception){
                        Toast.makeText(this, "El número introducido no es válido", Toast.LENGTH_SHORT).show()
                    }
                2 ->
                    try {
                        resultado=((Integer.parseInt(binding.txtOperador1.text.toString()).toFloat()*(Integer.parseInt(binding.txtOperador2.text.toString()).toFloat())).toString())
                    }catch (e:java.lang.Exception){
                        Toast.makeText(this, "El número introducido no es válido", Toast.LENGTH_SHORT).show()
                    }

                3 ->
                    try {
                        resultado=((Integer.parseInt(binding.txtOperador1.text.toString()).toFloat()/(Integer.parseInt(binding.txtOperador2.text.toString()).toFloat())).toString())
                    }catch (e:java.lang.Exception){
                        Toast.makeText(this, "El número introducido no es válido", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        //He buscado la extension necesario para que cuando selecciones un elemento se active la función pero no he podido encontrarla
        /*binding.spSpinner.setOnItemClickListener { adapterView, view, i, l ->
            when(i){
                0 -> binding.textView2.text=((Integer.parseInt(binding.txtOperador1.text.toString())+(Integer.parseInt(binding.txtOperador2.text.toString()))).toString())
                1 -> binding.textView2.text=((Integer.parseInt(binding.txtOperador1.text.toString())-(Integer.parseInt(binding.txtOperador2.text.toString()))).toString())
                2 -> binding.textView2.text=((Integer.parseInt(binding.txtOperador1.text.toString())*(Integer.parseInt(binding.txtOperador2.text.toString()))).toString())
                3 -> binding.textView2.text=((Integer.parseInt(binding.txtOperador1.text.toString())+(Integer.parseInt(binding.txtOperador2.text.toString()))).toString())

            }
        }*/

    }
    fun valoresotravenana(resultado:String){
        val inntent:Intent= Intent(this, VentanaResult::class.java)
        inntent.putExtra("res",resultado)
        startActivity(inntent)
    }
}