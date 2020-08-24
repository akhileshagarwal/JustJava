package akki.java11.features;

public class AKhilesh {
    public static void main(String[] args) {
        var multiline = "This\nis a\nmultiline\nstring";

        multiline.lines()

                // we now have a `Stream<String>`

                .map(line -> "// " + line)

                .forEach(System.out::println);
    }
}
