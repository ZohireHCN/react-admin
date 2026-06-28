//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.opencellsoft.dto;

public class ScriptInstance {
    private String code;
    private String description;
    private String type;
    private String script;

    public ScriptInstance() {
        this.setType("JAVA");
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScript() {
        return this.script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String toString() {
        return "ScriptInstance{code='" + this.code + '\'' + ", description='" + this.description + '\'' + ", type='" + this.type + '\'' + ", script=''}";
    }
}
