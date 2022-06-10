package com.example.myapplication.presentation.ui.home

import com.example.myapplication.data.movie.Movie

class HomeProvider {

    companion object{
        val homemovieList = listOf<Movie>(
            Movie(1,"https://pandoramarketing.net/wp-content/uploads/2020/12/MV5BM2EwMmRhMmUtMzBmMS00ZDQ3LTg4OGEtNjlkODk3ZTMxMmJlXkEyXkFqcGdeQXVyMjM5ODk1NDU@._V1_.jpg","9/6/22","QueensGambit","4.5"),
            Movie(2,"https://larepublica.pe/resizer/xasqoMSWfBL2KyBWXBisabtys5M=/1250x735/top/smart/cloudfront-us-east-1.images.arcpublishing.com/gruporepublica/DSZBWAL4K5HRXBHQEZWVMGBTZM.jpg","9/6/22","PeakyBliders","5.0"),
            Movie(3,"https://m.media-amazon.com/images/I/71HGgigujnL._SL1500_.jpg","9/6/22","Suit","3.5")
        )
    }

}