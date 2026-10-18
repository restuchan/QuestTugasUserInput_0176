package com.chan.myapplication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KontenUtama(modifier: Modifier ){
    var textNamaDepan by remember {mutableStateOf("")}
    var textNamaBelakang by remember {mutableStateOf("")}
    var textEmail by remember { mutableStateOf (value = "") }
    var textTanggalLahir by remember { mutableStateOf (value = "") }
    var textPengalaman by remember { mutableStateOf (value = "") }
    var textSkill by remember { mutableStateOf (setOf<String>()) }

    var NamaDepan by remember { mutableStateOf (value = "") }
    var NamaBelakang by remember { mutableStateOf (value = "") }
    var Email by remember { mutableStateOf (value = "") }
    var TanggalLahir by remember { mutableStateOf (value = "") }
    var Pengalaman by remember { mutableStateOf (value = "") }
    var Skill by remember { mutableStateOf (setOf<String>())}

    val listPengalaman = stringArrayResource(id = R.array.listPengalaman)
    val listSkill = stringArrayResource(id = R.array.listSkill)

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()
    var expandedDropdown by remember { mutableStateOf(false) }
    var isSubmitted by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {}
}