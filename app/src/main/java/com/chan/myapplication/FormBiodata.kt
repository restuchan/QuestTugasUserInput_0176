package com.chan.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

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
    ) {
        Image(
            painter = painterResource(id = R.drawable.gambar1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(1f)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ){
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 250.dp),
                    shape = RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 30.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    ),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                ){
                    Text(
                        stringResource(R.string.Judul),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.titel_color),
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .fillMaxWidth(1f),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        stringResource(R.string.Caption),
                        fontSize = 15.sp,
                        color = colorResource(id = R.color.black),
                        modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(1f),
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 30.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 5.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ){
                        OutlinedTextField(
                            value = textNamaDepan,
                            singleLine = true,
                            label = { Text(stringResource( R.string.Depan)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color),
                            ),
                            onValueChange = {
                                textNamaDepan = it
                            }
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            singleLine = true,
                            label = { Text(stringResource(R.string.Belakang)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color),
                            ),
                            onValueChange = {
                                textNamaBelakang = it
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 5.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 5.dp),
                    ){
                        OutlinedTextField(
                            value = textEmail,
                            singleLine = true,
                            label = { Text(stringResource(R.string.Email)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color),
                            ),
                            onValueChange = {
                                textEmail = it
                            }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 5.dp,
                                start = 20.dp,
                                end = 20.dp,
                                bottom = 10.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        OutlinedTextField(
                            value = textTanggalLahir,
                            onValueChange = { },
                            readOnly = true,
                            singleLine = true,
                            label = { Text(stringResource(  R.string.TglLahir)) },
                            shape = MaterialTheme.shapes.large,
                            modifier = Modifier.weight(1f),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = colorResource(id = R.color.outline_color),
                                focusedLabelColor = colorResource(id = R.color.outline_color),
                            ),
                            trailingIcon = {
                                IconButton(onClick = { showDatePicker = true }) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = null
                                    )
                                }
                            }
                        )
                        ExposedDropdownMenuBox(
                            expanded = expandedDropdown,
                            onExpandedChange = { expandedDropdown = !expandedDropdown },
                            modifier = Modifier.weight(1f)
                        ){
                            OutlinedTextField(
                                value = textPengalaman,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text(stringResource(R.string.Pengalaman)) },
                                shape = MaterialTheme.shapes.large,
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown) },
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = colorResource(id = R.color.outline_color),
                                    focusedLabelColor = colorResource(id = R.color.outline_color),
                                ),
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                            )
                            ExposedDropdownMenu(
                                expanded = expandedDropdown,
                                onDismissRequest = { expandedDropdown = false }
                            ) {
                                listPengalaman.forEach { option ->
                                    DropdownMenuItem(
                                        text = { Text(option) },
                                        onClick = {
                                            textPengalaman = option
                                            expandedDropdown = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 0.dp,
                                start = 12.dp,
                                end = 20.dp,
                                bottom = 10.dp)
                    ) {
                        listSkill.forEach { skill ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.weight(1f)
                            ) {
                                Checkbox(
                                    checked = textSkill.contains(skill),
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = colorResource(id = R.color.outline_color),
                                    ),
                                    onCheckedChange = { isChecked ->
                                        if (isChecked) {
                                            textSkill = textSkill + skill
                                        } else {
                                            textSkill = textSkill - skill
                                        }
                                    }
                                )
                                Text(
                                    text = skill,
                                    modifier = Modifier.padding(start = 2.dp)
                                )
                            }
                        }
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                        enabled = textNamaDepan.isNotEmpty() && textNamaBelakang.isNotEmpty() && textEmail.isNotEmpty() && textTanggalLahir.isNotEmpty() && textPengalaman.isNotEmpty() && textSkill.isNotEmpty(),
                        onClick = {
                            NamaDepan = textNamaDepan
                            NamaBelakang = textNamaBelakang
                            Email = textEmail
                            TanggalLahir = textTanggalLahir
                            Pengalaman = textPengalaman
                            Skill = textSkill

                            isSubmitted = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.button_color),
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.Simpan),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }

                if (showDatePicker) {
                    DatePickerDialog(
                        onDismissRequest = { showDatePicker = false },
                        confirmButton = {
                            TextButton(onClick = {
                                val selectedMillis = datePickerState
                                    .selectedDateMillis
                                if (selectedMillis != null) {
                                    val formatter =
                                        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                                    textTanggalLahir = formatter.format(Date(selectedMillis))
                                }
                                showDatePicker = false
                            },) {
                                Text(stringResource(R.string.ok), color = colorResource(id = R.color.titel_color))
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDatePicker = false }) {
                                Text(stringResource(R.string.batal), color = colorResource(id = R.color.titel_color))
                            }
                        }
                    ) {
                        DatePicker(
                            state = datePickerState,
                            colors = androidx.compose.material3.DatePickerDefaults.colors(
                                selectedDayContainerColor = colorResource(id = R.color.outline_color),
                                todayDateBorderColor = colorResource(id = R.color.titel_color)
                            )
                        )
                    }
                }
            }
            if (isSubmitted) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 20.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.black)
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                stringResource(R.string.DataTersimpan),
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(id = R.color.white),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )

                            Text(
                                stringResource (R.string.Nama_Card) + " $NamaDepan $NamaBelakang",
                                color = colorResource(id = R.color.white)
                            )
                            Text(
                                stringResource (R.string.Email_Card) + " $textEmail",
                                color = colorResource(id = R.color.white)
                            )
                            Text(
                                stringResource (R.string.TanggalLahir_Card) + " $TanggalLahir",
                                color = colorResource(id = R.color.white)
                            )
                            Text(
                                stringResource (R.string.Pengalaman_Card) + " $Pengalaman",
                                color = colorResource(id = R.color.white)
                            )

                            val skillGabungan = Skill.joinToString(", ")

                            Text(
                                stringResource ( R.string.Keahlian_Card) + " $skillGabungan",
                                color = colorResource(id = R.color.white)
                            )
                        }
                    }
                }
            }
        }
    }
}


