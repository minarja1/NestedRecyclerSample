package com.example.nestedrecyclersample.data.domain

data class AnimalSection(
    val title: String,
    val animals: List<Animal> = mutableListOf(),
)

data class Animal(
    val name: String,
    val image: String,
)