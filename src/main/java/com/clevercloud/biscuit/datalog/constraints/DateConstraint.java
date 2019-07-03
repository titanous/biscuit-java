package com.clevercloud.biscuit.datalog.constraints;

import java.io.Serializable;
import java.util.Set;

public abstract class DateConstraint implements Serializable {
   public abstract boolean check(final long value);

   public static final class Before extends DateConstraint implements Serializable {
      private final long value;

      public boolean check(final long value) {
         return this.value > value;
      }

      public Before(final long value) {
         this.value = value;
      }

      @Override
      public String toString() {
         return "<= " + this.value;
      }
   }

   public static final class After extends DateConstraint implements Serializable {
      private final long value;

      public boolean check(final long value) {
         return this.value < value;
      }

      public After(final long value) {
         this.value = value;
      }

      @Override
      public String toString() {
         return ">= " + this.value;
      }
   }
}
