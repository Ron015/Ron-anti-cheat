package ai.idealistic.vacan.abstraction.b;

import ai.idealistic.vacan.abstraction.d.g;
import lombok.Generated;

public class f {
   private long ff = 1000L;
   private long fg = 0L;
   private int fh;
   private int fi = 0;
   private int fj = 0;

   public void b(g var1) {
      long var2 = var1.G();
      this.fi = var2 > 15L && var2 < 48L ? this.fi + 1 : 0;
      this.fj = var2 > 40L && var2 < 48L ? this.fj + 10 : this.fj / 2;
      if (var2 > 50L) {
         this.ff += var2 - 50L;
         if (var2 > 53L) {
            ++this.fh;
         }
      } else if (var2 < 50L) {
         long var4 = 50L - var2;
         if (this.ff - var4 >= 0L) {
            this.ff -= var4;
         } else {
            long var6 = var4 - this.ff;
            this.fg += var6;
            this.ff = 0L;
         }

         this.fh = 0;
      } else if (this.fg >= 0L) {
         this.fg /= 2L;
         this.ff /= 2L;
         this.fh = 0;
      }

   }

   public boolean be() {
      return this.fh > 15;
   }

   public void c(long var1) {
      this.ff += var1;
   }

   @Generated
   public long bf() {
      return this.ff;
   }

   @Generated
   public long bg() {
      return this.fg;
   }

   @Generated
   public int bh() {
      return this.fh;
   }

   @Generated
   public int bi() {
      return this.fi;
   }

   @Generated
   public int bj() {
      return this.fj;
   }
}
