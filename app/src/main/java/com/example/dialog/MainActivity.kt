package com.example.dialog
import com.example.dialog.DialogSimpleOption
import com.example.dialog.DialogList
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dialog.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Preset personalizado
        val customPreset = CustomPreset(
            backgroundColor = android.R.color.white,
            backgroundBorderColor = android.R.color.darker_gray,
            textTitleSize = 18f,
            textDescriptionSize = 14f,
            textColor = android.R.color.black
        )

        // Mostrar diálogo simple
        binding.buttonShowDialog.setOnClickListener {
            DialogSimpleOption(this)
                .setPreset(customPreset) // Ensure customPreset is defined
                .setTitle("Título")
                .setDescription("¿Estás seguro de continuar?")
                .setAgreeClosure {
                    Toast.makeText(this, "Acción ejecutada", Toast.LENGTH_SHORT).show()
                }
                .build()
                .show()
        }
        // Mostrar diálogo con listado
        binding.buttonShowDialog2.setOnClickListener {
            DialogList(this)
                .setPreset(customPreset)
                .setDescription("Lista de elementos:")
                .setList(listOf("Elemento 1", "Elemento 2", "Elemento 3"))
                .setOnItemClick {
                    Toast.makeText(this, "Seleccionaste: $it", Toast.LENGTH_SHORT).show()
                }
                .build()
                .show()
        }
    }
}