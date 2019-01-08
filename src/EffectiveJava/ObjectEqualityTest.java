package EffectiveJava;

import java.util.Objects;

public class ObjectEqualityTest {
    public static void main(String[] args) {
        CaseIncensitiveString cis = new CaseIncensitiveString("Polish");

        String s = "polish";

        if (cis.equals(s)) {
            System.out.print("equal");
        }
        if (s.equals(cis))///here String class equals is called and it will compare only string types not CaseInsen
        {
            System.out.print("equal");
        } else System.out.print("not equal");
    }

    private static class CaseIncensitiveString {

        private final String S;

        public CaseIncensitiveString(String s) {
            this.S = Objects.requireNonNull(s);
        }

        @Override
        public boolean equals(Object o) {

            if (o instanceof CaseIncensitiveString) {
                return this.S.equalsIgnoreCase(((CaseIncensitiveString) o).S);
            } else if (o instanceof String) {
                return this.S.equalsIgnoreCase((String) o);
            }

            return false;

        }


    }
}
