package com.example.unshelf.controller

import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import com.example.unshelf.model.entities.Order
import com.example.unshelf.model.entities.Product
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

object OrderApprovalController {
    val db = FirebaseFirestore.getInstance()
    var quantityLow = mutableStateOf(false)
    fun acceptOrder(order: Order){
        val currentUser = FirebaseAuth.getInstance().currentUser!!.uid
        CoroutineScope(Dispatchers.Default).launch{
            quantityLow.value = false
            val storeProducts = order.products
            val status = hashMapOf("orderStatus" to "accepted")
            for(product in storeProducts){
                val p_id = product.productID
                val data = db.collection("products").document("p_id").get().await()
                if(data.exists()){
                    var productFetch = data.toObject(Product::class.java)!!
                    if(productFetch.quantity - product.quantity < 0){
                        quantityLow.value = true
                        return@launch
                    }
                    productFetch.quantity -= product.quantity
                    db.collection("products").document("p_id").set(productFetch, SetOptions.merge()).await()
                }
            }

        }
    }

    fun rejectOrder(orderId: String){

    }
}