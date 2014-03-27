package org.nodeclipse.enide.editors.jade.highlight;

public class Words {

	/**
	 * 
	 * 
<pre>
exports.isKeyword = isKeyword
function isKeyword(id) {
  return (id === 'if') || (id === 'in') || (id === 'do') || (id === 'var') || (id === 'for') || (id === 'new') ||
         (id === 'try') || (id === 'let') || (id === 'this') || (id === 'else') || (id === 'case') ||
         (id === 'void') || (id === 'with') || (id === 'enum') || (id === 'while') || (id === 'break') || (id === 'catch') ||
         (id === 'throw') || (id === 'const') || (id === 'yield') || (id === 'class') || (id === 'super') ||
         (id === 'return') || (id === 'typeof') || (id === 'delete') || (id === 'switch') || (id === 'export') ||
         (id === 'import') || (id === 'default') || (id === 'finally') || (id === 'extends') || (id === 'function') ||
         (id === 'continue') || (id === 'debugger') || (id === 'package') || (id === 'private') || (id === 'interface') ||
         (id === 'instanceof') || (id === 'implements') || (id === 'protected') || (id === 'public') || (id === 'static') ||
         (id === 'yield') || (id === 'let');
}
</pre>	 
	 * 
	 * */
	// "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
    public static final String[] KEYWORDS = 
    	{ "if", "in", "do", "var", "for", "new", "try", "let", "this", "else", "case", "void", "with", "enum", "while", "break", "catch",
    	 "throw", "const", "yield", "class", "super", "return", "typeof", "delete", "switch", "export", "import", "default", "finally", "extends", "function",  
    	 "continue", "debugger", "package", "private", "interface", "instanceof", "implements", "protected", "public", "static"
    };

    public static final String[] RESERVEDWORDS = { 
    	"html", "head", "body", "p", "div", "a", "ul", "ol", "li", "input",  
    	"doctype", "script", 
        "include", "mixin" 
    };

    public static final String[] NODE_WORDS = new String[] { "require", "__filename",//
            "__dirname", "module", "exports"
    };

}
