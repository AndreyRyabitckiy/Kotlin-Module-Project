fun String?.isDigit() = this?.toIntOrNull()?.let { true } ?: false
