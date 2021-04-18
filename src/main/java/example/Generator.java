package example;

import java.util.Random;

public class Generator {
    String generate(int length){
        Random random=new Random();
        Recognizer recognizer=new Recognizer();
        String generatedLine="";
        while(true){
            String s="";
            for(int i=0;i<length;i++){
                s+=String.valueOf(random.nextInt(2));
            }
            if(recognizer.nextState(length,0,s,1)){
                generatedLine=s;
                break;
            }
        }
        return generatedLine;
    }

}
