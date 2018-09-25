package com.duhok_tech.aqarat.data

class House {
    var House_ID: Int? = null
    var House_RentSale: Int? = null
    var House_Adress: String? = null
    var House_Room: Int? = null
    var House_Price: Double? = null
    var House_bathroom: Int? = null
    var House_Livingroom: Int? = null
    var House_Swedish_Room: Int? = null
    var House_Garage: Int? = null
    var House_Area: Double? = null
    var House_lat: Double? = null
    var House_lng: Double? = null
    val type: String = "house"

    constructor(House_ID: Int?, House_RentSale: Int?, House_Adress: String?, House_Room: Int?, House_Price: Double?, House_bathroom: Int?, House_Livingroom: Int?, House_Swedish_Room: Int?, House_Garage: Int?, House_Area: Double?, House_lat: Double?, House_lng: Double?) {
        this.House_ID = House_ID
        this.House_RentSale = House_RentSale
        this.House_Adress = House_Adress
        this.House_Room = House_Room
        this.House_Price = House_Price
        this.House_bathroom = House_bathroom
        this.House_Livingroom = House_Livingroom
        this.House_Swedish_Room = House_Swedish_Room
        this.House_Garage = House_Garage
        this.House_Area = House_Area
        this.House_lat = House_lat
        this.House_lng = House_lng
    }
}