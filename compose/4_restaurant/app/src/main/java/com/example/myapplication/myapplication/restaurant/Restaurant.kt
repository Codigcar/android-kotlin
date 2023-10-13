package com.example.myapplication.myapplication.restaurant

data class Restaurant(val id: Int,
                      val title: String,
                      val description: String,
                      val isFavorite: Boolean = false,
    )

val dummyRestaurant = listOf(
    Restaurant(0, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(1, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(2, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(3, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(4, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(5, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(6, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(7, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(8, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(9, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(10, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(11, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(12, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(13, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),
    Restaurant(14, "Alfredo's dishes","At Alfredo's, we provide the best seafood dishes."),

)
