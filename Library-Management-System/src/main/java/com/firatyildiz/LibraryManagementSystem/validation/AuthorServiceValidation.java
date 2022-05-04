package com.firatyildiz.LibraryManagementSystem.validation;

import org.springframework.stereotype.Service;

@Service
public class AuthorServiceValidation {

    public boolean istextual(String name)
    {
        if (org.apache.commons.lang3.StringUtils.isNumeric(name))
        {
            return false;
        }
        if (org.apache.commons.lang3.StringUtils.isEmpty(name))
        {
            return false;
        }
        if (name.trim().length() == 0)
        {
            return false;
        }

        return true;
    }



}
