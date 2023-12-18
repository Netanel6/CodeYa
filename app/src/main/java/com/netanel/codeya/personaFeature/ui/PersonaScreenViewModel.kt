package com.netanel.codeya.personaFeature.ui

import androidx.lifecycle.ViewModel
import com.netanel.codeya.PersonaNumberProperties
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * Created by netanelamar on 25/09/2023.
 * NetanelCA2@gmail.com
 */

@HiltViewModel
class PersonaScreenViewModel @Inject constructor() : ViewModel() {
    private val _firstPersonaNumber: PersonaNumberProperties by lazy { firstPersonaNumber }
    var firstPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()
    private val _secondPersonaNumber: PersonaNumberProperties by lazy { secondPersonaNumber }
    var secondPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()
    private val _thirdPersonaNumber: PersonaNumberProperties by lazy { thirdPersonaNumber }
    var thirdPersonaNumber: PersonaNumberProperties = PersonaNumberProperties()


    // TODO: Send data to storage and retrieve it here and move to the next page with the text or texts from storage

/*import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FileDownloadTask;
import java.io.File;
import java.io.IOException;

// ...

// Initialize Firebase Storage
FirebaseStorage storage = FirebaseStorage.getInstance();

// Reference to the file you want to download
StorageReference storageRef = storage.getReference().child("path/to/your/file.jpg");

// Create a local file to save the downloaded file
File localFile = new File(getApplicationContext().getFilesDir(), "downloaded_file.jpg");

// Download the file into the local file
storageRef.getFile(localFile).addOnSuccessListener(taskSnapshot -> {
    // File successfully downloaded
    // You can now use the localFile for further processing
}).addOnFailureListener(exception -> {
    // Handle any errors that may occur during the download
    exception.printStackTrace();
});*/


}