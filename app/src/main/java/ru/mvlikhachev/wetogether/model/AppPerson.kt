package ru.mvlikhachev.wetogether.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_tables")
data class AppPerson(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo
    val yourName: String = "",

    @ColumnInfo
    val yourBirthdayDate: String = "",

    @ColumnInfo
    val yourGender: Int = 0,

    @ColumnInfo
    val partnerName: String = "",

    @ColumnInfo
    val partnerBirthdayDate: String = "",

    @ColumnInfo
    val partnerGender: Int = 0,

    @ColumnInfo
    val loveDate: String = ""

)
