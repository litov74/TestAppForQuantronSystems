package ru.litov74dev.testapplication.navigation

interface Navigation {

    fun goToMain()
    fun goToSearch()
    fun goToProfile()

    fun cleanTop()
    fun cleanBackStack()
    fun goBack()

    // костыльный метод. навигация не должна быть связана с фрагментами
    fun closeScreen()

}