package com.example.unshelf.model.entities


class Store ( // please add methods (example: getters or setters)
// (if user can modify something, add setter)
// (use getters for a summary of details, returning an object or string)
    var storeID : String,
    val sellerID : String,
    val address: String,
    val rating : Double,
    val followers: Int,
    val isVerified : String,
    val storeName : String,
    val sellerName : String,
    val thumbnail : String,
)

