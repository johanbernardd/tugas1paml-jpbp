package com.example.tugas1paml_jpbp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// ViewModel ini digunakan untuk menyimpan serta mempertahankan hasil
// perkalian ketika layar dirotasi/diputar
class ViewModelVolume: ViewModel() {
    // MutableLiveData bertujuan untuk menyimpan hasil perkalian dalam bentuk Double setiap
    // kali terjadi perubahan
    private val res = MutableLiveData<Double>()
    // LiveData membuat komponen UI dapat mengupdate tampilannya secara otomatis
    val result: LiveData<Double> get() = res

    // Fungsi yang bertujuan untuk menghitung volume dalam konteks ini adalah balok
    fun hitungPerkalian(p: Double, l: Double, t: Double) {
        res.value = p * l * t // Menghitung volume perkalian balok
    }
}