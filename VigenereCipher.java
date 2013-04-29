public class VigenereCipher {
    
    private String keyword;
    private String text;
    private String cipherText;
    
    /* Constructor */
    public VigenereCipher(String keyword, String text) {
    
       this.keyword = keyword;
       this.text    = text;
       this.encrypt();    
    }

    /* Null Constructor */
    public VigenereCipher() {
        
    }
    
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public String getCipherText() {
       return cipherText;
    }
    
    @Override
    public String toString() {
       return cipherText;
    }
    
    private boolean validate() throws Exception {
        if(this.keyword.equals("") || this.keyword == null) { 
            throw new Exception("Keyword must be specified."); 
        }
        if(this.text.equals("") || this.text == null) { 
            throw new Exception("Text must be specified."); 
        }
        return true;
    }
    
    /* Encrypt using the Vigenere Cipher */
    
    public final void encrypt() {
        
        try {

            /* Aux variable */
            String cipher = "";
            
            /* Numeric value of each character of the text */
            int offset;

            /* Numeric value of each character of the keyword */
            int shift;
            
            /* ASCII Code for letter 'a' */
            int a = 97; 

            /* ASCII Code for letter 'A' */
            int A = 65;
            
            int lettersInAlphabet = 26; // A=0,Z=25
        
            if(validate()) {
               
                for(int i=0,j=0; i<this.text.length(); i++) {

                    if(this.text.charAt(i) >= 'a' && this.text.charAt(i) <= 'z') {
                        
                        /* Mapping letters to numeric values */
                        shift  = ((int)(this.keyword.charAt(j))) - a;
                        offset = ((int)(this.text.charAt(i)))    - a;
                        
                        j++;
                        j %= this.keyword.length();
                        
                        /* Add the text value to the key value, modulo the number of letters in the alphabet 
                         * Formula: Ci = (Pi + Ki) mod 26
                         */

                        offset  = (offset + shift) % lettersInAlphabet;  
                        cipher += (char)(offset + a);             
                    }
                    else if(this.text.charAt(i) >= 'A' && this.text.charAt(i) <= 'Z') {
                        
                        // The same logic, but for capitals

                        shift  = ((int)(this.keyword.charAt(j))) - A;
                        offset = ((int)(this.text.charAt(i)))    - A;
                        
                        j++;
                        j %= this.keyword.length();
                        
                        offset  = (offset + shift) % lettersInAlphabet;
                        cipher += (char)(offset + A);
                    }
                    else {
                        cipher += this.text.charAt(i);
                    }
                }
                this.cipherText = cipher;
            }
        }
        catch(Exception ex) {
           System.out.println("Error: " + ex.getMessage());
       } 
    }
}
