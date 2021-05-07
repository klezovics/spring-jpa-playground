package com.klezovich.springjpa.advanced.customhbmtype;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;
import org.hibernate.type.descriptor.java.ImmutableMutabilityPlan;

public class BracketPairJavaDescriptor extends AbstractTypeDescriptor<BracketPair> {

    public static final BracketPairJavaDescriptor INSTANCE = new BracketPairJavaDescriptor();

    protected BracketPairJavaDescriptor() {
        super(BracketPair.class, ImmutableMutabilityPlan.INSTANCE);
    }

    @Override
    public BracketPair fromString(String s) {
        return null;
    }

    @Override
    public <X> X unwrap(BracketPair bracketPair, Class<X> aClass, WrapperOptions wrapperOptions) {
        if (bracketPair == null) {
            return null;
        }

        if (String.class.isAssignableFrom(aClass)) {
            return (X) (bracketPair.getOpen().toString() + "," + bracketPair.getClosed().toString());
        }

        throw unknownUnwrap(aClass);
    }

    @Override
    public <X> BracketPair wrap(X x, WrapperOptions wrapperOptions) {
        if (x == null) {
            return null;
        }

        if (String.class.isInstance(x)) {
            String str = (String) x;
            var nums = str.split(",");
            return new BracketPair(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]));
        }

        return null;
    }
}
