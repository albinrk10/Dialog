import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.dialog.CustomPreset

abstract class DialogBuilder(protected val context: AppCompatActivity) {

    protected lateinit var dialog: AlertDialog
    protected lateinit var preset: CustomPreset

    fun setPreset(preset: CustomPreset): DialogBuilder {
        this.preset = preset
        return this
    }



    fun setBackgroundColor(color: Int): DialogBuilder {
        preset = preset.copy(backgroundColor = color)
        return this
    }

    fun setTextColor(color: Int): DialogBuilder {
        preset = preset.copy(textColor = color)
        return this
    }

    abstract fun build(): DialogBuilder
    abstract fun show()



}
