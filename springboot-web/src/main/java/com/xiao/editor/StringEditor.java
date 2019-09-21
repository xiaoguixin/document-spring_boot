package com.xiao.editor;

import org.springframework.web.util.HtmlUtils;

import java.beans.PropertyEditorSupport;

/**
 * web 字符串编辑器，将字符进行HTML转义（防止XSS攻击）
 */
public class StringEditor extends PropertyEditorSupport {

    /**
     * 是否将空字符串转换为null
     */
    private final boolean emptyAsNull;

    /**
     * 是否去掉前后空格
     */
    private final boolean trimmed;

    public StringEditor() {
        this(true, true);
    }

    public StringEditor(boolean emptyAsNull, boolean trimmed) {
        this.emptyAsNull = emptyAsNull;
        this.trimmed = trimmed;
    }

    @Override
    public String getAsText() {
        return getValue() != null ? (String) getValue() : null;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);
        } else if (emptyAsNull && text.isEmpty()) {
            setValue(null);
        } else if (trimmed) {
            //HTML转义（防止XSS攻击）
            setValue(HtmlUtils.htmlEscape(text.trim()));
        } else {
            //HTML转义（防止XSS攻击）
            setValue(HtmlUtils.htmlEscape(text));
        }
    }
}
