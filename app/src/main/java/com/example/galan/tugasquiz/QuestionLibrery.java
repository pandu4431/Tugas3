package com.example.galan.tugasquiz;

/**
 * Created by galan on 23/01/2017.
 */

public class QuestionLibrery {

    private String mQuestion [] = {

            "Apa nama ibukota Jawa Barat ?",
            "Apa nama makanan khas Madura ?",
            "Dimana letak candi Borobudur ?",
            "Siapakah Presiden pertama NKRI"
    };

    private String mChoices [][] = {
            {"Cimahi", "Bandung", "Madiun"},
            {"Sate", "Lumpia", "Sarden"},
            {"Klaten", "Yogyakarta", "Wates"},
            {"Ir. Soekarno", "Bj. Habibie", "Joko Widodo"}
    };

    private String mCorrectAnswer [] = {"Bandung", "Sate", "Klaten", "Ir. Soekarno"};

    public String getQuestion(int a){
        String question = mQuestion [a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices [a][0];
        return choice0;
    }
    public String getChoice2(int a){
        String choice1 = mChoices [a][1];
        return choice1;
    }
    public String getChoice3(int a){
        String choice2 = mChoices [a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

}
