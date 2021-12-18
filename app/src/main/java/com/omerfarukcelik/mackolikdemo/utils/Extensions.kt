package com.omerfarukcelik.mackolikdemo.utils

import java.text.SimpleDateFormat
import java.util.*

object Extensions {

  fun String.getDate(): Date {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm")
    return format.parse(this)
  }

  fun Date.formatDate(): String {
    return SimpleDateFormat("dd MMMM yyyy").format(this)
  }
}