VigereneCipher
==============

Java class of the Vigenere cipher
--------------

* Usage (Method 1): 
 ``` System.out.print(new VigenereCipher(keyword, text)); ```
 - @param String keyword (Required)
 - @param String text    (Required)
 - @return the text encrypted

* Usage (Method 2):
 ``` VigenereCipher obj = new VigenereCipher();
 obj.setKeyword(keyword);
 obj.setText(text); 
 obj.encrypt();
 System.out.print(obj.getCipherText())
 ```
 
