package ai.idealistic.vacan.abstraction.d;

import lombok.Generated;

public class g {
   public final ai.idealistic.vacan.abstraction.f.c ac;
   public final long bw = System.currentTimeMillis();
   public final boolean fA;
   public final boolean fB;
   private long bP;

   public g(ai.idealistic.vacan.abstraction.f.c var1, boolean var2, boolean var3) {
      this.ac = var1;
      this.bP = -1L;
      this.fB = var3;
      this.fA = var2;
   }

   public g bq() {
      this.bP = this.bw - this.ac.gF;
      if (this.fA) {
         if (this.bP > 1020L && this.bP < 1060L) {
            this.bP -= 1000L;
         } else if (this.bP > 950L) {
            this.bP -= 950L;
         }
      }

      this.ac.gF = this.bw;
      return this;
   }

   @Generated
   public long G() {
      return this.bP;
   }
}
