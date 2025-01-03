package com.example.dialog

import DialogBuilder
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.dialog.databinding.DialogLayoutBinding

class DialogSimpleOption(context: AppCompatActivity) : DialogBuilder(context) {

    private var title: String = ""
    private var description: String = ""
    private var onAgreeClosure: (() -> Unit)? = null

    fun setTitle(title: String): DialogSimpleOption {
        this.title = title
        return this
    }

    fun setDescription(description: String): DialogSimpleOption {
        this.description = description
        return this
    }

    fun setAgreeClosure(closure: () -> Unit): DialogSimpleOption {
        this.onAgreeClosure = closure
        return this
    }

    override fun build(): DialogSimpleOption {
        val binding = DialogLayoutBinding.inflate(LayoutInflater.from(context))

        // Aplicar el preset a la vista
        binding.root.setBackgroundColor(ContextCompat.getColor(context, preset.backgroundColor))
        binding.buttonContinue.apply {
            text = description
            setTextSize(preset.textDescriptionSize)
            setTextColor(ContextCompat.getColor(context, preset.textColor))
        }
        binding.buttonContinue.apply {
            text = "CONTINUAR"
            setOnClickListener {
                onAgreeClosure?.invoke()
                dialog.dismiss()
            }
        }

        dialog = AlertDialog.Builder(context)
            .setView(binding.root)
            .setCancelable(false)
            .create()

        return this
    }

    override fun show() {
        dialog.show()
    }
}
