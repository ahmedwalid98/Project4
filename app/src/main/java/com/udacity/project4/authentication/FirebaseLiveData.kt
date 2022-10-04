package com.udacity.project4.authentication

import androidx.lifecycle.LiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseLiveData:LiveData<FirebaseUser>() {
    private val firebaseAuth = FirebaseAuth.getInstance()
    val authStateListener = FirebaseAuth.AuthStateListener {firebaseAuth ->
        value = firebaseAuth.currentUser
    }
    override fun onActive() {
        super.onActive()
        firebaseAuth.addAuthStateListener(authStateListener)
    }

    override fun onInactive() {
        super.onInactive()
        firebaseAuth.removeAuthStateListener(authStateListener)
    }
}