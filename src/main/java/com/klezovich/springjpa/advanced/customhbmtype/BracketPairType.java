package com.klezovich.springjpa.advanced.customhbmtype;

import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

public class BracketPairType extends AbstractSingleColumnStandardBasicType<BracketPair> {

    public static final BracketPairType INSTANCE = new BracketPairType();

    public BracketPairType() {
        super(VarcharTypeDescriptor.INSTANCE, BracketPairJavaDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return "BracketPair";
    }
}
