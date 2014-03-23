package com.mwitekdesign.crystalball;

import java.util.Random;

public class CrystalBall {
    public  String[] mAnswers = {
             "It is certain",
             "It is decidedly so",
             "All signs say yes",
             "The stars are not aligned",
             "My reply is no",
             "It is doubtful",
             "Better not tell you now",
             "Concentrate and ask again",
             "Unable to answer now"
     };


   public String getAnAnswer() {

       String answer = "";

       Random randomGenerator = new Random();
       int randomNumber = randomGenerator.nextInt(mAnswers.length);
       return mAnswers[randomNumber];
   }

}
