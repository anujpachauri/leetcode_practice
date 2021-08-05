package command;

public class SaveTextFile implements TextFileOperation{

    public SaveTextFile(TextFile textFile) {
        this.textFile = textFile;
    }

    private TextFile textFile;

    @Override
    public String excecute() {
     return    textFile.save();
    }
}
