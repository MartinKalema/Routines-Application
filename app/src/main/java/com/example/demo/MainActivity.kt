package com.example.demo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.demo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        var payload3 = intent.getStringExtra("Open_routine")

        binding = ActivityMainBinding.inflate(layoutInflater)
        //Inflating. Converting an XML layout file into a hierarchy of view objects and returning the reference to the root view.
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //check  whether favorites database contains data
        val favoritesHelper = FavoritesDB(this@MainActivity)
        val favorites = favoritesHelper.getAllNames()

        //The first fragment we see when we open the application will be the Favorites fragment.
       if(favorites.isNotEmpty()){
           fragmentSelector(FavoritesFragment())
       }else{
           fragmentSelector(FavFragment())
       }




        binding.bottomMenu.setOnItemSelectedListener {
            //sets a listener to be notified when a menu item in a bottomNavigationView is selected
            when(it.itemId){
                //if we have data in the favorites DB, then display the FavoritesFragment
                R.id.fav -> if(favorites.isNotEmpty()){
                    fragmentSelector(FavoritesFragment())
                }else{
                    fragmentSelector(FavFragment())
                }
                R.id.thing -> fragmentSelector(ThingFragment())
                //If we have data in the database then display the Rout fragment
                R.id.rout-> if(DatabaseHelper(this@MainActivity).getAllNames().isNotEmpty()){
                    fragmentSelector(Rout2Fragment())
                }else{
                    fragmentSelector(RoutFragment())
                }
                R.id.ide -> fragmentSelector(IdeasFragment())
                R.id.set -> fragmentSelector(SettFragment())
            }// Used to switch between different fragments based on the ID of the selected menu item.
            true
        }

        //Opening second Routine Fragment
        if(payload3 != null && payload3 == "Open second routine fragment"){
            fragmentSelector(Rout2Fragment())
            binding.bottomMenu.menu.findItem(R.id.rout).isChecked = true
            payload3 = null

            Toast.makeText(this, "Notification scheduled successfully", Toast.LENGTH_LONG).show()
        }


    }

    private fun fragmentSelector(fragment: Fragment){
        val mySupport = supportFragmentManager
        val myTransaction = mySupport.beginTransaction()
        // beginTransaction() returns an instance of the FragmentTransaction class
        myTransaction.replace(R.id.container, fragment)
        myTransaction.commit()

        //mySupport is an instance of supportFragmentManager.
        //SupportFragmentManager is a class responsible for managing fragments in an application. Its used to add, replace, or remove fragments in an activity.
        //Its used in conjunction with a fragmentTransaction object that has access to the add(), commit(), remove() and replace() functions.
    }
}