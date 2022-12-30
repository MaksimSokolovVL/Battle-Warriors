package com.company.utility

class Stack<T> {

    private val stack = mutableListOf<T>()
    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T {
        val resultItem = stack[stack.lastIndex]
        stack.remove(resultItem)
        return resultItem
    }

    fun isEmpty(): Boolean {
        return stack.size > 0
    }
}

