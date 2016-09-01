package org.unileipzig.persistence.nif.impl;


import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.unileipzig.persistence.nif.NIF21Format;
import org.unileipzig.persistence.nif.NIFLiteral;
import org.unileipzig.persistence.nif.NIFVisitor;

public class NIF21Literal implements NIFLiteral, NIF21Format {


    public void add(Model model, NIFBean entity) {

        if (model != null  && entity != null ) {

            Resource contextRes = model.getResource(entity.getContext().context(CONTEXT_FORMAT));

            if (entity.isContext()) {

                contextRes.addLiteral(
                        model.getProperty(NIF_PROPERTY_ISSTRING),
                        entity.getMention());

                model.add(contextRes, model.createProperty(NIF_PROPERTY_BEGININDEX),
                        entity.getBeginIndex().toString(), XSDDatatype.XSDnonNegativeInteger);

                model.add(contextRes, model.createProperty(NIF_PROPERTY_ENDINDEX),
                        entity.getEndIndex().toString(), XSDDatatype.XSDnonNegativeInteger);

            } else if (entity.isMention()) {

                contextRes.addLiteral(
                        model.createProperty(NIF_PROPERTY_ANCHOR_OF),
                        entity.getMention());

                model.add(contextRes, model.createProperty(NIF_PROPERTY_BEGININDEX),
                        entity.getBeginIndex().toString(), XSDDatatype.XSDnonNegativeInteger);

                model.add(contextRes, model.createProperty(NIF_PROPERTY_ENDINDEX),
                        entity.getEndIndex().toString(), XSDDatatype.XSDnonNegativeInteger);


            }
        }

    }



    public void accept(NIFVisitor visitor) {
        visitor.visit(this);
    }
}