package macro;

//khopf <khopf@KOLJA-DESKTOP.fritz.box>
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

    public void parse()
    {

    }

}
