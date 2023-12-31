package models.scene;

import java.util.Objects;

public class Sentence {
    private String content = "";

    public String getContent() {
        //
        return content;
    }
    public void setContent(String value) {
        if(value.length() == 0) return;
        content = value;
    }

    public interface Callback {
        String call();
    }

    public Sentence(String content) {
        this.content = content;
    }

    public Sentence(Callback callback) {
        this.content = callback.call();
    }

    public void print() {
        System.out.println(content + ".");
    }

    public void print(String punctuationMark) {
        System.out.println(content + punctuationMark);
    }

    public Sentence and(String text) {
        return new Sentence(content + " и " + text);
    }

    public Sentence but(String text) {
        return new Sentence(content + ", но " + text);
    }

    public Sentence because(String text) {
        return new Sentence(content + ", так как " + text);
    }

    public Sentence comma(String text) {
        return new Sentence(content + ", " + text);
    }

    public Sentence that(String text) {
        return new Sentence(content + ", что " + text);
    }

    public Sentence custom(String value, String text) {
        return new Sentence(content + value + text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(content, sentence.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "content='" + content + '\'' +
                '}';
    }
}
