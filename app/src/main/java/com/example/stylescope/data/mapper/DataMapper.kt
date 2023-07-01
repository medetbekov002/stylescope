package com.example.stylescope.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}