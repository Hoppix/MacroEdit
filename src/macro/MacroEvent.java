package macro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import startupGUI.RecordAlertDialog;

public class MacroEvent
{
    //name zum refenzieren in der applikation
    String _name;

    //String in Key-Syntax
    String _macroString;

    //Arrays zum auslesen des Strings.
    String[] _actionsArray;
    int[] _delayArray;
    int counter;

    //regex zum auslesen
    String _syntaxRegex;
    String _actionsRegex;
    String _delayRegex;

    //Robot zum ausführen
    static Robot robot;

    public MacroEvent(String name, String macroString)
    {
        _name = name;
        _macroString = macroString;

        //TODO regex in Java
        _syntaxRegex = "({\\w+}-{\\d+(ms)}-)+";
        _actionsRegex = "{\\w*}";
        _delayRegex = "{\\d*}";

        //Max 15 Tasteninputs
        _actionsArray = new String[15];
        _delayArray = new int[15];

        try
        {
            robot = new Robot();
        }
        catch (AWTException e)
        {
            new RecordAlertDialog("Failed to create Macro");
        }
    }

    public void compile()
    {
        parseRegex();
    }

    private void parseRegex()
    {
        if (_macroString.matches(_syntaxRegex))
        {
            checkEnum();
        }
    }

    private void checkEnum()
    {
        if (_macroString.contains(Actions.values()
            .toString()))
        {
            readKeys(_macroString);
        }
    }

    private void readKeys(String recString)
    {
        if (recString.contains(_actionsRegex))
        {
            int start = recString.indexOf("{" + _actionsRegex);
            int end = recString.indexOf("}", start);
            String sub = recString.substring(start + 1, end - 1);
            recString.replaceFirst(_actionsRegex, "");

            _actionsArray[counter] = sub;

            start = recString.indexOf("{" + _delayRegex);
            end = recString.indexOf("}", start);
            sub = recString.substring(start + 1, end - 1);
            recString.replaceFirst(_delayRegex, "");

            _delayArray[counter] = Integer.parseInt(sub);

            counter++;
            readKeys(recString);
        }
    }

    private void convertKeycodes()
    {
        for (int i = 0; i < _actionsArray.length; i++)
        {
            //TODO MAP ENUM
            switch (_actionsArray[i])
            {
            case "SPACE":
                _actionsArray[i] = "VK_SPACE";

                break;

            default:
                break;
            }
        }
    }

    public void execute()
    {
    }

    /** helper method to send the given key to the active application */
    private static void sendKey(int keyCode, int delay)
    {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
        robot.delay(delay);
    }

    /** helper method to send a mouse-click to the active application */
    private static void sendMouseClick(int x, int y, int delay)
    {
        robot.mouseMove(x, y);
        robot.delay(delay);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

}
