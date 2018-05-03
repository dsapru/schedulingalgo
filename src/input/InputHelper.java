package input;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.media.jfxmedia.logging.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputHelper {

    private static InputHelper mInstance;
    private Input mInput;

    private InputHelper() {
        mInput = new Gson().fromJson(readFile(), Input.class);
    }

    public static InputHelper getInstance() {
        if (mInstance == null) {
            mInstance = new InputHelper();
        }
        return mInstance;
    }

    public Input getInput(){
        return mInput;
    }

    private JsonObject readFile() {
        try {
            FileReader path = new FileReader(getClass().getResource("input").getPath());
            return (JsonObject)
                   new JsonParser().parse(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //failed to return, abort
        Logger.logMsg(1,"failed to read file");
        return null;
    }
}
