package com.example.nestedrecyclersample.data.domain

import java.util.*

data class AnimalSection(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val animals: List<Animal> = mutableListOf(),
)

data class Animal(
    val name: String,
    val image: String,
)