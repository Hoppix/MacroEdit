package macro;

import java.awt.AWTException;
import java.awt.Robot;

import startupGUI.RecordAlertDialog;

public class MacroEvent
{
    String _name;
    //String in Key-Syntax
    String _macroString;
    //Commands aufgeteilt.
    String[] _actions;
    int[] _delay;
    String _syntax;
    String _keyword;
    String _miliseconds;
    Robot robot;

    public MacroEvent(String name, String macroString)
    {
        _name = name;
        _macroString = macroString;
        _syntax = "({\\w+}-{\\d+(ms)}-)+";
	       _keyword = "{\c*}";
         _miliseconds = "{\d*}";
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
        //TODO parseEXCEPTION
        if (_macroString.matches(_syntax))
        {
            checkEnum();
        }
    }

    private void checkEnum()
    {
        if (_macroString.contains(Actions.values()
            .toString()))
        {
            readKeys();
        }
    }

    private void readKeys(String recString)
    {
	if(recString.containts(_keyword)
	{
    int start = recString.indexOf("{" + Actions.values);
		int end = recString.indexOf("}", start);
		String sub  = recString.subString(start+1, end-1);
    append(_actions, sub);
    recString.replaceFirst(_keyword, "");

    start = recString.indexOf("{" + _miliseconds);
    end = recString.indexOf("}", start);
    sub = recString.subString(start+1, end-1);
		readKeys(recString);
	}
    }

    public void execute()
    {

    }

}
