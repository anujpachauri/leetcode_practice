package command;

public class TextFile {
   private  String name;

    public TextFile(String name) {
        this.name = name;
    }


    public String save() {
        return  "Saving " + name;

    }

    public String open() {
     return  "Opening " + name;

    }
}
