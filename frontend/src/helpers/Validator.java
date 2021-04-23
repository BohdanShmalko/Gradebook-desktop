package helpers;

public class Validator {
    public String maxStringLength(String str, int length){
        if(str.length() > length) return "The text is very long!";
        return "";
    }
    public String minStringLength(String str, int length){
        if(str.length() < length) return "The text is very short!";
        return "";
    }
    public String checkEmpty(String str){
        if(str.isEmpty()) return "Enter something";
        return "";
    }
}
