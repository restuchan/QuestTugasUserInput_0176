package com.chan.myapplication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KontenUtama(modifier: Modifier ){
    var textNamaDepan by remember {mutableStateOf("")}
    var textNamaBelakang by remember {mutableStateOf("")}
    var textEmail by remember { mutableStateOf (value = "") }
    var textTanggalLahir by remember { mutableStateOf (value = "") }
    var textPengalaman by remember { mutableStateOf (value = "") }
    var textSkill by remember { mutableStateOf (setOf<String>()) }
}