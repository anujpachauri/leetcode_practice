package command;

import java.util.ArrayList;
import java.util.List;

public class TextFileExecutor {

    private List<TextFileOperation> textFileOperations=new ArrayList<>();

    public String textExecutor(TextFileOperation textFileOperation){
        textFileOperations.add(textFileOperation);
        return  textFileOperation.excecute();
    }



}
