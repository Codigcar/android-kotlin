package com.example.myapplication.myapplication.restaurant

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantsViewModel(): ViewModel() {

    private lateinit var restInterface: RestaurantsApiServices
    private lateinit var restaurantsCall: Call<List<Restaurant>>

    // TODO-> inicializar el valor con la lista dummy
    //val state = mutableStateOf(dummyRestaurant)

    // TODO-> inicializar el valor con la lista vacia
    val state = mutableStateOf(emptyList<Restaurant>())

    init {
        instanceRetrofit()
    }

    fun getRestaunts() = dummyRestaurant
    private fun getRestaurantsByAPI() {
        /*restInterface.getRestaurants().execute().body()?.let {
            restaurants -> state.value = restaurants
        }*/

        restaurantsCall = restInterface.getRestaurants()
        restaurantsCall.enqueue(
            object: Callback<List<Restaurant>> {
                override fun onResponse(call: Call<List<Restaurant>>, response: Response<List<Restaurant>>) {
                    response.body()?.let {
                        restaurants -> state.value = restaurants
                    }
                }

                override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        restaurantsCall.cancel()
    }

    fun toggleFavorite(id: Int) {
        val restaurants = state.value.toMutableList()
        val itemIndex = restaurants.indexOfFirst{ it.id == id }
        val item = restaurants[itemIndex]
        restaurants[itemIndex] = item.copy(isFavorite = !item.isFavorite)
        state.value = restaurants
    }

   fun instanceRetrofit() {
       val retrofit: Retrofit = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl("https://restaurant-jetpack-default-rtdb.firebaseio.com/")
           .build()

       restInterface = retrofit.create(RestaurantsApiServices::class.java)
       getRestaurantsByAPI()
   }

}
