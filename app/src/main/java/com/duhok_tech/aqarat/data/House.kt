package com.duhok_tech.aqarat.data

import com.duhok_tech.aqarat.Tools.Const

class House {
    var ID: Int? = null
    var RentSale: Int? = null
    var Address: String? = null
    var Room: Int? = null
    var Price: Double? = null
    var bathroom: Int? = null
    var Livingroom: Int? = null
    var Swedish_Room: Int? = null
    var Garage: Int? = null
    var Area: Double? = null
    var lat: Double? = null
    var lng: Double? = null
    val type: String = Const.HOUSE

    constructor(ID: Int?, RentSale: Int?, Address: String?, Room: Int?, Price: Double?, bathroom: Int?, Livingroom: Int?, Swedish_Room: Int?, Garage: Int?, Area: Double?, lat: Double?, lng: Double?) {
        this.ID = ID
        this.RentSale = RentSale
        this.Address = Address
        this.Room = Room
        this.Price = Price
        this.bathroom = bathroom
        this.Livingroom = Livingroom
        this.Swedish_Room = Swedish_Room
        this.Garage = Garage
        this.Area = Area
        this.lat = lat
        this.lng = lng
    }
}