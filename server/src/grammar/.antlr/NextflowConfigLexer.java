// Generated from /Users/uwewinter/Documents/Biocommons/tower/vscode-fork/server/src/grammar/NextflowConfigLexer.g4 by ANTLR 4.9.2

    import { GroovyLexer } from './GroovyLexer';


import Denque = require("denque");
import { Token } from "antlr4ts";
import { IntStream } from "antlr4ts";


const NONSPACES_PATTERN = new RegExp("\\S+?");
const LETTER_AND_LEFTCURLY_PATTERN=new RegExp("[a-zA-Z_{]");
const NONSURROGATE_PATTERN=new RegExp("[^\u0001-\u007F\uD800-\uDBFF]");
const ISIDENTIFIERIGNORABLE = new RegExp("[\u0000-\u0008\u000E-\u001B\u007F-\u009F]");
const SURROGATE_PAIR1_PATTERN =new RegExp("[\uD800-\uDBFF]");
const SURROGATE_PAIR2_PATTERN = new RegExp("[\uDC00-\uDFFF]");

/** this is horrible, but the only way to do it in JS.
 * it equates to [\p{L}\p{Nd}_$]+
 */
const ISJAVAIDENTIFIERPART_PATTERN = new RegExp("[A-Za-z\u00AA\u00B5\u00BA\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02C1\u02C6-\u02D1\u02E0-\u02E4\u02EC\u02EE\u0370-\u0374\u0376\u0377\u037A-\u037D\u037F\u0386\u0388-\u038A\u038C\u038E-\u03A1\u03A3-\u03F5\u03F7-\u0481\u048A-\u052F\u0531-\u0556\u0559\u0561-\u0587\u05D0-\u05EA\u05F0-\u05F2\u0620-\u064A\u066E\u066F\u0671-\u06D3\u06D5\u06E5\u06E6\u06EE\u06EF\u06FA-\u06FC\u06FF\u0710\u0712-\u072F\u074D-\u07A5\u07B1\u07CA-\u07EA\u07F4\u07F5\u07FA\u0800-\u0815\u081A\u0824\u0828\u0840-\u0858\u08A0-\u08B4\u0904-\u0939\u093D\u0950\u0958-\u0961\u0971-\u0980\u0985-\u098C\u098F\u0990\u0993-\u09A8\u09AA-\u09B0\u09B2\u09B6-\u09B9\u09BD\u09CE\u09DC\u09DD\u09DF-\u09E1\u09F0\u09F1\u0A05-\u0A0A\u0A0F\u0A10\u0A13-\u0A28\u0A2A-\u0A30\u0A32\u0A33\u0A35\u0A36\u0A38\u0A39\u0A59-\u0A5C\u0A5E\u0A72-\u0A74\u0A85-\u0A8D\u0A8F-\u0A91\u0A93-\u0AA8\u0AAA-\u0AB0\u0AB2\u0AB3\u0AB5-\u0AB9\u0ABD\u0AD0\u0AE0\u0AE1\u0AF9\u0B05-\u0B0C\u0B0F\u0B10\u0B13-\u0B28\u0B2A-\u0B30\u0B32\u0B33\u0B35-\u0B39\u0B3D\u0B5C\u0B5D\u0B5F-\u0B61\u0B71\u0B83\u0B85-\u0B8A\u0B8E-\u0B90\u0B92-\u0B95\u0B99\u0B9A\u0B9C\u0B9E\u0B9F\u0BA3\u0BA4\u0BA8-\u0BAA\u0BAE-\u0BB9\u0BD0\u0C05-\u0C0C\u0C0E-\u0C10\u0C12-\u0C28\u0C2A-\u0C39\u0C3D\u0C58-\u0C5A\u0C60\u0C61\u0C85-\u0C8C\u0C8E-\u0C90\u0C92-\u0CA8\u0CAA-\u0CB3\u0CB5-\u0CB9\u0CBD\u0CDE\u0CE0\u0CE1\u0CF1\u0CF2\u0D05-\u0D0C\u0D0E-\u0D10\u0D12-\u0D3A\u0D3D\u0D4E\u0D5F-\u0D61\u0D7A-\u0D7F\u0D85-\u0D96\u0D9A-\u0DB1\u0DB3-\u0DBB\u0DBD\u0DC0-\u0DC6\u0E01-\u0E30\u0E32\u0E33\u0E40-\u0E46\u0E81\u0E82\u0E84\u0E87\u0E88\u0E8A\u0E8D\u0E94-\u0E97\u0E99-\u0E9F\u0EA1-\u0EA3\u0EA5\u0EA7\u0EAA\u0EAB\u0EAD-\u0EB0\u0EB2\u0EB3\u0EBD\u0EC0-\u0EC4\u0EC6\u0EDC-\u0EDF\u0F00\u0F40-\u0F47\u0F49-\u0F6C\u0F88-\u0F8C\u1000-\u102A\u103F\u1050-\u1055\u105A-\u105D\u1061\u1065\u1066\u106E-\u1070\u1075-\u1081\u108E\u10A0-\u10C5\u10C7\u10CD\u10D0-\u10FA\u10FC-\u1248\u124A-\u124D\u1250-\u1256\u1258\u125A-\u125D\u1260-\u1288\u128A-\u128D\u1290-\u12B0\u12B2-\u12B5\u12B8-\u12BE\u12C0\u12C2-\u12C5\u12C8-\u12D6\u12D8-\u1310\u1312-\u1315\u1318-\u135A\u1380-\u138F\u13A0-\u13F5\u13F8-\u13FD\u1401-\u166C\u166F-\u167F\u1681-\u169A\u16A0-\u16EA\u16F1-\u16F8\u1700-\u170C\u170E-\u1711\u1720-\u1731\u1740-\u1751\u1760-\u176C\u176E-\u1770\u1780-\u17B3\u17D7\u17DC\u1820-\u1877\u1880-\u18A8\u18AA\u18B0-\u18F5\u1900-\u191E\u1950-\u196D\u1970-\u1974\u1980-\u19AB\u19B0-\u19C9\u1A00-\u1A16\u1A20-\u1A54\u1AA7\u1B05-\u1B33\u1B45-\u1B4B\u1B83-\u1BA0\u1BAE\u1BAF\u1BBA-\u1BE5\u1C00-\u1C23\u1C4D-\u1C4F\u1C5A-\u1C7D\u1CE9-\u1CEC\u1CEE-\u1CF1\u1CF5\u1CF6\u1D00-\u1DBF\u1E00-\u1F15\u1F18-\u1F1D\u1F20-\u1F45\u1F48-\u1F4D\u1F50-\u1F57\u1F59\u1F5B\u1F5D\u1F5F-\u1F7D\u1F80-\u1FB4\u1FB6-\u1FBC\u1FBE\u1FC2-\u1FC4\u1FC6-\u1FCC\u1FD0-\u1FD3\u1FD6-\u1FDB\u1FE0-\u1FEC\u1FF2-\u1FF4\u1FF6-\u1FFC\u2071\u207F\u2090-\u209C\u2102\u2107\u210A-\u2113\u2115\u2119-\u211D\u2124\u2126\u2128\u212A-\u212D\u212F-\u2139\u213C-\u213F\u2145-\u2149\u214E\u2183\u2184\u2C00-\u2C2E\u2C30-\u2C5E\u2C60-\u2CE4\u2CEB-\u2CEE\u2CF2\u2CF3\u2D00-\u2D25\u2D27\u2D2D\u2D30-\u2D67\u2D6F\u2D80-\u2D96\u2DA0-\u2DA6\u2DA8-\u2DAE\u2DB0-\u2DB6\u2DB8-\u2DBE\u2DC0-\u2DC6\u2DC8-\u2DCE\u2DD0-\u2DD6\u2DD8-\u2DDE\u2E2F\u3005\u3006\u3031-\u3035\u303B\u303C\u3041-\u3096\u309D-\u309F\u30A1-\u30FA\u30FC-\u30FF\u3105-\u312D\u3131-\u318E\u31A0-\u31BA\u31F0-\u31FF\u3400-\u4DB5\u4E00-\u9FD5\uA000-\uA48C\uA4D0-\uA4FD\uA500-\uA60C\uA610-\uA61F\uA62A\uA62B\uA640-\uA66E\uA67F-\uA69D\uA6A0-\uA6E5\uA717-\uA71F\uA722-\uA788\uA78B-\uA7AD\uA7B0-\uA7B7\uA7F7-\uA801\uA803-\uA805\uA807-\uA80A\uA80C-\uA822\uA840-\uA873\uA882-\uA8B3\uA8F2-\uA8F7\uA8FB\uA8FD\uA90A-\uA925\uA930-\uA946\uA960-\uA97C\uA984-\uA9B2\uA9CF\uA9E0-\uA9E4\uA9E6-\uA9EF\uA9FA-\uA9FE\uAA00-\uAA28\uAA40-\uAA42\uAA44-\uAA4B\uAA60-\uAA76\uAA7A\uAA7E-\uAAAF\uAAB1\uAAB5\uAAB6\uAAB9-\uAABD\uAAC0\uAAC2\uAADB-\uAADD\uAAE0-\uAAEA\uAAF2-\uAAF4\uAB01-\uAB06\uAB09-\uAB0E\uAB11-\uAB16\uAB20-\uAB26\uAB28-\uAB2E\uAB30-\uAB5A\uAB5C-\uAB65\uAB70-\uABE2\uAC00-\uD7A3\uD7B0-\uD7C6\uD7CB-\uD7FB\uF900-\uFA6D\uFA70-\uFAD9\uFB00-\uFB06\uFB13-\uFB17\uFB1D\uFB1F-\uFB28\uFB2A-\uFB36\uFB38-\uFB3C\uFB3E\uFB40\uFB41\uFB43\uFB44\uFB46-\uFBB1\uFBD3-\uFD3D\uFD50-\uFD8F\uFD92-\uFDC7\uFDF0-\uFDFB\uFE70-\uFE74\uFE76-\uFEFC\uFF21-\uFF3A\uFF41-\uFF5A\uFF66-\uFFBE\uFFC2-\uFFC7\uFFCA-\uFFCF\uFFD2-\uFFD7\uFFDA-\uFFDC0-9\u0660-\u0669\u06F0-\u06F9\u07C0-\u07C9\u0966-\u096F\u09E6-\u09EF\u0A66-\u0A6F\u0AE6-\u0AEF\u0B66-\u0B6F\u0BE6-\u0BEF\u0C66-\u0C6F\u0CE6-\u0CEF\u0D66-\u0D6F\u0DE6-\u0DEF\u0E50-\u0E59\u0ED0-\u0ED9\u0F20-\u0F29\u1040-\u1049\u1090-\u1099\u17E0-\u17E9\u1810-\u1819\u1946-\u194F\u19D0-\u19D9\u1A80-\u1A89\u1A90-\u1A99\u1B50-\u1B59\u1BB0-\u1BB9\u1C40-\u1C49\u1C50-\u1C59\uA620-\uA629\uA8D0-\uA8D9\uA900-\uA909\uA9D0-\uA9D9\uA9F0-\uA9F9\uAA50-\uAA59\uABF0-\uABF9\uFF10-\uFF19_$]");
/** this is horrible, but the only way to do it in JS.
 * it equates to [\p{Nd}]+
 */
const ISJAVAIDENTIFIERSTART_PATTERN = new RegExp("[A-Za-z\u00AA\u00B5\u00BA\u00C0-\u00D6\u00D8-\u00F6\u00F8-\u02C1\u02C6-\u02D1\u02E0-\u02E4\u02EC\u02EE\u0370-\u0374\u0376\u0377\u037A-\u037D\u037F\u0386\u0388-\u038A\u038C\u038E-\u03A1\u03A3-\u03F5\u03F7-\u0481\u048A-\u052F\u0531-\u0556\u0559\u0561-\u0587\u05D0-\u05EA\u05F0-\u05F2\u0620-\u064A\u066E\u066F\u0671-\u06D3\u06D5\u06E5\u06E6\u06EE\u06EF\u06FA-\u06FC\u06FF\u0710\u0712-\u072F\u074D-\u07A5\u07B1\u07CA-\u07EA\u07F4\u07F5\u07FA\u0800-\u0815\u081A\u0824\u0828\u0840-\u0858\u08A0-\u08B4\u0904-\u0939\u093D\u0950\u0958-\u0961\u0971-\u0980\u0985-\u098C\u098F\u0990\u0993-\u09A8\u09AA-\u09B0\u09B2\u09B6-\u09B9\u09BD\u09CE\u09DC\u09DD\u09DF-\u09E1\u09F0\u09F1\u0A05-\u0A0A\u0A0F\u0A10\u0A13-\u0A28\u0A2A-\u0A30\u0A32\u0A33\u0A35\u0A36\u0A38\u0A39\u0A59-\u0A5C\u0A5E\u0A72-\u0A74\u0A85-\u0A8D\u0A8F-\u0A91\u0A93-\u0AA8\u0AAA-\u0AB0\u0AB2\u0AB3\u0AB5-\u0AB9\u0ABD\u0AD0\u0AE0\u0AE1\u0AF9\u0B05-\u0B0C\u0B0F\u0B10\u0B13-\u0B28\u0B2A-\u0B30\u0B32\u0B33\u0B35-\u0B39\u0B3D\u0B5C\u0B5D\u0B5F-\u0B61\u0B71\u0B83\u0B85-\u0B8A\u0B8E-\u0B90\u0B92-\u0B95\u0B99\u0B9A\u0B9C\u0B9E\u0B9F\u0BA3\u0BA4\u0BA8-\u0BAA\u0BAE-\u0BB9\u0BD0\u0C05-\u0C0C\u0C0E-\u0C10\u0C12-\u0C28\u0C2A-\u0C39\u0C3D\u0C58-\u0C5A\u0C60\u0C61\u0C85-\u0C8C\u0C8E-\u0C90\u0C92-\u0CA8\u0CAA-\u0CB3\u0CB5-\u0CB9\u0CBD\u0CDE\u0CE0\u0CE1\u0CF1\u0CF2\u0D05-\u0D0C\u0D0E-\u0D10\u0D12-\u0D3A\u0D3D\u0D4E\u0D5F-\u0D61\u0D7A-\u0D7F\u0D85-\u0D96\u0D9A-\u0DB1\u0DB3-\u0DBB\u0DBD\u0DC0-\u0DC6\u0E01-\u0E30\u0E32\u0E33\u0E40-\u0E46\u0E81\u0E82\u0E84\u0E87\u0E88\u0E8A\u0E8D\u0E94-\u0E97\u0E99-\u0E9F\u0EA1-\u0EA3\u0EA5\u0EA7\u0EAA\u0EAB\u0EAD-\u0EB0\u0EB2\u0EB3\u0EBD\u0EC0-\u0EC4\u0EC6\u0EDC-\u0EDF\u0F00\u0F40-\u0F47\u0F49-\u0F6C\u0F88-\u0F8C\u1000-\u102A\u103F\u1050-\u1055\u105A-\u105D\u1061\u1065\u1066\u106E-\u1070\u1075-\u1081\u108E\u10A0-\u10C5\u10C7\u10CD\u10D0-\u10FA\u10FC-\u1248\u124A-\u124D\u1250-\u1256\u1258\u125A-\u125D\u1260-\u1288\u128A-\u128D\u1290-\u12B0\u12B2-\u12B5\u12B8-\u12BE\u12C0\u12C2-\u12C5\u12C8-\u12D6\u12D8-\u1310\u1312-\u1315\u1318-\u135A\u1380-\u138F\u13A0-\u13F5\u13F8-\u13FD\u1401-\u166C\u166F-\u167F\u1681-\u169A\u16A0-\u16EA\u16F1-\u16F8\u1700-\u170C\u170E-\u1711\u1720-\u1731\u1740-\u1751\u1760-\u176C\u176E-\u1770\u1780-\u17B3\u17D7\u17DC\u1820-\u1877\u1880-\u18A8\u18AA\u18B0-\u18F5\u1900-\u191E\u1950-\u196D\u1970-\u1974\u1980-\u19AB\u19B0-\u19C9\u1A00-\u1A16\u1A20-\u1A54\u1AA7\u1B05-\u1B33\u1B45-\u1B4B\u1B83-\u1BA0\u1BAE\u1BAF\u1BBA-\u1BE5\u1C00-\u1C23\u1C4D-\u1C4F\u1C5A-\u1C7D\u1CE9-\u1CEC\u1CEE-\u1CF1\u1CF5\u1CF6\u1D00-\u1DBF\u1E00-\u1F15\u1F18-\u1F1D\u1F20-\u1F45\u1F48-\u1F4D\u1F50-\u1F57\u1F59\u1F5B\u1F5D\u1F5F-\u1F7D\u1F80-\u1FB4\u1FB6-\u1FBC\u1FBE\u1FC2-\u1FC4\u1FC6-\u1FCC\u1FD0-\u1FD3\u1FD6-\u1FDB\u1FE0-\u1FEC\u1FF2-\u1FF4\u1FF6-\u1FFC\u2071\u207F\u2090-\u209C\u2102\u2107\u210A-\u2113\u2115\u2119-\u211D\u2124\u2126\u2128\u212A-\u212D\u212F-\u2139\u213C-\u213F\u2145-\u2149\u214E\u2183\u2184\u2C00-\u2C2E\u2C30-\u2C5E\u2C60-\u2CE4\u2CEB-\u2CEE\u2CF2\u2CF3\u2D00-\u2D25\u2D27\u2D2D\u2D30-\u2D67\u2D6F\u2D80-\u2D96\u2DA0-\u2DA6\u2DA8-\u2DAE\u2DB0-\u2DB6\u2DB8-\u2DBE\u2DC0-\u2DC6\u2DC8-\u2DCE\u2DD0-\u2DD6\u2DD8-\u2DDE\u2E2F\u3005\u3006\u3031-\u3035\u303B\u303C\u3041-\u3096\u309D-\u309F\u30A1-\u30FA\u30FC-\u30FF\u3105-\u312D\u3131-\u318E\u31A0-\u31BA\u31F0-\u31FF\u3400-\u4DB5\u4E00-\u9FD5\uA000-\uA48C\uA4D0-\uA4FD\uA500-\uA60C\uA610-\uA61F\uA62A\uA62B\uA640-\uA66E\uA67F-\uA69D\uA6A0-\uA6E5\uA717-\uA71F\uA722-\uA788\uA78B-\uA7AD\uA7B0-\uA7B7\uA7F7-\uA801\uA803-\uA805\uA807-\uA80A\uA80C-\uA822\uA840-\uA873\uA882-\uA8B3\uA8F2-\uA8F7\uA8FB\uA8FD\uA90A-\uA925\uA930-\uA946\uA960-\uA97C\uA984-\uA9B2\uA9CF\uA9E0-\uA9E4\uA9E6-\uA9EF\uA9FA-\uA9FE\uAA00-\uAA28\uAA40-\uAA42\uAA44-\uAA4B\uAA60-\uAA76\uAA7A\uAA7E-\uAAAF\uAAB1\uAAB5\uAAB6\uAAB9-\uAABD\uAAC0\uAAC2\uAADB-\uAADD\uAAE0-\uAAEA\uAAF2-\uAAF4\uAB01-\uAB06\uAB09-\uAB0E\uAB11-\uAB16\uAB20-\uAB26\uAB28-\uAB2E\uAB30-\uAB5A\uAB5C-\uAB65\uAB70-\uABE2\uAC00-\uD7A3\uD7B0-\uD7C6\uD7CB-\uD7FB\uF900-\uFA6D\uFA70-\uFAD9\uFB00-\uFB06\uFB13-\uFB17\uFB1D\uFB1F-\uFB28\uFB2A-\uFB36\uFB38-\uFB3C\uFB3E\uFB40\uFB41\uFB43\uFB44\uFB46-\uFBB1\uFBD3-\uFD3D\uFD50-\uFD8F\uFD92-\uFDC7\uFDF0-\uFDFB\uFE70-\uFE74\uFE76-\uFEFC\uFF21-\uFF3A\uFF41-\uFF5A\uFF66-\uFFBE\uFFC2-\uFFC7\uFFCA-\uFFCF\uFFD2-\uFFD7\uFFDA-\uFFDC_$]+");


