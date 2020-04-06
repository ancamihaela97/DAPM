https://firebase.google.com/docs/database/android/start?fbclid=IwAR1d7jInH_7yYe08NRr3CNtQ0r5wS2BFdAcU-EzLPIK1Fl9lI0gkD821KSs
https://theengineerscafe.com/save-and-retrieve-data-firebase-android/?fbclid=IwAR1LMa1SavJTWpIH4DPknEiRKfU86zi9EeY8QgSoUwfyAFC44-TOXpfHXxU

For this lab we followed these 2 tutorials for using Firebase with our android application. We followed every step for configuring
the Firebase console and database, added our project, made the connection adding all the required dependencies and the google-services json
We used these 2 commands to make sure we are writing in the demo collection from our database
        //database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
        demoRef = rootRef.child("demo");
We used this for setting a value for our collection:
//push creates a unique id in database
demoRef.child("value").setValue(value);
and also we used this function to fetch the value from Firebase using DataSnapShot

public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        demoValue.setText(value);
                    }

For the ex 2 we read all the document and followed the tutorial but we did not uploaded it on git.
We added the docx for the ex1 and a short video of the app and a ss with the firebase.
Lab 8: Stefan Anca-Mihaela; Seit-Amet Ailin
