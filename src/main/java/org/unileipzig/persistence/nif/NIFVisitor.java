package org.unileipzig.persistence.nif;


import org.apache.jena.rdf.model.Model;
import org.unileipzig.persistence.nif.impl.NIF21AnnotationUnit;


public interface NIFVisitor {

    Model getModel();

    void visit(NIFModel model);

    void visit(NIFPrefixes prefixes);

    void visit(NIFProperties properties);

    void visit(NIFLiteral literal);

    void visit(NIFResource resource);
    
    void visit(NIF21AnnotationUnit anotationUnit);
}