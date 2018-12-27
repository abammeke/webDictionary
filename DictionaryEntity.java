package edu.cs.mum;

public class Dictionary {
    private String word,wordtype,definition;

    public Dictionary(String word, String wordtype, String definition) {
        this.word = word;
        this.wordtype = wordtype;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getWordtype() {
        return wordtype;
    }


    public String getDefinition() {
        return definition;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "word='" + word + '\'' +"\n"+
                ", wordtype='" + wordtype + '\'' +"\n"+
                ", definition='" + definition + '\'' +"\n"+
                '}';
    }
}
