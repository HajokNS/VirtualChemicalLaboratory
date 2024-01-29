package com.chornopyskyi.chemicallaboratory.model;

import java.util.ArrayList;
import java.util.List;


public abstract class EntityErrors {

    protected List<String> errors;
    protected boolean isValid;

    protected EntityErrors() {
        errors = new ArrayList<>();
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
