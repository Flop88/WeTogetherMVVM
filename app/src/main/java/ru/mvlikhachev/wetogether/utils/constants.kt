package ru.mvlikhachev.wetogether.utils

import ru.mvlikhachev.wetogether.MainActivity
import ru.mvlikhachev.wetogether.database.DatabaseRepository

lateinit var APP_ACTIVITY: MainActivity
lateinit var REPOSITORY: DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"