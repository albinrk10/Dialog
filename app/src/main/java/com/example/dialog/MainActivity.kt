package com.example.dialog

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dialog.databinding.ActivityMainBinding
import com.example.dialog.databinding.DialogHeroLayoutBinding
import com.example.dialog.databinding.DialogLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflar el layout con View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar insets para adaptarse a las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón para el primer diálogo
        binding.buttonShowDialog.setOnClickListener {
            showDialog()
        }

        // Botón para el segundo diálogo
        binding.buttonShowDialog2.setOnClickListener {
            showHeroDialog()
        }
    }

    // Función para el primer diálogo
    private fun showDialog() {
        // Inflar el diseño personalizado
        val dialogBinding = DialogLayoutBinding.inflate(layoutInflater)

        // Crear el diálogo
        val dialog = AlertDialog.Builder(this)
            .setTitle("Título del Diálogo") // Agregar el título aquí
            .setView(dialogBinding.root)
            .setCancelable(true) // Permite que se cierre tocando fuera del diálogo
            .create()

        dialog.show()

        // Configurar el botón del diálogo con View Binding
        dialogBinding.buttonContinue.setOnClickListener {
            dialog.dismiss() // Cerrar el diálogo al presionar el botón
        }
    }

    // Función para el segundo diálogo
    private fun showHeroDialog() {
        // Configurar View Binding para el segundo diálogo
        val dialogBinding = DialogHeroLayoutBinding.inflate(layoutInflater)



        // Crear el diálogo
        val dialog = AlertDialog.Builder(this)
            .setTitle("Héroes") // Establecer el título aquí
            .setView(dialogBinding.root)
            .setCancelable(true)
            .create()

        dialog.show()


        // Lista de héroes para mostrar
        val heroes = arrayOf("Iron Man", "Spider-Man", "Venom", "Capitán América")

        // Configurar el ListView del diálogo con View Binding
        dialogBinding.listViewHeroes.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, heroes)

        // Configurar el botón del diálogo con View Binding
        dialogBinding.buttonContinueHero.setOnClickListener {
            dialog.dismiss() // Cerrar el diálogo al presionar el botón
        }

//        // Configurar la lista de héroes
//        val listView: ListView = dialogView.findViewById(R.id.list_view_heroes)
//        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, heroes)
//
//        // Configurar el botón de continuar
//        val continueButton: Button = dialogView.findViewById(R.id.button_continue_hero)
//        continueButton.setOnClickListener {
//            dialog.dismiss() // Cerrar el diálogo al presionar el botón
//        }
    }


    // Activar diseño de borde a borde
    private fun enableEdgeToEdge() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
    }
}