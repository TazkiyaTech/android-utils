package com.tazkiyatech.utils.collections

/**
 * Returns true if the receiving array contains any of the specified elements.
 *
 * @param elements the elements to look for in the receiving array.
 * @return true if any element in [elements] is found in the receiving array.
 */
fun <T> Array<T>.containsAny(vararg elements: T): Boolean {
    return any(elements.toSet()::contains)
}