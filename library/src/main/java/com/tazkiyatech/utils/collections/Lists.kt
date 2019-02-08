package com.tazkiyatech.utils.collections

/**
 * Joins the [String]s in this [List] between indexes 0 (inclusive) and [toIndex] (exclusive) using a space separator.
 */
fun List<String>.joinWithSpaceSeparator(toIndex: Int = size): String {
    return subList(0, toIndex).joinToString(separator = " ")
}