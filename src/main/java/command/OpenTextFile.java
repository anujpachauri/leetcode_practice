package command;

public class OpenTextFile implements TextFileOperation{
   private TextFile textFile;

    public OpenTextFile(TextFile textFile) {
        this.textFile = textFile;
    }

    @Override
    public String excecute() {
      return  textFile.open();
    }
}
