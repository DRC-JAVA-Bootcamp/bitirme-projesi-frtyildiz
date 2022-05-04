package com.firatyildiz.LibraryManagementSystem.validation;

import org.springframework.stereotype.Service;

@Service
public class AuthorServiceValidation {

    public boolean istextual(String textualValue)
    {
        if (org.apache.commons.lang3.StringUtils.isNumeric(textualValue))
        {
            return false;
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(textualValue))
        {
            return false;
        }
        if (textualValue.trim().length() == 0)
        {
            return false;
        }
        if (textualValue.length() > 50)
        {
            return false;
        }
        if (textualValue.startsWith(" ") || textualValue.startsWith(",") || textualValue.startsWith("-") || textualValue.startsWith("?") || textualValue.startsWith("=") || textualValue.startsWith("%") || textualValue.startsWith("+") || textualValue.startsWith("!") || textualValue.startsWith("'") || textualValue.startsWith("/") || textualValue.startsWith("<") || textualValue.startsWith(">"))
        {
            return false;
        }
        if (textualValue.endsWith(" ") || textualValue.endsWith(",") || textualValue.endsWith("-") || textualValue.endsWith("?") || textualValue.endsWith("=") || textualValue.endsWith("%") || textualValue.endsWith("+") || textualValue.endsWith("!") || textualValue.endsWith("'") || textualValue.endsWith("/") || textualValue.endsWith("<") || textualValue.endsWith(">"))
        {
            return false;
        }

        return true;
    }


}
