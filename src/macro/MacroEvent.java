package macro;

public class MacroEvent
{
    String _name;
    //String in Key-Syntax
    String _macroString;
    //Commands aufgeteilt.
    Actions[] _actions;
    String _syntax;

    public MacroEvent(String name, String macroString)
    {
        _name = name;
        _macroString = macroString;
        _syntax = "({\\w+}-{\\d+(ms)}-)+";
    }

    public void compile()
    {
        parseRegex();
    }

    public void parseRegex()
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

    private void readKeys()
    {
        // TODO impl

    }

}
