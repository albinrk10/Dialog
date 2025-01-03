package com.example.dialog

import DialogBuilder
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dialog.databinding.DialogHeroLayoutBinding



class DialogList(context: AppCompatActivity) : DialogBuilder(context) {

    private var description: String = ""
    private var elements: List<String> = listOf()
    private var onItemClick: ((String) -> Unit)? = null

    fun setDescription(description: String): DialogList {
        this.description = description
        return this
    }

    fun setList(elements: List<String>): DialogList {
        this.elements = elements
        return this
    }

    fun setOnItemClick(listener: (String) -> Unit): DialogList {
        this.onItemClick = listener
        return this
    }

    override fun build(): DialogList {
        val binding = DialogHeroLayoutBinding.inflate(LayoutInflater.from(context))

        // Aplicar el preset a la vista
        binding.root.setBackgroundColor(ContextCompat.getColor(context, preset.backgroundColor))
        binding.listViewHeroes.adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            elements
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        // Configurar acción de clic en elementos
        binding.listViewHeroes.setOnItemClickListener { _, _, position, _ ->
            onItemClick?.invoke(elements[position])
            dialog.dismiss()
        }

        binding.buttonContinueHero.apply {
            text = "CERRAR"
            setOnClickListener {
                dialog.dismiss()
            }
        }

        dialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .setCancelable(true)
            .create()

        return this
    }

    override fun show() {
        dialog.show()
    }
}
