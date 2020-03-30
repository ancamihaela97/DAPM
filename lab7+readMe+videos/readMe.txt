 Lab 7, Stefan Anca 1240F

In this lab I learnt about TextToSpeech and how to use Fragments.
   1) For the first exercise: I set the language to UK english using setLanguage() function. I used the speechRecognizer function to
create an intent that can start the Speech Recognizer activity. The intent is populated with the speech text when the following function is called
startActivityForResult(intent, SPEECH_REQUEST_CODE);
In the onActivityResult() function I process the intent and extract the speech text from the intent. I put the text in the EditText using setText() function.
For the listen Button I use a OnClickListener to display the audio. I get the the text from the EditText and i use the speak(str, TextToSpeech.QUEUE_FLUSH, null) function
on the TextToSpeech parameter.
  2) For the second exercise: I followed the tutorial and saw exactly how to implement the Fragments. In order to change the fragments
I used the replace() method.
Overall I had no difficulties in solving the lab.
For the first exercise I could not use the screen recorder and the app in the same time because both of them were using the Mic so I had to use
another phone to film it :)) hope that is ok.
