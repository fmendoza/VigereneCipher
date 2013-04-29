VigereneCipher
==============

Java class of the Vigenere cipher
--------------

* Usage (Method 1): 

 - @param String keyword (required)
 - @param String text    (required)
 - @return the text encrypted

 ```java
 System.out.print(new VigenereCipher(keyword, text)); 
 ```

* Usage (Method 2):


 ```java
 VigenereCipher obj = new VigenereCipher();
 obj.setKeyword(keyword);
 obj.setText(text);
 obj.encrypt();
 System.out.print(obj.getCipherText());
 ```
 
 
 
