package com.example.unshelf.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.unshelf.R
import com.example.unshelf.controller.UI_Tester_Controller
import com.example.unshelf.view.authentication.Customer_Login
import com.example.unshelf.view.authentication.CustomerRegister
import com.example.unshelf.view.RestaurantNearMe.RestaurantsNearMe
import com.example.unshelf.view.product.cart
import com.example.unshelf.view.product.product_main
import com.example.unshelf.view.Wallet.Balance
import com.example.unshelf.view.bottom_navigations.ui.MainNavigationActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_tester)

        // BUTTONS
        // define the buttons here
        // IMPORTANT: always prefix your buttons with a test, e.g., testBtnName to distinguish that it is a test button. DO THIS in the ID definition as well.
        val testBtnNearMe = findViewById<Button>(R.id.testBtnNearMe)
        val testBtnLogin = findViewById<Button>(R.id.testBtnLogin);
        val testBtnRegister = findViewById<Button>(R.id.testBtnRegister);
        val testBtnPmain = findViewById<Button>(R.id.testBtnPMain);
        val testBtnCart = findViewById<Button>(R.id.testBtnCart);
        val testBtnWallet = findViewById<Button>(R.id.testBtnWallet);
        val testSellerScreen = findViewById<Button>(R.id.testSellerScreen);

        // CONTROLLER
        //! IMPORTANT: Just call the UI_Tester_Controller.UI_Test(intent, button, java.class) to
        UI_Tester_Controller.UI_Test(this, testBtnNearMe, RestaurantsNearMe::class.java);
        UI_Tester_Controller.UI_Test(this, testBtnLogin, Customer_Login::class.java);
        UI_Tester_Controller.UI_Test(this, testBtnRegister, CustomerRegister::class.java);
        UI_Tester_Controller.UI_Test(this, testBtnPmain, product_main::class.java);
//        UI_Tester_Controller.UI_Test(this, testBtnPmain, cart::class.java);
        UI_Tester_Controller.UI_Test(this, testBtnCart, cart::class.java);
        UI_Tester_Controller.UI_Test(this, testBtnWallet, Balance::class.java);
        UI_Tester_Controller.UI_Test(this, testSellerScreen, MainNavigationActivity::class.java);
    }


}