class Paren {
    private text: string = '';
    private lastTokenType: number = -1;
    private line: number = -1;
    private column: number = -1;

    public constructor(text: string, lastTokenType: number, line: number, column: number) {
        this.text = text;
        this.lastTokenType = lastTokenType;
        this.line = line;
        this.column = column;
    }

    public getText() {
        return this.text;
    }

    public getLastTokenType() {
        return this.lastTokenType;
    }

    public getLine() {
        return this.line;
    }

    public getColumn() {
        return this.column;
    }

    public toString() {
        return this.text + this.line + this.column
    }
}

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NextflowConfigLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		StringLiteral=1, GStringBegin=2, GStringEnd=3, GStringPart=4, GStringPathPart=5, 
		RollBackOne=6, AS=7, DEF=8, IN=9, TRAIT=10, THREADSAFE=11, VAR=12, BuiltInPrimitiveType=13, 
		ABSTRACT=14, ASSERT=15, BREAK=16, YIELD=17, CASE=18, CATCH=19, CLASS=20, 
		CONST=21, CONTINUE=22, DEFAULT=23, DO=24, ELSE=25, ENUM=26, EXTENDS=27, 
		FINAL=28, FINALLY=29, FOR=30, IF=31, GOTO=32, IMPLEMENTS=33, IMPORT=34, 
		INSTANCEOF=35, INTERFACE=36, NATIVE=37, NEW=38, NON_SEALED=39, PACKAGE=40, 
		PERMITS=41, PRIVATE=42, PROTECTED=43, PUBLIC=44, RECORD=45, RETURN=46, 
		SEALED=47, STATIC=48, STRICTFP=49, SUPER=50, SWITCH=51, SYNCHRONIZED=52, 
		THIS=53, THROW=54, THROWS=55, TRANSIENT=56, TRY=57, VOID=58, VOLATILE=59, 
		WHILE=60, IntegerLiteral=61, FloatingPointLiteral=62, BooleanLiteral=63, 
		NullLiteral=64, RANGE_INCLUSIVE=65, RANGE_EXCLUSIVE_LEFT=66, RANGE_EXCLUSIVE_RIGHT=67, 
		RANGE_EXCLUSIVE_FULL=68, SPREAD_DOT=69, SAFE_DOT=70, SAFE_INDEX=71, SAFE_CHAIN_DOT=72, 
		ELVIS=73, METHOD_POINTER=74, METHOD_REFERENCE=75, REGEX_FIND=76, REGEX_MATCH=77, 
		POWER=78, POWER_ASSIGN=79, SPACESHIP=80, IDENTICAL=81, NOT_IDENTICAL=82, 
		ARROW=83, NOT_INSTANCEOF=84, NOT_IN=85, LPAREN=86, RPAREN=87, LBRACE=88, 
		RBRACE=89, LBRACK=90, RBRACK=91, SEMI=92, COMMA=93, DOT=94, ASSIGN=95, 
		GT=96, LT=97, NOT=98, BITNOT=99, QUESTION=100, COLON=101, EQUAL=102, LE=103, 
		GE=104, NOTEQUAL=105, AND=106, OR=107, INC=108, DEC=109, ADD=110, SUB=111, 
		MUL=112, DIV=113, BITAND=114, BITOR=115, XOR=116, MOD=117, ADD_ASSIGN=118, 
		SUB_ASSIGN=119, MUL_ASSIGN=120, DIV_ASSIGN=121, AND_ASSIGN=122, OR_ASSIGN=123, 
		XOR_ASSIGN=124, MOD_ASSIGN=125, LSHIFT_ASSIGN=126, RSHIFT_ASSIGN=127, 
		URSHIFT_ASSIGN=128, ELVIS_ASSIGN=129, CapitalizedIdentifier=130, Identifier=131, 
		AT=132, ELLIPSIS=133, WS=134, NL=135, SH_COMMENT=136, UNEXPECTED_CHAR=137, 
		INCLUDECONF=138;
	public static final int
		DQ_GSTRING_MODE=1, TDQ_GSTRING_MODE=2, SLASHY_GSTRING_MODE=3, DOLLAR_SLASHY_GSTRING_MODE=4, 
		GSTRING_TYPE_SELECTOR_MODE=5, GSTRING_PATH_MODE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "DQ_GSTRING_MODE", "TDQ_GSTRING_MODE", "SLASHY_GSTRING_MODE", 
		"DOLLAR_SLASHY_GSTRING_MODE", "GSTRING_TYPE_SELECTOR_MODE", "GSTRING_PATH_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"INCLUDECONF", "StringLiteral", "GStringBegin", "TdqGStringBegin", "SlashyGStringBegin", 
			"DollarSlashyGStringBegin", "GStringEnd", "GStringPart", "GStringCharacter", 
			"TdqGStringEnd", "TdqGStringPart", "TdqGStringCharacter", "SlashyGStringEnd", 
			"SlashyGStringPart", "SlashyGStringCharacter", "DollarSlashyGStringEnd", 
			"DollarSlashyGStringPart", "DollarSlashyGStringCharacter", "GStringLBrace", 
			"GStringIdentifier", "GStringPathPart", "RollBackOne", "DqStringCharacter", 
			"SqStringCharacter", "TdqStringCharacter", "TsqStringCharacter", "SlashyStringCharacter", 
			"DollarSlashyStringCharacter", "AS", "DEF", "IN", "TRAIT", "THREADSAFE", 
			"VAR", "BuiltInPrimitiveType", "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", 
			"YIELD", "BYTE", "CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", 
			"DEFAULT", "DO", "DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", 
			"FLOAT", "FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", 
			"INTERFACE", "LONG", "NATIVE", "NEW", "NON_SEALED", "PACKAGE", "PERMITS", 
			"PRIVATE", "PROTECTED", "PUBLIC", "RECORD", "RETURN", "SEALED", "SHORT", 
			"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
			"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "IntegerLiteral", 
			"Zero", "DecimalIntegerLiteral", "HexIntegerLiteral", "OctalIntegerLiteral", 
			"BinaryIntegerLiteral", "IntegerTypeSuffix", "DecimalNumeral", "Digits", 
			"Digit", "NonZeroDigit", "DigitOrUnderscore", "Underscores", "Underscore", 
			"HexNumeral", "HexDigits", "HexDigit", "HexDigitOrUnderscore", "OctalNumeral", 
			"OctalDigits", "OctalDigit", "OctalDigitOrUnderscore", "BinaryNumeral", 
			"BinaryDigits", "BinaryDigit", "BinaryDigitOrUnderscore", "FloatingPointLiteral", 
			"DecimalFloatingPointLiteral", "ExponentPart", "ExponentIndicator", "SignedInteger", 
			"Sign", "FloatTypeSuffix", "HexadecimalFloatingPointLiteral", "HexSignificand", 
			"BinaryExponent", "BinaryExponentIndicator", "Dot", "BooleanLiteral", 
			"EscapeSequence", "OctalEscape", "UnicodeEscape", "ZeroToThree", "DollarEscape", 
			"LineEscape", "LineTerminator", "SlashEscape", "Backslash", "Slash", 
			"Dollar", "GStringQuotationMark", "SqStringQuotationMark", "TdqStringQuotationMark", 
			"TsqStringQuotationMark", "DollarSlashyGStringQuotationMarkBegin", "DollarSlashyGStringQuotationMarkEnd", 
			"DollarSlashEscape", "DollarDollarEscape", "DollarSlashDollarEscape", 
			"NullLiteral", "RANGE_INCLUSIVE", "RANGE_EXCLUSIVE_LEFT", "RANGE_EXCLUSIVE_RIGHT", 
			"RANGE_EXCLUSIVE_FULL", "SPREAD_DOT", "SAFE_DOT", "SAFE_INDEX", "SAFE_CHAIN_DOT", 
			"ELVIS", "METHOD_POINTER", "METHOD_REFERENCE", "REGEX_FIND", "REGEX_MATCH", 
			"POWER", "POWER_ASSIGN", "SPACESHIP", "IDENTICAL", "NOT_IDENTICAL", "ARROW", 
			"NOT_INSTANCEOF", "NOT_IN", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", 
			"RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "NOT", "BITNOT", 
			"QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", "OR", "INC", 
			"DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "XOR", "MOD", "ADD_ASSIGN", 
			"SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", 
			"XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", 
			"ELVIS_ASSIGN", "CapitalizedIdentifier", "Identifier", "IdentifierInGString", 
			"JavaLetter", "JavaLetterInGString", "JavaLetterOrDigit", "JavaLetterOrDigitInGString", 
			"ShCommand", "AT", "ELLIPSIS", "WS", "NL", "ML_COMMENT", "SL_COMMENT", 
			"SH_COMMENT", "UNEXPECTED_CHAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "'includeConfig'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "StringLiteral", "GStringBegin", "GStringEnd", "GStringPart", "GStringPathPart", 
			"RollBackOne", "AS", "DEF", "IN", "TRAIT", "THREADSAFE", "VAR", "BuiltInPrimitiveType", 
			"ABSTRACT", "ASSERT", "BREAK", "YIELD", "CASE", "CATCH", "CLASS", "CONST", 
			"CONTINUE", "DEFAULT", "DO", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", 
			"FOR", "IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INTERFACE", 
			"NATIVE", "NEW", "NON_SEALED", "PACKAGE", "PERMITS", "PRIVATE", "PROTECTED", 
			"PUBLIC", "RECORD", "RETURN", "SEALED", "STATIC", "STRICTFP", "SUPER", 
			"SWITCH", "SYNCHRONIZED", "THIS", "THROW", "THROWS", "TRANSIENT", "TRY", 
			"VOID", "VOLATILE", "WHILE", "IntegerLiteral", "FloatingPointLiteral", 
			"BooleanLiteral", "NullLiteral", "RANGE_INCLUSIVE", "RANGE_EXCLUSIVE_LEFT", 
			"RANGE_EXCLUSIVE_RIGHT", "RANGE_EXCLUSIVE_FULL", "SPREAD_DOT", "SAFE_DOT", 
			"SAFE_INDEX", "SAFE_CHAIN_DOT", "ELVIS", "METHOD_POINTER", "METHOD_REFERENCE", 
			"REGEX_FIND", "REGEX_MATCH", "POWER", "POWER_ASSIGN", "SPACESHIP", "IDENTICAL", 
			"NOT_IDENTICAL", "ARROW", "NOT_INSTANCEOF", "NOT_IN", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", 
			"GT", "LT", "NOT", "BITNOT", "QUESTION", "COLON", "EQUAL", "LE", "GE", 
			"NOTEQUAL", "AND", "OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", 
			"BITOR", "XOR", "MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", 
			"AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", 
			"RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "ELVIS_ASSIGN", "CapitalizedIdentifier", 
			"Identifier", "AT", "ELLIPSIS", "WS", "NL", "SH_COMMENT", "UNEXPECTED_CHAR", 
			"INCLUDECONF"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	    private errorIgnored: boolean = false;
	    private tokenIndex: number = -1;
	    private lastTokenType: number = -1;
	    private invalidDigitCount: number = -1;

	    /**
	     * Record the index and token type of the current token while emitting tokens.
	     */
	    @Override
	    public emit(token?: Token) : Token {
	        if (token === undefined) {
	            return super.emit();
	        }

	        this.tokenIndex = this.tokenIndex + 1;
	        let tokenType = token.type;
	        if (Token.DEFAULT_CHANNEL == token.channel) {
	            this.lastTokenType = tokenType;
	        }

	        if (GroovyLexer.RollBackOne == tokenType) {
	            this.rollbackOneChar();
	        }

	        return super.emit(token);
	    }

	    public static REGEX_CHECK_ARRAY = new Set<Number> ([
	        GroovyLexer.DEC,
	        GroovyLexer.INC,
	        GroovyLexer.THIS,
	        GroovyLexer.RBRACE,
	        GroovyLexer.RBRACK,
	        GroovyLexer.RPAREN,
	        GroovyLexer.GStringEnd,
	        GroovyLexer.NullLiteral,
	        GroovyLexer.StringLiteral,
	        GroovyLexer.BooleanLiteral,
	        GroovyLexer.IntegerLiteral,
	        GroovyLexer.FloatingPointLiteral,
	        GroovyLexer.Identifier,
	        GroovyLexer.CapitalizedIdentifier
	    ]);

	    private isRegexAllowed() {
	        return !(GroovyLexer.REGEX_CHECK_ARRAY.has(this.lastTokenType));
	    }

	    /**
	     * just a hook, which will be overrided by GroovyLangLexer
	     */
	    protected rollbackOneChar() {}

	    protected enterParenCallback(text: string) {}

	    protected exitParenCallback(text: string) {}

	    private parenStack = new Denque<Paren>();

	    private enterParen() {
	        let text = this.text;
	        this.enterParenCallback(text);
	        this.parenStack.push(new Paren(text, this.lastTokenType, this.line, this.charPositionInLine));
	    }

	    private exitParen() {
	        let text = this.text;
	        this.exitParenCallback(text);
	        let paren = this.parenStack.peekBack();
	        if (paren === undefined) return;
	        this.parenStack.pop();
	    }

	    private isInsideParens() {
	        let paren = this.parenStack.peekBack();
	        // We just care about "(", "[" and "?[", inside which the new lines will be ignored.
	        // Notice: the new lines between "{" and "}" can not be ignored.
	        if (paren === undefined) {
	            return false;
	        }

	        let text = paren.getText();

	        return ("(" === text && GroovyLexer.TRY != paren.getLastTokenType()) // we don't treat try-paren(i.e. try (....)) as parenthesis
	                    || "[" === text || "?[" === text;
	    }

	    private ignoreTokenInsideParens() {
	        if (!this.isInsideParens()) {
	            return;
	        }

	        this.channel = Token.HIDDEN_CHANNEL;
	    }

	    private ignoreMultiLineCommentConditionally() {
	        if (!this.isInsideParens() && GroovyLexer.isFollowedByWhiteSpaces(this._input)) {
	            return;
	        }

	        this.channel = Token.HIDDEN_CHANNEL;
	    }

	    public static isFollowedByWhiteSpaces(cs : CharStream) {
	        for (let index = 1, c = cs.LA(index); !('\r' === String.fromCodePoint(c) || '\n' == String.fromCodePoint(c) || IntStream.EOF == c); index++, c = cs.LA(index)) {
	            if (NONSPACES_PATTERN.test(String.fromCodePoint(c))) {
	                return false;
	            }
	        }

	        return true;
	    }

	    public static isFollowedByJavaLetterInGString(cs: CharStream) {
	        let c1 = cs.LA(1);

	        if ('$' == String.fromCodePoint(c1)) { // single $ is not a valid identifier
	            return false;
	        }

	        let str1 = String.fromCodePoint(c1);

	        if (LETTER_AND_LEFTCURLY_PATTERN.test(str1)) {
	            return true;
	        }

	        if (NONSURROGATE_PATTERN.test(str1)
	                && ISJAVAIDENTIFIERPART_PATTERN.test(str1)) {
	            return true;
	        }

	        let c2 = cs.LA(2);
	        let str2 = String.fromCodePoint(c2);

	        if (SURROGATE_PAIR1_PATTERN.test(str1)
	                && SURROGATE_PAIR2_PATTERN.test(str2)
	                && ISJAVAIDENTIFIERPART_PATTERN.test(String.fromCodePoint(c1,c2))) {

	            return true;
	        }

	        return false;
	    }

	    public static isFollowedBy(cs: CharStream, ...chars: string[]) {
	        let c1 = String.fromCodePoint(cs.LA(1));

	        for (let c of chars) {
	            if (c1 === c) {
	                return true;
	            }
	        }

	        return false;
	    }

	    @Override
	    public getSyntaxErrorSource() {
	        return 0;
	    }

	    @Override
	    public getErrorLine() {
	        return this.line;
	    }

	    @Override
	    public getErrorColumn() {
	        return this.charPositionInLine + 1;
	    }

	    @Override
	    public popMode() {
	        try {
	            return super.popMode();
	        } catch (EmptyStackException) { // raised when parens are unmatched: too many right braces

	        }

	        return Number.MIN_VALUE;
	    }

	    public static isJavaIdentifierStartAndNotIdentifierIgnorable(str: string) {
	        return ISJAVAIDENTIFIERSTART_PATTERN.test(str) && !ISIDENTIFIERIGNORABLE.test(str);
	    }

	    public static isJavaIdentifierPartAndNotIdentifierIgnorable(str: string) {
	        return ISJAVAIDENTIFIERPART_PATTERN.test(str) && !ISIDENTIFIERIGNORABLE.test(str);
	    }

	    public isErrorIgnored() {
	        return this.errorIgnored;
	    }

	    public setErrorIgnored(errorIgnored: boolean) {
	        this.errorIgnored = errorIgnored;
	    }

	    public check(condition: boolean, message: string , position: number, toAttachPositionInfo: boolean ) {
	        if (condition) {
	            return;
	        }

	        throw "" + position + ": message";
	    }


	public NextflowConfigLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NextflowConfigLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 18:
			GStringLBrace_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			RollBackOne_action((RuleContext)_localctx, actionIndex);
			break;
		case 90:
			IntegerLiteral_action((RuleContext)_localctx, actionIndex);
			break;
		case 116:
			FloatingPointLiteral_action((RuleContext)_localctx, actionIndex);
			break;
		case 156:
			SAFE_INDEX_action((RuleContext)_localctx, actionIndex);
			break;
		case 171:
			LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 172:
			RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 173:
			LBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 174:
			RBRACE_action((RuleContext)_localctx, actionIndex);
			break;
		case 175:
			LBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 176:
			RBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 226:
			NL_action((RuleContext)_localctx, actionIndex);
			break;
		case 227:
			ML_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 228:
			SL_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 229:
			SH_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 230:
			UNEXPECTED_CHAR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void GStringLBrace_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 this.enterParen();  
			break;
		}
	}
	private void RollBackOne_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:

			                // a trick to handle GStrings followed by EOF properly
			                let readChar = String.fromCodePoint(this._input.LA(-1));
			                if (GroovyLexer.EOF == this._input.LA(1) && ('"' === readChar || '/' === readChar)) {
			                    this.type = GroovyLexer.GStringEnd;
			                } else {
			                    this.channel = Token.HIDDEN_CHANNEL;
			                }
			            
			break;
		}
	}
	private void IntegerLiteral_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 this.check(this.errorIgnored, "Number ending with underscores is invalid", -1, true); 
			break;
		case 3:
			 this.invalidDigitCount++; 
			break;
		case 4:
			 this.check(this.errorIgnored, "Invalid octal number", -(this.invalidDigitCount + 1), true); 
			break;
		}
	}
	private void FloatingPointLiteral_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 this.check(this.errorIgnored, "Number ending with underscores is invalid", -1, true); 
			break;
		}
	}
	private void SAFE_INDEX_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			 this.enterParen();     
			break;
		}
	}
	private void LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 this.enterParen();     
			break;
		}
	}
	private void RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			 this.exitParen();      
			break;
		}
	}
	private void LBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			 this.enterParen();     
			break;
		}
	}
	private void RBRACE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			 this.exitParen();      
			break;
		}
	}
	private void LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			 this.enterParen();     
			break;
		}
	}
	private void RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			 this.exitParen();      
			break;
		}
	}
	private void NL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			 this.ignoreTokenInsideParens(); 
			break;
		}
	}
	private void ML_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14:
			 this.ignoreMultiLineCommentConditionally(); 
			break;
		}
	}
	private void SL_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15:
			 this.ignoreTokenInsideParens(); 
			break;
		}
	}
	private void SH_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16:
			 this.check(this.errorIgnored || 0 == this.tokenIndex, "Shebang comment should appear at the first line", -2, true); 
			break;
		}
	}
	private void UNEXPECTED_CHAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17:
			 this.check(this.errorIgnored, "Unexpected character: '" + this.text.replace("'", "\\'") + "'", -1, false); 
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return StringLiteral_sempred((RuleContext)_localctx, predIndex);
		case 4:
			return SlashyGStringBegin_sempred((RuleContext)_localctx, predIndex);
		case 5:
			return DollarSlashyGStringBegin_sempred((RuleContext)_localctx, predIndex);
		case 13:
			return SlashyGStringPart_sempred((RuleContext)_localctx, predIndex);
		case 16:
			return DollarSlashyGStringPart_sempred((RuleContext)_localctx, predIndex);
		case 24:
			return TdqStringCharacter_sempred((RuleContext)_localctx, predIndex);
		case 25:
			return TsqStringCharacter_sempred((RuleContext)_localctx, predIndex);
		case 26:
			return SlashyStringCharacter_sempred((RuleContext)_localctx, predIndex);
		case 27:
			return DollarSlashyStringCharacter_sempred((RuleContext)_localctx, predIndex);
		case 169:
			return NOT_INSTANCEOF_sempred((RuleContext)_localctx, predIndex);
		case 170:
			return NOT_IN_sempred((RuleContext)_localctx, predIndex);
		case 215:
			return CapitalizedIdentifier_sempred((RuleContext)_localctx, predIndex);
		case 218:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 219:
			return JavaLetterInGString_sempred((RuleContext)_localctx, predIndex);
		case 220:
			return JavaLetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		case 221:
			return JavaLetterOrDigitInGString_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean StringLiteral_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return  this.isRegexAllowed() && String.fromCodePoint(this._input.LA(1)) != '*' ;
		}
		return true;
	}
	private boolean SlashyGStringBegin_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return  this.isRegexAllowed() && String.fromCodePoint(this._input.LA(1)) != '*' ;
		case 2:
			return  GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean DollarSlashyGStringBegin_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return  GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean SlashyGStringPart_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return  GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean DollarSlashyGStringPart_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return  GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean TdqStringCharacter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return  String.fromCodePoint(this._input.LA(1)) != '"' || String.fromCodePoint(this._input.LA(2)) != '"' || String.fromCodePoint(this._input.LA(3)) == '"' && (String.fromCodePoint(this._input.LA(4)) != '"' || String.fromCodePoint(this._input.LA(5)) != '"') ;
		}
		return true;
	}
	private boolean TsqStringCharacter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return  String.fromCodePoint(this._input.LA(1)) != '\'' || String.fromCodePoint(this._input.LA(2)) != '\'' || String.fromCodePoint(this._input.LA(3)) == '\'' && (String.fromCodePoint(this._input.LA(4)) != '\'' || String.fromCodePoint(this._input.LA(5)) != '\'') ;
		}
		return true;
	}
	private boolean SlashyStringCharacter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return  !GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean DollarSlashyStringCharacter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return  String.fromCodePoint(this._input.LA(-4)) != '$' ;
		case 10:
			return  String.fromCodePoint(this._input.LA(1)) != '$' ;
		case 11:
			return  String.fromCodePoint(this._input.LA(1)) != '$' ;
		case 12:
			return  !GroovyLexer.isFollowedByJavaLetterInGString(this._input) ;
		}
		return true;
	}
	private boolean NOT_INSTANCEOF_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return  GroovyLexer.isFollowedBy(this._input, ' ', '\t', '\r', '\n') ;
		}
		return true;
	}
	private boolean NOT_IN_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 14:
			return  GroovyLexer.isFollowedBy(this._input, ' ', '\t', '\r', '\n', '[', '(', '{') ;
		}
		return true;
	}
	private boolean CapitalizedIdentifier_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return String.fromCodePoint(this._input.LA(-1)).toUpperCase() == String.fromCodePoint(this._input.LA(-1));
		}
		return true;
	}
	private boolean JavaLetter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return  GroovyLexer.isJavaIdentifierStartAndNotIdentifierIgnorable(String.fromCodePoint(this._input.LA(-1))) ;
		case 17:
			return  ISJAVAIDENTIFIERSTART_PATTERN.test(String.fromCodePoint(this._input.LA(-2),this._input.LA(-1))) ;
		}
		return true;
	}
	private boolean JavaLetterInGString_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return  String.fromCodePoint(this._input.LA(-1)) != '$' ;
		}
		return true;
	}
	private boolean JavaLetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return  GroovyLexer.isJavaIdentifierPartAndNotIdentifierIgnorable(String.fromCodePoint(this._input.LA(-1))) ;
		case 20:
			return  ISJAVAIDENTIFIERPART_PATTERN.test(String.fromCodePoint(this._input.LA(-2),this._input.LA(-1))) ;
		}
		return true;
	}
	private boolean JavaLetterOrDigitInGString_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 21:
			return  String.fromCodePoint(this._input.LA(-1)) != '$' ;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\u008c\u0703\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7"+
		"\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17"+
		"\4\20\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26"+
		"\4\27\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35"+
		"\4\36\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t"+
		"\'\4(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61"+
		"\4\62\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49"+
		"\t9\4:\t:\4;\t;\4<\t<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD"+
		"\4E\tE\4F\tF\4G\tG\4H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P"+
		"\tP\4Q\tQ\4R\tR\4S\tS\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t["+
		"\4\\\t\\\4]\t]\4^\t^\4_\t_\4`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4"+
		"g\tg\4h\th\4i\ti\4j\tj\4k\tk\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\t"+
		"r\4s\ts\4t\tt\4u\tu\4v\tv\4w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4"+
		"~\t~\4\177\t\177\4\u0080\t\u0080\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083"+
		"\t\u0083\4\u0084\t\u0084\4\u0085\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087"+
		"\4\u0088\t\u0088\4\u0089\t\u0089\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c"+
		"\t\u008c\4\u008d\t\u008d\4\u008e\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090"+
		"\4\u0091\t\u0091\4\u0092\t\u0092\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095"+
		"\t\u0095\4\u0096\t\u0096\4\u0097\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099"+
		"\4\u009a\t\u009a\4\u009b\t\u009b\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e"+
		"\t\u009e\4\u009f\t\u009f\4\u00a0\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2"+
		"\4\u00a3\t\u00a3\4\u00a4\t\u00a4\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7"+
		"\t\u00a7\4\u00a8\t\u00a8\4\u00a9\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab"+
		"\4\u00ac\t\u00ac\4\u00ad\t\u00ad\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0"+
		"\t\u00b0\4\u00b1\t\u00b1\4\u00b2\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4"+
		"\4\u00b5\t\u00b5\4\u00b6\t\u00b6\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9"+
		"\t\u00b9\4\u00ba\t\u00ba\4\u00bb\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd"+
		"\4\u00be\t\u00be\4\u00bf\t\u00bf\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2"+
		"\t\u00c2\4\u00c3\t\u00c3\4\u00c4\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6"+
		"\4\u00c7\t\u00c7\4\u00c8\t\u00c8\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb"+
		"\t\u00cb\4\u00cc\t\u00cc\4\u00cd\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf"+
		"\4\u00d0\t\u00d0\4\u00d1\t\u00d1\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4"+
		"\t\u00d4\4\u00d5\t\u00d5\4\u00d6\t\u00d6\4\u00d7\t\u00d7\4\u00d8\t\u00d8"+
		"\4\u00d9\t\u00d9\4\u00da\t\u00da\4\u00db\t\u00db\4\u00dc\t\u00dc\4\u00dd"+
		"\t\u00dd\4\u00de\t\u00de\4\u00df\t\u00df\4\u00e0\t\u00e0\4\u00e1\t\u00e1"+
		"\4\u00e2\t\u00e2\4\u00e3\t\u00e3\4\u00e4\t\u00e4\4\u00e5\t\u00e5\4\u00e6"+
		"\t\u00e6\4\u00e7\t\u00e7\4\u00e8\t\u00e8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\7\3\u01e8\n\3\f\3\16\3\u01eb\13\3\3"+
		"\3\3\3\3\3\3\3\7\3\u01f1\n\3\f\3\16\3\u01f4\13\3\3\3\3\3\3\3\3\3\3\3\6"+
		"\3\u01fb\n\3\r\3\16\3\u01fc\3\3\3\3\3\3\3\3\7\3\u0203\n\3\f\3\16\3\u0206"+
		"\13\3\3\3\3\3\3\3\3\3\7\3\u020c\n\3\f\3\16\3\u020f\13\3\3\3\3\3\3\3\3"+
		"\3\6\3\u0215\n\3\r\3\16\3\u0216\3\3\3\3\5\3\u021b\n\3\3\4\3\4\7\4\u021f"+
		"\n\4\f\4\16\4\u0222\13\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\7\5\u022b\n\5\f\5"+
		"\16\5\u022e\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\u0239\n\6\f\6"+
		"\16\6\u023c\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\7\7\u0247\n\7\f\7"+
		"\16\7\u024a\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\16\5\16\u026e\n\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\5\30\u02a5\n\30\3\31\3\31\5\31\u02a9\n\31\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u02b0\n\32\3\33\3\33\3\33\3\33\3\33\5\33\u02b7"+
		"\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u02be\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u02ce\n\35\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\5$\u02f7"+
		"\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3"+
		"/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\63\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\3"+
		"8\38\38\38\39\39\39\39\39\39\3:\3:\3:\3:\3;\3;\3;\3<\3<\3<\3<\3<\3=\3"+
		"=\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3"+
		"?\3?\3?\3?\3?\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3"+
		"B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3"+
		"F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3"+
		"H\3I\3I\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3"+
		"K\3K\3L\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3N\3O\3"+
		"O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3"+
		"R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S\3T\3T\3T\3T\3T\3"+
		"U\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3W\3W\3W\3W\3"+
		"X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3[\3"+
		"[\3\\\3\\\3\\\3\\\5\\\u0477\n\\\3\\\3\\\3\\\5\\\u047c\n\\\3\\\3\\\3\\"+
		"\6\\\u0481\n\\\r\\\16\\\u0482\3\\\3\\\5\\\u0487\n\\\5\\\u0489\n\\\3]\3"+
		"]\3^\3^\5^\u048f\n^\3_\3_\5_\u0493\n_\3`\3`\5`\u0497\n`\3a\3a\5a\u049b"+
		"\na\3b\3b\3c\3c\3c\5c\u04a2\nc\3c\3c\3c\5c\u04a7\nc\5c\u04a9\nc\3d\3d"+
		"\7d\u04ad\nd\fd\16d\u04b0\13d\3d\5d\u04b3\nd\3e\3e\5e\u04b7\ne\3f\3f\3"+
		"g\3g\5g\u04bd\ng\3h\6h\u04c0\nh\rh\16h\u04c1\3i\3i\3j\3j\3j\3j\3k\3k\7"+
		"k\u04cc\nk\fk\16k\u04cf\13k\3k\5k\u04d2\nk\3l\3l\3m\3m\5m\u04d8\nm\3n"+
		"\3n\5n\u04dc\nn\3n\3n\3o\3o\7o\u04e2\no\fo\16o\u04e5\13o\3o\5o\u04e8\n"+
		"o\3p\3p\3q\3q\5q\u04ee\nq\3r\3r\3r\3r\3s\3s\7s\u04f6\ns\fs\16s\u04f9\13"+
		"s\3s\5s\u04fc\ns\3t\3t\3u\3u\5u\u0502\nu\3v\3v\5v\u0506\nv\3v\3v\3v\5"+
		"v\u050b\nv\3w\5w\u050e\nw\3w\3w\3w\5w\u0513\nw\3w\5w\u0516\nw\3w\3w\3"+
		"w\5w\u051b\nw\3w\3w\3w\5w\u0520\nw\3x\3x\3x\3y\3y\3z\5z\u0528\nz\3z\3"+
		"z\3{\3{\3|\3|\3}\3}\3}\5}\u0533\n}\3~\3~\5~\u0537\n~\3~\3~\3~\5~\u053c"+
		"\n~\3~\3~\3~\5~\u0541\n~\3\177\3\177\3\177\3\u0080\3\u0080\3\u0081\3\u0081"+
		"\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082\3\u0082"+
		"\5\u0082\u0553\n\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083\3\u0083"+
		"\3\u0083\5\u0083\u055c\n\u0083\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084"+
		"\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\3\u0084\5\u0084\u056a"+
		"\n\u0084\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0085\3\u0086"+
		"\3\u0086\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0089\5\u0089"+
		"\u057c\n\u0089\3\u0089\3\u0089\5\u0089\u0580\n\u0089\3\u008a\3\u008a\3"+
		"\u008a\3\u008b\3\u008b\3\u008c\3\u008c\3\u008d\3\u008d\3\u008e\3\u008e"+
		"\3\u008f\3\u008f\3\u0090\3\u0090\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091"+
		"\3\u0091\3\u0092\3\u0092\3\u0092\3\u0093\3\u0093\3\u0093\3\u0094\3\u0094"+
		"\3\u0094\3\u0095\3\u0095\3\u0095\3\u0096\3\u0096\3\u0096\3\u0096\3\u0097"+
		"\3\u0097\3\u0097\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0099\3\u0099"+
		"\3\u0099\3\u0099\3\u009a\3\u009a\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b"+
		"\3\u009b\3\u009b\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d\3\u009e"+
		"\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009e\3\u009f\3\u009f\3\u009f"+
		"\3\u009f\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a1\3\u00a2\3\u00a2"+
		"\3\u00a2\3\u00a3\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a4\3\u00a4\3\u00a5"+
		"\3\u00a5\3\u00a5\3\u00a6\3\u00a6\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7"+
		"\3\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00a9\3\u00a9"+
		"\3\u00aa\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab"+
		"\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ac"+
		"\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad"+
		"\3\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00af\3\u00af\3\u00af"+
		"\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b0\3\u00b1\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b3"+
		"\3\u00b3\3\u00b4\3\u00b4\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b7\3\u00b7"+
		"\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00ba\3\u00ba\3\u00bb\3\u00bb\3\u00bc"+
		"\3\u00bc\3\u00bd\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00be\3\u00bf\3\u00bf"+
		"\3\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2"+
		"\3\u00c2\3\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c4\3\u00c5\3\u00c5"+
		"\3\u00c6\3\u00c6\3\u00c7\3\u00c7\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00ca"+
		"\3\u00ca\3\u00cb\3\u00cb\3\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00cd\3\u00ce"+
		"\3\u00ce\3\u00ce\3\u00cf\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d0\3\u00d1"+
		"\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d3\3\u00d3\3\u00d3\3\u00d4"+
		"\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d5\3\u00d5\3\u00d6\3\u00d6\3\u00d6"+
		"\3\u00d6\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d7\3\u00d8\3\u00d8\3\u00d8"+
		"\3\u00d9\3\u00d9\3\u00d9\7\u00d9\u068c\n\u00d9\f\u00d9\16\u00d9\u068f"+
		"\13\u00d9\3\u00da\3\u00da\7\u00da\u0693\n\u00da\f\u00da\16\u00da\u0696"+
		"\13\u00da\3\u00db\3\u00db\7\u00db\u069a\n\u00db\f\u00db\16\u00db\u069d"+
		"\13\u00db\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\3\u00dc\5\u00dc\u06a5"+
		"\n\u00dc\3\u00dd\3\u00dd\3\u00dd\3\u00de\3\u00de\3\u00de\3\u00de\3\u00de"+
		"\3\u00de\5\u00de\u06b0\n\u00de\3\u00df\3\u00df\3\u00df\3\u00e0\7\u00e0"+
		"\u06b6\n\u00e0\f\u00e0\16\u00e0\u06b9\13\u00e0\3\u00e1\3\u00e1\3\u00e2"+
		"\3\u00e2\3\u00e2\3\u00e2\3\u00e3\6\u00e3\u06c2\n\u00e3\r\u00e3\16\u00e3"+
		"\u06c3\3\u00e3\6\u00e3\u06c7\n\u00e3\r\u00e3\16\u00e3\u06c8\5\u00e3\u06cb"+
		"\n\u00e3\3\u00e3\3\u00e3\3\u00e4\3\u00e4\3\u00e4\3\u00e5\3\u00e5\3\u00e5"+
		"\3\u00e5\7\u00e5\u06d6\n\u00e5\f\u00e5\16\u00e5\u06d9\13\u00e5\3\u00e5"+
		"\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e5\3\u00e6\3\u00e6\3\u00e6"+
		"\3\u00e6\7\u00e6\u06e6\n\u00e6\f\u00e6\16\u00e6\u06e9\13\u00e6\3\u00e6"+
		"\3\u00e6\3\u00e6\3\u00e6\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7"+
		"\3\u00e7\3\u00e7\3\u00e7\3\u00e7\3\u00e7\7\u00e7\u06fa\n\u00e7\f\u00e7"+
		"\16\u00e7\u06fd\13\u00e7\3\u00e7\3\u00e7\3\u00e8\3\u00e8\3\u00e8\3\u06d7"+
		"\2\u00e9\t\u008c\13\3\r\4\17\2\21\2\23\2\25\5\27\6\31\2\33\2\35\2\37\2"+
		"!\2#\2%\2\'\2)\2+\2-\2/\2\61\7\63\b\65\2\67\29\2;\2=\2?\2A\tC\nE\13G\f"+
		"I\rK\16M\17O\20Q\21S\2U\22W\23Y\2[\24]\25_\2a\26c\27e\30g\31i\32k\2m\33"+
		"o\34q\35s\36u\37w\2y {!}\"\177#\u0081$\u0083%\u0085\2\u0087&\u0089\2\u008b"+
		"\'\u008d(\u008f)\u0091*\u0093+\u0095,\u0097-\u0099.\u009b/\u009d\60\u009f"+
		"\61\u00a1\2\u00a3\62\u00a5\63\u00a7\64\u00a9\65\u00ab\66\u00ad\67\u00af"+
		"8\u00b19\u00b3:\u00b5;\u00b7<\u00b9=\u00bb>\u00bd?\u00bf\2\u00c1\2\u00c3"+
		"\2\u00c5\2\u00c7\2\u00c9\2\u00cb\2\u00cd\2\u00cf\2\u00d1\2\u00d3\2\u00d5"+
		"\2\u00d7\2\u00d9\2\u00db\2\u00dd\2\u00df\2\u00e1\2\u00e3\2\u00e5\2\u00e7"+
		"\2\u00e9\2\u00eb\2\u00ed\2\u00ef\2\u00f1@\u00f3\2\u00f5\2\u00f7\2\u00f9"+
		"\2\u00fb\2\u00fd\2\u00ff\2\u0101\2\u0103\2\u0105\2\u0107\2\u0109A\u010b"+
		"\2\u010d\2\u010f\2\u0111\2\u0113\2\u0115\2\u0117\2\u0119\2\u011b\2\u011d"+
		"\2\u011f\2\u0121\2\u0123\2\u0125\2\u0127\2\u0129\2\u012b\2\u012d\2\u012f"+
		"\2\u0131\2\u0133B\u0135C\u0137D\u0139E\u013bF\u013dG\u013fH\u0141I\u0143"+
		"J\u0145K\u0147L\u0149M\u014bN\u014dO\u014fP\u0151Q\u0153R\u0155S\u0157"+
		"T\u0159U\u015bV\u015dW\u015fX\u0161Y\u0163Z\u0165[\u0167\\\u0169]\u016b"+
		"^\u016d_\u016f`\u0171a\u0173b\u0175c\u0177d\u0179e\u017bf\u017dg\u017f"+
		"h\u0181i\u0183j\u0185k\u0187l\u0189m\u018bn\u018do\u018fp\u0191q\u0193"+
		"r\u0195s\u0197t\u0199u\u019bv\u019dw\u019fx\u01a1y\u01a3z\u01a5{\u01a7"+
		"|\u01a9}\u01ab~\u01ad\177\u01af\u0080\u01b1\u0081\u01b3\u0082\u01b5\u0083"+
		"\u01b7\u0084\u01b9\u0085\u01bb\2\u01bd\2\u01bf\2\u01c1\2\u01c3\2\u01c5"+
		"\2\u01c7\u0086\u01c9\u0087\u01cb\u0088\u01cd\u0089\u01cf\2\u01d1\2\u01d3"+
		"\u008a\u01d5\u008b\t\2\3\4\5\6\7\b\34\7\2\f\f\17\17$$&&^^\6\2\f\f\17\17"+
		"))^^\5\2$$&&^^\4\2))^^\5\2\2\2&&\61\61\3\2\62;\b\2IIKKNNiikknn\3\2\63"+
		";\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62\63\4\2GGgg\4\2--//\6\2FF"+
		"HIffhi\4\2RRrr\t\2$$))^^ddhhpptv\3\2\62\65\6\2&&C\\aac|\4\2\2\u0081\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\7\2&&\62;C\\aac|\5\2\f\f\17\17"+
		"\1\1\4\2\13\13\"\"\2\u0715\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2U\3\2\2"+
		"\2\2W\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2"+
		"\2\u0083\3\2\2\2\2\u0087\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f"+
		"\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2"+
		"\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5"+
		"\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2"+
		"\2\2\u00f1\3\2\2\2\2\u0109\3\2\2\2\2\u0133\3\2\2\2\2\u0135\3\2\2\2\2\u0137"+
		"\3\2\2\2\2\u0139\3\2\2\2\2\u013b\3\2\2\2\2\u013d\3\2\2\2\2\u013f\3\2\2"+
		"\2\2\u0141\3\2\2\2\2\u0143\3\2\2\2\2\u0145\3\2\2\2\2\u0147\3\2\2\2\2\u0149"+
		"\3\2\2\2\2\u014b\3\2\2\2\2\u014d\3\2\2\2\2\u014f\3\2\2\2\2\u0151\3\2\2"+
		"\2\2\u0153\3\2\2\2\2\u0155\3\2\2\2\2\u0157\3\2\2\2\2\u0159\3\2\2\2\2\u015b"+
		"\3\2\2\2\2\u015d\3\2\2\2\2\u015f\3\2\2\2\2\u0161\3\2\2\2\2\u0163\3\2\2"+
		"\2\2\u0165\3\2\2\2\2\u0167\3\2\2\2\2\u0169\3\2\2\2\2\u016b\3\2\2\2\2\u016d"+
		"\3\2\2\2\2\u016f\3\2\2\2\2\u0171\3\2\2\2\2\u0173\3\2\2\2\2\u0175\3\2\2"+
		"\2\2\u0177\3\2\2\2\2\u0179\3\2\2\2\2\u017b\3\2\2\2\2\u017d\3\2\2\2\2\u017f"+
		"\3\2\2\2\2\u0181\3\2\2\2\2\u0183\3\2\2\2\2\u0185\3\2\2\2\2\u0187\3\2\2"+
		"\2\2\u0189\3\2\2\2\2\u018b\3\2\2\2\2\u018d\3\2\2\2\2\u018f\3\2\2\2\2\u0191"+
		"\3\2\2\2\2\u0193\3\2\2\2\2\u0195\3\2\2\2\2\u0197\3\2\2\2\2\u0199\3\2\2"+
		"\2\2\u019b\3\2\2\2\2\u019d\3\2\2\2\2\u019f\3\2\2\2\2\u01a1\3\2\2\2\2\u01a3"+
		"\3\2\2\2\2\u01a5\3\2\2\2\2\u01a7\3\2\2\2\2\u01a9\3\2\2\2\2\u01ab\3\2\2"+
		"\2\2\u01ad\3\2\2\2\2\u01af\3\2\2\2\2\u01b1\3\2\2\2\2\u01b3\3\2\2\2\2\u01b5"+
		"\3\2\2\2\2\u01b7\3\2\2\2\2\u01b9\3\2\2\2\2\u01c7\3\2\2\2\2\u01c9\3\2\2"+
		"\2\2\u01cb\3\2\2\2\2\u01cd\3\2\2\2\2\u01cf\3\2\2\2\2\u01d1\3\2\2\2\2\u01d3"+
		"\3\2\2\2\2\u01d5\3\2\2\2\3\25\3\2\2\2\3\27\3\2\2\2\3\31\3\2\2\2\4\33\3"+
		"\2\2\2\4\35\3\2\2\2\4\37\3\2\2\2\5!\3\2\2\2\5#\3\2\2\2\5%\3\2\2\2\6\'"+
		"\3\2\2\2\6)\3\2\2\2\6+\3\2\2\2\7-\3\2\2\2\7/\3\2\2\2\b\61\3\2\2\2\b\63"+
		"\3\2\2\2\t\u01d7\3\2\2\2\13\u021a\3\2\2\2\r\u021c\3\2\2\2\17\u0228\3\2"+
		"\2\2\21\u0235\3\2\2\2\23\u0244\3\2\2\2\25\u0252\3\2\2\2\27\u0256\3\2\2"+
		"\2\31\u025a\3\2\2\2\33\u025e\3\2\2\2\35\u0263\3\2\2\2\37\u0268\3\2\2\2"+
		"!\u026d\3\2\2\2#\u0274\3\2\2\2%\u027a\3\2\2\2\'\u027e\3\2\2\2)\u0283\3"+
		"\2\2\2+\u0289\3\2\2\2-\u028d\3\2\2\2/\u0294\3\2\2\2\61\u029a\3\2\2\2\63"+
		"\u029d\3\2\2\2\65\u02a4\3\2\2\2\67\u02a8\3\2\2\29\u02af\3\2\2\2;\u02b6"+
		"\3\2\2\2=\u02bd\3\2\2\2?\u02cd\3\2\2\2A\u02cf\3\2\2\2C\u02d2\3\2\2\2E"+
		"\u02d6\3\2\2\2G\u02d9\3\2\2\2I\u02df\3\2\2\2K\u02ea\3\2\2\2M\u02f6\3\2"+
		"\2\2O\u02f8\3\2\2\2Q\u0301\3\2\2\2S\u0308\3\2\2\2U\u0310\3\2\2\2W\u0316"+
		"\3\2\2\2Y\u031c\3\2\2\2[\u0321\3\2\2\2]\u0326\3\2\2\2_\u032c\3\2\2\2a"+
		"\u0331\3\2\2\2c\u0337\3\2\2\2e\u033d\3\2\2\2g\u0346\3\2\2\2i\u034e\3\2"+
		"\2\2k\u0351\3\2\2\2m\u0358\3\2\2\2o\u035d\3\2\2\2q\u0362\3\2\2\2s\u036a"+
		"\3\2\2\2u\u0370\3\2\2\2w\u0378\3\2\2\2y\u037e\3\2\2\2{\u0382\3\2\2\2}"+
		"\u0385\3\2\2\2\177\u038a\3\2\2\2\u0081\u0395\3\2\2\2\u0083\u039c\3\2\2"+
		"\2\u0085\u03a7\3\2\2\2\u0087\u03ab\3\2\2\2\u0089\u03b5\3\2\2\2\u008b\u03ba"+
		"\3\2\2\2\u008d\u03c1\3\2\2\2\u008f\u03c5\3\2\2\2\u0091\u03d0\3\2\2\2\u0093"+
		"\u03d8\3\2\2\2\u0095\u03e0\3\2\2\2\u0097\u03e8\3\2\2\2\u0099\u03f2\3\2"+
		"\2\2\u009b\u03f9\3\2\2\2\u009d\u0400\3\2\2\2\u009f\u0407\3\2\2\2\u00a1"+
		"\u040e\3\2\2\2\u00a3\u0414\3\2\2\2\u00a5\u041b\3\2\2\2\u00a7\u0424\3\2"+
		"\2\2\u00a9\u042a\3\2\2\2\u00ab\u0431\3\2\2\2\u00ad\u043e\3\2\2\2\u00af"+
		"\u0443\3\2\2\2\u00b1\u0449\3\2\2\2\u00b3\u0450\3\2\2\2\u00b5\u045a\3\2"+
		"\2\2\u00b7\u045e\3\2\2\2\u00b9\u0463\3\2\2\2\u00bb\u046c\3\2\2\2\u00bd"+
		"\u0488\3\2\2\2\u00bf\u048a\3\2\2\2\u00c1\u048c\3\2\2\2\u00c3\u0490\3\2"+
		"\2\2\u00c5\u0494\3\2\2\2\u00c7\u0498\3\2\2\2\u00c9\u049c\3\2\2\2\u00cb"+
		"\u04a8\3\2\2\2\u00cd\u04aa\3\2\2\2\u00cf\u04b6\3\2\2\2\u00d1\u04b8\3\2"+
		"\2\2\u00d3\u04bc\3\2\2\2\u00d5\u04bf\3\2\2\2\u00d7\u04c3\3\2\2\2\u00d9"+
		"\u04c5\3\2\2\2\u00db\u04c9\3\2\2\2\u00dd\u04d3\3\2\2\2\u00df\u04d7\3\2"+
		"\2\2\u00e1\u04d9\3\2\2\2\u00e3\u04df\3\2\2\2\u00e5\u04e9\3\2\2\2\u00e7"+
		"\u04ed\3\2\2\2\u00e9\u04ef\3\2\2\2\u00eb\u04f3\3\2\2\2\u00ed\u04fd\3\2"+
		"\2\2\u00ef\u0501\3\2\2\2\u00f1\u0505\3\2\2\2\u00f3\u051f\3\2\2\2\u00f5"+
		"\u0521\3\2\2\2\u00f7\u0524\3\2\2\2\u00f9\u0527\3\2\2\2\u00fb\u052b\3\2"+
		"\2\2\u00fd\u052d\3\2\2\2\u00ff\u052f\3\2\2\2\u0101\u0540\3\2\2\2\u0103"+
		"\u0542\3\2\2\2\u0105\u0545\3\2\2\2\u0107\u0547\3\2\2\2\u0109\u0552\3\2"+
		"\2\2\u010b\u055b\3\2\2\2\u010d\u0569\3\2\2\2\u010f\u056b\3\2\2\2\u0111"+
		"\u0572\3\2\2\2\u0113\u0574\3\2\2\2\u0115\u0577\3\2\2\2\u0117\u057f\3\2"+
		"\2\2\u0119\u0581\3\2\2\2\u011b\u0584\3\2\2\2\u011d\u0586\3\2\2\2\u011f"+
		"\u0588\3\2\2\2\u0121\u058a\3\2\2\2\u0123\u058c\3\2\2\2\u0125\u058e\3\2"+
		"\2\2\u0127\u0592\3\2\2\2\u0129\u0596\3\2\2\2\u012b\u0599\3\2\2\2\u012d"+
		"\u059c\3\2\2\2\u012f\u059f\3\2\2\2\u0131\u05a2\3\2\2\2\u0133\u05a6\3\2"+
		"\2\2\u0135\u05ab\3\2\2\2\u0137\u05ae\3\2\2\2\u0139\u05b2\3\2\2\2\u013b"+
		"\u05b6\3\2\2\2\u013d\u05bb\3\2\2\2\u013f\u05be\3\2\2\2\u0141\u05c1\3\2"+
		"\2\2\u0143\u05c8\3\2\2\2\u0145\u05cc\3\2\2\2\u0147\u05cf\3\2\2\2\u0149"+
		"\u05d2\3\2\2\2\u014b\u05d5\3\2\2\2\u014d\u05d8\3\2\2\2\u014f\u05dc\3\2"+
		"\2\2\u0151\u05df\3\2\2\2\u0153\u05e3\3\2\2\2\u0155\u05e7\3\2\2\2\u0157"+
		"\u05eb\3\2\2\2\u0159\u05ef\3\2\2\2\u015b\u05f2\3\2\2\2\u015d\u0600\3\2"+
		"\2\2\u015f\u0606\3\2\2\2\u0161\u060b\3\2\2\2\u0163\u0610\3\2\2\2\u0165"+
		"\u0615\3\2\2\2\u0167\u061a\3\2\2\2\u0169\u061f\3\2\2\2\u016b\u0624\3\2"+
		"\2\2\u016d\u0626\3\2\2\2\u016f\u0628\3\2\2\2\u0171\u062a\3\2\2\2\u0173"+
		"\u062c\3\2\2\2\u0175\u062e\3\2\2\2\u0177\u0630\3\2\2\2\u0179\u0632\3\2"+
		"\2\2\u017b\u0634\3\2\2\2\u017d\u0636\3\2\2\2\u017f\u0638\3\2\2\2\u0181"+
		"\u063b\3\2\2\2\u0183\u063e\3\2\2\2\u0185\u0641\3\2\2\2\u0187\u0644\3\2"+
		"\2\2\u0189\u0647\3\2\2\2\u018b\u064a\3\2\2\2\u018d\u064d\3\2\2\2\u018f"+
		"\u0650\3\2\2\2\u0191\u0652\3\2\2\2\u0193\u0654\3\2\2\2\u0195\u0656\3\2"+
		"\2\2\u0197\u0658\3\2\2\2\u0199\u065a\3\2\2\2\u019b\u065c\3\2\2\2\u019d"+
		"\u065e\3\2\2\2\u019f\u0660\3\2\2\2\u01a1\u0663\3\2\2\2\u01a3\u0666\3\2"+
		"\2\2\u01a5\u0669\3\2\2\2\u01a7\u066c\3\2\2\2\u01a9\u066f\3\2\2\2\u01ab"+
		"\u0672\3\2\2\2\u01ad\u0675\3\2\2\2\u01af\u0678\3\2\2\2\u01b1\u067c\3\2"+
		"\2\2\u01b3\u0680\3\2\2\2\u01b5\u0685\3\2\2\2\u01b7\u0688\3\2\2\2\u01b9"+
		"\u0690\3\2\2\2\u01bb\u0697\3\2\2\2\u01bd\u06a4\3\2\2\2\u01bf\u06a6\3\2"+
		"\2\2\u01c1\u06af\3\2\2\2\u01c3\u06b1\3\2\2\2\u01c5\u06b7\3\2\2\2\u01c7"+
		"\u06ba\3\2\2\2\u01c9\u06bc\3\2\2\2\u01cb\u06ca\3\2\2\2\u01cd\u06ce\3\2"+
		"\2\2\u01cf\u06d1\3\2\2\2\u01d1\u06e1\3\2\2\2\u01d3\u06ee\3\2\2\2\u01d5"+
		"\u0700\3\2\2\2\u01d7\u01d8\7k\2\2\u01d8\u01d9\7p\2\2\u01d9\u01da\7e\2"+
		"\2\u01da\u01db\7n\2\2\u01db\u01dc\7w\2\2\u01dc\u01dd\7f\2\2\u01dd\u01de"+
		"\7g\2\2\u01de\u01df\7E\2\2\u01df\u01e0\7q\2\2\u01e0\u01e1\7p\2\2\u01e1"+
		"\u01e2\7h\2\2\u01e2\u01e3\7k\2\2\u01e3\u01e4\7i\2\2\u01e4\n\3\2\2\2\u01e5"+
		"\u01e9\5\u0121\u008e\2\u01e6\u01e8\5\65\30\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u01ec\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ed\5\u0121\u008e\2\u01ed\u021b\3\2\2"+
		"\2\u01ee\u01f2\5\u0123\u008f\2\u01ef\u01f1\5\67\31\2\u01f0\u01ef\3\2\2"+
		"\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5"+
		"\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\5\u0123\u008f\2\u01f6\u021b\3"+
		"\2\2\2\u01f7\u01f8\5\u011d\u008c\2\u01f8\u01fa\6\3\2\2\u01f9\u01fb\5="+
		"\34\2\u01fa\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc"+
		"\u01fd\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\5\u011d\u008c\2\u01ff\u021b"+
		"\3\2\2\2\u0200\u0204\5\u0125\u0090\2\u0201\u0203\59\32\2\u0202\u0201\3"+
		"\2\2\2\u0203\u0206\3\2\2\2\u0204\u0202\3\2\2\2\u0204\u0205\3\2\2\2\u0205"+
		"\u0207\3\2\2\2\u0206\u0204\3\2\2\2\u0207\u0208\5\u0125\u0090\2\u0208\u021b"+
		"\3\2\2\2\u0209\u020d\5\u0127\u0091\2\u020a\u020c\5;\33\2\u020b\u020a\3"+
		"\2\2\2\u020c\u020f\3\2\2\2\u020d\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e"+
		"\u0210\3\2\2\2\u020f\u020d\3\2\2\2\u0210\u0211\5\u0127\u0091\2\u0211\u021b"+
		"\3\2\2\2\u0212\u0214\5\u0129\u0092\2\u0213\u0215\5?\35\2\u0214\u0213\3"+
		"\2\2\2\u0215\u0216\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"\u0218\3\2\2\2\u0218\u0219\5\u012b\u0093\2\u0219\u021b\3\2\2\2\u021a\u01e5"+
		"\3\2\2\2\u021a\u01ee\3\2\2\2\u021a\u01f7\3\2\2\2\u021a\u0200\3\2\2\2\u021a"+
		"\u0209\3\2\2\2\u021a\u0212\3\2\2\2\u021b\f\3\2\2\2\u021c\u0220\5\u0121"+
		"\u008e\2\u021d\u021f\5\65\30\2\u021e\u021d\3\2\2\2\u021f\u0222\3\2\2\2"+
		"\u0220\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0223\3\2\2\2\u0222\u0220"+
		"\3\2\2\2\u0223\u0224\5\u011f\u008d\2\u0224\u0225\3\2\2\2\u0225\u0226\b"+
		"\4\2\2\u0226\u0227\b\4\3\2\u0227\16\3\2\2\2\u0228\u022c\5\u0125\u0090"+
		"\2\u0229\u022b\59\32\2\u022a\u0229\3\2\2\2\u022b\u022e\3\2\2\2\u022c\u022a"+
		"\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c\3\2\2\2\u022f"+
		"\u0230\5\u011f\u008d\2\u0230\u0231\3\2\2\2\u0231\u0232\b\5\4\2\u0232\u0233"+
		"\b\5\5\2\u0233\u0234\b\5\3\2\u0234\20\3\2\2\2\u0235\u0236\5\u011d\u008c"+
		"\2\u0236\u023a\6\6\3\2\u0237\u0239\5=\34\2\u0238\u0237\3\2\2\2\u0239\u023c"+
		"\3\2\2\2\u023a\u0238\3\2\2\2\u023a\u023b\3\2\2\2\u023b\u023d\3\2\2\2\u023c"+
		"\u023a\3\2\2\2\u023d\u023e\5\u011f\u008d\2\u023e\u023f\6\6\4\2\u023f\u0240"+
		"\3\2\2\2\u0240\u0241\b\6\4\2\u0241\u0242\b\6\6\2\u0242\u0243\b\6\3\2\u0243"+
		"\22\3\2\2\2\u0244\u0248\5\u0129\u0092\2\u0245\u0247\5?\35\2\u0246\u0245"+
		"\3\2\2\2\u0247\u024a\3\2\2\2\u0248\u0246\3\2\2\2\u0248\u0249\3\2\2\2\u0249"+
		"\u024b\3\2\2\2\u024a\u0248\3\2\2\2\u024b\u024c\5\u011f\u008d\2\u024c\u024d"+
		"\6\7\5\2\u024d\u024e\3\2\2\2\u024e\u024f\b\7\4\2\u024f\u0250\b\7\7\2\u0250"+
		"\u0251\b\7\3\2\u0251\24\3\2\2\2\u0252\u0253\5\u0121\u008e\2\u0253\u0254"+
		"\3\2\2\2\u0254\u0255\b\b\b\2\u0255\26\3\2\2\2\u0256\u0257\5\u011f\u008d"+
		"\2\u0257\u0258\3\2\2\2\u0258\u0259\b\t\3\2\u0259\30\3\2\2\2\u025a\u025b"+
		"\5\65\30\2\u025b\u025c\3\2\2\2\u025c\u025d\b\n\t\2\u025d\32\3\2\2\2\u025e"+
		"\u025f\5\u0125\u0090\2\u025f\u0260\3\2\2\2\u0260\u0261\b\13\n\2\u0261"+
		"\u0262\b\13\b\2\u0262\34\3\2\2\2\u0263\u0264\5\u011f\u008d\2\u0264\u0265"+
		"\3\2\2\2\u0265\u0266\b\f\13\2\u0266\u0267\b\f\3\2\u0267\36\3\2\2\2\u0268"+
		"\u0269\59\32\2\u0269\u026a\3\2\2\2\u026a\u026b\b\r\t\2\u026b \3\2\2\2"+
		"\u026c\u026e\5\u011f\u008d\2\u026d\u026c\3\2\2\2\u026d\u026e\3\2\2\2\u026e"+
		"\u026f\3\2\2\2\u026f\u0270\5\u011d\u008c\2\u0270\u0271\3\2\2\2\u0271\u0272"+
		"\b\16\n\2\u0272\u0273\b\16\b\2\u0273\"\3\2\2\2\u0274\u0275\5\u011f\u008d"+
		"\2\u0275\u0276\6\17\6\2\u0276\u0277\3\2\2\2\u0277\u0278\b\17\13\2\u0278"+
		"\u0279\b\17\3\2\u0279$\3\2\2\2\u027a\u027b\5=\34\2\u027b\u027c\3\2\2\2"+
		"\u027c\u027d\b\20\t\2\u027d&\3\2\2\2\u027e\u027f\5\u012b\u0093\2\u027f"+
		"\u0280\3\2\2\2\u0280\u0281\b\21\n\2\u0281\u0282\b\21\b\2\u0282(\3\2\2"+
		"\2\u0283\u0284\5\u011f\u008d\2\u0284\u0285\6\22\7\2\u0285\u0286\3\2\2"+
		"\2\u0286\u0287\b\22\13\2\u0287\u0288\b\22\3\2\u0288*\3\2\2\2\u0289\u028a"+
		"\5?\35\2\u028a\u028b\3\2\2\2\u028b\u028c\b\23\t\2\u028c,\3\2\2\2\u028d"+
		"\u028e\7}\2\2\u028e\u028f\b\24\f\2\u028f\u0290\3\2\2\2\u0290\u0291\b\24"+
		"\r\2\u0291\u0292\b\24\b\2\u0292\u0293\b\24\16\2\u0293.\3\2\2\2\u0294\u0295"+
		"\5\u01bb\u00db\2\u0295\u0296\3\2\2\2\u0296\u0297\b\25\17\2\u0297\u0298"+
		"\b\25\b\2\u0298\u0299\b\25\20\2\u0299\60\3\2\2\2\u029a\u029b\5\u0107\u0081"+
		"\2\u029b\u029c\5\u01bb\u00db\2\u029c\62\3\2\2\2\u029d\u029e\13\2\2\2\u029e"+
		"\u029f\b\27\21\2\u029f\u02a0\3\2\2\2\u02a0\u02a1\b\27\b\2\u02a1\64\3\2"+
		"\2\2\u02a2\u02a5\n\2\2\2\u02a3\u02a5\5\u010b\u0083\2\u02a4\u02a2\3\2\2"+
		"\2\u02a4\u02a3\3\2\2\2\u02a5\66\3\2\2\2\u02a6\u02a9\n\3\2\2\u02a7\u02a9"+
		"\5\u010b\u0083\2\u02a8\u02a6\3\2\2\2\u02a8\u02a7\3\2\2\2\u02a98\3\2\2"+
		"\2\u02aa\u02b0\n\4\2\2\u02ab\u02ac\5\u0121\u008e\2\u02ac\u02ad\6\32\b"+
		"\2\u02ad\u02b0\3\2\2\2\u02ae\u02b0\5\u010b\u0083\2\u02af\u02aa\3\2\2\2"+
		"\u02af\u02ab\3\2\2\2\u02af\u02ae\3\2\2\2\u02b0:\3\2\2\2\u02b1\u02b7\n"+
		"\5\2\2\u02b2\u02b3\5\u0123\u008f\2\u02b3\u02b4\6\33\t\2\u02b4\u02b7\3"+
		"\2\2\2\u02b5\u02b7\5\u010b\u0083\2\u02b6\u02b1\3\2\2\2\u02b6\u02b2\3\2"+
		"\2\2\u02b6\u02b5\3\2\2\2\u02b7<\3\2\2\2\u02b8\u02be\5\u0119\u008a\2\u02b9"+
		"\u02ba\5\u011f\u008d\2\u02ba\u02bb\6\34\n\2\u02bb\u02be\3\2\2\2\u02bc"+
		"\u02be\n\6\2\2\u02bd\u02b8\3\2\2\2\u02bd\u02b9\3\2\2\2\u02bd\u02bc\3\2"+
		"\2\2\u02be>\3\2\2\2\u02bf\u02ce\5\u012f\u0095\2\u02c0\u02c1\5\u0131\u0096"+
		"\2\u02c1\u02c2\6\35\13\2\u02c2\u02ce\3\2\2\2\u02c3\u02c4\5\u012d\u0094"+
		"\2\u02c4\u02c5\6\35\f\2\u02c5\u02ce\3\2\2\2\u02c6\u02c7\5\u011d\u008c"+
		"\2\u02c7\u02c8\6\35\r\2\u02c8\u02ce\3\2\2\2\u02c9\u02ca\5\u011f\u008d"+
		"\2\u02ca\u02cb\6\35\16\2\u02cb\u02ce\3\2\2\2\u02cc\u02ce\n\6\2\2\u02cd"+
		"\u02bf\3\2\2\2\u02cd\u02c0\3\2\2\2\u02cd\u02c3\3\2\2\2\u02cd\u02c6\3\2"+
		"\2\2\u02cd\u02c9\3\2\2\2\u02cd\u02cc\3\2\2\2\u02ce@\3\2\2\2\u02cf\u02d0"+
		"\7c\2\2\u02d0\u02d1\7u\2\2\u02d1B\3\2\2\2\u02d2\u02d3\7f\2\2\u02d3\u02d4"+
		"\7g\2\2\u02d4\u02d5\7h\2\2\u02d5D\3\2\2\2\u02d6\u02d7\7k\2\2\u02d7\u02d8"+
		"\7p\2\2\u02d8F\3\2\2\2\u02d9\u02da\7v\2\2\u02da\u02db\7t\2\2\u02db\u02dc"+
		"\7c\2\2\u02dc\u02dd\7k\2\2\u02dd\u02de\7v\2\2\u02deH\3\2\2\2\u02df\u02e0"+
		"\7v\2\2\u02e0\u02e1\7j\2\2\u02e1\u02e2\7t\2\2\u02e2\u02e3\7g\2\2\u02e3"+
		"\u02e4\7c\2\2\u02e4\u02e5\7f\2\2\u02e5\u02e6\7u\2\2\u02e6\u02e7\7c\2\2"+
		"\u02e7\u02e8\7h\2\2\u02e8\u02e9\7g\2\2\u02e9J\3\2\2\2\u02ea\u02eb\7x\2"+
		"\2\u02eb\u02ec\7c\2\2\u02ec\u02ed\7t\2\2\u02edL\3\2\2\2\u02ee\u02f7\5"+
		"S\'\2\u02ef\u02f7\5_-\2\u02f0\u02f7\5Y*\2\u02f1\u02f7\5\u00a1N\2\u02f2"+
		"\u02f7\5\u0085@\2\u02f3\u02f7\5\u0089B\2\u02f4\u02f7\5w9\2\u02f5\u02f7"+
		"\5k\63\2\u02f6\u02ee\3\2\2\2\u02f6\u02ef\3\2\2\2\u02f6\u02f0\3\2\2\2\u02f6"+
		"\u02f1\3\2\2\2\u02f6\u02f2\3\2\2\2\u02f6\u02f3\3\2\2\2\u02f6\u02f4\3\2"+
		"\2\2\u02f6\u02f5\3\2\2\2\u02f7N\3\2\2\2\u02f8\u02f9\7c\2\2\u02f9\u02fa"+
		"\7d\2\2\u02fa\u02fb\7u\2\2\u02fb\u02fc\7v\2\2\u02fc\u02fd\7t\2\2\u02fd"+
		"\u02fe\7c\2\2\u02fe\u02ff\7e\2\2\u02ff\u0300\7v\2\2\u0300P\3\2\2\2\u0301"+
		"\u0302\7c\2\2\u0302\u0303\7u\2\2\u0303\u0304\7u\2\2\u0304\u0305\7g\2\2"+
		"\u0305\u0306\7t\2\2\u0306\u0307\7v\2\2\u0307R\3\2\2\2\u0308\u0309\7d\2"+
		"\2\u0309\u030a\7q\2\2\u030a\u030b\7q\2\2\u030b\u030c\7n\2\2\u030c\u030d"+
		"\7g\2\2\u030d\u030e\7c\2\2\u030e\u030f\7p\2\2\u030fT\3\2\2\2\u0310\u0311"+
		"\7d\2\2\u0311\u0312\7t\2\2\u0312\u0313\7g\2\2\u0313\u0314\7c\2\2\u0314"+
		"\u0315\7m\2\2\u0315V\3\2\2\2\u0316\u0317\7{\2\2\u0317\u0318\7k\2\2\u0318"+
		"\u0319\7g\2\2\u0319\u031a\7n\2\2\u031a\u031b\7f\2\2\u031bX\3\2\2\2\u031c"+
		"\u031d\7d\2\2\u031d\u031e\7{\2\2\u031e\u031f\7v\2\2\u031f\u0320\7g\2\2"+
		"\u0320Z\3\2\2\2\u0321\u0322\7e\2\2\u0322\u0323\7c\2\2\u0323\u0324\7u\2"+
		"\2\u0324\u0325\7g\2\2\u0325\\\3\2\2\2\u0326\u0327\7e\2\2\u0327\u0328\7"+
		"c\2\2\u0328\u0329\7v\2\2\u0329\u032a\7e\2\2\u032a\u032b\7j\2\2\u032b^"+
		"\3\2\2\2\u032c\u032d\7e\2\2\u032d\u032e\7j\2\2\u032e\u032f\7c\2\2\u032f"+
		"\u0330\7t\2\2\u0330`\3\2\2\2\u0331\u0332\7e\2\2\u0332\u0333\7n\2\2\u0333"+
		"\u0334\7c\2\2\u0334\u0335\7u\2\2\u0335\u0336\7u\2\2\u0336b\3\2\2\2\u0337"+
		"\u0338\7e\2\2\u0338\u0339\7q\2\2\u0339\u033a\7p\2\2\u033a\u033b\7u\2\2"+
		"\u033b\u033c\7v\2\2\u033cd\3\2\2\2\u033d\u033e\7e\2\2\u033e\u033f\7q\2"+
		"\2\u033f\u0340\7p\2\2\u0340\u0341\7v\2\2\u0341\u0342\7k\2\2\u0342\u0343"+
		"\7p\2\2\u0343\u0344\7w\2\2\u0344\u0345\7g\2\2\u0345f\3\2\2\2\u0346\u0347"+
		"\7f\2\2\u0347\u0348\7g\2\2\u0348\u0349\7h\2\2\u0349\u034a\7c\2\2\u034a"+
		"\u034b\7w\2\2\u034b\u034c\7n\2\2\u034c\u034d\7v\2\2\u034dh\3\2\2\2\u034e"+
		"\u034f\7f\2\2\u034f\u0350\7q\2\2\u0350j\3\2\2\2\u0351\u0352\7f\2\2\u0352"+
		"\u0353\7q\2\2\u0353\u0354\7w\2\2\u0354\u0355\7d\2\2\u0355\u0356\7n\2\2"+
		"\u0356\u0357\7g\2\2\u0357l\3\2\2\2\u0358\u0359\7g\2\2\u0359\u035a\7n\2"+
		"\2\u035a\u035b\7u\2\2\u035b\u035c\7g\2\2\u035cn\3\2\2\2\u035d\u035e\7"+
		"g\2\2\u035e\u035f\7p\2\2\u035f\u0360\7w\2\2\u0360\u0361\7o\2\2\u0361p"+
		"\3\2\2\2\u0362\u0363\7g\2\2\u0363\u0364\7z\2\2\u0364\u0365\7v\2\2\u0365"+
		"\u0366\7g\2\2\u0366\u0367\7p\2\2\u0367\u0368\7f\2\2\u0368\u0369\7u\2\2"+
		"\u0369r\3\2\2\2\u036a\u036b\7h\2\2\u036b\u036c\7k\2\2\u036c\u036d\7p\2"+
		"\2\u036d\u036e\7c\2\2\u036e\u036f\7n\2\2\u036ft\3\2\2\2\u0370\u0371\7"+
		"h\2\2\u0371\u0372\7k\2\2\u0372\u0373\7p\2\2\u0373\u0374\7c\2\2\u0374\u0375"+
		"\7n\2\2\u0375\u0376\7n\2\2\u0376\u0377\7{\2\2\u0377v\3\2\2\2\u0378\u0379"+
		"\7h\2\2\u0379\u037a\7n\2\2\u037a\u037b\7q\2\2\u037b\u037c\7c\2\2\u037c"+
		"\u037d\7v\2\2\u037dx\3\2\2\2\u037e\u037f\7h\2\2\u037f\u0380\7q\2\2\u0380"+
		"\u0381\7t\2\2\u0381z\3\2\2\2\u0382\u0383\7k\2\2\u0383\u0384\7h\2\2\u0384"+
		"|\3\2\2\2\u0385\u0386\7i\2\2\u0386\u0387\7q\2\2\u0387\u0388\7v\2\2\u0388"+
		"\u0389\7q\2\2\u0389~\3\2\2\2\u038a\u038b\7k\2\2\u038b\u038c\7o\2\2\u038c"+
		"\u038d\7r\2\2\u038d\u038e\7n\2\2\u038e\u038f\7g\2\2\u038f\u0390\7o\2\2"+
		"\u0390\u0391\7g\2\2\u0391\u0392\7p\2\2\u0392\u0393\7v\2\2\u0393\u0394"+
		"\7u\2\2\u0394\u0080\3\2\2\2\u0395\u0396\7k\2\2\u0396\u0397\7o\2\2\u0397"+
		"\u0398\7r\2\2\u0398\u0399\7q\2\2\u0399\u039a\7t\2\2\u039a\u039b\7v\2\2"+
		"\u039b\u0082\3\2\2\2\u039c\u039d\7k\2\2\u039d\u039e\7p\2\2\u039e\u039f"+
		"\7u\2\2\u039f\u03a0\7v\2\2\u03a0\u03a1\7c\2\2\u03a1\u03a2\7p\2\2\u03a2"+
		"\u03a3\7e\2\2\u03a3\u03a4\7g\2\2\u03a4\u03a5\7q\2\2\u03a5\u03a6\7h\2\2"+
		"\u03a6\u0084\3\2\2\2\u03a7\u03a8\7k\2\2\u03a8\u03a9\7p\2\2\u03a9\u03aa"+
		"\7v\2\2\u03aa\u0086\3\2\2\2\u03ab\u03ac\7k\2\2\u03ac\u03ad\7p\2\2\u03ad"+
		"\u03ae\7v\2\2\u03ae\u03af\7g\2\2\u03af\u03b0\7t\2\2\u03b0\u03b1\7h\2\2"+
		"\u03b1\u03b2\7c\2\2\u03b2\u03b3\7e\2\2\u03b3\u03b4\7g\2\2\u03b4\u0088"+
		"\3\2\2\2\u03b5\u03b6\7n\2\2\u03b6\u03b7\7q\2\2\u03b7\u03b8\7p\2\2\u03b8"+
		"\u03b9\7i\2\2\u03b9\u008a\3\2\2\2\u03ba\u03bb\7p\2\2\u03bb\u03bc\7c\2"+
		"\2\u03bc\u03bd\7v\2\2\u03bd\u03be\7k\2\2\u03be\u03bf\7x\2\2\u03bf\u03c0"+
		"\7g\2\2\u03c0\u008c\3\2\2\2\u03c1\u03c2\7p\2\2\u03c2\u03c3\7g\2\2\u03c3"+
		"\u03c4\7y\2\2\u03c4\u008e\3\2\2\2\u03c5\u03c6\7p\2\2\u03c6\u03c7\7q\2"+
		"\2\u03c7\u03c8\7p\2\2\u03c8\u03c9\7/\2\2\u03c9\u03ca\7u\2\2\u03ca\u03cb"+
		"\7g\2\2\u03cb\u03cc\7c\2\2\u03cc\u03cd\7n\2\2\u03cd\u03ce\7g\2\2\u03ce"+
		"\u03cf\7f\2\2\u03cf\u0090\3\2\2\2\u03d0\u03d1\7r\2\2\u03d1\u03d2\7c\2"+
		"\2\u03d2\u03d3\7e\2\2\u03d3\u03d4\7m\2\2\u03d4\u03d5\7c\2\2\u03d5\u03d6"+
		"\7i\2\2\u03d6\u03d7\7g\2\2\u03d7\u0092\3\2\2\2\u03d8\u03d9\7r\2\2\u03d9"+
		"\u03da\7g\2\2\u03da\u03db\7t\2\2\u03db\u03dc\7o\2\2\u03dc\u03dd\7k\2\2"+
		"\u03dd\u03de\7v\2\2\u03de\u03df\7u\2\2\u03df\u0094\3\2\2\2\u03e0\u03e1"+
		"\7r\2\2\u03e1\u03e2\7t\2\2\u03e2\u03e3\7k\2\2\u03e3\u03e4\7x\2\2\u03e4"+
		"\u03e5\7c\2\2\u03e5\u03e6\7v\2\2\u03e6\u03e7\7g\2\2\u03e7\u0096\3\2\2"+
		"\2\u03e8\u03e9\7r\2\2\u03e9\u03ea\7t\2\2\u03ea\u03eb\7q\2\2\u03eb\u03ec"+
		"\7v\2\2\u03ec\u03ed\7g\2\2\u03ed\u03ee\7e\2\2\u03ee\u03ef\7v\2\2\u03ef"+
		"\u03f0\7g\2\2\u03f0\u03f1\7f\2\2\u03f1\u0098\3\2\2\2\u03f2\u03f3\7r\2"+
		"\2\u03f3\u03f4\7w\2\2\u03f4\u03f5\7d\2\2\u03f5\u03f6\7n\2\2\u03f6\u03f7"+
		"\7k\2\2\u03f7\u03f8\7e\2\2\u03f8\u009a\3\2\2\2\u03f9\u03fa\7t\2\2\u03fa"+
		"\u03fb\7g\2\2\u03fb\u03fc\7e\2\2\u03fc\u03fd\7q\2\2\u03fd\u03fe\7t\2\2"+
		"\u03fe\u03ff\7f\2\2\u03ff\u009c\3\2\2\2\u0400\u0401\7t\2\2\u0401\u0402"+
		"\7g\2\2\u0402\u0403\7v\2\2\u0403\u0404\7w\2\2\u0404\u0405\7t\2\2\u0405"+
		"\u0406\7p\2\2\u0406\u009e\3\2\2\2\u0407\u0408\7u\2\2\u0408\u0409\7g\2"+
		"\2\u0409\u040a\7c\2\2\u040a\u040b\7n\2\2\u040b\u040c\7g\2\2\u040c\u040d"+
		"\7f\2\2\u040d\u00a0\3\2\2\2\u040e\u040f\7u\2\2\u040f\u0410\7j\2\2\u0410"+
		"\u0411\7q\2\2\u0411\u0412\7t\2\2\u0412\u0413\7v\2\2\u0413\u00a2\3\2\2"+
		"\2\u0414\u0415\7u\2\2\u0415\u0416\7v\2\2\u0416\u0417\7c\2\2\u0417\u0418"+
		"\7v\2\2\u0418\u0419\7k\2\2\u0419\u041a\7e\2\2\u041a\u00a4\3\2\2\2\u041b"+
		"\u041c\7u\2\2\u041c\u041d\7v\2\2\u041d\u041e\7t\2\2\u041e\u041f\7k\2\2"+
		"\u041f\u0420\7e\2\2\u0420\u0421\7v\2\2\u0421\u0422\7h\2\2\u0422\u0423"+
		"\7r\2\2\u0423\u00a6\3\2\2\2\u0424\u0425\7u\2\2\u0425\u0426\7w\2\2\u0426"+
		"\u0427\7r\2\2\u0427\u0428\7g\2\2\u0428\u0429\7t\2\2\u0429\u00a8\3\2\2"+
		"\2\u042a\u042b\7u\2\2\u042b\u042c\7y\2\2\u042c\u042d\7k\2\2\u042d\u042e"+
		"\7v\2\2\u042e\u042f\7e\2\2\u042f\u0430\7j\2\2\u0430\u00aa\3\2\2\2\u0431"+
		"\u0432\7u\2\2\u0432\u0433\7{\2\2\u0433\u0434\7p\2\2\u0434\u0435\7e\2\2"+
		"\u0435\u0436\7j\2\2\u0436\u0437\7t\2\2\u0437\u0438\7q\2\2\u0438\u0439"+
		"\7p\2\2\u0439\u043a\7k\2\2\u043a\u043b\7|\2\2\u043b\u043c\7g\2\2\u043c"+
		"\u043d\7f\2\2\u043d\u00ac\3\2\2\2\u043e\u043f\7v\2\2\u043f\u0440\7j\2"+
		"\2\u0440\u0441\7k\2\2\u0441\u0442\7u\2\2\u0442\u00ae\3\2\2\2\u0443\u0444"+
		"\7v\2\2\u0444\u0445\7j\2\2\u0445\u0446\7t\2\2\u0446\u0447\7q\2\2\u0447"+
		"\u0448\7y\2\2\u0448\u00b0\3\2\2\2\u0449\u044a\7v\2\2\u044a\u044b\7j\2"+
		"\2\u044b\u044c\7t\2\2\u044c\u044d\7q\2\2\u044d\u044e\7y\2\2\u044e\u044f"+
		"\7u\2\2\u044f\u00b2\3\2\2\2\u0450\u0451\7v\2\2\u0451\u0452\7t\2\2\u0452"+
		"\u0453\7c\2\2\u0453\u0454\7p\2\2\u0454\u0455\7u\2\2\u0455\u0456\7k\2\2"+
		"\u0456\u0457\7g\2\2\u0457\u0458\7p\2\2\u0458\u0459\7v\2\2\u0459\u00b4"+
		"\3\2\2\2\u045a\u045b\7v\2\2\u045b\u045c\7t\2\2\u045c\u045d\7{\2\2\u045d"+
		"\u00b6\3\2\2\2\u045e\u045f\7x\2\2\u045f\u0460\7q\2\2\u0460\u0461\7k\2"+
		"\2\u0461\u0462\7f\2\2\u0462\u00b8\3\2\2\2\u0463\u0464\7x\2\2\u0464\u0465"+
		"\7q\2\2\u0465\u0466\7n\2\2\u0466\u0467\7c\2\2\u0467\u0468\7v\2\2\u0468"+
		"\u0469\7k\2\2\u0469\u046a\7n\2\2\u046a\u046b\7g\2\2\u046b\u00ba\3\2\2"+
		"\2\u046c\u046d\7y\2\2\u046d\u046e\7j\2\2\u046e\u046f\7k\2\2\u046f\u0470"+
		"\7n\2\2\u0470\u0471\7g\2\2\u0471\u00bc\3\2\2\2\u0472\u0477\5\u00c1^\2"+
		"\u0473\u0477\5\u00c3_\2\u0474\u0477\5\u00c5`\2\u0475\u0477\5\u00c7a\2"+
		"\u0476\u0472\3\2\2\2\u0476\u0473\3\2\2\2\u0476\u0474\3\2\2\2\u0476\u0475"+
		"\3\2\2\2\u0477\u047b\3\2\2\2\u0478\u0479\5\u00d7i\2\u0479\u047a\b\\\22"+
		"\2\u047a\u047c\3\2\2\2\u047b\u0478\3\2\2\2\u047b\u047c\3\2\2\2\u047c\u0489"+
		"\3\2\2\2\u047d\u0480\5\u00bf]\2\u047e\u047f\t\7\2\2\u047f\u0481\b\\\23"+
		"\2\u0480\u047e\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0480\3\2\2\2\u0482\u0483"+
		"\3\2\2\2\u0483\u0484\3\2\2\2\u0484\u0486\b\\\24\2\u0485\u0487\5\u00c9"+
		"b\2\u0486\u0485\3\2\2\2\u0486\u0487\3\2\2\2\u0487\u0489\3\2\2\2\u0488"+
		"\u0476\3\2\2\2\u0488\u047d\3\2\2\2\u0489\u00be\3\2\2\2\u048a\u048b\7\62"+
		"\2\2\u048b\u00c0\3\2\2\2\u048c\u048e\5\u00cbc\2\u048d\u048f\5\u00c9b\2"+
		"\u048e\u048d\3\2\2\2\u048e\u048f\3\2\2\2\u048f\u00c2\3\2\2\2\u0490\u0492"+
		"\5\u00d9j\2\u0491\u0493\5\u00c9b\2\u0492\u0491\3\2\2\2\u0492\u0493\3\2"+
		"\2\2\u0493\u00c4\3\2\2\2\u0494\u0496\5\u00e1n\2\u0495\u0497\5\u00c9b\2"+
		"\u0496\u0495\3\2\2\2\u0496\u0497\3\2\2\2\u0497\u00c6\3\2\2\2\u0498\u049a"+
		"\5\u00e9r\2\u0499\u049b\5\u00c9b\2\u049a\u0499\3\2\2\2\u049a\u049b\3\2"+
		"\2\2\u049b\u00c8\3\2\2\2\u049c\u049d\t\b\2\2\u049d\u00ca\3\2\2\2\u049e"+
		"\u04a9\5\u00bf]\2\u049f\u04a6\5\u00d1f\2\u04a0\u04a2\5\u00cdd\2\u04a1"+
		"\u04a0\3\2\2\2\u04a1\u04a2\3\2\2\2\u04a2\u04a7\3\2\2\2\u04a3\u04a4\5\u00d5"+
		"h\2\u04a4\u04a5\5\u00cdd\2\u04a5\u04a7\3\2\2\2\u04a6\u04a1\3\2\2\2\u04a6"+
		"\u04a3\3\2\2\2\u04a7\u04a9\3\2\2\2\u04a8\u049e\3\2\2\2\u04a8\u049f\3\2"+
		"\2\2\u04a9\u00cc\3\2\2\2\u04aa\u04b2\5\u00cfe\2\u04ab\u04ad\5\u00d3g\2"+
		"\u04ac\u04ab\3\2\2\2\u04ad\u04b0\3\2\2\2\u04ae\u04ac\3\2\2\2\u04ae\u04af"+
		"\3\2\2\2\u04af\u04b1\3\2\2\2\u04b0\u04ae\3\2\2\2\u04b1\u04b3\5\u00cfe"+
		"\2\u04b2\u04ae\3\2\2\2\u04b2\u04b3\3\2\2\2\u04b3\u00ce\3\2\2\2\u04b4\u04b7"+
		"\5\u00bf]\2\u04b5\u04b7\5\u00d1f\2\u04b6\u04b4\3\2\2\2\u04b6\u04b5\3\2"+
		"\2\2\u04b7\u00d0\3\2\2\2\u04b8\u04b9\t\t\2\2\u04b9\u00d2\3\2\2\2\u04ba"+
		"\u04bd\5\u00cfe\2\u04bb\u04bd\5\u00d7i\2\u04bc\u04ba\3\2\2\2\u04bc\u04bb"+
		"\3\2\2\2\u04bd\u00d4\3\2\2\2\u04be\u04c0\5\u00d7i\2\u04bf\u04be\3\2\2"+
		"\2\u04c0\u04c1\3\2\2\2\u04c1\u04bf\3\2\2\2\u04c1\u04c2\3\2\2\2\u04c2\u00d6"+
		"\3\2\2\2\u04c3\u04c4\7a\2\2\u04c4\u00d8\3\2\2\2\u04c5\u04c6\5\u00bf]\2"+
		"\u04c6\u04c7\t\n\2\2\u04c7\u04c8\5\u00dbk\2\u04c8\u00da\3\2\2\2\u04c9"+
		"\u04d1\5\u00ddl\2\u04ca\u04cc\5\u00dfm\2\u04cb\u04ca\3\2\2\2\u04cc\u04cf"+
		"\3\2\2\2\u04cd\u04cb\3\2\2\2\u04cd\u04ce\3\2\2\2\u04ce\u04d0\3\2\2\2\u04cf"+
		"\u04cd\3\2\2\2\u04d0\u04d2\5\u00ddl\2\u04d1\u04cd\3\2\2\2\u04d1\u04d2"+
		"\3\2\2\2\u04d2\u00dc\3\2\2\2\u04d3\u04d4\t\13\2\2\u04d4\u00de\3\2\2\2"+
		"\u04d5\u04d8\5\u00ddl\2\u04d6\u04d8\5\u00d7i\2\u04d7\u04d5\3\2\2\2\u04d7"+
		"\u04d6\3\2\2\2\u04d8\u00e0\3\2\2\2\u04d9\u04db\5\u00bf]\2\u04da\u04dc"+
		"\5\u00d5h\2\u04db\u04da\3\2\2\2\u04db\u04dc\3\2\2\2\u04dc\u04dd\3\2\2"+
		"\2\u04dd\u04de\5\u00e3o\2\u04de\u00e2\3\2\2\2\u04df\u04e7\5\u00e5p\2\u04e0"+
		"\u04e2\5\u00e7q\2\u04e1\u04e0\3\2\2\2\u04e2\u04e5\3\2\2\2\u04e3\u04e1"+
		"\3\2\2\2\u04e3\u04e4\3\2\2\2\u04e4\u04e6\3\2\2\2\u04e5\u04e3\3\2\2\2\u04e6"+
		"\u04e8\5\u00e5p\2\u04e7\u04e3\3\2\2\2\u04e7\u04e8\3\2\2\2\u04e8\u00e4"+
		"\3\2\2\2\u04e9\u04ea\t\f\2\2\u04ea\u00e6\3\2\2\2\u04eb\u04ee\5\u00e5p"+
		"\2\u04ec\u04ee\5\u00d7i\2\u04ed\u04eb\3\2\2\2\u04ed\u04ec\3\2\2\2\u04ee"+
		"\u00e8\3\2\2\2\u04ef\u04f0\5\u00bf]\2\u04f0\u04f1\t\r\2\2\u04f1\u04f2"+
		"\5\u00ebs\2\u04f2\u00ea\3\2\2\2\u04f3\u04fb\5\u00edt\2\u04f4\u04f6\5\u00ef"+
		"u\2\u04f5\u04f4\3\2\2\2\u04f6\u04f9\3\2\2\2\u04f7\u04f5\3\2\2\2\u04f7"+
		"\u04f8\3\2\2\2\u04f8\u04fa\3\2\2\2\u04f9\u04f7\3\2\2\2\u04fa\u04fc\5\u00ed"+
		"t\2\u04fb\u04f7\3\2\2\2\u04fb\u04fc\3\2\2\2\u04fc\u00ec\3\2\2\2\u04fd"+
		"\u04fe\t\16\2\2\u04fe\u00ee\3\2\2\2\u04ff\u0502\5\u00edt\2\u0500\u0502"+
		"\5\u00d7i\2\u0501\u04ff\3\2\2\2\u0501\u0500\3\2\2\2\u0502\u00f0\3\2\2"+
		"\2\u0503\u0506\5\u00f3w\2\u0504\u0506\5\u00ff}\2\u0505\u0503\3\2\2\2\u0505"+
		"\u0504\3\2\2\2\u0506\u050a\3\2\2\2\u0507\u0508\5\u00d7i\2\u0508\u0509"+
		"\bv\25\2\u0509\u050b\3\2\2\2\u050a\u0507\3\2\2\2\u050a\u050b\3\2\2\2\u050b"+
		"\u00f2\3\2\2\2\u050c\u050e\5\u00cdd\2\u050d\u050c\3\2\2\2\u050d\u050e"+
		"\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u0510\5\u0107\u0081\2\u0510\u0512\5"+
		"\u00cdd\2\u0511\u0513\5\u00f5x\2\u0512\u0511\3\2\2\2\u0512\u0513\3\2\2"+
		"\2\u0513\u0515\3\2\2\2\u0514\u0516\5\u00fd|\2\u0515\u0514\3\2\2\2\u0515"+
		"\u0516\3\2\2\2\u0516\u0520\3\2\2\2\u0517\u0518\5\u00cdd\2\u0518\u051a"+
		"\5\u00f5x\2\u0519\u051b\5\u00fd|\2\u051a\u0519\3\2\2\2\u051a\u051b\3\2"+
		"\2\2\u051b\u0520\3\2\2\2\u051c\u051d\5\u00cdd\2\u051d\u051e\5\u00fd|\2"+
		"\u051e\u0520\3\2\2\2\u051f\u050d\3\2\2\2\u051f\u0517\3\2\2\2\u051f\u051c"+
		"\3\2\2\2\u0520\u00f4\3\2\2\2\u0521\u0522\5\u00f7y\2\u0522\u0523\5\u00f9"+
		"z\2\u0523\u00f6\3\2\2\2\u0524\u0525\t\17\2\2\u0525\u00f8\3\2\2\2\u0526"+
		"\u0528\5\u00fb{\2\u0527\u0526\3\2\2\2\u0527\u0528\3\2\2\2\u0528\u0529"+
		"\3\2\2\2\u0529\u052a\5\u00cdd\2\u052a\u00fa\3\2\2\2\u052b\u052c\t\20\2"+
		"\2\u052c\u00fc\3\2\2\2\u052d\u052e\t\21\2\2\u052e\u00fe\3\2\2\2\u052f"+
		"\u0530\5\u0101~\2\u0530\u0532\5\u0103\177\2\u0531\u0533\5\u00fd|\2\u0532"+
		"\u0531\3\2\2\2\u0532\u0533\3\2\2\2\u0533\u0100\3\2\2\2\u0534\u0536\5\u00d9"+
		"j\2\u0535\u0537\5\u0107\u0081\2\u0536\u0535\3\2\2\2\u0536\u0537\3\2\2"+
		"\2\u0537\u0541\3\2\2\2\u0538\u0539\5\u00bf]\2\u0539\u053b\t\n\2\2\u053a"+
		"\u053c\5\u00dbk\2\u053b\u053a\3\2\2\2\u053b\u053c\3\2\2\2\u053c\u053d"+
		"\3\2\2\2\u053d\u053e\5\u0107\u0081\2\u053e\u053f\5\u00dbk\2\u053f\u0541"+
		"\3\2\2\2\u0540\u0534\3\2\2\2\u0540\u0538\3\2\2\2\u0541\u0102\3\2\2\2\u0542"+
		"\u0543\5\u0105\u0080\2\u0543\u0544\5\u00f9z\2\u0544\u0104\3\2\2\2\u0545"+
		"\u0546\t\22\2\2\u0546\u0106\3\2\2\2\u0547\u0548\7\60\2\2\u0548\u0108\3"+
		"\2\2\2\u0549\u054a\7v\2\2\u054a\u054b\7t\2\2\u054b\u054c\7w\2\2\u054c"+
		"\u0553\7g\2\2\u054d\u054e\7h\2\2\u054e\u054f\7c\2\2\u054f\u0550\7n\2\2"+
		"\u0550\u0551\7u\2\2\u0551\u0553\7g\2\2\u0552\u0549\3\2\2\2\u0552\u054d"+
		"\3\2\2\2\u0553\u010a\3\2\2\2\u0554\u0555\5\u011b\u008b\2\u0555\u0556\t"+
		"\23\2\2\u0556\u055c\3\2\2\2\u0557\u055c\5\u010d\u0084\2\u0558\u055c\5"+
		"\u010f\u0085\2\u0559\u055c\5\u0113\u0087\2\u055a\u055c\5\u0115\u0088\2"+
		"\u055b\u0554\3\2\2\2\u055b\u0557\3\2\2\2\u055b\u0558\3\2\2\2\u055b\u0559"+
		"\3\2\2\2\u055b\u055a\3\2\2\2\u055c\u010c\3\2\2\2\u055d\u055e\5\u011b\u008b"+
		"\2\u055e\u055f\5\u00e5p\2\u055f\u056a\3\2\2\2\u0560\u0561\5\u011b\u008b"+
		"\2\u0561\u0562\5\u00e5p\2\u0562\u0563\5\u00e5p\2\u0563\u056a\3\2\2\2\u0564"+
		"\u0565\5\u011b\u008b\2\u0565\u0566\5\u0111\u0086\2\u0566\u0567\5\u00e5"+
		"p\2\u0567\u0568\5\u00e5p\2\u0568\u056a\3\2\2\2\u0569\u055d\3\2\2\2\u0569"+
		"\u0560\3\2\2\2\u0569\u0564\3\2\2\2\u056a\u010e\3\2\2\2\u056b\u056c\5\u011b"+
		"\u008b\2\u056c\u056d\7w\2\2\u056d\u056e\5\u00ddl\2\u056e\u056f\5\u00dd"+
		"l\2\u056f\u0570\5\u00ddl\2\u0570\u0571\5\u00ddl\2\u0571\u0110\3\2\2\2"+
		"\u0572\u0573\t\24\2\2\u0573\u0112\3\2\2\2\u0574\u0575\5\u011b\u008b\2"+
		"\u0575\u0576\5\u011f\u008d\2\u0576\u0114\3\2\2\2\u0577\u0578\5\u011b\u008b"+
		"\2\u0578\u0579\5\u0117\u0089\2\u0579\u0116\3\2\2\2\u057a\u057c\7\17\2"+
		"\2\u057b\u057a\3\2\2\2\u057b\u057c\3\2\2\2\u057c\u057d\3\2\2\2\u057d\u0580"+
		"\7\f\2\2\u057e\u0580\7\17\2\2\u057f\u057b\3\2\2\2\u057f\u057e\3\2\2\2"+
		"\u0580\u0118\3\2\2\2\u0581\u0582\5\u011b\u008b\2\u0582\u0583\5\u011d\u008c"+
		"\2\u0583\u011a\3\2\2\2\u0584\u0585\7^\2\2\u0585\u011c\3\2\2\2\u0586\u0587"+
		"\7\61\2\2\u0587\u011e\3\2\2\2\u0588\u0589\7&\2\2\u0589\u0120\3\2\2\2\u058a"+
		"\u058b\7$\2\2\u058b\u0122\3\2\2\2\u058c\u058d\7)\2\2\u058d\u0124\3\2\2"+
		"\2\u058e\u058f\7$\2\2\u058f\u0590\7$\2\2\u0590\u0591\7$\2\2\u0591\u0126"+
		"\3\2\2\2\u0592\u0593\7)\2\2\u0593\u0594\7)\2\2\u0594\u0595\7)\2\2\u0595"+
		"\u0128\3\2\2\2\u0596\u0597\7&\2\2\u0597\u0598\7\61\2\2\u0598\u012a\3\2"+
		"\2\2\u0599\u059a\7\61\2\2\u059a\u059b\7&\2\2\u059b\u012c\3\2\2\2\u059c"+
		"\u059d\7&\2\2\u059d\u059e\7\61\2\2\u059e\u012e\3\2\2\2\u059f\u05a0\7&"+
		"\2\2\u05a0\u05a1\7&\2\2\u05a1\u0130\3\2\2\2\u05a2\u05a3\7&\2\2\u05a3\u05a4"+
		"\7\61\2\2\u05a4\u05a5\7&\2\2\u05a5\u0132\3\2\2\2\u05a6\u05a7\7p\2\2\u05a7"+
		"\u05a8\7w\2\2\u05a8\u05a9\7n\2\2\u05a9\u05aa\7n\2\2\u05aa\u0134\3\2\2"+
		"\2\u05ab\u05ac\7\60\2\2\u05ac\u05ad\7\60\2\2\u05ad\u0136\3\2\2\2\u05ae"+
		"\u05af\7>\2\2\u05af\u05b0\7\60\2\2\u05b0\u05b1\7\60\2\2\u05b1\u0138\3"+
		"\2\2\2\u05b2\u05b3\7\60\2\2\u05b3\u05b4\7\60\2\2\u05b4\u05b5\7>\2\2\u05b5"+
		"\u013a\3\2\2\2\u05b6\u05b7\7>\2\2\u05b7\u05b8\7\60\2\2\u05b8\u05b9\7\60"+
		"\2\2\u05b9\u05ba\7>\2\2\u05ba\u013c\3\2\2\2\u05bb\u05bc\7,\2\2\u05bc\u05bd"+
		"\7\60\2\2\u05bd\u013e\3\2\2\2\u05be\u05bf\7A\2\2\u05bf\u05c0\7\60\2\2"+
		"\u05c0\u0140\3\2\2\2\u05c1\u05c2\7A\2\2\u05c2\u05c3\7]\2\2\u05c3\u05c4"+
		"\3\2\2\2\u05c4\u05c5\b\u009e\26\2\u05c5\u05c6\3\2\2\2\u05c6\u05c7\b\u009e"+
		"\16\2\u05c7\u0142\3\2\2\2\u05c8\u05c9\7A\2\2\u05c9\u05ca\7A\2\2\u05ca"+
		"\u05cb\7\60\2\2\u05cb\u0144\3\2\2\2\u05cc\u05cd\7A\2\2\u05cd\u05ce\7<"+
		"\2\2\u05ce\u0146\3\2\2\2\u05cf\u05d0\7\60\2\2\u05d0\u05d1\7(\2\2\u05d1"+
		"\u0148\3\2\2\2\u05d2\u05d3\7<\2\2\u05d3\u05d4\7<\2\2\u05d4\u014a\3\2\2"+
		"\2\u05d5\u05d6\7?\2\2\u05d6\u05d7\7\u0080\2\2\u05d7\u014c\3\2\2\2\u05d8"+
		"\u05d9\7?\2\2\u05d9\u05da\7?\2\2\u05da\u05db\7\u0080\2\2\u05db\u014e\3"+
		"\2\2\2\u05dc\u05dd\7,\2\2\u05dd\u05de\7,\2\2\u05de\u0150\3\2\2\2\u05df"+
		"\u05e0\7,\2\2\u05e0\u05e1\7,\2\2\u05e1\u05e2\7?\2\2\u05e2\u0152\3\2\2"+
		"\2\u05e3\u05e4\7>\2\2\u05e4\u05e5\7?\2\2\u05e5\u05e6\7@\2\2\u05e6\u0154"+
		"\3\2\2\2\u05e7\u05e8\7?\2\2\u05e8\u05e9\7?\2\2\u05e9\u05ea\7?\2\2\u05ea"+
		"\u0156\3\2\2\2\u05eb\u05ec\7#\2\2\u05ec\u05ed\7?\2\2\u05ed\u05ee\7?\2"+
		"\2\u05ee\u0158\3\2\2\2\u05ef\u05f0\7/\2\2\u05f0\u05f1\7@\2\2\u05f1\u015a"+
		"\3\2\2\2\u05f2\u05f3\7#\2\2\u05f3\u05f4\7k\2\2\u05f4\u05f5\7p\2\2\u05f5"+
		"\u05f6\7u\2\2\u05f6\u05f7\7v\2\2\u05f7\u05f8\7c\2\2\u05f8\u05f9\7p\2\2"+
		"\u05f9\u05fa\7e\2\2\u05fa\u05fb\7g\2\2\u05fb\u05fc\7q\2\2\u05fc\u05fd"+
		"\7h\2\2\u05fd\u05fe\3\2\2\2\u05fe\u05ff\6\u00ab\17\2\u05ff\u015c\3\2\2"+
		"\2\u0600\u0601\7#\2\2\u0601\u0602\7k\2\2\u0602\u0603\7p\2\2\u0603\u0604"+
		"\3\2\2\2\u0604\u0605\6\u00ac\20\2\u0605\u015e\3\2\2\2\u0606\u0607\7*\2"+
		"\2\u0607\u0608\b\u00ad\27\2\u0608\u0609\3\2\2\2\u0609\u060a\b\u00ad\16"+
		"\2\u060a\u0160\3\2\2\2\u060b\u060c\7+\2\2\u060c\u060d\b\u00ae\30\2\u060d"+
		"\u060e\3\2\2\2\u060e\u060f\b\u00ae\b\2\u060f\u0162\3\2\2\2\u0610\u0611"+
		"\7}\2\2\u0611\u0612\b\u00af\31\2\u0612\u0613\3\2\2\2\u0613\u0614\b\u00af"+
		"\16\2\u0614\u0164\3\2\2\2\u0615\u0616\7\177\2\2\u0616\u0617\b\u00b0\32"+
		"\2\u0617\u0618\3\2\2\2\u0618\u0619\b\u00b0\b\2\u0619\u0166\3\2\2\2\u061a"+
		"\u061b\7]\2\2\u061b\u061c\b\u00b1\33\2\u061c\u061d\3\2\2\2\u061d\u061e"+
		"\b\u00b1\16\2\u061e\u0168\3\2\2\2\u061f\u0620\7_\2\2\u0620\u0621\b\u00b2"+
		"\34\2\u0621\u0622\3\2\2\2\u0622\u0623\b\u00b2\b\2\u0623\u016a\3\2\2\2"+
		"\u0624\u0625\7=\2\2\u0625\u016c\3\2\2\2\u0626\u0627\7.\2\2\u0627\u016e"+
		"\3\2\2\2\u0628\u0629\5\u0107\u0081\2\u0629\u0170\3\2\2\2\u062a\u062b\7"+
		"?\2\2\u062b\u0172\3\2\2\2\u062c\u062d\7@\2\2\u062d\u0174\3\2\2\2\u062e"+
		"\u062f\7>\2\2\u062f\u0176\3\2\2\2\u0630\u0631\7#\2\2\u0631\u0178\3\2\2"+
		"\2\u0632\u0633\7\u0080\2\2\u0633\u017a\3\2\2\2\u0634\u0635\7A\2\2\u0635"+
		"\u017c\3\2\2\2\u0636\u0637\7<\2\2\u0637\u017e\3\2\2\2\u0638\u0639\7?\2"+
		"\2\u0639\u063a\7?\2\2\u063a\u0180\3\2\2\2\u063b\u063c\7>\2\2\u063c\u063d"+
		"\7?\2\2\u063d\u0182\3\2\2\2\u063e\u063f\7@\2\2\u063f\u0640\7?\2\2\u0640"+
		"\u0184\3\2\2\2\u0641\u0642\7#\2\2\u0642\u0643\7?\2\2\u0643\u0186\3\2\2"+
		"\2\u0644\u0645\7(\2\2\u0645\u0646\7(\2\2\u0646\u0188\3\2\2\2\u0647\u0648"+
		"\7~\2\2\u0648\u0649\7~\2\2\u0649\u018a\3\2\2\2\u064a\u064b\7-\2\2\u064b"+
		"\u064c\7-\2\2\u064c\u018c\3\2\2\2\u064d\u064e\7/\2\2\u064e\u064f\7/\2"+
		"\2\u064f\u018e\3\2\2\2\u0650\u0651\7-\2\2\u0651\u0190\3\2\2\2\u0652\u0653"+
		"\7/\2\2\u0653\u0192\3\2\2\2\u0654\u0655\7,\2\2\u0655\u0194\3\2\2\2\u0656"+
		"\u0657\5\u011d\u008c\2\u0657\u0196\3\2\2\2\u0658\u0659\7(\2\2\u0659\u0198"+
		"\3\2\2\2\u065a\u065b\7~\2\2\u065b\u019a\3\2\2\2\u065c\u065d\7`\2\2\u065d"+
		"\u019c\3\2\2\2\u065e\u065f\7\'\2\2\u065f\u019e\3\2\2\2\u0660\u0661\7-"+
		"\2\2\u0661\u0662\7?\2\2\u0662\u01a0\3\2\2\2\u0663\u0664\7/\2\2\u0664\u0665"+
		"\7?\2\2\u0665\u01a2\3\2\2\2\u0666\u0667\7,\2\2\u0667\u0668\7?\2\2\u0668"+
		"\u01a4\3\2\2\2\u0669\u066a\7\61\2\2\u066a\u066b\7?\2\2\u066b\u01a6\3\2"+
		"\2\2\u066c\u066d\7(\2\2\u066d\u066e\7?\2\2\u066e\u01a8\3\2\2\2\u066f\u0670"+
		"\7~\2\2\u0670\u0671\7?\2\2\u0671\u01aa\3\2\2\2\u0672\u0673\7`\2\2\u0673"+
		"\u0674\7?\2\2\u0674\u01ac\3\2\2\2\u0675\u0676\7\'\2\2\u0676\u0677\7?\2"+
		"\2\u0677\u01ae\3\2\2\2\u0678\u0679\7>\2\2\u0679\u067a\7>\2\2\u067a\u067b"+
		"\7?\2\2\u067b\u01b0\3\2\2\2\u067c\u067d\7@\2\2\u067d\u067e\7@\2\2\u067e"+
		"\u067f\7?\2\2\u067f\u01b2\3\2\2\2\u0680\u0681\7@\2\2\u0681\u0682\7@\2"+
		"\2\u0682\u0683\7@\2\2\u0683\u0684\7?\2\2\u0684\u01b4\3\2\2\2\u0685\u0686"+
		"\7A\2\2\u0686\u0687\7?\2\2\u0687\u01b6\3\2\2\2\u0688\u0689\5\u01bd\u00dc"+
		"\2\u0689\u068d\6\u00d9\21\2\u068a\u068c\5\u01c1\u00de\2\u068b\u068a\3"+
		"\2\2\2\u068c\u068f\3\2\2\2\u068d\u068b\3\2\2\2\u068d\u068e\3\2\2\2\u068e"+
		"\u01b8\3\2\2\2\u068f\u068d\3\2\2\2\u0690\u0694\5\u01bd\u00dc\2\u0691\u0693"+
		"\5\u01c1\u00de\2\u0692\u0691\3\2\2\2\u0693\u0696\3\2\2\2\u0694\u0692\3"+
		"\2\2\2\u0694\u0695\3\2\2\2\u0695\u01ba\3\2\2\2\u0696\u0694\3\2\2\2\u0697"+
		"\u069b\5\u01bf\u00dd\2\u0698\u069a\5\u01c3\u00df\2\u0699\u0698\3\2\2\2"+
		"\u069a\u069d\3\2\2\2\u069b\u0699\3\2\2\2\u069b\u069c\3\2\2\2\u069c\u01bc"+
		"\3\2\2\2\u069d\u069b\3\2\2\2\u069e\u06a5\t\25\2\2\u069f\u06a0\n\26\2\2"+
		"\u06a0\u06a5\6\u00dc\22\2\u06a1\u06a2\t\27\2\2\u06a2\u06a3\t\30\2\2\u06a3"+
		"\u06a5\6\u00dc\23\2\u06a4\u069e\3\2\2\2\u06a4\u069f\3\2\2\2\u06a4\u06a1"+
		"\3\2\2\2\u06a5\u01be\3\2\2\2\u06a6\u06a7\5\u01bd\u00dc\2\u06a7\u06a8\6"+
		"\u00dd\24\2\u06a8\u01c0\3\2\2\2\u06a9\u06b0\t\31\2\2\u06aa\u06ab\n\26"+
		"\2\2\u06ab\u06b0\6\u00de\25\2\u06ac\u06ad\t\27\2\2\u06ad\u06ae\t\30\2"+
		"\2\u06ae\u06b0\6\u00de\26\2\u06af\u06a9\3\2\2\2\u06af\u06aa\3\2\2\2\u06af"+
		"\u06ac\3\2\2\2\u06b0\u01c2\3\2\2\2\u06b1\u06b2\5\u01c1\u00de\2\u06b2\u06b3"+
		"\6\u00df\27\2\u06b3\u01c4\3\2\2\2\u06b4\u06b6\n\32\2\2\u06b5\u06b4\3\2"+
		"\2\2\u06b6\u06b9\3\2\2\2\u06b7\u06b5\3\2\2\2\u06b7\u06b8\3\2\2\2\u06b8"+
		"\u01c6\3\2\2\2\u06b9\u06b7\3\2\2\2\u06ba\u06bb\7B\2\2\u06bb\u01c8\3\2"+
		"\2\2\u06bc\u06bd\7\60\2\2\u06bd\u06be\7\60\2\2\u06be\u06bf\7\60\2\2\u06bf"+
		"\u01ca\3\2\2\2\u06c0\u06c2\t\33\2\2\u06c1\u06c0\3\2\2\2\u06c2\u06c3\3"+
		"\2\2\2\u06c3\u06c1\3\2\2\2\u06c3\u06c4\3\2\2\2\u06c4\u06cb\3\2\2\2\u06c5"+
		"\u06c7\5\u0115\u0088\2\u06c6\u06c5\3\2\2\2\u06c7\u06c8\3\2\2\2\u06c8\u06c6"+
		"\3\2\2\2\u06c8\u06c9\3\2\2\2\u06c9\u06cb\3\2\2\2\u06ca\u06c1\3\2\2\2\u06ca"+
		"\u06c6\3\2\2\2\u06cb\u06cc\3\2\2\2\u06cc\u06cd\b\u00e3\35\2\u06cd\u01cc"+
		"\3\2\2\2\u06ce\u06cf\5\u0117\u0089\2\u06cf\u06d0\b\u00e4\36\2\u06d0\u01ce"+
		"\3\2\2\2\u06d1\u06d2\7\61\2\2\u06d2\u06d3\7,\2\2\u06d3\u06d7\3\2\2\2\u06d4"+
		"\u06d6\13\2\2\2\u06d5\u06d4\3\2\2\2\u06d6\u06d9\3\2\2\2\u06d7\u06d8\3"+
		"\2\2\2\u06d7\u06d5\3\2\2\2\u06d8\u06da\3\2\2\2\u06d9\u06d7\3\2\2\2\u06da"+
		"\u06db\7,\2\2\u06db\u06dc\7\61\2\2\u06dc\u06dd\3\2\2\2\u06dd\u06de\b\u00e5"+
		"\37\2\u06de\u06df\3\2\2\2\u06df\u06e0\b\u00e5 \2\u06e0\u01d0\3\2\2\2\u06e1"+
		"\u06e2\7\61\2\2\u06e2\u06e3\7\61\2\2\u06e3\u06e7\3\2\2\2\u06e4\u06e6\n"+
		"\32\2\2\u06e5\u06e4\3\2\2\2\u06e6\u06e9\3\2\2\2\u06e7\u06e5\3\2\2\2\u06e7"+
		"\u06e8\3\2\2\2\u06e8\u06ea\3\2\2\2\u06e9\u06e7\3\2\2\2\u06ea\u06eb\b\u00e6"+
		"!\2\u06eb\u06ec\3\2\2\2\u06ec\u06ed\b\u00e6 \2\u06ed\u01d2\3\2\2\2\u06ee"+
		"\u06ef\7%\2\2\u06ef\u06f0\7#\2\2\u06f0\u06f1\3\2\2\2\u06f1\u06f2\b\u00e7"+
		"\"\2\u06f2\u06fb\5\u01c5\u00e0\2\u06f3\u06f4\5\u0117\u0089\2\u06f4\u06f5"+
		"\7%\2\2\u06f5\u06f6\7#\2\2\u06f6\u06f7\3\2\2\2\u06f7\u06f8\5\u01c5\u00e0"+
		"\2\u06f8\u06fa\3\2\2\2\u06f9\u06f3\3\2\2\2\u06fa\u06fd\3\2\2\2\u06fb\u06f9"+
		"\3\2\2\2\u06fb\u06fc\3\2\2\2\u06fc\u06fe\3\2\2\2\u06fd\u06fb\3\2\2\2\u06fe"+
		"\u06ff\b\u00e7\35\2\u06ff\u01d4\3\2\2\2\u0700\u0701\13\2\2\2\u0701\u0702"+
		"\b\u00e8#\2\u0702\u01d6\3\2\2\2T\2\3\4\5\6\7\b\u01e9\u01f2\u01fc\u0204"+
		"\u020d\u0216\u021a\u0220\u022c\u023a\u0248\u026d\u02a4\u02a8\u02af\u02b6"+
		"\u02bd\u02cd\u02f6\u0476\u047b\u0482\u0486\u0488\u048e\u0492\u0496\u049a"+
		"\u04a1\u04a6\u04a8\u04ae\u04b2\u04b6\u04bc\u04c1\u04cd\u04d1\u04d7\u04db"+
		"\u04e3\u04e7\u04ed\u04f7\u04fb\u0501\u0505\u050a\u050d\u0512\u0515\u051a"+
		"\u051f\u0527\u0532\u0536\u053b\u0540\u0552\u055b\u0569\u057b\u057f\u068d"+
		"\u0694\u069b\u06a4\u06af\u06b7\u06c3\u06c8\u06ca\u06d7\u06e7\u06fb$\7"+
		"\3\2\7\7\2\t\4\2\7\4\2\7\5\2\7\6\2\6\2\2\5\2\2\t\5\2\t\6\2\3\24\2\tZ\2"+
		"\7\2\2\t\u0085\2\7\b\2\3\27\3\3\\\4\3\\\5\3\\\6\3v\7\3\u009e\b\3\u00ad"+
		"\t\3\u00ae\n\3\u00af\13\3\u00b0\f\3\u00b1\r\3\u00b2\16\b\2\2\3\u00e4\17"+
		"\3\u00e5\20\t\u0089\2\3\u00e6\21\3\u00e7\22\3\u00e8\23";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}