package com.example.tugas1paml_jpbp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.example.tugas1paml_jpbp.ui.theme.Tugas1pamljpbpTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugas1paml_jpbp.ViewModelVolume

// Class MainActivity ini bertujuan sebagai tampilan utama untuk menghitung volume
class MainActivity : AppCompatActivity() {

    // Melakukan inisialisasi ViewModel menggunakan viewModels()
    private val viewModel: ViewModelVolume by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Menggunakan layout XML dari activity_main sebagai tampilan utama untuk Activity-nya
        setContentView(R.layout.activity_main)

        // Melakukan proses inisialisasi dari setiap komponen UI pada activity_main.xml
        val editPanjang = findViewById<EditText>(R.id.edt_panjang) // Input nilai panjang
        val editLebar = findViewById<EditText>(R.id.edt_lebar) // Input nilai lebar
        val editTinggi = findViewById<EditText>(R.id.edt_tinggi) // Input nilai tinggi
        val tombolHitung = findViewById<Button>(R.id.btn_hitung) // Tombol klik hitung
        val textviewHasil = findViewById<TextView>(R.id.tv_hasil) // Tampilan hasil perkalian

        // Melihat dan mengecek perubahan data result(hasil perkalian) di ViewModel
        viewModel.result.observe(this) { result ->
            textviewHasil.text = result?.toString() ?: "0" // Tampilan hasil perkalian
        }

        // Fungsionalitas tombol hitung untuk menghitung volume(p*l*t)
        tombolHitung.setOnClickListener {
            val p = editPanjang.text.toString().toDoubleOrNull() ?: 0.0 // Ambil data nilai panjang
            val l = editLebar.text.toString().toDoubleOrNull() ?: 0.0 // Ambil data nilai lebar
            val t = editTinggi.text.toString().toDoubleOrNull() ?: 0.0 // Ambil data nilai tinggi
            // Kemudian akan di-convert ke bentuk Double serta secara default akan diisi 0 apabila
            // nilai kosong atau invalid

            // Akan mengimplementasi ViewModel terhadap hasil perkalian dengan memanggil fungsi
            // yang telah dibuat agar mampu mempertahankan hasil perkalian ketika layar dirotasi
            viewModel.hitungPerkalian(p, l, t)
        }
    }
}